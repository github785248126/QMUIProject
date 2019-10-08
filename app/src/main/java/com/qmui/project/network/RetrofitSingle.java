package com.qmui.project.network;
import android.util.Log;
import com.google.gson.Gson;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Create by cbh on 2019/1/18
 * e-mail:yoursilib@qq.com
 */
public class RetrofitSingle {
    private static RetrofitSingle retrofitUtil = null;
    private static OkHttpClient okHttpClient;
    public static RetrofitSingle getInstance() {
        if (retrofitUtil == null) {
            synchronized (RetrofitSingle.class){
                if (retrofitUtil == null) {
                    retrofitUtil = new RetrofitSingle();
                }
            }
        }
        return retrofitUtil;
    }

    public Retrofit retrofit(){
        return new Retrofit.Builder()
                .baseUrl("http://v.juhe.cn/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(getOkHttpClient())
                .build();
    }

    private static OkHttpClient getOkHttpClient() {
        if (okHttpClient == null) {
            synchronized (OkHttpClient.class) {
                if (okHttpClient == null) {
                    try {
                        okHttpClient = new OkHttpClient.Builder()
                                .addInterceptor(new Interceptor() {
                                    @Override
                                    public Response intercept(Chain chain) throws IOException {
                                        Request request = chain.request();
                                        Log.e("NetWorkURL - ",request.method() + " - " + request.url());
                                        return chain.proceed(request);
                                    }
                                }).build();
                        return okHttpClient;
                    } catch (Exception e) {
                        Log.e("OkHttpClient - ",e.getMessage());
                    }
                }
            }
        }
        return okHttpClient;
    }
}
