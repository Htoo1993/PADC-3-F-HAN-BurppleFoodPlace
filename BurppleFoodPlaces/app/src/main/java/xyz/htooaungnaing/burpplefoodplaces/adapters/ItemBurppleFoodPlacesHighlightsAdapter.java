package xyz.htooaungnaing.burpplefoodplaces.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import xyz.htooaungnaing.burpplefoodplaces.R;
import xyz.htooaungnaing.burpplefoodplaces.data.vo.FoodHighlightVO;
import xyz.htooaungnaing.burpplefoodplaces.viewitems.ItemImageInBurppleFoodPlacesHighlightViewItem;

/**
 * Created by htoo on 1/5/2018.
 */

public class ItemBurppleFoodPlacesHighlightsAdapter extends PagerAdapter {

    private List<FoodHighlightVO> mFoodHighlightList;

    public ItemBurppleFoodPlacesHighlightsAdapter(){
        mFoodHighlightList = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return mFoodHighlightList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Context context = container.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        ItemImageInBurppleFoodPlacesHighlightViewItem viewItem = (ItemImageInBurppleFoodPlacesHighlightViewItem)layoutInflater.inflate(R.layout.item_burpple_food_places_highlight,container,false);
        container.addView(viewItem);

        viewItem.setData(mFoodHighlightList.get(position));

        return viewItem;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
        container.removeView((View)object);
    }

    public void setFoodHighLight(List<FoodHighlightVO> foodHighLightList){
        mFoodHighlightList = foodHighLightList;
        notifyDataSetChanged();
    }
}
