package com.gmail.mqh444.qzhihu.business.pojo.response.ext;

import com.gmail.mqh444.qzhihu.business.pojo.bean.LastThemeStory;
import com.gmail.mqh444.qzhihu.business.pojo.bean.ThemeEditor;
import com.gmail.mqh444.qzhihu.business.pojo.response.BaseResponse;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

/**
 * GetThemeResponse
 * Created by Louis on 2016/11/8.
 */

public class GetThemeResponse extends BaseResponse {

    @SerializedName("stories")
    private LastThemeStory[] stories;

    @SerializedName("description")
    private String description;

    @SerializedName("background")
    private String background;

    @SerializedName("color")
    private int color;

    @SerializedName("name")
    private String name;

    @SerializedName("image")
    private String image;

    @SerializedName("editors")
    private ThemeEditor[] editors;

    @SerializedName("image_source")
    private String imageSource;

    public LastThemeStory[] getStories() {
        return stories;
    }

    public void setStories(LastThemeStory[] stories) {
        this.stories = stories;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ThemeEditor[] getEditors() {
        return editors;
    }

    public void setEditors(ThemeEditor[] editors) {
        this.editors = editors;
    }

    public String getImageSource() {
        return imageSource;
    }

    public void setImageSource(String imageSource) {
        this.imageSource = imageSource;
    }

    @Override
    public String toString() {
        return "GetThemeResponse{" +
                "stories=" + Arrays.toString(stories) +
                ", description='" + description + '\'' +
                ", background='" + background + '\'' +
                ", color=" + color +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", editors=" + Arrays.toString(editors) +
                ", imageSource='" + imageSource + '\'' +
                "} " + super.toString();
    }
}
