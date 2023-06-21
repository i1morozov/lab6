package com.example.lr6;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.yandex.mapkit.geometry.Point;

public class PointOfInterest implements Parcelable {
    String name;
    String info;

    private Point point;

    private String cost;

    private String time;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public PointOfInterest() {
    }

    public PointOfInterest(Point point, String info, String name, String cost, String time) {
        this.name = name;
        this.info = info;
        this.point = point;
        this.cost = cost;
        this.time = time;
    }

    protected PointOfInterest(Parcel in) {
        info = in.readString();
        name = in.readString();
        point = new Point(in.readDouble(), in.readDouble());
        cost = in.readString();
        time = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(info);
        dest.writeString(name);
        dest.writeDouble(point.getLatitude());
        dest.writeDouble(point.getLongitude());
        dest.writeString(cost);
        dest.writeString(time);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public PointOfInterest createFromParcel(Parcel in) {
            return new PointOfInterest(in);
        }

        public PointOfInterest[] newArray(int size) {
            return new PointOfInterest[size];
        }
    };

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
