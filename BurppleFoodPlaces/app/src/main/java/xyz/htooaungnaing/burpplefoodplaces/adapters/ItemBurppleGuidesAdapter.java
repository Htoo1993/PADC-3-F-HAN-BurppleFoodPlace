package xyz.htooaungnaing.burpplefoodplaces.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import xyz.htooaungnaing.burpplefoodplaces.R;
import xyz.htooaungnaing.burpplefoodplaces.data.vo.GuidesVO;
import xyz.htooaungnaing.burpplefoodplaces.viewholders.ItemBurppleGuidesViewHolder;

/**
 * Created by htoo on 1/5/2018.
 */

public class ItemBurppleGuidesAdapter extends RecyclerView.Adapter<ItemBurppleGuidesViewHolder> {

    private List<GuidesVO> mFoodGuidesList;

    public ItemBurppleGuidesAdapter(){
        mFoodGuidesList = new ArrayList<>();
    }

    @Override
    public ItemBurppleGuidesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_burpple_guides,parent,false);
        ItemBurppleGuidesViewHolder itemBurppleGuidesViewHolder = new ItemBurppleGuidesViewHolder(view);

        return itemBurppleGuidesViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemBurppleGuidesViewHolder holder, int position) {
        holder.setFoodGuides(mFoodGuidesList.get(position));
    }

    @Override
    public int getItemCount() {
        return mFoodGuidesList.size();
    }

    public void setFoodGuides(List<GuidesVO> guidesLsit){
        mFoodGuidesList = guidesLsit;
        notifyDataSetChanged();
    }
}
