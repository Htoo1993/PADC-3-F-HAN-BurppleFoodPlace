package xyz.htooaungnaing.burpplefoodplaces.events;

import xyz.htooaungnaing.burpplefoodplaces.data.vo.LoginUserVO;

/**
 * Created by htoo on 1/26/2018.
 */

public class RegisterEvent {

    private LoginUserVO registerVO;

    public RegisterEvent(LoginUserVO registerVO) {
        this.registerVO = registerVO;
    }

    public LoginUserVO getRegisterVO() {
        return registerVO;
    }
}
