package com.bw.qgs.qgs20181210.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.qgs.qgs20181210.R;
import com.bw.qgs.qgs20181210.bean.ProsenUser;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * date:2018/12/10    10:23
 * author:秦广帅(Lenovo)
 * fileName:ProsenAdapter
 */
public class ProsenAdapter extends RecyclerView.Adapter<ProsenAdapter.MyViewHolder> {

    private Context mContext;
    private ProsenUser.DataBean mData;

    public ProsenAdapter(Context context, ProsenUser.DataBean data) {
        mContext = context;
        mData = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item3, viewGroup, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Uri uri = Uri.parse(mData.getIcon());
        myViewHolder.image.setImageURI(uri);
        myViewHolder.text1.setText(mData.getUsername());
        myViewHolder.text2.setText(mData.getAppsecret());
        myViewHolder.text3.setText(mData.getNickname());
        myViewHolder.text4.setText(mData.getCreatetime());
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        SimpleDraweeView image;
        TextView text1,text2,text3,text4;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.item3image);
            text1 = itemView.findViewById(R.id.item3text1);
            text2 = itemView.findViewById(R.id.item3text2);
            text3 = itemView.findViewById(R.id.item3text3);
            text4 = itemView.findViewById(R.id.item3text4);
        }
    }
}
