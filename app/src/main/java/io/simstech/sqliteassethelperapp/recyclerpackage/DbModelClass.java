package io.simstech.sqliteassethelperapp.recyclerpackage;

import android.graphics.Bitmap;

public class DbModelClass {
    String imageDec;
    Bitmap ourImage;

    public String getImageDec() {
        return imageDec;
    }

    public void setImageDec(String imageDec) {
        this.imageDec = imageDec;
    }

    public Bitmap getOurImage() {
        return ourImage;
    }

    public void setOurImage(Bitmap ourImage) {
        this.ourImage = ourImage;
    }

    public DbModelClass(String imageDec, Bitmap ourImage) {
        this.imageDec = imageDec;
        this.ourImage = ourImage;
    }
}
