package kg.neobis.careerfair.utils.data

import kg.neobis.careerfair.model.AboutCareerFair
import kg.neobis.careerfair.model.Organizers
import kg.neobis.careerfair.model.Shedule
import retrofit2.Call
import retrofit2.http.GET

interface ForumService {


    @GET("organizer/")
    fun getOrganizersList(): Call<List<Organizers>>
    @GET("sponsor/")
    fun getSponsorsList(): Call<List<Organizers>>
    @GET("employer/")
    fun getListEmployers():Call<List<Organizers>>
    @GET("partner/")
    fun getPartnersList():Call<List<Organizers>>
    @GET("mediapartner/")
    fun getMediaPartnersList():Call<List<Organizers>>
    @GET("shedule/")
    fun getSheduleList():Call<List<Shedule>>
    @GET("about/")
    fun getInfoAboutCareerFair():Call<List<AboutCareerFair>>



}