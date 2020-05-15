package id.calocallo.testmagang.ui.wisataBatu

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.calocallo.testmagang.model.ResponsePhotoBatu
import id.calocallo.testmagang.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class WisataBatuViewModel : ViewModel() {
    private var dataListBatu = MutableLiveData<ArrayList<ResponsePhotoBatu>>()
    private var status = MutableLiveData<Boolean>()

    init {
        getDataBatu()
    }

    private fun getDataBatu() {
        status.value = true

        //koneksi retrotit
        NetworkConfig().api().batu().enqueue(object : Callback<ArrayList<ResponsePhotoBatu>> {
            override fun onFailure(call: Call<ArrayList<ResponsePhotoBatu>>, t: Throwable) {
                status.value = true
                dataListBatu.value = null
            }

            override fun onResponse(
                call: Call<ArrayList<ResponsePhotoBatu>>,
                response: Response<ArrayList<ResponsePhotoBatu>>
            ) {
                status.value = false
                if (response.isSuccessful) {
                    dataListBatu.value = response.body()
                } else {
                    status.value = true
                }
            }
        })
    }

    fun setDataBatu(): MutableLiveData<ArrayList<ResponsePhotoBatu>> {
        return dataListBatu
    }

    fun getStatus(): MutableLiveData<Boolean> {
        status.value = true
        return status
    }


}