package com.mixail.model;

public class Friends {
    private int friendId;
    private String friendName;
    private String emailAddr;
    private int age;
    private String favoriteColor;

    public Friends(int friendId, String friendName, String emailAddr, int age, String favoriteColor) {
        this.friendId = friendId;
        this.friendName = friendName;
        this.emailAddr = emailAddr;
        this.age = age;
        this.favoriteColor = favoriteColor;
    }

    public Friends()
    {
        this.friendId =0;
        this.friendName = "";
        this.emailAddr = "";
        this.age = 0;
        this.favoriteColor = "";

    }

    public int getFriendId() {
        return friendId;
    }

    public void setFriendId(int friendId) {
        this.friendId = friendId;
    }

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }

    public String getEmailAddr() {
        return emailAddr;
    }

    public void setEmailAddr(String emailAddr) {
        this.emailAddr = emailAddr;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFavoriteColor() {
        return favoriteColor;
    }

    public void setFavoriteColor(String favoriteColor) {
        this.favoriteColor = favoriteColor;
    }
}
