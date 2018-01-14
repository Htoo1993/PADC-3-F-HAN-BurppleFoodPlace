package xyz.htooaungnaing.burpplefoodplaces.viewitems;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.htooaungnaing.burpplefoodplaces.R;

/**
 * Created by htoo on 1/5/2018.
 */

public class ItemImageInBurppleFoodPlacesHighlightViewItem extends FrameLayout {

    @BindView(R.id.iv_foods_highlight)
    ImageView ivFoodsHighlight;

    public ItemImageInBurppleFoodPlacesHighlightViewItem(@NonNull Context context) {
        super(context);
    }

    public ItemImageInBurppleFoodPlacesHighlightViewItem(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ItemImageInBurppleFoodPlacesHighlightViewItem(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this,this);
    }

    public void setData(String imageUrl){
        Glide.with(ivFoodsHighlight.getContext())
                .load(imageUrl)
                .into(ivFoodsHighlight);
    }

}
