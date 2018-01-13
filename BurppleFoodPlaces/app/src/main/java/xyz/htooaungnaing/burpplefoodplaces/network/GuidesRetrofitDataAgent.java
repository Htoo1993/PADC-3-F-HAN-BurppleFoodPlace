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
import xyz.htooaungnaing.burpplefoodplaces.events.LoadedFoodGuidesEvent;
import xyz.htooaungnaing.burpplefoodplaces.network.responses.GetFoodGuidesResponse;

/**
 * Created by htoo on 1/14/2018.
 */

public class GuidesRetrofitDataAgent implements GuidesDataAgent {

    private static GuidesRetrofitDataAgent sObjInstance;
    private BurppleFoodGuidesApi mBurppleFoodGuidesApi;

    private GuidesRetrofitDataAgent(){
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

        mBurppleFoodGuidesApi = retrofit.create(BurppleFoodGuidesApi.class);
    }

    public static GuidesRetrofitDataAgent getsObjInstance() {
        if (sObjInstance == null){
            sObjInstance = new GuidesRetrofitDataAgent();
        }
        return sObjInstance;
    }

    @Override
    public void loadGuides() {
        Call<GetFoodGuidesResponse> getFoodGuidesResponseCall = mBurppleFoodGuidesApi.getFoods(1,"b002c7e1a528b7cb460933fc2875e916");
        getFoodGuidesResponseCall.enqueue(new Callback<GetFoodGuidesResponse>() {
            @Override
            public void onResponse(Call<GetFoodGuidesResponse> call, Response<GetFoodGuidesResponse> response) {
                GetFoodGuidesResponse getFoodGuidesResponse = response.body();

                if(getFoodGuidesResponse != null){
                    LoadedFoodGuidesEvent event = new LoadedFoodGuidesEvent(getFoodGuidesResponse.getGuides());
                    EventBus.getDefault().post(event);
                }
            }

            @Override
            public void onFailure(Call<GetFoodGuidesResponse> call, Throwable t) {
                Log.d("", "onFailure : "+t.getMessage());
            }
        });
    }
}
