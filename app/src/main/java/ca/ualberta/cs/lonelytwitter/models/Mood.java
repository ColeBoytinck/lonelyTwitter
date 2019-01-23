package ca.ualberta.cs.lonelytwitter.models;

import java.util.Date;

/**
 * @author Cole Boytinck
 * @version 1.0
 * Currently not in use
 */
public abstract class Mood {
    private Date date;

    /**
     * Sets the date for the mood
     */
    Mood() {
        this.date = new Date();
    }

    /**
     *
     * @return Date date, gets the date for the mood
     */
    public Date getDate() {
        return date;
    }

    /**
     *
     * @param date, sets the date for the mood
     */
    public void setDate(Date date) {
        this.date = date;
    }

}
