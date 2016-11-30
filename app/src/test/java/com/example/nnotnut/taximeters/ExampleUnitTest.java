package com.example.nnotnut.taximeters;

import junit.framework.Assert;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
//    @Test
//    public void addition_isCorrect() throws Exception {
//        assertEquals(4, 2 + 2);
//    }
//    public void calTest(){
//        String way = "0";
//        double result = MainActivity.cal(way);
//        Assert.assertEquals(0,result);
//
//        way = "1";
//        result = MainActivity.cal(way);
//        Assert.assertEquals(35,result);
//
//        way = "10";
//        result = MainActivity.cal(way);
//        Assert.assertEquals(85,result);
//
//        way = "20";
//        result = MainActivity.cal(way);
//        Assert.assertEquals(151,result);
//
//        way = "30";
//        result = MainActivity.cal(way);
//        Assert.assertEquals(225,result);
//
//        way = "40";
//        result = MainActivity.cal(way);
//        Assert.assertEquals(301,result);
//
//    }

    @Test
    public void caltrafTest(){
        int num= 0;
        double sum = MainActivity.caltraf(num);
        Assert.assertEquals(0.0,sum);

        num= 15;
        sum = MainActivity.caltraf(num);
        Assert.assertEquals(30.0,sum);

        num= 30;
        sum = MainActivity.caltraf(num);
        Assert.assertEquals(60.0,sum);

        num= 60;
        sum = MainActivity.caltraf(num);
        Assert.assertEquals(120.0,sum);

    }

    @Test
    public void calperTest(){
        double price = 0.0;
        double result = MainActivity.calper(price);
        Assert.assertEquals(0.0, result);

        price = 1.0;
        result = MainActivity.calper(price);
        Assert.assertEquals(3.0, result);

        price = 35;
        result = MainActivity.calper(price);
        Assert.assertEquals(47.0, result);

        price = 85.0;
        result = MainActivity.calper(price);
        Assert.assertEquals(113.0, result);

        price = 101.0;
        result = MainActivity.calper(price);
        Assert.assertEquals(133.0, result);

        price = 221.0;
        result = MainActivity.calper(price);
        Assert.assertEquals(289.0, result);
    }


}