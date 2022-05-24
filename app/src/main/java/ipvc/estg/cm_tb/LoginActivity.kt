package ipvc.estg.cm_tb


import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_login.*
import kotlin.collections.Map


class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        auth = Firebase.auth
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        dbRef = FirebaseDatabase.getInstance().getReference("User")

        textViewSignInLink.setOnClickListener{
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }

        buttonSignUp.setOnClickListener {
            val inputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
            if (editTextEmail.text.toString().isNullOrEmpty() || editTextPassword.text.toString()
                    .isNullOrEmpty()
            )
                textViewResponse.text = "Email ou Password não introduzidos"
            else {
                auth.createUserWithEmailAndPassword(
                    editTextEmail.text.toString(),
                    editTextPassword.text.toString()
                )
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            textViewResponse.text =
                                "Registo com sucesso. Email e Password criados"
                            val user = auth.currentUser
                            updateUI(user)
                            saveUser()
                        } else {
                            textViewResponse.text = "Registo falhou"
                            updateUI(null)
                        }
                    }
            }
        }
    }

    private fun updateUI(currentUser: FirebaseUser?) {

    }

    private fun saveUser(){
        val userEmail = editTextEmail.text.toString()
        val userPassword = editTextPassword.text.toString()
        val userNome = editTextName.text.toString()
        val userNumero = editTextNumber.text.toString()
        val userTelemovel = editTextPhone.text.toString()

        if(userNome.isEmpty()){
            textViewResponse.text = "Insira um nome"
        }

        if(userNumero.isEmpty()){
            textViewResponse.text = "Insira um número de Aluno"
        }

        if(userTelemovel.isEmpty()){
            textViewResponse.text = "Insira um número de telemóvel"
        }

        //  val userId = dbRef.push().key!!

        val user = UserModel(userNumero, userNome, userEmail, userPassword, userTelemovel, userPontos = 0)

        dbRef.child(userNumero).setValue(user)
            .addOnCompleteListener{
                Toast.makeText(this, "Data inserida com sucesso", Toast.LENGTH_LONG).show()
                val intent = Intent(this, Map:: class.java)
                startActivity(intent)
            }.addOnFailureListener{ err ->
                Toast.makeText(this, "Error ${err.message}", Toast.LENGTH_LONG).show()

            }

    }


}