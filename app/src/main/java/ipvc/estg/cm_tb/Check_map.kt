package ipvc.estg.cm_tb

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class Check_map : AppCompatActivity() {

    val idArray = arrayOf(R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5,
                          R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9, R.id.btn10,
                          R.id.btn11, R.id.btn12, R.id.btn13, R.id.btn14, R.id.btn15,
                          R.id.btn16, R.id.btn17, R.id.btn18, R.id.btn19, R.id.btn20,
                          R.id.btn21, R.id.btn22, R.id.btn23, R.id.btn24, R.id.btn25,
                          R.id.btn26, R.id.btn27, R.id.btn28, R.id.btn29, R.id.btn30 )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_map)

        for (i in idArray){
            findViewById<Button>(i).setOnClickListener{

                val intent = Intent(this@Check_map, Checker_map::class.java)
                intent.putExtra("index", (idArray.indexOf(i)+1).toString())
                startActivity(intent)
            }
        }

        for(i in idArray.indices){
            val button = intent.getStringExtra("button")
            val status = intent.getStringExtra("status")
            if(status == "false"){
                findViewById<Button>(idArray[i]).setBackgroundColor(Color.RED)
            }else if(status == "true"){
                findViewById<Button>(idArray[i]).setBackgroundColor(Color.GREEN)
            }else{
                //findViewById<Button>(idArray[i]).setBackgroundColor(Color.GREEN)
            }
        }
    }

    fun bt1OnClick(view: View) {
        val intent = Intent(this, Map:: class.java)
        startActivity(intent)

    }
}