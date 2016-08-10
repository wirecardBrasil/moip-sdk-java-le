package br.com.moip.request;

public class GeolocationRequest {
    private double latitude;
    private double longitude;

    public GeolocationRequest latitude(double latitude){
        this.latitude = latitude;
        return this;
    }

    public GeolocationRequest longitude(double longitude){
        this.longitude = longitude;
        return this;
    }
}
