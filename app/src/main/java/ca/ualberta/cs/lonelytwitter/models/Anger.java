package ca.ualberta.cs.lonelytwitter.models;

/**
 * @author Cole Boytinck
 * @version 1.0
 * currently not in use
 */
public class Anger extends Mood {
    private String mood;

    /**
     * Sets the current mood to 'Anger'
     */
    Anger() {
        this.mood = "Anger";
    }

    /**
     *
     * @return String mood, returns the Anger mood
     */
    public String getMood() {
        return mood;
    }
}
