package com.example.fa22_bse_b.tiktak

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fa22_bse_b.R
import com.example.fa22_bse_b.basics.callBack.main.Student

class tiktakActivity : AppCompatActivity() {

    var playerState: Boolean = true // true -> 1st player, false-> 2nd player
    val TAG = "tiktakActivity" // this@tiktakActivity.javaClass.simpleName

    val filledBoxesList: MutableList<Pair<Int, Boolean>> =
        arrayListOf() // first-> viewRef, second -> playerState

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tiktak)
        val extras = intent?.extras

        val email = extras?.get("email")
        val password = extras?.get("password")

        Toast.makeText(this,"$TAG onCreate", Toast.LENGTH_SHORT).show()
        Toast.makeText(this,"$TAG Welcome ${extras?.get("email")?:"Unknown"}", Toast.LENGTH_SHORT).show()

        val topLeft_ref: ImageView = findViewById(R.id.topLeft_child)
        val topCenter_ref: ImageView = findViewById(R.id.topCenter_child)
        val topRight_ref: ImageView = findViewById(R.id.topRight_child)
        val centerLeft_ref: ImageView = findViewById(R.id.centerLeft_child)
        val center_ref: ImageView = findViewById(R.id.center_child)
        val centerRight_ref: ImageView = findViewById(R.id.centerRight_child)
        val bottomLeft_ref: ImageView = findViewById(R.id.bottomLeft_child)
        val bottomCenter_ref: ImageView = findViewById(R.id.bottomCenter_child)
        val bottomRight_ref: ImageView = findViewById(R.id.bottomRight_child)

        arrayListOf(
            topLeft_ref,
            topCenter_ref,
            topRight_ref,
            centerLeft_ref,
            center_ref,
            centerRight_ref,
            bottomLeft_ref,
            bottomCenter_ref,
            bottomRight_ref
        ).forEach { ref ->
            ref.setOnClickListener { view ->
                onBoxClick(view)
            }
        }
    }


    fun onBoxClick(boxView: View) {
        if (filledBoxesList.filter { previousTurn -> previousTurn.first == boxView.id }.size == 0) {
            Log.e(
                TAG,
                "onCreate: player ${if (playerState == true) 1 else 2} have cliked on ${boxView.id}"
            )
            if (playerState) { // player 1
                (boxView as ImageView).setImageDrawable(resources.getDrawable(R.drawable.baseline_check_24))
            } else { // player 2
                (boxView as ImageView).setImageDrawable(resources.getDrawable(R.drawable.baseline_cancel_24))
            }

            filledBoxesList.add(Pair(boxView.id, playerState))
            playerState = !playerState

            if (filledBoxesList.size > 4) {
                checkWinningState()
            }
            Log.e(TAG, "onBoxClick: filledBoxesList-> $filledBoxesList")
        }
    }

    fun checkWinningState() {
//        arrayListOf(
//            arrayListOf(R.id.topLeft_child, R.id.topCenter_child, R.id.topRight_child),
//            arrayListOf(R.id.centerLeft_child, R.id.center_child, R.id.centerRight_child),
//            arrayListOf(R.id.bottomLeft_child, R.id.bottomCenter_child, R.id.bottomRight_child)
//        ).forEach { row -> 
//            if(filledBoxesList.filter { previousRef-> previousRef.first == row.get(0) }.getOrNull(0)?.second == true)
//            
//        }
        
//        if(filledBoxesList.filter { entry-> entry.first == R.id.topLeft_child }.getOrNull(0)?.second == true &&
//            filledBoxesList.filter { entry-> entry.first == R.id.topCenter_child }.getOrNull(0)?.second == true &&
//                filledBoxesList.filter { entry-> entry.first == R.id.topRight_child }.getOrNull(0)?.second == true){
//            Log.e(TAG, "checkWinningState: Player 1 has won", )
//        } else {
//            Log.e(TAG, "checkWinningState: No winning state", )
//        }



        val filteredList = filledBoxesList.filter { entry-> entry.first == R.id.topLeft_child }
        val topLeftBoxState = filteredList.getOrNull(0)
        if(topLeftBoxState!= null && topLeftBoxState.second == true) {

        }
    }


    fun filterStudents(students: List<Student>, maleStudentCallBack: (List<Student>)->Unit,feMaleStudentCallBack: (List<Student>)->Unit) {
        maleStudentCallBack.invoke(students.filter { student -> student.gender == false })
        feMaleStudentCallBack.invoke(students.filter { student-> student.gender == true })
    }


    override fun onPause() {
        super.onPause()
        Toast.makeText(this,"$TAG onPause", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this,"$TAG onResume", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this,"$TAG onDestroy", Toast.LENGTH_SHORT).show()
    }
}