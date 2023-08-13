package com.rkant.bhajanapp;

public class DataHolder_BhajanMenu {

    String bhajan_name_nepali;

    public String getBhajan_name_english() {
        return bhajan_name_english;
    }

    public void setBhajan_name_english(String bhajan_name_english) {
        this.bhajan_name_english = bhajan_name_english;
    }

    String bhajan_name_english;

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }

    int integer;
    public DataHolder_BhajanMenu(String bhajan_name_nepali, String bhajan_name_english, int integer){
        this.bhajan_name_nepali =bhajan_name_nepali;
        this.bhajan_name_english=bhajan_name_english;
        this.integer=integer;
    }
    public String getBhajan_name_nepali() {
        return bhajan_name_nepali;
    }

    public void setBhajan_name_nepali(String bhajan_name_nepali) {
        this.bhajan_name_nepali = bhajan_name_nepali;
    }

}