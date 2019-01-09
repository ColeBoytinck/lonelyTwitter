package ca.ualberta.cs.lonelytwitter.models;

public class Anger extends Mood {
    private String mood;

    Anger() {
        this.mood = "Anger";
    }

    public String getMood() {
        return mood;
    }
}
