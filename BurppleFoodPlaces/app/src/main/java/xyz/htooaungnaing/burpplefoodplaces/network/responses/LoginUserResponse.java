package xyz.htooaungnaing.burpplefoodplaces.network.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import xyz.htooaungnaing.burpplefoodplaces.data.vo.FavouriteFoodPlaceVO;
import xyz.htooaungnaing.burpplefoodplaces.data.vo.FavouriteFoodVO;
import xyz.htooaungnaing.burpplefoodplaces.data.vo.LoginUserVO;

/**
 * Created by htoo on 1/25/2018.
 */

public class LoginUserResponse {

    private int code;
    private String message;

    @SerializedName("login_user")
    private LoginUserVO loginUser;


    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public LoginUserVO getLoginUser() {
        return loginUser;
    }

}
