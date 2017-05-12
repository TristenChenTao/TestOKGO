package esgame.com.testokgo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;


import okhttp3.Call;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OkGo.get("http://test.m.esgame.com/App/Wallet")     // 请求方式和请求url
                .tag(this)                       // 请求的 tag, 主要用于取消对应的请求
                .cacheKey("cacheKey")            // 设置当前请求的缓存key,建议每个不同功能的请求设置一个
                .cacheMode(CacheMode.DEFAULT)    // 缓存模式，详细请看缓存介绍
                .execute(new JsonCallback<BaseResponse<Model>>() {
                    @Override
                    public void onSuccess(BaseResponse<Model> responseData, Call call, Response response) {
                        System.out.println("code :"+responseData.ResultCode);
                        System.out.println("msg :"+responseData.ResultMessage);
                    }
                });
    }
}



