package xyz.htooaungnaing.burpplefoodplaces.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.htooaungnaing.burpplefoodplaces.R;
import xyz.htooaungnaing.burpplefoodplaces.viewholders.ItemNewsAndTrendingNewsViewHolder;

/**
 * Created by htoo on 1/8/2018.
 */

public class ItemNewsAndTrendingNewsAdapter extends RecyclerView.Adapter {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_news_and_tending_news,parent,false);
        ItemNewsAndTrendingNewsViewHolder itemNewsAndTrendingNewsViewHolder = new ItemNewsAndTrendingNewsViewHolder(view);
        return itemNewsAndTrendingNewsViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
