package com.im.rxjavabook1;

public class Order {
    private String mId;

    public Order(String mId) {
        this.mId = mId;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    @Override
    public String toString() {
        return "Order ID:" + mId;
    }
}
