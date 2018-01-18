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
import xyz.htooaungnaing.burpplefoodplaces.events.LoadedFoodHighlightEvent;
import xyz.htooaungnaing.burpplefoodplaces.events.LoadedFoodPromotionsEvent;
import xyz.htooaungnaing.burpplefoodplaces.network.responses.GetFoodGuidesResponse;
import xyz.htooaungnaing.burpplefoodplaces.network.responses.GetFoodHighlightResponse;
import xyz.htooaungnaing.burpplefoodplaces.network.responses.GetFoodPromotionsResponse;

/**
 * Created by htoo on 1/13/2018.
 */

public class RetrofitDataAgent implements HighlightDataAgent,PromotionDataAgent,GuidesDataAgent {

    private static RetrofitDataAgent sObjInstance;
    private BurppleFoodAPI mBurppleFoodApi;

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

        mBurppleFoodApi = retrofit.create(BurppleFoodAPI.class);
    }

    public static RetrofitDataAgent getsObjInstance() {
        if(sObjInstance == null){
            sObjInstance = new RetrofitDataAgent();
        }

        return sObjInstance;
    }

    @Override
    public void loadFoodHighlight() {
        Call<GetFoodHighlightResponse> getFoodHighlightResponseCall = mBurppleFoodApi.getHighlight(1,"b002c7e1a528b7cb460933fc2875e916");
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

    @Override
    public void loadPromotion() {
        Call<GetFoodPromotionsResponse> getFoodPromotionsResponseCall = mBurppleFoodApi.getPromotion(1,"b002c7e1a528b7cb460933fc2875e916");
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

    @Override
    public void loadGuides() {
        Call<GetFoodGuidesResponse> getFoodGuidesResponseCall = mBurppleFoodApi.getGuides(1,"b002c7e1a528b7cb460933fc2875e916");
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
