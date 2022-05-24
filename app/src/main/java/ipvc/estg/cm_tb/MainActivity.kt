package ipvc.estg.cm_tb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this, SignInActivity:: class.java)
        startActivity(intent)

    }

    fun btnOnClick(view: View) {
        val intent = Intent(this, Map:: class.java)
        startActivity(intent)

    // Parte Chico Login
    }

    fun login(view: View) {
        val intent1 = Intent(this, LoginActivity::class.java)
        startActivity(intent1)
    }

    fun perfilClick(view: View) {
        val intent = Intent (this, Perfil::class.java)
        startActivity(intent)
    }
}