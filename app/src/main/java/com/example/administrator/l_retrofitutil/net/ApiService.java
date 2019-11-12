package com.example.administrator.l_retrofitutil.net;

import com.example.administrator.l_retrofitutil.bean.Menu;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2019/11/12.
 */

public interface ApiService {
    @GET("getdata.php")
    Call<HttpResult<List<Menu>>> getMenus();
}
