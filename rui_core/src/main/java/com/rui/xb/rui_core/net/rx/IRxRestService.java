package com.rui.xb.rui_core.net.rx;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Created by Rui on 2018/4/14.
 */

public interface IRxRestService {

    @GET
    Observable<String> get(@Url String url, @QueryMap Map<String, Object> params);

    @POST
    @FormUrlEncoded
    Observable<String> post(@Url String url, @FieldMap Map<String, Object> params);

    @PUT
    @FormUrlEncoded
    Observable<String> put(@Url String url, @FieldMap Map<String, Object> params);

    @GET
    @Streaming
    Observable<ResponseBody> download(@Url String url, @QueryMap Map<String, Object> params);

    @POST
    @Multipart
    Observable<String> upload(@Url String url, @Part MultipartBody.Part file);

}
