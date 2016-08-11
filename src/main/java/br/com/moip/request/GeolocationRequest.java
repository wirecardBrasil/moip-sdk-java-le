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

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GeolocationRequest{");
        sb.append("latitude=").append(latitude);
        sb.append(", longitude=").append(longitude);
        sb.append('}');
        return sb.toString();
    }
}
