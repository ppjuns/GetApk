package com.ppjun.getapk.utils;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.ppjun.getapk.bean.AppInfo;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @Package :com.ppjun.getapk.utils
 * @Description :
 * @Author :Rc3
 * @Created at :2016/5/4 10:12.
 */
public class PackageUtils {


    public static ArrayList<AppInfo> getApplicationName(PackageManager packageManager){
        List<PackageInfo> list=packageManager.getInstalledPackages(0);
        ArrayList<AppInfo> apps=new ArrayList<>();

        for (int i = 0; i <list.size(); i++) {
            PackageInfo pak = (PackageInfo) list.get(i);
            if((pak.applicationInfo.flags&pak.applicationInfo.FLAG_SYSTEM)<=0){
              AppInfo info=new AppInfo();
              info.setName(packageManager.getApplicationLabel(pak.applicationInfo).toString());
              info.setIcon(pak.applicationInfo.loadIcon(packageManager));
                File file=new File(pak.applicationInfo.sourceDir);
                info.setApkfile(file);
                float size=file.length() / 1024/ 1024;
                 info.setSize(String.valueOf(size)+"MB");
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("MM-dd HH:mm");
                info.setUpdateTime(simpleDateFormat.format(pak.lastUpdateTime));

                apps.add(info);
            }

        }

        return  apps;
    }


}
