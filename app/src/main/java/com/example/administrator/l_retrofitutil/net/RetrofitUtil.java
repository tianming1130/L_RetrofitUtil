package com.example.administrator.l_retrofitutil.net;

import com.example.administrator.l_retrofitutil.bean.Menu;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2019/11/12.
 */

public class RetrofitUtil {
    private static RetrofitUtil mRetrofitUtil;
    private static final String BASE_URL="http://10.0.2.2/";
    private ApiService mApiService;

    private RetrofitUtil(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mApiService=retrofit.create(ApiService.class);
    }
    public static RetrofitUtil getInstance(){
        if (mRetrofitUtil==null){
            mRetrofitUtil=new RetrofitUtil();
        }
        return mRetrofitUtil;
    }

    public void getMenus(Callback<HttpResult<List<Menu>>> callback){
        Call<HttpResult<List<Menu>>> call=mApiService.getMenus();
        call.enqueue(callback);
    }
}
