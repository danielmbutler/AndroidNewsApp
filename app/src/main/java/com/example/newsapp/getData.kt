
import okhttp3.*
import org.json.JSONArray
import org.json.JSONObject



suspend fun getData(url : String): JSONArray {

     val client = OkHttpClient()

        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) {
                println("Unexpected code $response")
            } else {
                val responseData = response.body?.string()

                var json = JSONObject(responseData)
                println("Request Successful!!")


                val responseObject = json.getJSONArray("articles")

                return responseObject

            }


        }
        return JSONArray()
        }




