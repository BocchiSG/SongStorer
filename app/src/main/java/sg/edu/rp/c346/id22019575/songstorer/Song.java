package sg.edu.rp.c346.id22019575.songstorer;

public class Song {
    private int _id;
    private String title;
    private String singers;
    private int year;
    private int stars;

    public Song(String title, String singers, int year, int stars){
        this.title =title;
        this.singers = singers;
        this.year = year;
        this.stars = stars;

    }

    public int getId() { return _id; }

    public String getTitle() { return title; }

    public String getSingers() { return singers; }

    public int getYear() { return year; }

    public int getStar() { return stars; }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSingers(String singers) {
        this.singers = singers;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}
