package xyz.htooaungnaing.burpplefoodplaces.data.model;

import xyz.htooaungnaing.burpplefoodplaces.network.GuidesDataAgent;
import xyz.htooaungnaing.burpplefoodplaces.network.RetrofitDataAgent;

/**
 * Created by htoo on 1/13/2018.
 */

public class GuidesModel {
    private static GuidesModel sObjInstance;
    private GuidesDataAgent mGuidesDataAgent;

    private GuidesModel(){
//        mGuidesDataAgent = GuidesOkHttpDataAgent.getsObjInstance();
        mGuidesDataAgent = RetrofitDataAgent.getsObjInstance();
    }

    public static GuidesModel getsObjInstance() {
        if (sObjInstance==null){
            sObjInstance = new GuidesModel();
        }
        return sObjInstance;
    }

    public void loadFoodGuides(){
        mGuidesDataAgent.loadGuides();
    }
}
