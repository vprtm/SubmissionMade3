package dicoding.submissionmade3;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AdapterMovies extends RecyclerView.Adapter<AdapterMovies.ListViewHolder> {

    private ArrayList<Movies> listMovies;
    private Context context;

    public AdapterMovies(Context context) {
        this.context = context;
    }

    public ArrayList<Movies> getListMovies() {
        return listMovies;
    }

    public void setListMovies(ArrayList<Movies> listMovies) {
        this.listMovies = listMovies;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycle_item, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder listViewHolder, int i) {
        Movies movies = listMovies.get(i);
        String url = "https://image.tmdb.org/t/p/w600_and_h900_bestv2";
        listViewHolder.tvMovieName.setText(movies.getMovieName());
        listViewHolder.tvMovieDate.setText(movies.getMovieDate());
        listViewHolder.tvMovieOverview.setText(movies.getMovieOverview());

        Glide.with(listViewHolder.itemView.getContext())
                .load(url + movies.getMoviePoster())
                .into(listViewHolder.ivMoviePoster);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        TextView tvMovieName;
        TextView tvMovieDate;
        TextView tvMovieOverview;
        ImageView ivMoviePoster;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMovieName = itemView.findViewById(R.id.tv_name);
            tvMovieDate = itemView.findViewById(R.id.tv_date);
            tvMovieOverview = itemView.findViewById(R.id.tv_overview);
            ivMoviePoster = itemView.findViewById(R.id.poster);
        }
    }
}
