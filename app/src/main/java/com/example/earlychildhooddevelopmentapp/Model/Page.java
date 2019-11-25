package com.example.earlychildhooddevelopmentapp.Model;

/**
 * Created by CryoFlar3 on 4/19/2015.
 */
public class Page {
    private int imageId;
    private String header;
    private String subHeader1;
    private String subHeader2;
    private String progress;


    public Page(int imageId, String text1, String text2, String text3, String text4){
        this.imageId = imageId;
        subHeader1 = text2;
        header = text1;
        subHeader2 = text4;
        progress = text3;

    }

    public String getSubHeader2() {
        return subHeader2;
    }

    public void setSubHeader2(String subHeader2) {
        this.subHeader2 = subHeader2;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getSubHeader1() {
        return subHeader1;
    }

    public void setSubHeader1(String subHeader1) {
        this.subHeader1 = subHeader1;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }


}
