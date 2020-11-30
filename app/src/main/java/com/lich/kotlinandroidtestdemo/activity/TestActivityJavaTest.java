package com.lich.kotlinandroidtestdemo.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.toolbox.HttpResponse;
import com.lich.kotlinandroidtestdemo.R;

import java.io.File;
import java.io.IOException;

import okhttp3.Response;

/**
 * Created by lichhowger on 2020/11/9.
 */
public class TestActivityJavaTest extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }

    public HttpResponse invokeXAUTHPOSTService(String url, String token, File file) {
//
//        client = new DefaultHttpClient();
//
//        HttpPost request = new HttpPost(url);
//
//        HttpResponse response = null;
//
//        DRPContentForUpload content = new DRPContentForUpload(file);
//        String jsonObject = DRPJSONConverter.toJson(content);
//        String BOUNDARY= "--eriksboundry--";
//
//        request.setHeader("Content-Type", "multipart/form-data; boundary="+BOUNDARY);
//        request.addHeader("X-AUTHORIZATION",token);
//        MultipartEntity entity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE,BOUNDARY,Charset.defaultCharset());
//        try {
//
//
//            entity.addPart("file01", new StringBody(jsonObject));
//
//            entity.addPart("file01", new FileBody(file));
//
//            request.addHeader("Accept-Encoding", "gzip, deflate");
//
//        } catch (UnsupportedEncodingException e) {
//            Log.v("encoding exception","E::: "+e);
//            e.printStackTrace();
//        }
//        request.setHeader("Accept", "application/json");
//        request.setHeader("Content-Type", "multipart/form-data; boundary="+BOUNDARY);
//        request.setEntity(entity);
//
//        try {
//
//
//
//
//            response = client.execute(request);
//
//
//
//        }  catch (IOException e) {
//
//            e.printStackTrace();
//        }
//
//
//        return response;
        return null;
    }
}
