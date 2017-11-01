package android.example.com.androidworkshop.network;


/*
 * Created by John Melin on 19/10/2017.
 */

import android.example.com.androidworkshop.models.OrganisationUnit;
import android.example.com.androidworkshop.models.Program;
import android.example.com.androidworkshop.models.SystemInfo;
import android.example.com.androidworkshop.models.UserAccount;

import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 *  This is where all the REST api endpoints go.
 *
 *  Call is a default Retrofit call. The Observable instead of Call, means that you can use the
 *  RxJava library for handling responses.
 *
 *
 *  A call has a
 *  - REQUEST: GET/PUT/POST/DELETE
 *  - RETURN VALUE: Call<return value>
 *  - FUNCTION NAME: e.g getSystemInfo()
 *  - PARAMETERS: e.g String name
 *
 *  - ANNOTATION ARGUMENT: Bundled with a corresponding parameter and is
 *    translated by retrofit into JSON.
 *
 *    @PATH: Will create a REST parameter from the JAVA parameter. e.g
 *    @Path("id") String organisationUnitId will translate "organisationUnitId"
 *    into the parameter "id" that can be read by the REST url call.
 *
 *    @QueryMap: Will provide a sort of "bundle" of arguments in one Object.
 *    The content of the Map will be the arguments.
 *
 *    @Body: Will provide a complete object as the argument.
 *
 *
 *  Notice that the urls never should start with a "/". Doing so will make
 *  the urls absolute and the baseurl will be reduced to something like:
 *  play.dhis2.org/me instead of play.dhis2.org/api/me.
 *
 *
 **/
public interface DhisApi {
    /////////////////////////////////////////////////////////////////////////
    // Methods for getting user information
    /////////////////////////////////////////////////////////////////////////

    @GET("system/info/")
    Call<SystemInfo> getSystemInfo();

    @GET("me/")
    Call<UserAccount> getCurrentUserAccount(@QueryMap Map<String, String> queryParams);

    /////////////////////////////////////////////////////////////////////////
    // Methods for organisation units
    /////////////////////////////////////////////////////////////////////////

    @GET(ApiEndpointConstants.ORGANISATIONUNITS + "/{id}")
    Call<OrganisationUnit> getOrganisationUnitById(@Path("id") String organisationUnitId);

    @GET(ApiEndpointConstants.ORGANISATIONUNITS + "?paging=false")
    Call<Map<String,List<OrganisationUnit>>> getOrganisationUnits(
            @QueryMap(encoded = false) Map<String,String> queryMap);

    @PUT(ApiEndpointConstants.ORGANISATIONUNITS + "/{id}")
    Call<ResponseBody> putOrganisationUnitById(@Path("id") String organisationUnitId,
                                               @Body OrganisationUnit organisationUnit);


    /////////////////////////////////////////////////////////////////////////
    // Methods for programs
    /////////////////////////////////////////////////////////////////////////

    @GET(ApiEndpointConstants.PROGRAMS + "/{id}")
    Call<Program> getProgramById(@Path("id") String programUid, @QueryMap Map<String, String> queryMap);

    @POST(ApiEndpointConstants.PROGRAMS + "/")
    Call<ResponseBody> createProgram(@Body Program program);

    @DELETE(ApiEndpointConstants.PROGRAMS + "/{id}")
    Call<ResponseBody> deleteProgram(@Path("id") String id);
}
