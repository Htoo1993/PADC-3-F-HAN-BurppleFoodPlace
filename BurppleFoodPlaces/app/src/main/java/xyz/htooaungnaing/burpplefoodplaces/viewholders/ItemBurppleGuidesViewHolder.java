package xyz.htooaungnaing.burpplefoodplaces.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.htooaungnaing.burpplefoodplaces.R;
import xyz.htooaungnaing.burpplefoodplaces.data.vo.GuidesVO;

/**
 * Created by htoo on 1/5/2018.
 */

public class ItemBurppleGuidesViewHolder extends RecyclerView.ViewHolder {

    private GuidesVO mGuides;

    @BindView(R.id.iv_burpple_guides)
    ImageView ivBurppleGuides;

    @BindView(R.id.tv_china_town)
    TextView tvChinaTown;

    public ItemBurppleGuidesViewHolder(View itemView) {
        super(itemView);

        ButterKnife.bind(this,itemView);
    }

    public void setFoodGuides(GuidesVO guides){

        tvChinaTown.setText(guides.getBurppleGuideTitle());

        Glide.with(ivBurppleGuides.getContext())
                .load(guides.getBurppleGuideImage())
                .into(ivBurppleGuides);
    }
}
