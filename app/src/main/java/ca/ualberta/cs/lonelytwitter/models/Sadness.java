package ca.ualberta.cs.lonelytwitter.models;

/**
 * @author Cole Boytinck
 * @version 1.0
 * currently not in use
 */
public class Sadness extends Mood {
    private String mood;

    /**
     * Sets the current mood to 'Sadness'
     */
    Sadness() {
        this.mood = "Sadness";
    }

    /**
     *
     * @return String mood, returns the sadness mood
     */
    public String getMood() {
        return mood;
    }
}
