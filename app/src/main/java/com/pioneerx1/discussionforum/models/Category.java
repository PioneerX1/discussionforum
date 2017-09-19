package com.pioneerx1.discussionforum.models;

import org.parceler.Parcel;

@Parcel
public class Category {

    String name;
    String description;
    String imageUrl;
    // no need for id??

    public Category() { }  // for Parceler

    public Category(String name, String description, String imageUrl) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

}
