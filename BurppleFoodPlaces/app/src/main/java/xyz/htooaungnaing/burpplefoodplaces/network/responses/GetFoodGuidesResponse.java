package xyz.htooaungnaing.burpplefoodplaces.network.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import xyz.htooaungnaing.burpplefoodplaces.data.vo.GuidesVO;
import xyz.htooaungnaing.burpplefoodplaces.data.vo.PromotionVO;

/**
 * Created by htoo on 1/13/2018.
 */

public class GetFoodGuidesResponse {

    private int code;
    private String message;
    private String apiVersion;
    private String page;

    @SerializedName("featured")
    private List<GuidesVO> guides;

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

    public List<GuidesVO> getGuides() {
        return guides;
    }
}
