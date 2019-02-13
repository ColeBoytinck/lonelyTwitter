package ca.ualberta.cs.lonelytwitter;

import java.util.Date;
import java.util.UUID;

/**
 * @author Cole Boytinck
 * @version 1.0
 */
public class Tweet {

    private String message;
    private Date date;

    public UUID getUniqueID() {
        return UniqueID;
    }

    public void setUniqueID(UUID uniqueID) {
        UniqueID = uniqueID;
    }

    private UUID UniqueID;

    /**
     *
     * @param message String, the tweet message
     */
    Tweet(String message) {
        this.message = message;
        this.UniqueID = UUID.randomUUID();
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
