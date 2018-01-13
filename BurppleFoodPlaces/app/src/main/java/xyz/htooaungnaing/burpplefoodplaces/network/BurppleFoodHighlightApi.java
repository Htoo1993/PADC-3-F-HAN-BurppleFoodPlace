package xyz.htooaungnaing.burpplefoodplaces.network;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import xyz.htooaungnaing.burpplefoodplaces.network.responses.GetFoodHighlightResponse;

/**
 * Created by htoo on 1/13/2018.
 */

public interface BurppleFoodHighlightApi {

    @FormUrlEncoded
    @POST("getFeatured.php")
    Call<GetFoodHighlightResponse> getNews(@Field("page") int page,
                                           @Field("access_token") String accessToken);

}
