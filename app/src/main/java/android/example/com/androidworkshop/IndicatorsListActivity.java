package android.example.com.androidworkshop;

import android.app.Activity;
import android.content.Intent;
import android.example.com.androidworkshop.models.Indicator;
import android.example.com.androidworkshop.network.DhisApi;
import android.example.com.androidworkshop.network.DhisServiceGenerator;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IndicatorsListActivity extends Activity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    DhisApi dhisApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indicators_list);
        dhisApi = DhisServiceGenerator.createService();

        RecyclerView rv = (RecyclerView) findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getBaseContext());
        rv.setLayoutManager(llm);

        rv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IndicatorsListActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        getIndicators(rv);


    }
    public void getIndicators(RecyclerView rv)
    {
        final Map<String, String> QUERY_MAP_FULL = new HashMap<>();
        QUERY_MAP_FULL.put("fields", "*");

        dhisApi.getIndicators(QUERY_MAP_FULL).enqueue(new Callback<Map<String, List<Indicator>>>() {
            @Override
            public void onResponse(Call<Map<String, List<Indicator>>> call, Response<Map<String, List<Indicator>>> response) {
                //turnOffSpinner();
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
                //turnOffSpinner();
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
}