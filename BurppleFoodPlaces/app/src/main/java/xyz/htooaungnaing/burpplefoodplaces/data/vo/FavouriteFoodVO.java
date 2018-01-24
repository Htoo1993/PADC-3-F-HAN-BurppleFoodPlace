package xyz.htooaungnaing.burpplefoodplaces.data.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by htoo on 1/24/2018.
 */

public class FavouriteFoodVO {

    @SerializedName("favorite_food_id")
    private int favoriteFoodId;
    private String title;
    private String photoUrl;

    public int getFavoriteFoodId() {
        return favoriteFoodId;
    }

    public String getTitle() {
        return title;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }
}
