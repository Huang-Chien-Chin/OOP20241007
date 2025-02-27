package tw.edu.pu.esim.s1120326.oop

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.view.View.OnLongClickListener
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() ,OnClickListener ,OnLongClickListener{
    lateinit var txv: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var txv: TextView = findViewById(R.id.txv)

        /*/txv.text = "OOP example"
        var v1 = Two()
        v1.x = 7
        v1.y = 5
        txv.text = v1.sum().toString()

        var v2 = Two()
        v2.x =55
        v2.y = 7
        var v3 =Teo(55,6)
        */

        var v3 = Three(55, 6, 21)
        txv.text = v3.sum().toString() + "\n" + v3.Avg().toString()

        var img: ImageView = findViewById(R.id.img)
        img.setOnClickListener(this)
        txv.setOnClickListener(this)
        img.setOnLongClickListener(this)
    }


    override fun onClick(v: View?) {
        var txv: TextView = findViewById(R.id.txv)
        var img: ImageView = findViewById(R.id.img)
        if (v == txv) {
            txv.text = "文字短按"
        } else {
            txv.text = "爆炸 撕裂 下墜"
        }
    }
    override fun onLongClick(p0: View?): Boolean {
        var txv: TextView = findViewById(R.id.txv)
        txv.text = "長按炸馬桶"
        return false
    }
        interface Average {
            fun Avg(): Float
        }

        open class Two(var x: Int = 0, var y: Int = 0) {
            open fun sum(): Int {
                return x + y
            }
        }

        class Three(x: Int, y: Int, var z: Int) : Two(x, y), Average {
            override fun sum(): Int {
                return x + y + z
            }

            override fun Avg(): Float {
                return (x + y + z).toFloat() / 3
            }

        }

    }

/*
class Two(var x : Int = 0,
          var y : Int = 0){


    fun sum():Int{
        return x + y
 */