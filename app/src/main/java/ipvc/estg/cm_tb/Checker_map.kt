package ipvc.estg.cm_tb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Switch
import android.widget.Toast

class Checker_map : AppCompatActivity() {

    val number = Array(30) { it + 1 }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checker_map)

        val adapter = ArrayAdapter(this, android.R.layout.select_dialog_item, number)
        val acTextView: AutoCompleteTextView = findViewById<AutoCompleteTextView>(R.id.numbers)
        acTextView.setAdapter(adapter)

        val index = intent.getStringExtra("index")

        //Toast.makeText(this, index, Toast.LENGTH_SHORT).show()

        acTextView.setText(index)

        val sw1 = findViewById<Switch>(R.id.switch1)
        sw1?.setOnCheckedChangeListener({ _ , isChecked ->
            val message = if (isChecked) "Marcar" else "Desmarcar"
            Toast.makeText(this, message,
                Toast.LENGTH_SHORT).show()
        })
    }

    fun bt1OnClick(view: View) {
        val intent = Intent(this, Check_map:: class.java)
        startActivity(intent)
    }
}