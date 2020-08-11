package com.example.pojo;

import java.util.Map;

public class GetUserPojo {

    private String expand;
    private String self;
    private String key;
    private String name;
    private String emailAddress;
    private Map<String, String> avatarUrls;
    private String displayName;
    private boolean active;
    private String timeZone;
    private String locale;
    private GetUserGroupsPojo groups;
    private GetUserGroupsPojo applicationRoles;

    public String getExpand() {
        return expand;
    }

    public void setExpand(String expand) {
        this.expand = expand;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Map<String, String> getAvatarUrls() {
        return avatarUrls;
    }

    public void setAvatarUrls(Map<String, String> avatarUrls) {
        this.avatarUrls = avatarUrls;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public GetUserGroupsPojo getGroups() {
        return groups;
    }

    public void setGroups(GetUserGroupsPojo groups) {
        this.groups = groups;
    }

    public GetUserGroupsPojo getApplicationRoles() {
        return applicationRoles;
    }

    public void setApplicationRoles(GetUserGroupsPojo applicationRoles) {
        this.applicationRoles = applicationRoles;
    }
}
