package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by zhur198 on 12/25/16.
 */
public class PointTests {

    @Test
    public void testDistance1 () {
      Points d = new Points(7, 5, 3, 4);
      System.out.println("Distance between p1 and p2 = " + d.distance());
      Assert.assertEquals(d.distance(), 4.123105625617661);
    }

    @Test
     public void testDistance2 () {
      Points d = new Points(8, 6, 2, 3);
      System.out.println("Distance between p1 and p2 = " + d.distance());
      Assert.assertEquals(d.distance(), 6.708203932499369);
    }

    @Test
    public void testDistance3 () {
      Points d = new Points(12, 18, 9, 1);
      System.out.println("Distance between p1 and p2 = " + d.distance());
      Assert.assertEquals(d.distance(), 17.26267650163207);
    }

    @Test
    public void testDistance4 () {
      Points d = new Points(4, 9, 1, 4);
      System.out.println("Distance between p1 and p2 = " + d.distance());
      Assert.assertEquals(d.distance(), 5.830951894845301);
    }

}
