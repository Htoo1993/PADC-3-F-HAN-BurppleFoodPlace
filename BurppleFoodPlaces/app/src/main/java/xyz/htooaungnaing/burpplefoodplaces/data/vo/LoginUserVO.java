package xyz.htooaungnaing.burpplefoodplaces.data.vo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by htoo on 1/24/2018.
 */

public class LoginUserVO {
    private int userId;
    private String name;
    private String email;
    private String phoneNo;
    private String profileUrl;
    private String coverUrl;

    @SerializedName("fav_foods")
    private List<FavouriteFoodVO> favouriteFoods;

    @SerializedName("fav_food_places")
    private List<FavouriteFoodPlaceVO> favouriteFoodPlaces;

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public List<FavouriteFoodVO> getFavouriteFoods() {
        return favouriteFoods;
    }

    public List<FavouriteFoodPlaceVO> getFavouriteFoodPlaces() {
        return favouriteFoodPlaces;
    }
}
