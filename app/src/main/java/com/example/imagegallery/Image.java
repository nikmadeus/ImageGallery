package com.example.imagegallery;

import android.os.Parcel;
import android.os.Parcelable;

public class Image implements Parcelable {

    private String mUrl;
    private String mTitle;

    public Image(String url, String title) {
        mUrl = url;
        mTitle = title;
    }

    protected Image(Parcel in) {
        mUrl = in.readString();
        mTitle = in.readString();
    }

    public static final Creator<Image> CREATOR = new Creator<Image>() {
        @Override
        public Image createFromParcel(Parcel in) {
            return new Image(in);
        }

        @Override
        public Image[] newArray(int size) {
            return new Image[size];
        }
    };

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public static  Image[] getImages() {

        return new Image[]{
                new Image("http://www.kartinki24.ru/uploads/gallery/main/14/kartinki24_ru_cities_244.jpg", "Image1"),
                new Image("http://www.kartinki24.ru/uploads/gallery/main/14/kartinki24_ru_cities_243.jpg", "Image2"),
                new Image("http://www.kartinki24.ru/uploads/gallery/main/14/kartinki24_ru_cities_242.jpg", "Image3"),
                new Image("http://www.kartinki24.ru/uploads/gallery/main/14/kartinki24_ru_cities_241.jpg", "Image4"),
                new Image("http://www.kartinki24.ru/uploads/gallery/main/14/kartinki24_ru_cities_240.jpg", "Image5"),
                new Image("http://www.kartinki24.ru/uploads/gallery/main/14/kartinki24_ru_cities_239.jpg", "Image6"),
                new Image("http://www.kartinki24.ru/uploads/gallery/main/14/kartinki24_ru_cities_238.jpg", "Image7"),
                new Image("http://www.kartinki24.ru/uploads/gallery/main/14/kartinki24_ru_cities_237.jpg", "Image8"),
                new Image("http://www.kartinki24.ru/uploads/gallery/main/14/kartinki24_ru_cities_236.jpg", "Image9"),
                new Image("http://www.kartinki24.ru/uploads/gallery/main/14/kartinki24_ru_cities_235.jpg", "Image10"),
                new Image("http://www.kartinki24.ru/uploads/gallery/main/14/kartinki24_ru_cities_234.jpg", "Image11"),
                new Image("http://www.kartinki24.ru/uploads/gallery/main/14/kartinki24_ru_cities_233.jpg", "Image12")
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mUrl);
        parcel.writeString(mTitle);
    }
}
