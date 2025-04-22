package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DSA {

    public static void main(String args[]) {
//        Map<Integer, Integer> map = new HashMap<>();

        int[] arr = {0, 2, 1, 5, 3, 4};

        /*for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        for (var m : map.entrySet()) {
            if (m.getValue() >= 3) {
                System.out.println(m.getKey() + " " + m.getValue());
            }
        }*/


        double[][] coordinates = {
                {73.7100527309127, 18.659080042159},
                {73.7096362300538, 18.6588502957374},
                {73.7095602789925, 18.6583791541584},
                {73.7095153632029, 18.6581005303857},
                {73.7098344875019, 18.6581100805341},
                {73.7100527309127, 18.659080042159}
        };

        double area = calculatePolygonArea(coordinates);
        System.out.println("The area of the polygon is: " + area + " square meters");
    }

    public static double calculatePolygonArea(double[][] coordinates) {
        int n = coordinates.length;

        // Radius of the Earth in meters
        double R = 6371000;

        // Convert latitude and longitude from degrees to radians
        double[] lat = new double[n];
        double[] lon = new double[n];
        for (int i = 0; i < n; i++) {
            lat[i] = Math.toRadians(coordinates[i][1]);
            lon[i] = Math.toRadians(coordinates[i][0]);
        }

        // Use the spherical excess formula to calculate the area
        double area = 0;
        for (int i = 0; i < n - 1; i++) {
            area += (lon[i + 1] - lon[i]) * (2 + Math.sin(lat[i]) + Math.sin(lat[i + 1]));
        }
        area = area * R * R / 2;

        // Make sure the area is positive
        return Math.abs(area);
    }

}
