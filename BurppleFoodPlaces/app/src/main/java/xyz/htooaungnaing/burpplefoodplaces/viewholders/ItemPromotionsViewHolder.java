package xyz.htooaungnaing.burpplefoodplaces.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.htooaungnaing.burpplefoodplaces.R;
import xyz.htooaungnaing.burpplefoodplaces.data.vo.PromotionVO;

/**
 * Created by htoo on 1/5/2018.
 */

public class ItemPromotionsViewHolder extends RecyclerView.ViewHolder {

    private PromotionVO mPromotion;

    @BindView(R.id.iv_promotions)
    ImageView ivPromotions;

    @BindView(R.id.tv_promotions_content)
    TextView tvPromotionContent;

    @BindView(R.id.tv_due_date)
    TextView tvDueDate;

    @BindView(R.id.tv_promotions_address)
    TextView tvPromotionAddress;

    @BindView(R.id.tv_promotions_city)
    TextView tvPromotionsCity;

    public ItemPromotionsViewHolder(View itemView) {
        super(itemView);

        ButterKnife.bind(this,itemView);
    }

    public void setFoodPromotion(PromotionVO promotion){
        Glide.with(ivPromotions.getContext())
                .load(promotion.getBurpplePromotionImage())
                .into(ivPromotions);

        tvPromotionContent.setText(promotion.getBurpplePromotionTitle());
        tvPromotionAddress.setText(promotion.getBurpplePromotionShop().getBurppleShopName());
        tvPromotionsCity.setText(promotion.getBurpplePromotionShop().getBurppleShopArea());
    }
}
