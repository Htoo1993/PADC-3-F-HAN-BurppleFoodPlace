package xyz.htooaungnaing.burpplefoodplaces.events;

import java.util.List;

import xyz.htooaungnaing.burpplefoodplaces.data.vo.PromotionVO;

/**
 * Created by htoo on 1/14/2018.
 */

public class LoadedGoodPromotionsEvent {
    private List<PromotionVO> promotions;

    public LoadedGoodPromotionsEvent(List<PromotionVO> promotions) {
        this.promotions = promotions;
    }

    public List<PromotionVO> getPromotions() {
        return promotions;
    }
}
