package xyz.htooaungnaing.burpplefoodplaces.events;

import xyz.htooaungnaing.burpplefoodplaces.data.vo.LoginUserVO;

/**
 * Created by htoo on 1/25/2018.
 */

public class LoadedLoginUserEvent {

    private LoginUserVO loginUser;

    public LoadedLoginUserEvent(LoginUserVO loginUser) {
        this.loginUser = loginUser;
    }

    public LoginUserVO getLoginUser() {
        return loginUser;
    }
}
