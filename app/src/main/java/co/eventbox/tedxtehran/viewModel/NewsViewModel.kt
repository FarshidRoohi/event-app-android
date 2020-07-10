package co.eventbox.tedxtehran.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import co.eventbox.tedxtehran.respository.GalleryRepository
import com.apollographql.apollo.co.eventbox.tedxtehran.DashboardCacheQuery
import kotlinx.coroutines.launch

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 7/10/20.
 */
class NewsViewModel : BaseViewModel() {

    private val galleryRepository = GalleryRepository()

    fun news(): LiveData<List<DashboardCacheQuery.AllNew>> {

        val albums = MutableLiveData<List<DashboardCacheQuery.AllNew>>()


        launch {
            galleryRepository.request().fold({
                albums.postValue(null)
            }, {
                albums.postValue(it?.allNews())
            })


        }

        return albums
    }
}