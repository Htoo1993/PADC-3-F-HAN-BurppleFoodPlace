package xyz.htooaungnaing.burpplefoodplaces.network;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import xyz.htooaungnaing.burpplefoodplaces.network.responses.GetFoodPromotionsResponse;

/**
 * Created by htoo on 1/14/2018.
 */

public interface BurppleFoodPromotionApi{

    @FormUrlEncoded
    @POST("getPromotions.php")
    Call<GetFoodPromotionsResponse> getPromotion(@Field("page") int page,
                                                 @Field("access_token") String accessToken);


}
