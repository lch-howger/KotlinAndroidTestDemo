package com.lich.kotlinandroidtestdemo.adapter

import android.view.View
import com.lich.kotlinandroidtestdemo.R
import com.lich.kotlinandroidtestdemo.entity.IPFSEntity
import kotlinx.android.synthetic.main.item_ipfs.view.*

/**
 * Created by lichhowger on 2020/11/9.
 */
class IPFSAdapter(list: List<IPFSEntity.Link>) : BaseAdapter<IPFSEntity.Link>(list) {

    override fun getLayoutId(): Int {
        return R.layout.item_ipfs
    }

    override fun initViews(i: Int, view: View) {
        val entity = list.get(i)

        view.tv_name.setText("名称: "+entity.Name)
        view.tv_hash.setText("Hash: "+entity.Hash)
        view.tv_size.setText("大小: " + entity.Size)
    }


}