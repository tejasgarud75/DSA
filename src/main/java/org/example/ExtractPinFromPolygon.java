package org.example;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ExtractPinFromPolygon {

    public static void main(String[] args) {
        try {
            File inputFile = new File("/Users/mgs/Downloads/sangawade_refine1.kml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
//            int count = 0;
            NodeList placemarkList = doc.getElementsByTagName("Placemark");

            List<double[][]> polygons = new ArrayList<>();
            List<double[]> points = new ArrayList<>();
            List<double[]> points1 = new ArrayList<>();

            for (int i = 0; i < placemarkList.getLength(); i++) {
                Node placemarkNode = placemarkList.item(i);
                if (placemarkNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element placemarkElement = (Element) placemarkNode;
                    NodeList coordinatesList = placemarkElement.getElementsByTagName("coordinates");

                    for (int j = 0; j < coordinatesList.getLength(); j++) {
                        String coordinatesString = coordinatesList.item(j).getTextContent().trim();
                        String[] coordinatePairs = coordinatesString.split(" ");

                        if (coordinatePairs.length > 1) { // Polygon
                            double[][] polygon = new double[coordinatePairs.length][2];
                            for (int k = 0; k < coordinatePairs.length; k++) {
                                String[] latLng = coordinatePairs[k].split(",");
                                polygon[k][0] = Double.parseDouble(latLng[0]);
                                polygon[k][1] = Double.parseDouble(latLng[1]);
                            }
                            polygons.add(polygon);
                        } else { // Point
                            String[] latLng = coordinatePairs[0].split(",");
                            double[] point = new double[2];
                            point[0] = Double.parseDouble(latLng[0]);
                            point[1] = Double.parseDouble(latLng[1]);
                            points.add(point);
                        }
                    }
                }
            }
            int count = 0;

            // Check if points are inside any polygon
            for (double[] point : points) {
                boolean isInside = false;
                for (double[][] polygon : polygons) {
                    if (isPointInPolygon(polygon, point)) {
                        isInside = true;
//                        System.out.println("Point " + point[0] + "," + point[1] + " is inside a polygon: " + isInside);
//                        polygons.remove(polygon);
                        count++;
                        points1.add(point);
                        break;
                    }
                }

            }

            System.out.println("Size of remaining polygon" + polygons.size());
//            System.out.println("Count of points is " + count);
//            System.out.println("Remaining points " + points);
            List<double[]> unmatchingPoints = findUnmatchingPoints(points, points1);
            // Print unmatching points
            for (double[] point : unmatchingPoints) {
                System.out.println("Unmatching point: [" + point[0] + ", " + point[1] + "]");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static boolean isPointInPolygon(double[][] polygon, double[] point) {
        int n = polygon.length;
        boolean inside = false;
        for (int i = 0, j = n - 1; i < n; j = i++) {
            double xi = polygon[i][0], yi = polygon[i][1];
            double xj = polygon[j][0], yj = polygon[j][1];
            boolean intersect = ((yi > point[1]) != (yj > point[1])) &&
                    (point[0] < (xj - xi) * (point[1] - yi) / (yj - yi) + xi);
            if (intersect) inside = !inside;
        }
        return inside;
    }
    public static List<double[]> findUnmatchingPoints(List<double[]> list1, List<double[]> list2) {
        List<double[]> unmatchingPoints = new ArrayList<>();

        for (double[] point : list1) {
            if (!containsPoint(list2, point)) {
                unmatchingPoints.add(point);
            }
        }

        for (double[] point : list2) {
            if (!containsPoint(list1, point)) {
                unmatchingPoints.add(point);
            }
        }

        return unmatchingPoints;
    }

    public static boolean containsPoint(List<double[]> list, double[] point) {
        for (double[] p : list) {
            if (p[0] == point[0] && p[1] == point[1]) {
                return true;
            }
        }
        return false;
    }
}
