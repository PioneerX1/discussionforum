package com.pioneerx1.discussionforum.models;

import org.parceler.Parcel;

@Parcel
public class Message {

    String title;
    String content;
    String author;
    String categoryName;

    public Message() { }  // for Parceler

    public Message(String title, String content, String author, String categoryName) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.categoryName = categoryName;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategoryName() {
        return categoryName;
    }

}
