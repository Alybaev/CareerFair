package kg.neobis.careerfair.utils

import android.app.Application
import kg.neobis.careerfair.utils.Constants.Companion.BASE_URL
import kg.neobis.careerfair.utils.data.ForumService
import kg.neobis.careerfair.utils.data.NetWork
import java.io.File

class ApplicationClass : Application(){
    companion object {
        @Volatile
        lateinit var INSTANCE : ApplicationClass
        lateinit var service: ForumService
    }
    override fun onCreate(){
        super.onCreate()
        INSTANCE = this
        service = NetWork.initService(BASE_URL)

    }

}