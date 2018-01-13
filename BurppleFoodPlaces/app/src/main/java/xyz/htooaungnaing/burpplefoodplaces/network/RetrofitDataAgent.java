package xyz.htooaungnaing.burpplefoodplaces.network;

import android.util.Log;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import xyz.htooaungnaing.burpplefoodplaces.events.LoadedFoodHighlightEvent;
import xyz.htooaungnaing.burpplefoodplaces.network.responses.GetFoodHighlightResponse;

/**
 * Created by htoo on 1/13/2018.
 */

public class RetrofitDataAgent implements BurppleFoodDataAgent {

    private static RetrofitDataAgent sObjInstance;
    private BurppleFoodApi mBurppleFoodApi;

    private RetrofitDataAgent() {
        OkHttpClient httpClient = new OkHttpClient.Builder() //1
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder() //2
                .baseUrl("http://padcmyanmar.com/padc-3/burpple-food-places/apis/v1/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(httpClient)
                .build();

        mBurppleFoodApi = retrofit.create(BurppleFoodApi.class);
    }

    public static RetrofitDataAgent getsObjInstance() {
        if(sObjInstance == null){
            sObjInstance = new RetrofitDataAgent();
        }

        return sObjInstance;
    }

    @Override
    public void loadFoodHighlight() {
        Call<GetFoodHighlightResponse> getFoodHighlightResponseCall = mBurppleFoodApi.getNews(1,"b002c7e1a528b7cb460933fc2875e916");
        getFoodHighlightResponseCall.enqueue(new Callback<GetFoodHighlightResponse>() {
            @Override
            public void onResponse(Call<GetFoodHighlightResponse> call, Response<GetFoodHighlightResponse> response) {
                GetFoodHighlightResponse getFoodHighlightResponse = response.body();

                if(getFoodHighlightResponse != null){
                    LoadedFoodHighlightEvent event = new LoadedFoodHighlightEvent(getFoodHighlightResponse.getFoodHighlights());
                    EventBus.getDefault().post(event);
                }
            }

            @Override
                public void onFailure(Call<GetFoodHighlightResponse> call, Throwable t) {
                    Log.d("", "onFailure : "+t.getMessage());
                }
        });
    }
}
