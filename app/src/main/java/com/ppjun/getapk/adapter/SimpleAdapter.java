package com.ppjun.getapk.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ppjun.getapk.R;
import com.ppjun.getapk.bean.AppInfo;

import java.util.ArrayList;

/**
 * @Package :com.ppjun.getapk.adapter
 * @Description :
 * @Author :Rc3
 * @Created at :2016/5/4 09:45.
 */
public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.SimpleHolder> {
    ArrayList<AppInfo> mList;
    OnItemClickListener mlistener;
    public interface OnItemClickListener{
        void OnItemClick(int position);
    }


    public void setOnItemClickListener(OnItemClickListener listener){
        this.mlistener=listener;
    }

    public SimpleAdapter(ArrayList<AppInfo> list) {
        this.mList = list;


    }

    @Override
    public SimpleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new SimpleHolder(view);
    }

    @Override
    public void onBindViewHolder(SimpleHolder holder, final int position) {
        AppInfo appinfo=mList.get(position);
        holder.icon.setImageDrawable(appinfo.getIcon());
        holder.name.setText(appinfo.getName());
        holder.updateTime.setText(appinfo.getUpdateTime());
        holder.size.setText(appinfo.getSize());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 if (mlistener!=null)
        mlistener.OnItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public class SimpleHolder extends RecyclerView.ViewHolder {
        ImageView icon;
        TextView name;
        TextView size;
        TextView updateTime;
        public SimpleHolder(View itemView) {
            super(itemView);
            icon= (ImageView) itemView.findViewById(R.id.apkicon);
            name= (TextView) itemView.findViewById(R.id.name);
            size= (TextView) itemView.findViewById(R.id.size);
            updateTime= (TextView) itemView.findViewById(R.id.updatetime);
        }
    }
}
