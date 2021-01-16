package com.disebud.quiztokobuahabc.Data;

public class Data {

    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String jenis;

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String harga;

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public int imageId;

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }




    public Data(String name, String jenis, String harga, int imageId) {
        this.name = name;
        this.jenis = jenis;
        this.harga = harga;
        this.imageId = imageId;
    }
}
