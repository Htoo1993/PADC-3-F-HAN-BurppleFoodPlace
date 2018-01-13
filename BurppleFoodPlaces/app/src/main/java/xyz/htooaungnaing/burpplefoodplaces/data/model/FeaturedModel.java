package xyz.htooaungnaing.burpplefoodplaces.data.model;

import xyz.htooaungnaing.burpplefoodplaces.network.BurppleFoodDataAgent;
import xyz.htooaungnaing.burpplefoodplaces.network.FoodHighlightOkHttpDataAgent;
import xyz.htooaungnaing.burpplefoodplaces.network.RetrofitDataAgent;

/**
 * Created by htoo on 1/12/2018.
 */

public class FeaturedModel {

    private static FeaturedModel sObjInstance;
    private BurppleFoodDataAgent mFoodHighlightDataAgent;

    private FeaturedModel() {
        mFoodHighlightDataAgent = FoodHighlightOkHttpDataAgent.getsObjInstance();
//        mFoodHighlightDataAgent = RetrofitDataAgent.getsObjInstance();
    }

    public static FeaturedModel getsObjInstance() {
        if(sObjInstance == null){
            sObjInstance = new FeaturedModel();
        }
        return sObjInstance;
    }

    public void loadFoodHighlight(){
        mFoodHighlightDataAgent.loadFoodHighlight();
    }
}
