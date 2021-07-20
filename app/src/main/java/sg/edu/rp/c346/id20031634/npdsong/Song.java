package sg.edu.rp.c346.id20031634.npdsong;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Song implements Serializable {
    private int _id;
    private String singers;
    private String title;
    private int year;
    private int stars;

    public Song(int id, String title, String singers, int year, int stars) {
        this.title = title;
        this.singers = singers;
        this.year = year;
        this.stars = stars;
    }

    public void setSingers(String singers) {
        this.singers = singers;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public int get_id() {
        return _id;
    }

    public String getTitle() {
        return title;
    }

    public String getSingers() {
        return singers;
    }

    public int getYear() {
        return year;
    }

    public int getStars() {
        return stars;
    }

    @NonNull
    @Override
    public String toString() {
        return "ID:" + _id + ", " + title +"\n" + singers + "-" + year + "\n" + stars;
    }

}

