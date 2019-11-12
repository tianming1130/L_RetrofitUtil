package com.example.administrator.l_retrofitutil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.administrator.l_retrofitutil.adapter.MenuAdapter;
import com.example.administrator.l_retrofitutil.bean.Menu;
import com.example.administrator.l_retrofitutil.net.HttpResult;
import com.example.administrator.l_retrofitutil.net.RetrofitUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG ="MainActivity" ;
    private Button mBtnGetData;
    private RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnGetData=(Button)findViewById(R.id.btn_get_data);
        mRecyclerView=(RecyclerView)findViewById(R.id.recycler_view);

        mBtnGetData.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        RetrofitUtil.getInstance().getMenus(new Callback<HttpResult<List<Menu>>>() {
            @Override
            public void onResponse(Call<HttpResult<List<Menu>>> call, Response<HttpResult<List<Menu>>> response) {
                MenuAdapter adapter=new MenuAdapter(R.layout.item_view,response.body().getData());
                mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                mRecyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<HttpResult<List<Menu>>> call, Throwable t) {

            }
        });

    }
}
