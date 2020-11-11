package com.lich.kotlinandroidtestdemo.lich;

import androidx.annotation.Nullable;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;

/**
 * Created by lichhowger on 2020/11/9.
 */
public class LichRequest extends Request {

    public LichRequest(String url, Response.ErrorListener listener) {
        super(url, listener);
    }

    public LichRequest(int method, String url, @Nullable Response.ErrorListener listener) {
        super(method, url, listener);
    }

    @Override
    protected Response parseNetworkResponse(NetworkResponse response) {
        return null;
    }

    @Override
    protected void deliverResponse(Object response) {

    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
