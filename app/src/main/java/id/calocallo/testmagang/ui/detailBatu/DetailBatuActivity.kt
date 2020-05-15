package id.calocallo.testmagang.ui.detailBatu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import id.calocallo.testmagang.R
import id.calocallo.testmagang.ui.wisataBatu.WisataBatuViewModel
import kotlinx.android.synthetic.main.activity_detail_batu.*

class DetailBatuActivity : AppCompatActivity() {

    private lateinit var imgDetail: ImageView
    private lateinit var textDetail: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_batu)

        supportActionBar?.title = "Detail"

        imgDetail = findViewById(R.id.img_detail)
        textDetail = findViewById(R.id.txt_detail)

        val getImg = intent.getStringExtra("setImg")
        Glide.with(this)
            .load(getImg)
            .into(imgDetail)

        val getCap = intent.getStringExtra("setCap")
        textDetail.text = getCap

    }
}
