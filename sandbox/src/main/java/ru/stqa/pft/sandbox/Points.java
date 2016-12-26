package ru.stqa.pft.sandbox;

/**
 * Created by zhur198 on 12/25/16.
 */
public class Points {

  public double x;
  public double y;
//
public static void main(String[] args) {
  Points p1 = new Points();
  Points p2 = new Points();
  p1.x = 7;
  p2.x = 3;
  p1.y = 5;
  p2.y = 4;
  System.out.println("Distance between p1 and p2 = " + distance(p1, p2));
}

  public static double distance (Points p1, Points p2) {

    return Math.sqrt((p1.x-p2.x)*(p1.x-p2.x) + (p1.y-p2.y)*(p1.y-p2.y));

  }
}
