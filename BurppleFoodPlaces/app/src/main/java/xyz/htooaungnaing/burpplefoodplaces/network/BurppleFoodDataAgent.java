package xyz.htooaungnaing.burpplefoodplaces.network;

/**
 * Created by htoo on 1/25/2018.
 */

public interface BurppleFoodDataAgent {

    /**
     * load login user information from api
     */
    void loadLoginUser(String phoneNo, String password);
}
