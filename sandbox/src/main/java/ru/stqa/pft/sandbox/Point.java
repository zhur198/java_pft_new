package ru.stqa.pft.sandbox;

/**
 * Created by zhur198 on 12/25/16.
 */
public class Point {

private double x, y;
  Point (double ax, double ay) {
    x = ax;
    y = ay;
  }

  public static void main (String[] args) {

    Point p1 = new Point (7, 5);
    Point p2 = new Point (3, 4);

    System.out.println("Distance between p1 and p2 = " + distance(p1, p2));

  }
//
  public static double distance (Point p1, Point p2) {

    return Math.sqrt((p1.x-p2.x)*(p1.x-p2.x) + (p1.y-p2.y)*(p1.y-p2.y));

  }
}
