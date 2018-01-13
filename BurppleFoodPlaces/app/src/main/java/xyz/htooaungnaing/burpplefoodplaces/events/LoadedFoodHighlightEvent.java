package xyz.htooaungnaing.burpplefoodplaces.events;

import java.util.List;

import xyz.htooaungnaing.burpplefoodplaces.data.vo.FoodHighlightVO;

/**
 * Created by htoo on 1/12/2018.
 */

public class LoadedFoodHighlightEvent {

    private List<FoodHighlightVO> foodHighlightList;

    public LoadedFoodHighlightEvent(List<FoodHighlightVO> foodHighlightList) {
        this.foodHighlightList = foodHighlightList;
    }

    public List<FoodHighlightVO> getFoodHighlightList() {
        return foodHighlightList;
    }
}
