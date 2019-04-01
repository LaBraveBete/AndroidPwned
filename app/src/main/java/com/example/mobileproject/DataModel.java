package com.example.mobileproject;

import com.google.gson.annotations.SerializedName;

import org.joda.time.DateTime;

import java.util.Date;


public class DataModel {

    @SerializedName("Name")
    private String Name;

    @SerializedName("Title")
    private String Title;

    @SerializedName("Domain")
    private String Domain;

    /*
    @SerializedName("BreachDate")
    private Date BreachDate;

    @SerializedName("AddedDate")
    private DateTime AddedDate;

    @SerializedName("ModifiedDate")
    private DateTime ModifiedDate;
*/
    @SerializedName("PwnCount")
    private Integer PwnCount;

    @SerializedName("Description")
    private String Description;

    @SerializedName("DataClasses")
    private String[] DataClasses;

    @SerializedName("IsVerified")
    private boolean IsVerified;

    @SerializedName("IsFabricated")
    private boolean IsFabricated;

    @SerializedName("IsSensitive")
    private boolean IsSensitive;

    @SerializedName("IsRetired")
    private boolean IsRetired;

    @SerializedName("IsSpamList")
    private boolean IsSpamList;

    @SerializedName("LogoPath")
    private String LogoPath;


    public DataModel(String Name, String Title, String Domain,  Integer PwnCount, String Description, String[] DataClasses, boolean IsVerified, boolean IsFabricated, boolean IsSensitive, boolean IsRetired, boolean IsSpamList, String LogoPath)
    {
        this.Name = Name;
        this.Title = Title;
        this.Domain = Domain;
       // this.BreachDate = BreachDate;
        //this.AddedDate = AddedDate;
        //this.ModifiedDate = ModifiedDate; //Date BreachDate, DateTime AddedDate, DateTime ModifiedDate,
        this.PwnCount = PwnCount;
        this.Description = Description;
        this.DataClasses = DataClasses;
        this.IsVerified = IsVerified;
        this.IsFabricated = IsFabricated;
        this.IsSensitive = IsSensitive;
        this.IsRetired = IsRetired;
        this.IsSpamList = IsSpamList;
        this.LogoPath = LogoPath;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDomain() {
        return Domain;
    }

    public void setDomain(String domain) {
        Domain = domain;
    }
/*
    public Date getBreachDate() {
        return BreachDate;
    }

    public void setBreachDate(Date breachDate) {
        BreachDate = breachDate;
    }

    public DateTime getAddedDate() {
        return AddedDate;
    }

    public void setAddedDate(DateTime addedDate) {
        AddedDate = addedDate;
    }

    public DateTime getModifiedDate() {
        return ModifiedDate;
    }

    public void setModifiedDate(DateTime modifiedDate) {
        ModifiedDate = modifiedDate;
    }
*/
    public Integer getPwnCount() {
        return PwnCount;
    }

    public void setPwnCount(Integer pwnCount) {
        PwnCount = pwnCount;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String[] getDataClasses() {
        return DataClasses;
    }

    public void setDataClasses(String[] dataClasses) {
        DataClasses = dataClasses;
    }

    public boolean isVerified() {
        return IsVerified;
    }

    public void setVerified(boolean verified) {
        IsVerified = verified;
    }

    public boolean isFabricated() {
        return IsFabricated;
    }

    public void setFabricated(boolean fabricated) {
        IsFabricated = fabricated;
    }

    public boolean isSensitive() {
        return IsSensitive;
    }

    public void setSensitive(boolean sensitive) {
        IsSensitive = sensitive;
    }

    public boolean isRetired() {
        return IsRetired;
    }

    public void setRetired(boolean retired) {
        IsRetired = retired;
    }

    public boolean isSpamList() {
        return IsSpamList;
    }

    public void setSpamList(boolean spamList) {
        IsSpamList = spamList;
    }

    public String getLogoPath() {
        return LogoPath;
    }

    public void setLogoPath(String logoPathl) {
        LogoPath = logoPathl;
    }
}
