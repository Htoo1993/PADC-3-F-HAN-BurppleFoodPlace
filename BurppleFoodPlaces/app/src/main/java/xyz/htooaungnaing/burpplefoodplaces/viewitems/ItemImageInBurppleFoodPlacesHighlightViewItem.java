package xyz.htooaungnaing.burpplefoodplaces.viewitems;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.htooaungnaing.burpplefoodplaces.R;
import xyz.htooaungnaing.burpplefoodplaces.data.vo.FoodHighlightVO;

/**
 * Created by htoo on 1/5/2018.
 */

public class ItemImageInBurppleFoodPlacesHighlightViewItem extends FrameLayout {

    @BindView(R.id.iv_foods_highlight)
    ImageView ivFoodsHighlight;

    @BindView(R.id.tv_highlight_features)
    TextView tvHighlightFeatures;

    @BindView(R.id.tv_highlight_title)
    TextView tvHighlightTitle;

    @BindView(R.id.tv_highlight_content)
    TextView tvHighlightContent;

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

    public void setData(FoodHighlightVO highlight){
        Glide.with(ivFoodsHighlight.getContext())
                .load(highlight.getBurppleFeaturedImage())
                .into(ivFoodsHighlight);

        tvHighlightFeatures.setText(highlight.getBurppleFeaturedTag());
        tvHighlightTitle.setText(highlight.getBurppleFeaturedTitle());
        tvHighlightContent.setText(highlight.getBurppleFeaturedDesc());
    }

}
