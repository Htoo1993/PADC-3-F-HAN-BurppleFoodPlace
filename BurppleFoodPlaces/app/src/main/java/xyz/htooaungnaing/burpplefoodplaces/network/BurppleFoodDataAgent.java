package xyz.htooaungnaing.burpplefoodplaces.network;

/**
 * Created by htoo on 1/25/2018.
 */

public interface BurppleFoodDataAgent {

    /**
     * load login user information from api
     * @param phoneNo
     * @param password
     */
    void loadLoginUser(String phoneNo, String password);

    /**
     * load register from api
     * @param phoneNo
     * @param password
     * @param name
     */
    void loadRegister(String phoneNo, String password, String name);
}
