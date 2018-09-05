package kg.neobis.careerfair.utils

import android.content.Context
import java.io.*
import java.nio.file.Files.exists



class FileUtils{
    companion object {
        fun <T> writeCacheData(context: Context, filename: String, data: T) {
            val cacheDir = File(context.getCacheDir(), filename)
            if (!cacheDir.exists()) cacheDir.mkdirs()
            try {
                val dir = File(cacheDir, "$filename.ser")
                if (!dir.exists()) dir.createNewFile()
                val fos = FileOutputStream(dir)
                val oos = ObjectOutputStream(fos)
                oos.writeObject(data)
                oos.close()
                fos.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }

        fun <T> readCacheData(context: Context, filename: String): T? {
            val cacheDir = File(context.getCacheDir(), filename)
            if (!cacheDir.exists()) return null
            try {
                val dir = File(cacheDir, "$filename.ser")
                if (!dir.exists()) return null
                val fis = FileInputStream(dir)
                val ois = ObjectInputStream(fis)
                val data = ois.readObject() as T
                fis.close()
                ois.close()
                return data
            } catch (e: Exception) {
                e.printStackTrace()
            }

            return null
        }

    }
}