package xyz.htooaungnaing.burpplefoodplaces.activities;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.htooaungnaing.burpplefoodplaces.R;
import xyz.htooaungnaing.burpplefoodplaces.adapters.ItemBurppleFoodPlacesHighlightsAdapter;
import xyz.htooaungnaing.burpplefoodplaces.adapters.ItemBurppleGuidesAdapter;
import xyz.htooaungnaing.burpplefoodplaces.adapters.ItemNewNTrendingAdapter;
import xyz.htooaungnaing.burpplefoodplaces.adapters.ItemPromotionsAdapter;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.vp_burpple_food_places_highlight)
    ViewPager vpBurppleFoodPlacesHighlight;

    @BindView(R.id.rv_promotions)
    RecyclerView rvPromotions;

    @BindView(R.id.rv_burpple_guides)
    RecyclerView rvBurppleGuides;

    @BindView(R.id.rv_new_n_trending)
    RecyclerView rvNewNTrending;

    private ItemBurppleFoodPlacesHighlightsAdapter mItemBurppleFoodPlacesHighlightsAdapter;
    private ItemPromotionsAdapter mItemPromotionsAdapter;
    private ItemBurppleGuidesAdapter mItemBurppleGuidesAdapter;
    private ItemNewNTrendingAdapter mItemNewNTrendingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this,this);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        mItemBurppleFoodPlacesHighlightsAdapter = new ItemBurppleFoodPlacesHighlightsAdapter();
        vpBurppleFoodPlacesHighlight.setAdapter(mItemBurppleFoodPlacesHighlightsAdapter);

        mItemPromotionsAdapter = new ItemPromotionsAdapter();
        LinearLayoutManager rvPromotionsLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        rvPromotions.setLayoutManager(rvPromotionsLayoutManager);
        rvPromotions.setAdapter(mItemPromotionsAdapter);

        mItemBurppleGuidesAdapter = new ItemBurppleGuidesAdapter();
        LinearLayoutManager rvBurppleGuidesLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        rvBurppleGuides.setLayoutManager(rvBurppleGuidesLayoutManager);
        rvBurppleGuides.setAdapter(mItemBurppleGuidesAdapter);

        mItemNewNTrendingAdapter = new ItemNewNTrendingAdapter();
        LinearLayoutManager rvItemNewNTrendingLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL,false);
        rvNewNTrending.setLayoutManager(rvItemNewNTrendingLayoutManager);
        rvNewNTrending.setAdapter(mItemNewNTrendingAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
