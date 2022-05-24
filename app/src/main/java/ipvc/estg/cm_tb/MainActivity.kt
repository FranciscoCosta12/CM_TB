package ipvc.estg.cm_tb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import ipvc.estg.cm_tb.databinding.ActivityMainBinding
import ipvc.estg.cm_tb.databinding.ItemAddBinding


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnPerfil(view: View) {
        val intent = Intent(this, Perfil::class.java)
        startActivity(intent)
    }




}