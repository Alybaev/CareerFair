package kg.neobis.careerfair.data

import kg.neobis.careerfair.model.AboutCareerFair
import kg.neobis.careerfair.model.Organizers
import kg.neobis.careerfair.model.Shedule
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ForumService {


    @GET("{category}/")
    fun getInfoAbout(@Path("category") category: String): Call<ArrayList<Organizers>>
    @GET("organizer/")
    fun getOrganizers(): Call<ArrayList<Organizers>>
    @GET("shedule/")
    fun getScheduleList():Call<ArrayList<Shedule>>
    @GET("{category}/")
    fun getInfoAboutCareerFair(@Path("category") category: String):Call<ArrayList<AboutCareerFair>>



}