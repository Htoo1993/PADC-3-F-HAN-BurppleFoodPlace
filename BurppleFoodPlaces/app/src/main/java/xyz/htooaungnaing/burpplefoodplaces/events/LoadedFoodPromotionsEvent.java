package xyz.htooaungnaing.burpplefoodplaces.events;

import java.util.List;

import xyz.htooaungnaing.burpplefoodplaces.data.vo.PromotionVO;

/**
 * Created by htoo on 1/14/2018.
 */

public class LoadedFoodPromotionsEvent {
    private List<PromotionVO> promotions;

    public LoadedFoodPromotionsEvent(List<PromotionVO> promotions) {
        this.promotions = promotions;
    }

    public List<PromotionVO> getPromotions() {
        return promotions;
    }
}
