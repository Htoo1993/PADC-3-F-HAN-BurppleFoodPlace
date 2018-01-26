package xyz.htooaungnaing.burpplefoodplaces.data.model;

import xyz.htooaungnaing.burpplefoodplaces.network.BurppleFoodDataAgent;
import xyz.htooaungnaing.burpplefoodplaces.network.RetrofitDataAgent;

/**
 * Created by htoo on 1/26/2018.
 */

public class RegisterModel {

    private static RegisterModel sObjInstance;
    private BurppleFoodDataAgent mBurppleFoodDataAgent;

    private RegisterModel(){
        mBurppleFoodDataAgent = RetrofitDataAgent.getsObjInstance();
    }

    public static RegisterModel getsObjInstance() {
        if(sObjInstance == null){
            sObjInstance = new RegisterModel();
        }
        return sObjInstance;
    }

    public void register(String phoneNo, String password, String name){
        mBurppleFoodDataAgent.loadRegister(phoneNo, password, name);
    }
}
