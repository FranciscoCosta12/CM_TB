package ipvc.estg.cm_tb


import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth

import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        auth = Firebase.auth
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

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


}