package com.bw.qgs.qgs20181210.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.qgs.qgs20181210.R;
import com.bw.qgs.qgs20181210.bean.DuanUser;
import com.facebook.drawee.view.SimpleDraweeView;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * date:2018/12/10    9:38
 * author:秦广帅(Lenovo)
 * fileName:DuanAdapter
 */
public class DuanAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private List<DuanUser.DataBean> mData;

    public DuanAdapter(Context context, List<DuanUser.DataBean> data) {
        mContext = context;
        mData = data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        RecyclerView.ViewHolder holder = null;
        switch (i){
            case 1:
                view = LayoutInflater.from(mContext).inflate(R.layout.item2,viewGroup,false);
                holder = new TwoViewHolder(view);
                break;
            case 2:
                view = LayoutInflater.from(mContext).inflate(R.layout.item1,viewGroup,false);
                holder = new MyViewHolder(view);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        DuanUser.DataBean bean = mData.get(i);
        switch (getItemViewType(i)){
            case 1:
                bean.getUser().getIcon().replace("https","http");
                //Picasso.with(mContext).load(bean.getUser().getIcon()).into(((TwoViewHolder)viewHolder).image2);
                Uri uri = Uri.parse(bean.getUser().getIcon());
                ((TwoViewHolder) viewHolder).image2.setImageURI(uri);
                break;
            case 2:
                if(bean.getImgUrls()==null){
                    //Uri uri1 = Uri.parse(null);
                    //((MyViewHolder) viewHolder).image1.setImageURI(uri1);
                    ((MyViewHolder) viewHolder).image1.setVisibility(View.GONE);
                }else{
                    Uri uri1 = Uri.parse(bean.getImgUrls()+"");
                    ((MyViewHolder) viewHolder).image1.setImageURI(uri1);
                    //Picasso.with(mContext).load(bean.getImgUrls()+"").into(((MyViewHolder)viewHolder).image1);
                }
                ((MyViewHolder) viewHolder).text1.setText(bean.getContent());
                ((MyViewHolder) viewHolder).text2.setText(bean.getCreateTime()+"");
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(position%2!=0){
            return 2;
        }else{
            return 1;
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        SimpleDraweeView image1;
        TextView text1,text2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image1 = itemView.findViewById(R.id.item1image);
            text1 = itemView.findViewById(R.id.item1text);
            text2 = itemView.findViewById(R.id.item1text2);
        }
    }
    class TwoViewHolder extends RecyclerView.ViewHolder{

        SimpleDraweeView image2;

        public TwoViewHolder(@NonNull View itemView) {
            super(itemView);
            image2 = itemView.findViewById(R.id.item2image);
        }
    }
}
