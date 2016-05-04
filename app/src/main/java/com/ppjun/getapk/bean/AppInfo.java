package com.ppjun.getapk.bean;

import android.graphics.drawable.Drawable;

import java.io.File;

/**
 * @Package :com.ppjun.getapk.bean
 * @Description :
 * @Author :Rc3
 * @Created at :2016/5/4 09:52.
 */
public class AppInfo {
     private File apkfile;
    private Drawable icon;
    private String name;
    private String size;
    private String updateTime;

    public File getApkfile() {
        return apkfile;
    }

    public void setApkfile(File apkfile) {
        this.apkfile = apkfile;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
