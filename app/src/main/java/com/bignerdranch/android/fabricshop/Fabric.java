package com.bignerdranch.android.fabricshop;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Fabric {

    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;
    private double mFabricCost;
    private int mIcon;

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

    public static List<Fabric> initialFabrics() {
        List<Fabric> fabrics = new ArrayList<>();

        Fabric f1 = new Fabric();
        f1.setTitle("Glamorous Beige");
        f1.setIcon(R.mipmap.horridbeige);

        Fabric f2 = new Fabric();
        f2.setTitle("Snazzy Blue");
        f2.setIcon(R.mipmap.snazzyblue);

        Fabric f3 = new Fabric();
        f3.setTitle("Farmer Brown");

        fabrics.add(f1);
        fabrics.add(f2);
        fabrics.add(f3);

        return fabrics;
    }

    public void setIcon(int i) {
        this.mIcon = i;
    }

    public int getIcon() {
        return this.mIcon;
    }
}
