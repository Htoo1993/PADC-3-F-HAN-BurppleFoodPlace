package xyz.htooaungnaing.burpplefoodplaces.network.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import xyz.htooaungnaing.burpplefoodplaces.data.vo.FoodHighlightVO;

/**
 * Created by htoo on 1/12/2018.
 */

public class GetFoodHighlightResponse {

    private int code;
    private String message;
    private String apiVersion;
    private String page;

    @SerializedName("featured")
    private List<FoodHighlightVO> foodHighlights;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String getPage() {
        return page;
    }

    public List<FoodHighlightVO> getFoodHighlights() {
        return foodHighlights;
    }
}
