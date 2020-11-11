package com.lich.kotlinandroidtestdemo

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView


/**
 * Created by lichhowger on 2020/11/9.
 */
abstract class BaseAdapter<T>(list: List<T>) : BaseAdapter() {

    var list: List<T> = list

    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(i: Int): T {
        return list.get(i)
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getView(i: Int, convertView: View?, viewGroup: ViewGroup?): View {
        var view: View
        if (convertView == null) {
            view = View.inflate(viewGroup?.context, getLayoutId(), null)
        } else {
            view = convertView
        }

        initViews(i, view)
        return view
    }

    abstract fun getLayoutId(): Int
    abstract fun initViews(i: Int, view: View)
}