package ipvc.estg.cm_tb

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.imageview.ShapeableImageView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
import java.lang.StringBuilder

class Perfil : AppCompatActivity() {

    private  lateinit var firebaseAuth: FirebaseAuth

    val dbref = FirebaseDatabase.getInstance().getReference("User")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.perfil)

        firebaseAuth = FirebaseAuth.getInstance()

    }

    /*
    dbref.addValueEventListener(object : ValueEventListener{
        override fun onDataChange(snapshot: DataSnapshot) {
            if(snapshot.exists()){

                for (userSnapshot in snapshot.children){
                    val user = userSnapshot.getValue(UserModel::class.java)
                    if(user?.userId == firebaseAuth.currentUser?.uid){
                        val emailUser = user?.userEmail
                        val nameUser = user?.userNome
                        nome.text = nameUser.toString()
                        email.text = emailUser.toString()
                    }
                }
            }

        }

        override fun onCancelled(error: DatabaseError) {}
    })


*/


}