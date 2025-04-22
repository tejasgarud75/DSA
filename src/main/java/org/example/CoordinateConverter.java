package org.example;

import java.util.ArrayList;
import java.util.List;

public class CoordinateConverter {

    // Method to convert EPSG:3857 to LatLng
    private static final double SHIFT_LNG = 0.0001; // Adjust this value to shift the polygon to the left

    // Method to convert EPSG:3857 to LatLng
    public static LatLng fromEPSG3857ToLatLng(double x, double y) {
        double lon = (x / 20037508.34) * 180 - SHIFT_LNG;
        double lat = (y / 20037508.34) * 180;
        lat = (180 / Math.PI) * (2 * Math.atan(Math.exp((lat * Math.PI) / 180)) - Math.PI / 2);
        return new LatLng(lat, lon);
    }

    // Method to convert a list of EPSG:3857 coordinates to LatLng
    public static List<LatLng> convertCoordinates(List<double[]> coordinates) {
        List<LatLng> latLngCoordinates = new ArrayList<>();
        for (double[] coord : coordinates) {
            latLngCoordinates.add(fromEPSG3857ToLatLng(coord[0], coord[1]));
        }
        return latLngCoordinates;
    }

    // Inner class to represent LatLng
    public static class LatLng {
        private double lat;
        private double lng;

        public LatLng(double lat, double lng) {
            this.lat = lat;
            this.lng = lng;
        }

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public double getLng() {
            return lng;
        }

        public void setLng(double lng) {
            this.lng = lng;
        }

        @Override
        public String toString() {
            return "{ lat: " + lat + ", lng: " + lng + " }";
        }
    }

    public static void main(String[] args) {
        // Example coordinates in EPSG:3857
        List<double[]> coordinates = new ArrayList<>();
        coordinates.add(new double[]{8204676.06087217, 2113531.4419539385});
        coordinates.add(new double[]{8204646.621317196, 2113372.2115686587});
        coordinates.add(new double[]{8204632.257834069, 2113373.945973428});
        coordinates.add(new double[]{8204589.514767335, 2113379.088153869});
        coordinates.add(new double[]{8204619.813138693, 2113507.155644661});
        coordinates.add(new double[]{8204628.297961627, 2113543.278982701});
        coordinates.add(new double[]{8204676.06087217, 2113531.4419539385});

        // Convert coordinates to LatLng
        var latLngCoordinates = convertCoordinates(coordinates);

        // Print converted coordinates
        for (LatLng latLng : latLngCoordinates) {
            System.out.println(latLng);
        }
    }
}