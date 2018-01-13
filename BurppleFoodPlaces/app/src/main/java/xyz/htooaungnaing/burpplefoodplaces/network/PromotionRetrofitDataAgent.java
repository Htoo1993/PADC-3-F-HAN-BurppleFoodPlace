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
import xyz.htooaungnaing.burpplefoodplaces.events.LoadedFoodPromotionsEvent;
import xyz.htooaungnaing.burpplefoodplaces.network.responses.GetFoodGuidesResponse;
import xyz.htooaungnaing.burpplefoodplaces.network.responses.GetFoodPromotionsResponse;

/**
 * Created by htoo on 1/14/2018.
 */

public class PromotionRetrofitDataAgent implements PromotionDataAgent {

    private static PromotionRetrofitDataAgent sObjInstance;
    private BurppleFoodPromotionApi mBurppleFoodPromotionApi;

    private PromotionRetrofitDataAgent(){
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

        mBurppleFoodPromotionApi = retrofit.create(BurppleFoodPromotionApi.class);
    }

    public static PromotionRetrofitDataAgent getsObjInstance() {
        if (sObjInstance == null){
            sObjInstance = new PromotionRetrofitDataAgent();
        }
        return sObjInstance;
    }

    @Override
    public void loadPromotion() {
        Call<GetFoodPromotionsResponse> getFoodPromotionsResponseCall = mBurppleFoodPromotionApi.getFoods(1,"b002c7e1a528b7cb460933fc2875e916");
        getFoodPromotionsResponseCall.enqueue(new Callback<GetFoodPromotionsResponse>() {
            @Override
            public void onResponse(Call<GetFoodPromotionsResponse> call, Response<GetFoodPromotionsResponse> response) {
                GetFoodPromotionsResponse getFoodPromotionsResponse = response.body();

                if(getFoodPromotionsResponse != null){
                    LoadedFoodPromotionsEvent event = new LoadedFoodPromotionsEvent(getFoodPromotionsResponse.getPromotions());
                    EventBus.getDefault().post(event);
                }
            }

            @Override
            public void onFailure(Call<GetFoodPromotionsResponse> call, Throwable t) {
                Log.d("", "onFailure : "+t.getMessage());
            }
        });
    }
}
