package dicoding.submissionmade3;

import android.os.Parcel;
import android.os.Parcelable;

public class Movies implements Parcelable {

    private int movieId,moviePopularity;
    private double movieRate;
    private String movieName,movieDate,movieOverview,moviePoster,movieBackDrop;
    private int[] movieGenre;

    public Movies(int movieId, int moviePopularity, float movieRate, String movieName, String movieDate, String movieOverview, String moviePoster, String movieBackDrop, int[] movieGenre) {
        this.movieId = movieId;
        this.moviePopularity = moviePopularity;
        this.movieRate = movieRate;
        this.movieName = movieName;
        this.movieDate = movieDate;
        this.movieOverview = movieOverview;
        this.moviePoster = moviePoster;
        this.movieBackDrop = movieBackDrop;
        this.movieGenre = movieGenre;
    }

    public Movies() {

    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getMoviePopularity() {
        return moviePopularity;
    }

    public void setMoviePopularity(int moviePopularity) {
        this.moviePopularity = moviePopularity;
    }

    public double getMovieRate() {
        return movieRate;
    }

    public void setMovieRate(double movieRate) {
        this.movieRate = movieRate;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieDate() {
        return movieDate;
    }

    public void setMovieDate(String movieDate) {
        this.movieDate = movieDate;
    }

    public String getMovieOverview() {
        return movieOverview;
    }

    public void setMovieOverview(String movieOverview) {
        this.movieOverview = movieOverview;
    }

    public String getMoviePoster() {
        return moviePoster;
    }

    public void setMoviePoster(String moviePoster) {
        this.moviePoster = moviePoster;
    }

    public String getMovieBackDrop() {
        return movieBackDrop;
    }

    public void setMovieBackDrop(String movieBackDrop) {
        this.movieBackDrop = movieBackDrop;
    }

    public int[] getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(int[] movieGenre) {
        this.movieGenre = movieGenre;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.movieId);
        dest.writeInt(this.moviePopularity);
        dest.writeDouble(this.movieRate);
        dest.writeString(this.movieName);
        dest.writeString(this.movieDate);
        dest.writeString(this.movieOverview);
        dest.writeString(this.moviePoster);
        dest.writeString(this.movieBackDrop);
        dest.writeIntArray(this.movieGenre);
    }

    protected Movies(Parcel in) {
        this.movieId = in.readInt();
        this.moviePopularity = in.readInt();
        this.movieRate = in.readFloat();
        this.movieName = in.readString();
        this.movieDate = in.readString();
        this.movieOverview = in.readString();
        this.moviePoster = in.readString();
        this.movieBackDrop = in.readString();
        this.movieGenre = in.createIntArray();
    }

    public static final Creator<Movies> CREATOR = new Creator<Movies>() {
        @Override
        public Movies createFromParcel(Parcel source) {
            return new Movies(source);
        }

        @Override
        public Movies[] newArray(int size) {
            return new Movies[size];
        }
    };
}
