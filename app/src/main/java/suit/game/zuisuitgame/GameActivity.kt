package suit.game.zuisuitgame

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.ImageView
import android.widget.Toast

class GameActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var handpemain:ImageView
    lateinit var scipemain:ImageView
    lateinit var rockpemain:ImageView
    lateinit var handlawan:ImageView
    lateinit var scilawan:ImageView
    lateinit var rocklawan:ImageView
    lateinit var reset:ImageView
    var images= intArrayOf(
        R.drawable.tanganbatu,
        R.drawable.tangankertas,
        R.drawable.tangangunting
    )
    var userinput = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        reset = findViewById(R.id.resetgame) as ImageView
        scilawan = findViewById<View>(R.id.guntinglawan) as ImageView
        handpemain = findViewById<View>(R.id.kertaspemain) as ImageView
        scipemain = findViewById<View>(R.id.guntingpemain) as ImageView
        rockpemain = findViewById<View>(R.id.batupemain) as ImageView

        handpemain.setOnClickListener(this)
        scipemain.setOnClickListener(this)
        rockpemain.setOnClickListener(this)
        reset.setOnClickListener{
            finish()
            startActivity(Intent(this,GameActivity::class.java))
        }
    }

    override fun onClick(p0: View?) {
        val id = p0?.id
        when (id) {
            R.id.batupemain -> {
                userinput = 1
//                input!!.setBackgroundResource(R.drawable.tanganbatu)
                setOutput()
            }
            R.id.kertaspemain -> {
                userinput = 2
//                input!!.setBackgroundResource(R.drawable.paper)
                setOutput()
            }
            R.id.guntingpemain-> {
                userinput = 3
//                input!!.setBackgroundResource(R.drawable.scissor)
                setOutput()
            }
        }
    }

    private fun setOutput(){
        val imageId = (Math.random() * images.size).toInt()
        scilawan.setBackgroundResource(images[imageId])
        checkresult(imageId)
    }

    private fun checkresult(imageId : Int){
        if (userinput == 1 && imageId == 0) {     //User choose Rock,Computer choose Rock
            showresult(2)
        } else if (userinput == 1 && imageId == 1) { //User choose Rock,Computer choose Paper
            showresult(0)
        } else if (userinput == 1 && imageId == 2) { //User choose Rock,Computer choose Scissors
            showresult(1)
        } else if (userinput == 2 && imageId == 0) { //User choose Paper,Computer choose Rock
            showresult(1)
        } else if (userinput == 3 && imageId == 2){
            showresult(2)
        }
    }

    private fun showresult(result: Int) {
        if (result == 0) {
            Toast.makeText(applicationContext, "Oh! You Lost :(", Toast.LENGTH_SHORT).show()
        } else if (result == 1) Toast.makeText(
            applicationContext,
            "You Won! Yeah! :)",
            Toast.LENGTH_SHORT
        ).show() else Toast.makeText(
            applicationContext, "OOPS! It's a Tie! :P", Toast.LENGTH_SHORT
        ).show()
    }

}