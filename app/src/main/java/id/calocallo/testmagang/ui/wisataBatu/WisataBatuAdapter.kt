package id.calocallo.testmagang.ui.wisataBatu

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.calocallo.testmagang.R
import id.calocallo.testmagang.model.ResponsePhotoBatu
import kotlinx.android.synthetic.main.item_batu.view.*
import id.calocallo.testmagang.ui.detailBatu.DetailBatuActivity

class WisataBatuAdapter(val batuList: ArrayList<ResponsePhotoBatu>) :
    RecyclerView.Adapter<WisataBatuAdapter.BatuHolder>() {
    inner class BatuHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(batuModel: ResponsePhotoBatu) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(batuModel.thumbnail)
                    .into(img_batu)

                itemView.setOnClickListener {
                    val intent = Intent(context.applicationContext, DetailBatuActivity::class.java)
                    intent.flags =
                        Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_MULTIPLE_TASK
                    intent.putExtra("setImg", batuModel.image)
                    intent.putExtra("setCap", batuModel.caption)
                    context.applicationContext.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WisataBatuAdapter.BatuHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_batu, parent, false)
        return BatuHolder(view)
    }

    override fun getItemCount(): Int {
        return batuList.size
    }

    override fun onBindViewHolder(holder: BatuHolder, position: Int) {
        holder.bind(batuList[position])
    }

}