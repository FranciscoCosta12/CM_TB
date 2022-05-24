package ipvc.estg.cm_tb

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlin.collections.Map

class Perfil : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.perfil)

        }

    fun btMap(view: View) {
        val intent = Intent(this, Map:: class.java)
        startActivity(intent)
    }
    fun btPerfil(view: View) {
        val intent = Intent(this, Perfil:: class.java)
        startActivity(intent)
    }
    fun btLogout(view: View) {
        val intent = Intent(this, LoginActivity:: class.java)
        startActivity(intent)
    }
}