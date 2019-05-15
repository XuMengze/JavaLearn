package com.alg.other;

public class Polygon {
    public static void main(String[] args) {
        double[] xA = {0, 0, 1, 1};
        double[] yA = {0, 1, 1, 0};
        System.out.println(isInnerPoint(1.5, 0.5, xA, yA));
    }

    private static boolean isInnerPoint(double x, double y, double[] xArrays, double[] yArrays) {
        return Math.abs(getPolygonSpaceInnerPoint(x, y, xArrays, yArrays) - getPolygonSpace(xArrays, yArrays)) < 0.0000001;
    }

    private static double getPolygonSpaceInnerPoint(double x, double y, double[] xArrays, double[] yArrays) {
        double sum = 0;
        if (xArrays.length < 3 || xArrays.length != yArrays.length) {
            return sum;
        }
        for (int i = 0, len = xArrays.length; i < len; i++) {
            sum += getTriangleSpace(
                    getLineLength(x, y, xArrays[i], yArrays[i]),
                    getLineLength(xArrays[i], yArrays[i], xArrays[(i + 1) % len], yArrays[(i + 1) % len]),
                    getLineLength(xArrays[(i + 1) % len], yArrays[(i + 1) % len], x, y));
        }
        return sum;
    }

    private static double getPolygonSpace(double[] xArrays, double[] yArrays) {
        double sum = 0;
        if (xArrays.length < 3 || xArrays.length != yArrays.length) {
            return sum;
        }
        for (int i = 1, len = xArrays.length; i <= len - 2; i++) {
            sum += getTriangleSpace(
                    getLineLength(xArrays[0], yArrays[0], xArrays[i], yArrays[i]),
                    getLineLength(xArrays[i], yArrays[i], xArrays[i + 1], yArrays[i + 1]),
                    getLineLength(xArrays[i + 1], yArrays[i + 1], xArrays[0], yArrays[0]));
        }
        return sum;
    }

    private static double getLineLength(Double x1, Double y1, Double x2, Double y2) {
        return Math.pow(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2), 0.5);
    }

    private static double getTriangleSpace(Double s1, Double s2, Double s3) {
        double halfPerimeter = (s1 + s2 + s3) / 2.0;
        return Math.pow(halfPerimeter * (halfPerimeter - s1) * (halfPerimeter - s2) * (halfPerimeter - s3), 0.5);
    }
}
