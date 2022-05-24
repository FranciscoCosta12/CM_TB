package ipvc.estg.cm_tb

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Checker_map : AppCompatActivity() {

    val number = Array(30) { it + 1 }

    private lateinit var tvuser: TextView
    private lateinit var acTextView: AutoCompleteTextView
    private lateinit var sw1: Switch
    private lateinit var btsave: Button

    private lateinit var dbRef: DatabaseReference

    var status: String = "false"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checker_map)

        tvuser = findViewById(R.id.tvuser)
        acTextView = findViewById(R.id.numbers)
        sw1 = findViewById(R.id.switch1)
        btsave = findViewById(R.id.btsave)

        dbRef = FirebaseDatabase.getInstance().getReference("Checker")

        val adapter = ArrayAdapter(this, android.R.layout.select_dialog_item, number)
        acTextView.setAdapter(adapter)

        val index = intent.getStringExtra("index")

        //Toast.makeText(this, index, Toast.LENGTH_SHORT).show()

        acTextView.setText(index)

        sw1?.setOnCheckedChangeListener({ _ , isChecked ->
            val message = if (isChecked){
                "Marcar"
            }  else {
                "Desmarcar"
            }
            if(isChecked) status = "true" else status = "false"

            Toast.makeText(this, message,
                Toast.LENGTH_SHORT).show()
        })

        btsave.setOnClickListener {
            saveCheck()
        }

    }

    fun bt1OnClick(view: View) {
        val intent = Intent(this, Check_map:: class.java)
        startActivity(intent)
    }

    private fun saveCheck(){

        val tv = tvuser.text.toString()
        val ac = acTextView.text.toString()
        val sw = status

        if(tv.isEmpty()){
            tvuser.error = "Please login"
        }
        if(acTextView.text.isEmpty()){
            acTextView.error = "Please enter a number"
        }

        val check = CheckModel(ac, tv, sw)

        val intent = Intent(this, Check_map:: class.java)
        intent.putExtra("button", ac)
        intent.putExtra("status", sw)

        dbRef.child(ac).setValue(check)
            .addOnCompleteListener{
                Toast.makeText(this, "Data inserted successfully", Toast.LENGTH_LONG).show()
                startActivity(intent)
            }.addOnFailureListener{ err->
                Toast.makeText(this, "Error ${err.message}", Toast.LENGTH_LONG).show()
            }

    }
}