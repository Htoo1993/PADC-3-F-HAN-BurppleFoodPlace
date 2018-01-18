package xyz.htooaungnaing.burpplefoodplaces.data.model;

import xyz.htooaungnaing.burpplefoodplaces.network.HighlightDataAgent;
import xyz.htooaungnaing.burpplefoodplaces.network.RetrofitDataAgent;

/**
 * Created by htoo on 1/12/2018.
 */

public class FeaturedModel {

    private static FeaturedModel sObjInstance;
    private HighlightDataAgent mFoodHighlightDataAgent;

    private FeaturedModel() {
//        mFoodHighlightDataAgent = HighlightOkHttpDataAgent.getsObjInstance();
        mFoodHighlightDataAgent = RetrofitDataAgent.getsObjInstance();
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
