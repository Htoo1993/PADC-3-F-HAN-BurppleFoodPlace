package xyz.htooaungnaing.burpplefoodplaces.data.model;

import xyz.htooaungnaing.burpplefoodplaces.network.PromotionDataAgent;
import xyz.htooaungnaing.burpplefoodplaces.network.RetrofitDataAgent;

/**
 * Created by htoo on 1/14/2018.
 */

public class PromotionsModel {

    private static PromotionsModel sObjInstance;
    private PromotionDataAgent mPromotionDataAgent;

    private PromotionsModel(){
//        mPromotionDataAgent = PromotionsOkHttpDataAgent.getsObjInstance();
        mPromotionDataAgent = RetrofitDataAgent.getsObjInstance();
    }

    public static PromotionsModel getsObjInstance() {
        if (sObjInstance == null){
            sObjInstance = new PromotionsModel();
        }
        return sObjInstance;
    }

    public void loadedFoodPromotion(){
        mPromotionDataAgent.loadPromotion();
    }
}
