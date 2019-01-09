package ca.ualberta.cs.lonelytwitter.models;

public class Sadness extends Mood {
    private String mood;

    Sadness() {
        this.mood = "Sadness";
    }

    public String getMood() {
        return mood;
    }
}
