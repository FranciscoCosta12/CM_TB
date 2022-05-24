package ipvc.estg.cm_tb

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.signin.*

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){

        lateinit var auth: FirebaseAuth

        super.onCreate(savedInstanceState)
        auth = Firebase.auth
        setContentView(R.layout.signin)

        textViewSignUpLink.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        buttonSignIn.setOnClickListener {
            val inputMethodManager =  getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
            if (editTextEmail.text.toString().isNullOrEmpty() || editTextPassword.text.toString().isNullOrEmpty())
                textViewResponse.text = "Email ou Password não introduzidos"
            else {
                auth.signInWithEmailAndPassword(editTextEmail.text.toString(),editTextPassword.text.toString())
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            textViewResponse.text =  "Sign In com sucesso. "
                            val user = auth.currentUser
                            updateUI(user, editTextEmail.text.toString() )
                        } else
                            textViewResponse.text = "Email ou Password inválidos"
                    }
            }
        }
    }

    private fun updateUI(currentUser: FirebaseUser?, emailAdd: String) {
        if(currentUser !=null){
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("emailAddress", emailAdd);
            startActivity(intent)
            finish()
        }
    }
}