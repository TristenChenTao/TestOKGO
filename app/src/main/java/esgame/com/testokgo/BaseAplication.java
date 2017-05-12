package esgame.com.testokgo;

import android.app.Application;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheEntity;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.cookie.store.PersistentCookieStore;
import com.lzy.okgo.model.HttpHeaders;
import com.lzy.okgo.model.HttpParams;

import java.util.logging.Level;

/**
 * Created by TristenChenTao on 08/05/2017.
 */

public class BaseAplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //公共 Header, 注意不支持中文
        HttpHeaders headers = new HttpHeaders();
        headers.put("commonHeaderKey", "commonHeaderValue1");

        //公共 请求参数, 注意支持中文
        HttpParams params = new HttpParams();
        params.put("commonParamsKey", "支持中文参数");
        //-----------------------------------------------------------------------------------//


        OkGo.init(this);
        try {
            //全局参数
            OkGo.getInstance()

                    // 打开该调试开关,打印级别INFO,并不是异常,是为了显眼,不需要就不要加入该行
                    // 最后的true表示是否打印okgo的内部异常，一般打开方便调试错误
                    .debug("OkGo", Level.INFO, true)

                    //默认的60秒
                    .setConnectTimeout(OkGo.DEFAULT_MILLISECONDS)  //全局的连接超时时间
                    .setReadTimeOut(OkGo.DEFAULT_MILLISECONDS)     //全局的读取超时时间
                    .setWriteTimeOut(OkGo.DEFAULT_MILLISECONDS)    //全局的写入超时时间

                    //设置缓存模式,默认是不使用缓存
                    .setCacheMode(CacheMode.NO_CACHE)

                    //设置缓存时间,默认永不过期
                    .setCacheTime(CacheEntity.CACHE_NEVER_EXPIRE)

                    //设置超时重连次数,默认为三次
                    .setRetryCount(3)

                    //管理cookie
//              .setCookieStore(new MemoryCookieStore())            //cookie使用内存缓存（app退出后，cookie消失）
                    .setCookieStore(new PersistentCookieStore())        //cookie持久化存储，如果cookie不过期，则一直有效

                    //设置https的证书
                    .setCertificates()                                                               //方法一：信任所有证书,不安全有风险
//              .setCertificates(new SafeTrustManager())                                             //方法二：自定义信任规则，校验服务端证书
//              .setCertificates(getAssets().open("srca.cer"))                                       //方法三：使用预埋证书，校验服务端证书（自签名证书）
//              .setCertificates(getAssets().open("xxx.bks"), "123456", getAssets().open("yyy.cer")) //方法四：使用bks证书和密码管理客户端证书（双向认证），使用预埋证书，校验服务端证书（自签名证书）

                    //配置https的域名匹配规则
//               .setHostnameVerifier(new SafeHostnameVerifier())

                    //添加全局拦截器
//                .addInterceptor(new Interceptor() {
//                    @Override
//                    public Response intercept(Chain chain) throws IOException {
//                        return chain.proceed(chain.request());
//                    }
//                })

                    .addCommonHeaders(headers)  //设置全局公共头
                    .addCommonParams(params);   //设置全局公共参数

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
