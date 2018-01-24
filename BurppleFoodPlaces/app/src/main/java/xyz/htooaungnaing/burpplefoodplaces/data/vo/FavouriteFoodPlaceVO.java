package xyz.htooaungnaing.burpplefoodplaces.data.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by htoo on 1/24/2018.
 */

public class FavouriteFoodPlaceVO {

    @SerializedName("favorite_food_place_id")
    private int favoriteFoodPlaceId;
    private String title;
    private String address;
    private String photoUrl;

    public int getFavoriteFoodPlaceId() {
        return favoriteFoodPlaceId;
    }

    public String getTitle() {
        return title;
    }

    public String getAddress() {
        return address;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }
}
