package xyz.htooaungnaing.burpplefoodplaces.network;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import xyz.htooaungnaing.burpplefoodplaces.BurppleFoodPlacesApp;
import xyz.htooaungnaing.burpplefoodplaces.events.LoadedFoodHighlightEvent;
import xyz.htooaungnaing.burpplefoodplaces.network.responses.GetFoodHighlightResponse;

/**
 * Created by htoo on 1/12/2018.
 */

public class HighlightOkHttpDataAgent implements HighlightDataAgent {

    private static HighlightOkHttpDataAgent sObjInstance;

    private HighlightOkHttpDataAgent() {
    }

    public static HighlightOkHttpDataAgent getsObjInstance() {
        if(sObjInstance == null){
            sObjInstance = new HighlightOkHttpDataAgent();
        }
        return sObjInstance;
    }


    @Override
    public void loadFoodHighlight() {
        new LoadFoodHighlightTask().execute("http://padcmyanmar.com/padc-3/burpple-food-places/apis/v1/getFeatured.php");
    }

    private static class LoadFoodHighlightTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {

            String url = urls[0];

            OkHttpClient httpClient = new OkHttpClient.Builder() //1
                    .connectTimeout(15, TimeUnit.SECONDS)
                    .readTimeout(15, TimeUnit.SECONDS)
                    .writeTimeout(60, TimeUnit.SECONDS)
                    .build();

            RequestBody formBody = new FormBody.Builder() //2
                    .add("access_token", "b002c7e1a528b7cb460933fc2875e916")
                    .add("page", "1")
                    .build();

            Request request = new Request.Builder() //3
                    .url(url)
                    .post(formBody)
                    .build();

            String responseString = null;

            try {
                Response response = httpClient.newCall(request).execute(); //4
                if(response.isSuccessful() && response.body() != null){
                    responseString = response.body().string();
                }
            } catch (IOException e) {
                Log.e(BurppleFoodPlacesApp.LOG_TAG,e.getMessage());
            }

            return responseString;
        }

        @Override
        protected void onPostExecute(String response) {
            super.onPostExecute(response);

            Gson gson = new Gson();
            GetFoodHighlightResponse getFoodHighlightResponse = gson.fromJson(response,GetFoodHighlightResponse.class);

            EventBus.getDefault().post(new LoadedFoodHighlightEvent(getFoodHighlightResponse.getFoodHighlights()));
        }
    }
}
