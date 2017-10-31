package android.example.com.androidworkshop;

import android.content.Intent;
import android.example.com.androidworkshop.adapters.OrganisationUnitAdapter;
import android.example.com.androidworkshop.controllers.OrganisationUnitController;
import android.example.com.androidworkshop.models.OrganisationUnit;
import android.example.com.androidworkshop.network.DhisApi;
import android.example.com.androidworkshop.network.DhisServiceGenerator;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends FragmentActivity {
    private DhisApi dhisApi;

    private RecyclerView orgUnitListView;

    private ProgressBar spinner;
    private TextView messageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setViews();
        dhisApi = DhisServiceGenerator.createService();
    }

    public void navigateToOrgUnitEdit(OrganisationUnit orgUnit) {
        Intent editAcitivity = new Intent(MainActivity.this, OrganisationUnitEditActivity.class);
        editAcitivity.putExtra("orgUnit", orgUnit);

        MainActivity.this.startActivity(editAcitivity);
    }

    private void setViews() {
        setContentView(R.layout.activity_main);
        messageTextView = (TextView) findViewById(R.id.message);
        setOrgUnitListView();
        setSpinner();
        setButtons();
    }

    private void setOrgUnitListView() {
        orgUnitListView = (RecyclerView) findViewById(R.id.orgUnitList);
        orgUnitListView.setLayoutManager(new LinearLayoutManager(this));

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        orgUnitListView.setLayoutManager(mLayoutManager);
        orgUnitListView.setItemAnimator(new DefaultItemAnimator());
    }

    public void setAdapterToListView(List<OrganisationUnit> organisationUnits) {
        OrganisationUnitAdapter.OnItemClickListener listener = orgUnit ->
                Toast.makeText(
                        getApplicationContext(),
                        orgUnit.getDisplayName() + " Clicked",
                        Toast.LENGTH_SHORT).show();

        orgUnitListView.setAdapter(
                new OrganisationUnitAdapter(organisationUnits,
                        R.layout.list_item_org_unit,
                        getApplicationContext(),
                        listener));
    }

    private void setSpinner() {
        spinner = (ProgressBar) findViewById(R.id.spinner);
        spinner.setVisibility(View.GONE);
    }

    private void setButtons() {
        Button getOrgUnitsButton = (Button) findViewById(R.id.getAllOrgUnits);
        Button getAdonkiaButton = (Button) findViewById(R.id.getAdonkia);
        Button getCreateButton = (Button) findViewById(R.id.createProgram);

        getAdonkiaButton.setOnClickListener(v -> OrganisationUnitController
                .getOrgUnitById("Rp268JB6Ne4", this));
        getOrgUnitsButton.setOnClickListener(v -> OrganisationUnitController
                .getOrgUnits(this));
        getCreateButton.setOnClickListener(v -> navigateToCreateProgramActivity());
    }

    private void navigateToCreateProgramActivity() {
        Intent createProgramAcitivity = new Intent(MainActivity.this, ProgramCreateActivity.class);
        MainActivity.this.startActivity(createProgramAcitivity);
    }

    public void turnOfSpinner() {
        spinner.setVisibility(View.GONE);
    }

    public void turnOnSpinner() {
        spinner.setVisibility(View.VISIBLE);
    }

    public DhisApi getApi() {
        return dhisApi;
    }

    public TextView getMessageTextView(){
        return messageTextView;
    }
}