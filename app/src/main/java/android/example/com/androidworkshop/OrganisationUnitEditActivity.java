package android.example.com.androidworkshop;

/*
 * Created by John Melin on 29/10/2017.
 */

import android.example.com.androidworkshop.models.OrganisationUnit;
import android.example.com.androidworkshop.network.DhisApi;
import android.example.com.androidworkshop.network.DhisServiceGenerator;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrganisationUnitEditActivity extends FragmentActivity {
    private TextView name;
    private TextView openingDate;
    private TextView parentName;
    private TextView level;
    private Button updateButton;
    private ProgressBar spinner;

    private OrganisationUnit orgUnit;

    private DhisApi dhisApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_org_unit);
        orgUnit = new OrganisationUnit();
        setupViews();

        dhisApi = DhisServiceGenerator.createService();
        getOrgUnitById("Rp268JB6Ne4");
    }

    private void getOrgUnitById(String id) {
        turnOnSpinner();
        dhisApi.getOrganisationUnitById(id).enqueue(new Callback<OrganisationUnit>() {
            @Override
            public void onResponse(Call<OrganisationUnit> call, Response<OrganisationUnit> response) {
                turnOffSpinner();
                if (response.isSuccessful()){
                    orgUnit = response.body();
                    updateFields();
                } else {
                   displayToastMessage(response.message());
                }
            }

            @Override
            public void onFailure(Call<OrganisationUnit> call, Throwable t) {
                turnOffSpinner();
                displayToastMessage(t.getMessage());
            }
        });
    }

    private void updateOrganisationUnit(View view) {
        turnOnSpinner();

        orgUnit.setDisplayName(name.getText().toString());
        orgUnit.setDisplayName(openingDate.getText().toString());

        dhisApi.putOrganisationUnitById(orgUnit.getId(), orgUnit).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                turnOffSpinner();
                displayToastMessage(response.message());
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                turnOffSpinner();
                displayToastMessage(t.getMessage());
            }
        });
    }

    private void turnOnSpinner(){
        spinner.setVisibility(View.VISIBLE);
    }

    private void turnOffSpinner(){
        spinner.setVisibility(View.GONE);
    }

    private void setupViews(){
        name = (TextView) findViewById(R.id.name);
        openingDate = (TextView) findViewById(R.id.opening_date);
        parentName = (TextView) findViewById(R.id.parent_name);
        level = (TextView) findViewById(R.id.level);
        updateButton = (Button) findViewById(R.id.update_org_unit);
        spinner = (ProgressBar) findViewById(R.id.spinner);
        spinner.setVisibility(View.GONE);

        updateButton.setOnClickListener(this::updateOrganisationUnit);
    }

    private void updateFields(){
        name.setText(orgUnit.getDisplayName());

    }

    private void displayToastMessage(String message){
        Toast.makeText(
                getApplicationContext(),
                message,
                Toast.LENGTH_SHORT).show();
    }
}
