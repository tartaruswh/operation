package com.guide.zzdts.operation.data;

/**
 * Created by 15840 on 2017/9/19.
 */

public class LocationInformation {
    float radius;
    double laitude;
    double longitude;
    int locType;

    public LocationInformation(float radius, double laitude, double longitude, int locType) {
        this.radius = radius;
        this.laitude = laitude;
        this.longitude = longitude;
        this.locType = locType;
    }

    public int getLocType() {
        return locType;
    }

    public void setLocType(int locType) {
        this.locType = locType;
    }

    public LocationInformation(float radius, double laitude, double longitude) {
        this.radius = radius;
        this.laitude = laitude;
        this.longitude = longitude;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public double getLaitude() {
        return laitude;
    }

    public void setLaitude(double laitude) {
        this.laitude = laitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
