package android.example.com.androidworkshop;

/*
 * Created by John Melin on 29/10/2017.
 */

import android.content.Intent;
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
    private OrganisationUnit orgUnit;
    private TextView name;
    private TextView openingDate;
    private TextView parentName;
    private TextView level;
    private Button updateButton;
    private ProgressBar spinner;

    private DhisApi dhisApi;

    public OrganisationUnitEditActivity() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_org_unit);

        dhisApi = DhisServiceGenerator.createService();
        setupViews();
        getIntentContent();
        upDateViewsWithContent();
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

    private void getIntentContent(){
        Intent intent = getIntent();
        orgUnit = (OrganisationUnit) intent.getSerializableExtra("orgUnit");
    }

    private void upDateViewsWithContent(){
        name.setText(orgUnit.getDisplayName());
        openingDate.setText(orgUnit.getOpeningDate().toString());
        parentName.setText("Parent id: " + orgUnit.getParent().getId());
        level.setText("Level: " + orgUnit.getLevel());
    }

    private void updateOrganisationUnit(View view) {
        spinner.setVisibility(View.VISIBLE);
        orgUnit.setDisplayName(name.getText().toString());
        orgUnit.setDisplayName(openingDate.getText().toString());

        dhisApi.putOrganisationUnitById(orgUnit.getId(), orgUnit).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                spinner.setVisibility(View.GONE);
                Toast.makeText(
                        getApplicationContext(),
                        response.message(),
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                spinner.setVisibility(View.GONE);
                Toast.makeText(
                        getApplicationContext(),
                        t.getMessage(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
