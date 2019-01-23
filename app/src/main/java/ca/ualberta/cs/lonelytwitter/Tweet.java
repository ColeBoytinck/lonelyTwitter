package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * @author Cole Boytinck
 * @version 1.0
 */
public class Tweet {

    private String message;
    private Date date;

    /**
     *
     * @param message String, the tweet message
     */
    Tweet(String message) {
        this.message = message;
    }

    /**
     *
     * @param message String, set tweet message to this
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     *
     * @return String message, get the tweet message
     */
    public String getMessage() {
        return message;
    }

    /**
     *
     * @return String message, get the tweet message
     */
    @Override
    public String toString() {
        return message;
    }
}
