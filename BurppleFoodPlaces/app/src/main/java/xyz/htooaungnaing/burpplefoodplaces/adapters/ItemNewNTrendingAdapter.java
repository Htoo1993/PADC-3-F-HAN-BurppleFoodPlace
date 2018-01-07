package xyz.htooaungnaing.burpplefoodplaces.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.htooaungnaing.burpplefoodplaces.R;
import xyz.htooaungnaing.burpplefoodplaces.viewholders.ItemNewNTrendingViewHolder;

/**
 * Created by htoo on 1/6/2018.
 */

public class ItemNewNTrendingAdapter extends RecyclerView.Adapter {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_new_n_trending,parent,false);
        ItemNewNTrendingViewHolder itemNewNTrendingViewHolder = new ItemNewNTrendingViewHolder(view);

        return itemNewNTrendingViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
