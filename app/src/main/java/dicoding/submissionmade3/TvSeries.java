package dicoding.submissionmade3;

import android.os.Parcel;
import android.os.Parcelable;

public class TvSeries implements Parcelable {

    private int tvId,tvPopularity;
    private float tvRate;
    private String tvName,tvDate,tvOverview,tvPoster,tvBackDrop;
    private int[] tvGenre;

    public TvSeries(int tvId, int tvPopularity, float tvRate, String tvName, String tvDate, String tvOverview, String tvPoster, String tvBackDrop, int[] tvGenre) {
        this.tvId = tvId;
        this.tvPopularity = tvPopularity;
        this.tvRate = tvRate;
        this.tvName = tvName;
        this.tvDate = tvDate;
        this.tvOverview = tvOverview;
        this.tvPoster = tvPoster;
        this.tvBackDrop = tvBackDrop;
        this.tvGenre = tvGenre;
    }

    public int getTvId() {
        return tvId;
    }

    public void setTvId(int tvId) {
        this.tvId = tvId;
    }

    public int getTvPopularity() {
        return tvPopularity;
    }

    public void setTvPopularity(int tvPopularity) {
        this.tvPopularity = tvPopularity;
    }

    public float getTvRate() {
        return tvRate;
    }

    public void setTvRate(float tvRate) {
        this.tvRate = tvRate;
    }

    public String getTvName() {
        return tvName;
    }

    public void setTvName(String tvName) {
        this.tvName = tvName;
    }

    public String getTvDate() {
        return tvDate;
    }

    public void setTvDate(String tvDate) {
        this.tvDate = tvDate;
    }

    public String getTvOverview() {
        return tvOverview;
    }

    public void setTvOverview(String tvOverview) {
        this.tvOverview = tvOverview;
    }

    public String getTvPoster() {
        return tvPoster;
    }

    public void setTvPoster(String tvPoster) {
        this.tvPoster = tvPoster;
    }

    public String getTvBackDrop() {
        return tvBackDrop;
    }

    public void setTvBackDrop(String tvBackDrop) {
        this.tvBackDrop = tvBackDrop;
    }

    public int[] getTvGenre() {
        return tvGenre;
    }

    public void setTvGenre(int[] tvGenre) {
        this.tvGenre = tvGenre;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.tvId);
        dest.writeInt(this.tvPopularity);
        dest.writeFloat(this.tvRate);
        dest.writeString(this.tvName);
        dest.writeString(this.tvDate);
        dest.writeString(this.tvOverview);
        dest.writeString(this.tvPoster);
        dest.writeString(this.tvBackDrop);
        dest.writeIntArray(this.tvGenre);
    }

    protected TvSeries(Parcel in) {
        this.tvId = in.readInt();
        this.tvPopularity = in.readInt();
        this.tvRate = in.readFloat();
        this.tvName = in.readString();
        this.tvDate = in.readString();
        this.tvOverview = in.readString();
        this.tvPoster = in.readString();
        this.tvBackDrop = in.readString();
        this.tvGenre = in.createIntArray();
    }

    public static final Parcelable.Creator<TvSeries> CREATOR = new Parcelable.Creator<TvSeries>() {
        @Override
        public TvSeries createFromParcel(Parcel source) {
            return new TvSeries(source);
        }

        @Override
        public TvSeries[] newArray(int size) {
            return new TvSeries[size];
        }
    };
}
