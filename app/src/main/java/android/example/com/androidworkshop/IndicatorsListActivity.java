package android.example.com.androidworkshop;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.example.com.androidworkshop.models.Indicator;
import android.example.com.androidworkshop.models.User;
import android.example.com.androidworkshop.network.DhisApi;
import android.example.com.androidworkshop.network.DhisServiceGenerator;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IndicatorsListActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    DhisApi dhisApi;
    ProgressBar spinner;
    ImageView bt_offline;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indicators_list);
        dhisApi = DhisServiceGenerator.createService();

        RecyclerView rv = (RecyclerView) findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getBaseContext());
        rv.setLayoutManager(llm);

        List<Indicator> indicators = new ArrayList<>();
        Indicator a=new Indicator();
        User u= new User();
        u.setSurName("Doe");
        u.setFirstName("John");

        a.setUser(u);

        a.setName("How to add a fragment to the previous layout:");
        a.setDescription("Keep in mind that when you perform fragment transactions, such as replace or remove one. To allow the user to navigate backward through the fragment transactions");

indicators.add(a);
        indicators.add(a);
        indicators.add(a);
        indicators.add(a);

        spinner = (ProgressBar) findViewById(R.id.spinner);
        spinner.setVisibility(View.GONE);
        bt_offline=(ImageView) findViewById(R.id.image_offlinewrap_content);
        bt_offline.setVisibility(View.GONE);

        if(isOnline()){
            getIndicators(rv);
        } else {
            bt_offline.setVisibility(View.VISIBLE);
           // Toast.makeText(getApplicationContext(),"You are not connected to internet, please check your connection settings!",Toast.LENGTH_LONG).show();
             Snackbar.make(rv, "You are not connected to internet, please check your connection settings!", Snackbar.LENGTH_INDEFINITE)
                    .setAction("Action", null).show();
        }

////        TemporaryData.indicatorList=indicators;
////        //setTextMessage(indicators.size() + "");\
////        //Toast.makeText(getApplicationContext(),TemporaryData.indicatorList.size()+"",Toast.LENGTH_LONG).show();
////        IndicatorsListAdapter adapter = new IndicatorsListAdapter(TemporaryData.indicatorList);
////        rv.setAdapter(adapter);TemporaryData.indicatorList=indicators;
//        //setTextMessage(indicators.size() + "");\
//        //Toast.makeText(getApplicationContext(),TemporaryData.indicatorList.size()+"",Toast.LENGTH_LONG).show();
//        IndicatorsListAdapter adapter = new IndicatorsListAdapter(TemporaryData.indicatorList);
//        rv.setAdapter(adapter);


    }


    public void getIndicators(RecyclerView rv)
    {
        turnOnSpinner();
        final Map<String, String> QUERY_MAP_FULL = new HashMap<>();
        QUERY_MAP_FULL.put("fields", "*");

        dhisApi.getIndicators(QUERY_MAP_FULL).enqueue(new Callback<Map<String, List<Indicator>>>() {
            @Override
            public void onResponse(Call<Map<String, List<Indicator>>> call, Response<Map<String, List<Indicator>>> response) {
                turnOffSpinner();
                if (response.isSuccessful())
                {

                    List<Indicator> indicators =  response.body().get("indicators");
                    //assign the Indicator List to a global class
                    IndicatorsData.setIndicators(indicators);
                    passDataToAdapter(rv, indicators);
                } else {
                    // setTextMessage(response.message());
                    Toast.makeText(getApplicationContext(),response.message()+"",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Map<String, List<Indicator>>> call, Throwable t) {
                turnOffSpinner();
                // setTextMessage(t.getMessage());
                Toast.makeText(getApplicationContext(),t.getMessage()+"",Toast.LENGTH_LONG).show();
            }
        });
    }
    public void passDataToAdapter(RecyclerView rv, List<Indicator> indicators)
    {
        TemporaryData.indicatorList=indicators;
        //setTextMessage(indicators.size() + "");\
        //Toast.makeText(getApplicationContext(),TemporaryData.indicatorList.size()+"",Toast.LENGTH_LONG).show();
        IndicatorsListAdapter adapter = new IndicatorsListAdapter(TemporaryData.indicatorList);
        rv.setAdapter(adapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the options menu from XML
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        // Get the SearchView and set the searchable configuration
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        // Assumes current activity is the searchable activity
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(false); // Do not iconify the widget; expand it by default

        return true;
    }

    private void turnOnSpinner(){
        spinner.setVisibility(View.VISIBLE);
    }

    private void turnOffSpinner(){
        spinner.setVisibility(View.GONE);
    }

    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnectedOrConnecting();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection

        switch (item.getItemId()) {
            case R.id.home:
                // app icon in action bar clicked; goto parent activity.
                this.finish();
                return true;
            case R.id.settings:
                Intent intent = new Intent(getApplicationContext(),SettingsActivity.class);

                getApplicationContext().startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }
}