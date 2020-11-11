package com.lich.kotlinandroidtestdemo

import android.view.View
import kotlinx.android.synthetic.main.item_ipfs.*
import kotlinx.android.synthetic.main.item_ipfs.view.*
import kotlinx.android.synthetic.main.item_ipfs.view.tv_name
import kotlinx.android.synthetic.main.item_ipfs_simple.view.*

/**
 * Created by lichhowger on 2020/11/9.
 */
class IPFSSimpleAdapter(list: List<IPFSSimpleEntity>) : BaseAdapter<IPFSSimpleEntity>(list) {

    override fun getLayoutId(): Int {
        return R.layout.item_ipfs_simple
    }

    override fun initViews(i: Int, view: View) {
        val entity = list.get(i)

        var name = entity.Name
        if (name.contains(".")) {
            view.tv_type.setText("类型: 文件")
        } else {
            view.tv_type.setText("类型: 文件夹")
        }
        view.tv_name.setText("名称: " + entity.Name)
    }


}