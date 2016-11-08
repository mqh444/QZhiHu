package com.gmail.mqh444.qzhihu.business.pojo.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Arrays;

/**
 * LastThemeStory
 * Created by Louis on 2016/11/8.
 */
public class LastThemeStory implements Serializable {

    @SerializedName("id")
    private int id;

    @SerializedName("type")
    private int type;

    @SerializedName("title")
    private String title;

    @SerializedName("ga_prefix")
    private String gaPrefix;

    @SerializedName("images")
    private String[] images;

    @Override
    public String toString() {
        return "LastThemeStory{" +
                "id=" + id +
                ", type=" + type +
                ", title='" + title + '\'' +
                ", gaPrefix='" + gaPrefix + '\'' +
                ", images='" + Arrays.toString(images) +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGaPrefix() {
        return gaPrefix;
    }

    public void setGaPrefix(String gaPrefix) {
        this.gaPrefix = gaPrefix;
    }

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }

}
