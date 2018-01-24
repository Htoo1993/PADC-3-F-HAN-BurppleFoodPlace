package xyz.htooaungnaing.burpplefoodplaces.data.model;

import xyz.htooaungnaing.burpplefoodplaces.network.BurppleFoodDataAgent;
import xyz.htooaungnaing.burpplefoodplaces.network.RetrofitDataAgent;

/**
 * Created by htoo on 1/25/2018.
 */

public class LoginUserModel {
    private static LoginUserModel sObjInstance;
    private BurppleFoodDataAgent mBurppleFoodDataAgent;

    private LoginUserModel(){
        mBurppleFoodDataAgent = RetrofitDataAgent.getsObjInstance();
    }

    public static LoginUserModel getsObjInstance() {
        if(sObjInstance == null){
            sObjInstance = new LoginUserModel();
        }
        return sObjInstance;
    }

    public void loginUser(String phoneNo, String password){
        mBurppleFoodDataAgent.loadLoginUser(phoneNo, password);
    }
}
