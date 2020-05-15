package id.calocallo.testmagang.ui.wisataBatu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.calocallo.testmagang.R
import id.calocallo.testmagang.model.ResponsePhotoBatu
import kotlinx.android.synthetic.main.activity_wisata_batu.*

class WisataBatuActivity : AppCompatActivity() {

    private lateinit var viewModel: WisataBatuViewModel
    private lateinit var rvBatu: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wisata_batu)
        rvBatu = findViewById(R.id.rv_batu)

        viewModel = ViewModelProvider(this).get(WisataBatuViewModel::class.java)

        viewModel.getStatus().observe(this, Observer {
            if (it ?: true) {
                rvBatu.visibility = View.GONE
            } else {
                rvBatu.visibility = View.VISIBLE
            }
        })

        viewModel.setDataBatu().observe(this, Observer {
            showData(it)
        })

    }

    private fun showData(data: ArrayList<ResponsePhotoBatu>) {
        rvBatu.apply {
            rvBatu.layoutManager = GridLayoutManager(this@WisataBatuActivity, 3)
            adapter = WisataBatuAdapter(data)
        }
    }
}
