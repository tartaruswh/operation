package com.guide.zzdts.operation.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.guide.zzdts.operation.R;
import com.guide.zzdts.operation.data.User;

import java.util.ArrayList;

/**
 * Created by 15840 on 2017/7/28.
 */

public class RecyclerViewAdapter extends BaseAdapter<User> {

    private Context context;
    private ArrayList<User> userArrayList = new ArrayList<>();
    private LayoutInflater layoutInflater;
    public RecyclerViewAdapter(Context context,ArrayList<User> list){
        super();
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.userArrayList = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder myViewHolder = new MyViewHolder(
                layoutInflater.inflate(R.layout.community_layout, parent, false));
        return myViewHolder;
    }

    public int getItemCount(){
        return userArrayList.size();
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((MyViewHolder)holder).textView_userName.setText(userArrayList.get(position).getUserName());
        ((MyViewHolder)holder).textView_title.setText(userArrayList.get(position).getTitle());
        ((MyViewHolder)holder).textView_content.setText(userArrayList.get(position).getContent());
        ((MyViewHolder)holder).textView_time.setText(userArrayList.get(position).getSendTime());
        ((MyViewHolder)holder).simpleDraweeView.setImageURI(Uri.parse(userArrayList.get(position).getAvatarAddress()));
}

    static  class MyViewHolder extends RecyclerView.ViewHolder{

        SimpleDraweeView simpleDraweeView;
        TextView textView_userName;
        TextView textView_title;
        TextView textView_content;
        TextView textView_time;
        public MyViewHolder(View itemView) {
            super(itemView);
            simpleDraweeView = (SimpleDraweeView) itemView.findViewById(R.id.simpleDraweeView);
            textView_userName = (TextView) itemView.findViewById(R.id.textView_userName);
            textView_title = (TextView) itemView.findViewById(R.id.textView_title);
            textView_content = (TextView) itemView.findViewById(R.id.textView_content);
            textView_time = (TextView) itemView.findViewById(R.id.textView_time);
        }
    }
}
