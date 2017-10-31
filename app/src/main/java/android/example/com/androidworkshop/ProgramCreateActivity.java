package android.example.com.androidworkshop;

import android.example.com.androidworkshop.models.Program;
import android.example.com.androidworkshop.models.ProgramType;
import android.example.com.androidworkshop.network.DhisApi;
import android.example.com.androidworkshop.network.DhisServiceGenerator;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;


import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/*
 * Created by John Melin on 29/10/2017.
 */

public class ProgramCreateActivity extends FragmentActivity {
    DhisApi dhisApi;
    TextView name;
    TextView shortName;
    Program program;
    Button createProgramButton;
    Button deleteProgramButton;
    Button getProgramButton;
    ProgressBar spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_program);

        name = (TextView) findViewById(R.id.name);
        shortName = (TextView) findViewById(R.id.short_name);
        spinner = (ProgressBar) findViewById(R.id.spinner);
        spinner.setVisibility(View.GONE);

        createProgramButton = (Button) findViewById(R.id.create_program);
        createProgramButton.setOnClickListener(v -> createProgram());

        deleteProgramButton = (Button) findViewById(R.id.delete_program);
        deleteProgramButton.setOnClickListener(v -> deleteProgram("IpHINAT79UW"));

        getProgramButton = (Button) findViewById(R.id.get_program);
        getProgramButton.setOnClickListener(v -> getProgram());


        dhisApi = DhisServiceGenerator.createService();
    }

    private void createProgram(){
        program = new Program();
        program.setName(name.getText().toString());
        program.setShortName(shortName.getText().toString());
        program.setProgramType(ProgramType.WITH_REGISTRATION);

        spinner.setVisibility(View.VISIBLE);
        dhisApi.createProgram(program).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                spinner.setVisibility(View.GONE);
                TextView text = (TextView) findViewById(R.id.textView);
                text.setText(response.message());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                spinner.setVisibility(View.GONE);
                TextView text = (TextView) findViewById(R.id.textView);
                text.setText(t.getMessage());
            }
        });

    }

    private void deleteProgram(String id){
        spinner.setVisibility(View.VISIBLE);
        dhisApi.deleteProgram(id).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                spinner.setVisibility(View.GONE);
                TextView text = (TextView) findViewById(R.id.textView);
                text.setText(response.message());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                spinner.setVisibility(View.GONE);
                TextView text = (TextView) findViewById(R.id.textView);
                text.setText(t.getMessage());
            }
        });
    }

    private void getProgram(){
        spinner.setVisibility(View.VISIBLE);

        final Map<String, String> QUERY_MAP_FULL = new HashMap<>();
        QUERY_MAP_FULL.put("fields",
                "*,trackedEntity[*]," +
                        "programIndicators[*]," +
                        "programStages[*,!dataEntryForm,program[id],programIndicators[*]," +
                        "programStageSections[*,programStageDataElements[*,programStage[id]," +
                        "dataElement[*,id,attributeValues[*,attribute[*]],optionSet[id]]],programIndicators[*]],programStageDataElements" +
                        "[*,programStage[id],dataElement[*,optionSet[id]]]],programTrackedEntityAttributes" +
                        "[*,trackedEntityAttribute[*]],!organisationUnits");
        dhisApi.getProgram("lxAQ7Zs9VYR", QUERY_MAP_FULL).enqueue(new Callback<Program>() {
            @Override
            public void onResponse(Call<Program> call, Response<Program> response) {
                spinner.setVisibility(View.GONE);
                if (response.isSuccessful()) {
                    TextView text = (TextView) findViewById(R.id.textView);
                    Program program = response.body();
                    text.setText(program.getShortName());
                } else {
                    TextView text = (TextView) findViewById(R.id.textView);
                    text.setText(response.message());
                }
            }

            @Override
            public void onFailure(Call<Program> call, Throwable t) {
                spinner.setVisibility(View.GONE);
                TextView text = (TextView) findViewById(R.id.textView);
                text.setText(t.getMessage());
            }
        });
    }
}
