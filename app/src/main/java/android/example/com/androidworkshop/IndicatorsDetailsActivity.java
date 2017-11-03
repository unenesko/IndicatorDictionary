package android.example.com.androidworkshop;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.example.com.androidworkshop.models.DataValue;
import android.example.com.androidworkshop.models.Indicator;
import android.example.com.androidworkshop.network.DhisApi;
import android.example.com.androidworkshop.network.DhisServiceGenerator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.SearchView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IndicatorsDetailsActivity extends AppCompatActivity {
    DhisApi dhisApi;
    boolean isEditing=false;
    private ShareActionProvider mShareActionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indicators_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        dhisApi = DhisServiceGenerator.createService();

        Indicator indicator = (Indicator) getIntent().getSerializableExtra("indicator");

        TextView name = (TextView) findViewById(R.id.name);
        TextView description = (TextView) findViewById(R.id.description);
        TextView lastUpdated = (TextView) findViewById(R.id.lastUpdated);
        TextView created = (TextView) findViewById(R.id.created);
        TextView user = (TextView) findViewById(R.id.user);

        TextView numerator = (TextView) findViewById(R.id.numerator);
        TextView denominator = (TextView) findViewById(R.id.denominator);
        TextView factor = (TextView) findViewById(R.id.factor);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // WebView browser = (WebView) findViewById(R.id.webview);

        name.setText(indicator.getName());
        description.setText(indicator.getDescription());
        lastUpdated.setText("2015-20-01");
        created.setText("2017-08-03");

        user.setText(indicator.getUser().getId() + "");
        numerator.setText(indicator.getNumeratorDescription());
        denominator.setText(indicator.getDenominatorDescription());
        factor.setText(indicator.getIndicatorType().getId());

        TabHost host = (TabHost) findViewById(R.id.tabHost);
        host.setup();

        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("Data");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Data");
        host.addTab(spec);

        //Tab 2
        spec = host.newTabSpec("Formula");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Formula");
        host.addTab(spec);

        //Tab 3
        spec = host.newTabSpec("Management");
        spec.setContent(R.id.tab3);
        spec.setIndicator("Management");
        host.addTab(spec);


        final Map<String, String> QUERY_MAP_FULL = new HashMap<>();
        QUERY_MAP_FULL.put("fields", "*");
        QUERY_MAP_FULL.put("dimension", "dx:" + indicator.getId());

        dhisApi.getDataValue(QUERY_MAP_FULL).enqueue(new Callback<Map<String, List<DataValue>>>() {
            @Override
            public void onResponse(Call<Map<String, List<DataValue>>> call, Response<Map<String, List<DataValue>>> response) {

                if (response.isSuccessful()) {
                    List<DataValue> indicators = response.body().get("dataValues");
                    //assign the Indicator List to a global class
                    //IndicatorsData.setIndicators(indicators);
                    //passDataToAdapter(rv, indicators);
                    // setTextMessage("--------" + indicators.get(0).getValue() + "--" + indicators.get(0).getPeriod() + "--------" + indicators.get(1).getValue());
                    GraphView graph = (GraphView) findViewById(R.id.graph);


                    LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{

                            new DataPoint(Integer.parseInt(indicators.get(0).getPeriod()), indicators.get(0).getValue()),
                            new DataPoint(Integer.parseInt(indicators.get(1).getPeriod()), indicators.get(1).getValue()),
                            // new DataPoint(Integer.parseInt(indicators.get(2).getPeriod()),indicators.get(2).getValue())
                    });

                    graph.addSeries(series);
                    graph.setTitle(indicators.get(0).getOrgUnit());


                } else {
                    // setTextMessage(response.message());
                    Toast.makeText(getApplicationContext(), response.message(), Toast.LENGTH_LONG).show();
                    Log.d("msg", response.message());
                }
            }

            @Override
            public void onFailure(Call<Map<String, List<DataValue>>> call, Throwable t) {

                setTextMessage(t.getMessage());
                // Toast.makeText(getApplicationContext(),t.getMessage()+"",Toast.LENGTH_LONG).show();
            }
        });

//        browser.loadUrl("https://play.dhis2.org/demo/api/charts/C2anHS9bjJr/data");
//        browser.canZoomIn();
//        browser.canZoomOut();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                if (isEditing) {
                    name.setEnabled(false);
                    description.setEnabled(false);
                    //fab.setImageDrawable(R.);
                    Toast.makeText(getApplicationContext(),"Indicator updated",Toast.LENGTH_LONG).show();
                    isEditing = false;
                } else {
                    name.setEnabled(true);
                    description.setEnabled(true);
                    isEditing = true;
                }



                // fab.setImageResource();
              //  Snackbar.make(view, "You don't have permission to perfom this action", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate menu resource file.
        getMenuInflater().inflate(R.menu.options_menu_details, menu);

        // Locate MenuItem with ShareActionProvider
        MenuItem item = menu.findItem(R.id.share);

        return true;
        // Fetch and store ShareActionProvider
      //  mShareActionProvider = (ShareActionProvider) item.getActionProvider();

        // Return true to display menu
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection

                switch (item.getItemId()) {
                    case R.id.home:
                        // app icon in action bar clicked; goto parent activity.
                        this.finish();
                        return true;
                    case R.id.share:
                        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                        sharingIntent.setType("text/plain");
                        String shareBody = "Here is the share content body";
                        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                        startActivity(Intent.createChooser(sharingIntent, "Share via"));
                        return true;
                    default:
                        return super.onOptionsItemSelected(item);
                }


    }



    private void setTextMessage(String message) {
        TextView text = (TextView) findViewById(R.id.t3);
        text.setText(message);
    }

    private void setShareIntent(Intent shareIntent) {
        if (mShareActionProvider != null) {
            mShareActionProvider.setShareIntent(shareIntent);
        }
    }
}
