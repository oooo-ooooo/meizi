package io.github.nuannuan;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.github.nuannuan.callback.ImageCallBack;
import io.github.nuannuan.modle.Images;
import io.github.nuannuan.network.OkHttpUtils;
import io.github.nuannuan.utils.MeiZiAPI;
import okhttp3.Call;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    @Bind(R.id.body)
    RecyclerView mRecyclerView;

    private MeiZiAdapter mMeiZiAdapter;
    private StaggeredGridLayoutManager layoutManager;
    private Context mContext = MainActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initView() {
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mMeiZiAdapter = new MeiZiAdapter(mContext);
        mRecyclerView.setAdapter(mMeiZiAdapter);
    }
    private void initData() {
        OkHttpUtils.get().url(MeiZiAPI.HOST_API).build().execute(new ImageCallBack() {
            @Override
            public void onError(Call call, Exception e) {

            }

            @Override
            public void onResponse(Images response) {
                mMeiZiAdapter.update(response.getResults());
            }
        });
    }
}