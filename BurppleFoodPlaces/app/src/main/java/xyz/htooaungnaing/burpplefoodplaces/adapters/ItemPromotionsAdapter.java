package xyz.htooaungnaing.burpplefoodplaces.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import xyz.htooaungnaing.burpplefoodplaces.R;
import xyz.htooaungnaing.burpplefoodplaces.data.vo.PromotionVO;
import xyz.htooaungnaing.burpplefoodplaces.viewholders.ItemPromotionsViewHolder;

/**
 * Created by htoo on 1/5/2018.
 */

public class ItemPromotionsAdapter extends RecyclerView.Adapter<ItemPromotionsViewHolder> {

    private List<PromotionVO> mPromotionList;

    public ItemPromotionsAdapter(){
        mPromotionList = new ArrayList<>();
    }

    @Override
    public ItemPromotionsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_promotions,parent,false);
        ItemPromotionsViewHolder itemPromotionsViewHolder = new ItemPromotionsViewHolder(view);

        return itemPromotionsViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemPromotionsViewHolder holder, int position) {
        holder.setFoodPromotion(mPromotionList.get(position));
    }

    @Override
    public int getItemCount() {
        return mPromotionList.size();
    }

    public void setFoodPromotion(List<PromotionVO> promotionList){
        mPromotionList = promotionList;
        notifyDataSetChanged();
    }
}
