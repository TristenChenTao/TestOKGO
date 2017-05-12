package esgame.com.testokgo;


import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.lzy.okgo.callback.AbsCallback;
import com.lzy.okgo.request.BaseRequest;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.Response;


public abstract class JsonCallback<T> extends AbsCallback<T> {

    @Override
    public void onBefore(BaseRequest request) {
        super.onBefore(request);
        // 主要用于在所有请求之前添加公共的请求头或请求参数
//        request.headers("header1", "HeaderValue1")//
//                .params("params1", "ParamsValue1")//
//                .params("token", "3215sdf13ad1f65asd4f3ads1f");
    }

    @Override
    public T convertSuccess(Response response) throws Exception {


        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        Type type = params[0];

        if (!(type instanceof ParameterizedType)) throw new IllegalStateException("没有填写泛型参数");

        Type rawType = ((ParameterizedType) type).getRawType();
        Type typeArgument = ((ParameterizedType) type).getActualTypeArguments()[0];
        Gson gson = new Gson();

        JsonReader jsonReader = new JsonReader(response.body().charStream());
        if (typeArgument == Void.class) {
            SimpleResponse simpleResponse = gson.fromJson(jsonReader, SimpleResponse.class);
            response.close();
            return (T) simpleResponse.toBaseResponse();
        } else if (rawType == BaseResponse.class) {
            //有数据类型，表示有data
            BaseResponse baseResponse = gson.fromJson(jsonReader, type);
            response.close();

            return (T) baseResponse;

        } else {
            response.close();
            throw new IllegalStateException("基类错误无法解析!");
        }
    }
}