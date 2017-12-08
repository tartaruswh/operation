package com.guide.zzdts.operation.adapter;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 15840 on 2017/7/28.
 * 数据源相关的字段和方法封装在父类中
 */

public abstract class BaseAdapter<T> extends RecyclerView.Adapter  {
    /**
     * 数据集合
     */
    protected List<T> dataSet = new ArrayList<>();

    /**
     * @param dataSet
     * 更新集合数据
     */
    public void updateData(List<T> dataSet){
        this.dataSet.clear();
        appendData(dataSet);
    }

    /**
     * 添加集合数据
     * @param dataSet
     */
    public void appendData(List<T> dataSet){
        if (dataSet!=null && !dataSet.isEmpty()){
            this.dataSet.addAll(dataSet);
            notifyDataSetChanged();
        }
    }
    public List<T> getDateSet(){
        return dataSet;
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}