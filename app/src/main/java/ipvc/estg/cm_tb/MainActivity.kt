package ipvc.estg.cm_tb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val reportActivity = findViewById<Button>(R.id.buttonServicoReports)
        reportActivity.setOnClickListener {
            val IntentOpenReports = Intent(this, ReportActivity::class.java)
            startActivity(IntentOpenReports)
        }
    }
}