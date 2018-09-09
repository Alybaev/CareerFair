package kg.neobis.careerfair.utils.data

import kg.neobis.careerfair.model.Organizers
import retrofit2.Call
import retrofit2.http.GET

interface ForumService {


    @GET("organizer/")
    fun getOrganizersList(): Call<List<Organizers>>


}