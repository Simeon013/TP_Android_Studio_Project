package com.example.gest_project;

public class Model {
    int id;
    int img;
    String proj;
    String chef;
    String description;

    public Model(){
    }

    public Model(int id,int img, String proj, String chef, String description) {
        this.id = id;
        this.img = img;
        this.proj = proj;
        this.chef = chef;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }



    public String getProj() {
        return proj;
    }

    public void setProj(String proj) {
        this.proj = proj;
    }

    public String getChef() {
        return chef;
    }

    public void setChef(String chef) {
        this.chef = chef;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
