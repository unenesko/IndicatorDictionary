package android.example.com.androidworkshop.controllers;

/*
 * Created by John Melin on 27/10/2017.
 */

import android.example.com.androidworkshop.MainActivity;
import android.example.com.androidworkshop.R;
import android.example.com.androidworkshop.models.OrganisationUnit;
import android.example.com.androidworkshop.network.DhisApi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrganisationUnitController {
    private DhisApi dhisApi;
    /**
     * This example uses async Observables.
     */
    public static void getOrgUnitById(String id, MainActivity mainActivity) {
        mainActivity.turnOnSpinner();
        mainActivity.getApi().getOrganisationUnitById(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally(mainActivity::turnOfSpinner)
                .subscribe(mainActivity::navigateToOrgUnitEdit,
                        e -> mainActivity
                                .getMessageTextView()
                                .setText(e.getCause().toString()));
    }

    /**
     * A retrofit async all is initiated by the enqueue() function and expects a callback.
     */
    public static void getOrgUnits(MainActivity mainActivity) {
        mainActivity.turnOnSpinner();
        Map<String, String> queryMap = new HashMap<>();

        // retrofit will request the fields "id" and "displayName" from the webApi.
        queryMap.put("fields", "[id,displayName]");

        mainActivity.getApi().getOrganisationUnits(queryMap).enqueue(new Callback<Map<String, List<OrganisationUnit>>>() {
            @Override
            public void onResponse(Call<Map<String, List<OrganisationUnit>>> call,
                                   Response<Map<String, List<OrganisationUnit>>> response) {
                mainActivity.turnOfSpinner();
                if (response.isSuccessful()) {
                    mainActivity.getMessageTextView().setText(R.string.got_org_units);
                    mainActivity.setAdapterToListView(response.body().get("organisationUnits"));
                } else {
                    mainActivity.getMessageTextView().setText(response.message());
                }
            }

            @Override
            public void onFailure(Call<Map<String, List<OrganisationUnit>>> call, Throwable t) {
                mainActivity.turnOfSpinner();
                mainActivity.getMessageTextView().setText(t.getMessage());
            }
        });
    }
}
