package ipvc.estg.cm_tb

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class Map : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

    }

    fun bt1OnClick(view: View) {
        val intent = Intent(this, Check_map:: class.java)
        startActivity(intent)
    }


}