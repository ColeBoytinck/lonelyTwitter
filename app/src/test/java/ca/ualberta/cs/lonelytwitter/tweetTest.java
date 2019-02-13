package ca.ualberta.cs.lonelytwitter;

import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class tweetTest {

    @Test
    public void addTest() {
        LonelyTwitterActivity test = new LonelyTwitterActivity();
        Tweet t1 = new Tweet("test2");
        Tweet t2 = new Tweet("test2");
        int num1 = test.addTweet(t1);
        assertEquals(0, num1);
        int num2 = test.addTweet(t2);
        assertEquals(-1, num2);
    }

    @Test
    public void getTest() {
        LonelyTwitterActivity test = new LonelyTwitterActivity();
        Tweet t1 = new Tweet("1");
        Tweet t2 = new Tweet("2");
        Tweet t3 = new Tweet("3");
        Tweet t4 = new Tweet("4");
        test.addTweet(t1);
        test.addTweet(t2);
        test.addTweet(t3);
        test.addTweet(t4);
        ArrayList<Tweet> tList = test.getTweet();

        assertEquals("1", tList.get(0).getMessage());
        assertEquals("2", tList.get(1).getMessage());
        assertEquals("3", tList.get(2).getMessage());
        assertEquals("4", tList.get(3).getMessage());
    }

    @Test
    public void hasTest() {
        LonelyTwitterActivity test = new LonelyTwitterActivity();
        Tweet t1 = new Tweet("1");
        test.addTweet(t1);
        boolean tf = test.hasTweet(t1);
        assertTrue(tf);
    }

    @Test
    public void countTest() {
        LonelyTwitterActivity test = new LonelyTwitterActivity();
        Tweet t1 = new Tweet("1");
        test.addTweet(t1);
        int num = test.getCount();
        assertEquals(1, num);
    }
}
