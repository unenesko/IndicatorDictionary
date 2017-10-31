package android.example.com.androidworkshop;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button getAdonkiaButton = (Button) findViewById(R.id.getAdonkia);
        Button getCreateButton = (Button) findViewById(R.id.createProgram);

        getAdonkiaButton.setOnClickListener(v -> navigateToEditOrgUnitActicity());
        getCreateButton.setOnClickListener(v -> navigateToCreateProgramActivity());
    }

    private void navigateToEditOrgUnitActicity(){
        Intent editOrgUnitActivity = new Intent(this, OrganisationUnitEditActivity.class);
        this.startActivity(editOrgUnitActivity);
    }

    private void navigateToCreateProgramActivity() {
        Intent createProgramAcitivity = new Intent(this, ProgramCreateActivity.class);
        this.startActivity(createProgramAcitivity);
    }
}