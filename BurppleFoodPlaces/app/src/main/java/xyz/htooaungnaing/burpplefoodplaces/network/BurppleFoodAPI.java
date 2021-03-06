package xyz.htooaungnaing.burpplefoodplaces.network;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import xyz.htooaungnaing.burpplefoodplaces.network.responses.GetFoodGuidesResponse;
import xyz.htooaungnaing.burpplefoodplaces.network.responses.GetFoodHighlightResponse;
import xyz.htooaungnaing.burpplefoodplaces.network.responses.GetFoodPromotionsResponse;
import xyz.htooaungnaing.burpplefoodplaces.network.responses.LoginUserResponse;

/**
 * Created by htoo on 1/18/2018.
 */

public interface BurppleFoodAPI {

    @FormUrlEncoded
    @POST("getFeatured.php")
    Call<GetFoodHighlightResponse> getHighlight(@Field("page") int page,
                                                @Field("access_token") String accessToken);

    @FormUrlEncoded
    @POST("getPromotions.php")
    Call<GetFoodPromotionsResponse> getPromotion(@Field("page") int page,
                                                 @Field("access_token") String accessToken);

    @FormUrlEncoded
    @POST("getGuides.php")
    Call<GetFoodGuidesResponse> getGuides(@Field("page") int page,
                                          @Field("access_token") String accessToken);

    @FormUrlEncoded
    @POST("login.php")
    Call<LoginUserResponse> getLoginUserInfo(@Field("phoneNo") String phoneNo,
                                             @Field("password") String password);

    @FormUrlEncoded
    @POST("register.php")
    Call<LoginUserResponse> getRegister(@Field("phoneNo") String phoneNo,
                                     @Field("password") String password,
                                    @Field("name") String name);


}
