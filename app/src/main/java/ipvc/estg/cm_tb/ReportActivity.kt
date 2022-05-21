package ipvc.estg.cm_tb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ReportActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report)

        val mainActivity = findViewById<Button>(R.id.buttonBackMainMenu)
        mainActivity.setOnClickListener {
            val IntentBackMain = Intent(this, MainActivity::class.java)
            startActivity(IntentBackMain)
        }
    }
}