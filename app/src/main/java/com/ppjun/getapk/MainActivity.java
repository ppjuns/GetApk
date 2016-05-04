package com.ppjun.getapk;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ppjun.getapk.adapter.SimpleAdapter;
import com.ppjun.getapk.bean.AppInfo;
import com.ppjun.getapk.utils.PackageUtils;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
       RecyclerView mRecyclerView;
    ArrayList<AppInfo> mList=new ArrayList<>();
    SimpleAdapter adapter;
    Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            adapter=new SimpleAdapter((ArrayList<AppInfo>) msg.obj);
            mRecyclerView.setAdapter(adapter);

            adapter.setOnItemClickListener(new SimpleAdapter.OnItemClickListener() {
                @Override
                public void OnItemClick(int position) {
                    File apkFile=mList.get(position).getApkfile();
                    Intent intent=new Intent();
                    intent.setAction(Intent.ACTION_SEND);
                    intent.setType("*/*");
                    intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(apkFile));
                    startActivity(intent);
                }
            });
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView= (RecyclerView) findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager manager=new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(manager);
           new  Thread(new Runnable() {
           @Override
           public void run() {
           mList= PackageUtils.getApplicationName(MainActivity.this.getPackageManager());
           Message msg=Message.obtain(mHandler,0,mList);
               msg.sendToTarget();
           }
       }).start();



    }
}
