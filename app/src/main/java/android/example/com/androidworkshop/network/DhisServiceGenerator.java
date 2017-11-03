package android.example.com.androidworkshop.network;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/*
 * Created by John Melin on 21/10/2017.
 */

public class DhisServiceGenerator {
    final private static String SERVER_URL = "https://play.dhis2.org/demo/api/";

//final private static String SERVER_URL = "https://dhis2.org.mz/hosp1/api/";
    final private static String USERNAME = "admin";
    final private static String PASS = "district";

    private static Retrofit retrofit = provideRetroFit(SERVER_URL);

    public static DhisApi createService() {
        return retrofit.create(DhisApi.class);
    }

    private static Retrofit provideRetroFit(String SERVER_URL) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(SERVER_URL)
                .client(provideOkHttpClient())
                .build();
    }

    private static OkHttpClient provideOkHttpClient() {
        return new OkHttpClient()
                .newBuilder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(provideInterceptor())
                .build();
    }

    private static Interceptor provideInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                String base64Credentials = Credentials.basic(USERNAME, PASS);
                Request originalRequest = chain.request()
                        .newBuilder()
                        .addHeader("Authorization", base64Credentials)
                        .build();
                return chain.proceed(originalRequest);
            }
        };
    }
}