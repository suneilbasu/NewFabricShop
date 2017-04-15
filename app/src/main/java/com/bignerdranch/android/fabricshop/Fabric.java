package com.bignerdranch.android.fabricshop;

import java.util.Date;
import java.util.UUID;

public class Fabric {

    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;
    private double mFabricCost;

    public double getFabricCost() {
        return mFabricCost;
    }

    public void setFabricCost(double fabricCost) {
        mFabricCost = fabricCost;
    }

    private int mFabricTotal;

    public int getFabricTotal() {
        return mFabricTotal;
    }

    public void setFabricTotal(int fabricTotal) {
        mFabricTotal = fabricTotal;
    }

    public void setSeekFabric(int seekFabric) {
        mSeekFabric = seekFabric;
    }

    private int mSeekFabric;

    public int getSeekFabric() {
        return mSeekFabric;
    }

    public Fabric() {
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }
}
