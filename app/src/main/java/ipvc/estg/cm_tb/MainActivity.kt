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

    // Parte Chico Login
    }

    fun login(view: View) {
        val intent1 = Intent(this, LoginActivity::class.java).apply {  }

        startActivity(intent1)
    }
}