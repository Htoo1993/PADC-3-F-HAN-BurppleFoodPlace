package xyz.htooaungnaing.burpplefoodplaces.viewpods;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.htooaungnaing.burpplefoodplaces.R;
import xyz.htooaungnaing.burpplefoodplaces.delegates.BeforeLoginDelegate;

/**
 * Created by htoo on 1/24/2018.
 */

public class BeforeLoginUserViewPod extends RelativeLayout {

    private BeforeLoginDelegate mBeforeLoginDelegate;

    public BeforeLoginUserViewPod(Context context) {
        super(context);
    }

    public BeforeLoginUserViewPod(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BeforeLoginUserViewPod(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        ButterKnife.bind(this,this);
    }

    public void setDelegate(BeforeLoginDelegate delegate){
        mBeforeLoginDelegate = delegate;
    }

    @OnClick(R.id.btn_to_login)
    public void onTapLogin(View view){
        mBeforeLoginDelegate.onTapLogin();
    }

    @OnClick(R.id.btn_to_register)
    public void onTapRegister(View view){
        mBeforeLoginDelegate.onTapRegister();
    }
}
