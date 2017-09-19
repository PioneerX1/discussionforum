package com.pioneerx1.discussionforum.models;

import org.parceler.Parcel;

@Parcel
public class Category {

    private String name;
    private String description;
    private String imageUrl;
    // no need for id??

    public Category() { }  // for Parceler

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
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
