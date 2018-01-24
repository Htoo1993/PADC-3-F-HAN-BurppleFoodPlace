package xyz.htooaungnaing.burpplefoodplaces.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import xyz.htooaungnaing.burpplefoodplaces.R;
import xyz.htooaungnaing.burpplefoodplaces.fragments.LoginFragment;
import xyz.htooaungnaing.burpplefoodplaces.fragments.RegisterFragment;

/**
 * Created by htoo on 1/24/2018.
 */

public class SwitchAccountActivity extends AppCompatActivity {

    private static final String IE_SCREEN_TYPE = "IE_SCREEN_TYPE";
    private static final int SCREEN_TYPE_LOGIN = 1;
    private static final int SCREEN_TYPE_REGISTER = 2;

    public static Intent newIntentLogin(Context context){
        Intent intent = new Intent(context,SwitchAccountActivity.class);
        intent.putExtra(IE_SCREEN_TYPE, SCREEN_TYPE_LOGIN);
        return intent;
    }

    public static Intent newIntentRegister(Context context){
        Intent intent = new Intent(context,SwitchAccountActivity.class);
        intent.putExtra(IE_SCREEN_TYPE, SCREEN_TYPE_REGISTER);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_account_control);

        int screenType = getIntent().getIntExtra(IE_SCREEN_TYPE, -1);
        if(screenType == SCREEN_TYPE_LOGIN){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_switch_account, new LoginFragment())
                    .commit();
        } else if (screenType == SCREEN_TYPE_REGISTER){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_switch_account, new RegisterFragment())
                    .commit();
        }
    }
}
