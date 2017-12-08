package com.guide.zzdts.operation.data;

import java.util.UUID;

/**
 * Created by 15840 on 2017/7/28.
 */

public class User {
    private String id;
    private String avatarAddress;
    private String title;
    private String personalWebAddress;
    private String sendTime;
    private String userName;
    private String content;

    public User() {

    }

    public User(String avatarAddress, String title, String personalWebAddress,
                String sendTime, String userName, String content) {
        this(UUID.randomUUID().toString(),avatarAddress,title,personalWebAddress,sendTime,userName,content);
        this.avatarAddress = avatarAddress;
        this.title = title;
        this.personalWebAddress = personalWebAddress;
        this.sendTime = sendTime;
        this.userName = userName;
        this.content = content;
    }

    public User(String id, String avatarAddress, String title, String personalWebAddress,
                String sendTime, String userName, String content) {
        this.id = id;
        this.avatarAddress = avatarAddress;
        this.title = title;
        this.personalWebAddress = personalWebAddress;
        this.sendTime = sendTime;
        this.userName = userName;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAvatarAddress() {
        return avatarAddress;
    }

    public void setAvatarAddress(String avatarAddress) {
        this.avatarAddress = avatarAddress;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPersonalWebAddress() {
        return personalWebAddress;
    }

    public void setPersonalWebAddress(String personalWebAddress) {
        this.personalWebAddress = personalWebAddress;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
