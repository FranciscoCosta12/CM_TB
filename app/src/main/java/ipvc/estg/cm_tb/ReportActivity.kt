package ipvc.estg.cm_tb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class ReportActivity : AppCompatActivity() {

    lateinit var option : Spinner
    lateinit var result : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report)

        val mainActivity = findViewById<Button>(R.id.buttonBackMainMenu)
        mainActivity.setOnClickListener {
            val IntentBackMain = Intent(this, MainActivity::class.java)
            startActivity(IntentBackMain)
        }

        //Spinner Options ( opções de report )------------------------------------------------------
        option = findViewById(R.id.spinner) as Spinner
        result = findViewById(R.id.spinnerResult) as TextView

        //Array de Opções
        val options = arrayOf("Informação Falsa","Hacker Informático","Nome Inapropriado")

        //addapter de opções ( Definir as opções no spinner )
        option.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options)

    }
}