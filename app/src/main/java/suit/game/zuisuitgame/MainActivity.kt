package suit.game.zuisuitgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var mulai:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);

        mulai = findViewById(R.id.buttonmulai);
        mulai.setOnClickListener(){
            startActivity(Intent(this,GameActivity::class.java))
        }
    }
}