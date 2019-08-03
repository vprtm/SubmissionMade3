package dicoding.submissionmade3;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Locale;

import cz.msebera.android.httpclient.Header;


/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesFragment extends Fragment {

    private RecyclerView rvMovies;
    private ArrayList<Movies> moviesArrayList;
    private String key = "f27cb1c0463d4fd3a8d54fbbe6cfa011";
    private String TAG = "RESULT_TAG";

    public MoviesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        moviesArrayList = new ArrayList<>();

        rvMovies = view.findViewById(R.id.recycler_view_movie);
        rvMovies.setHasFixedSize(true);
        showList();

        ItemClickSupport.addTo(rvMovies).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, final int position, View v) {
                showSelectedMovies(moviesArrayList.get(position));
            }
        });
    }

    private void showRecyclerList(ArrayList<Movies> arrayMovies) {
        moviesArrayList = arrayMovies;
        rvMovies.setLayoutManager(new LinearLayoutManager(getActivity()));
        AdapterMovies adapterMovies = new AdapterMovies(getActivity());
        adapterMovies.setListMovies(moviesArrayList);
        rvMovies.setAdapter(adapterMovies);
    }

    private void showList(){
        final ArrayList<Movies> listMovies = new ArrayList<>();
        AsyncHttpClient client = new AsyncHttpClient();
        String url = "https://api.themoviedb.org/3/movie/upcoming?api_key=" + key + "&language=" + Locale.getDefault().toString() + "&page=1";
        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Toast.makeText(getActivity(), "Success", Toast.LENGTH_SHORT).show();
                String result = new String(responseBody);
                Log.d(TAG, TAG);
                try {
                    JSONObject responseObject = new JSONObject(result);
                    for(int i=0;i<2;i++){
                        Movies movies = new Movies();
                        movies.setMovieId(responseObject.getJSONArray("result").getJSONObject(i).getInt("id"));
                        movies.setMovieName(responseObject.getJSONArray("result").getJSONObject(i).getString("title"));
                        movies.setMovieDate(responseObject.getJSONArray("result").getJSONObject(i).getString("release_date"));
                        movies.setMovieOverview(responseObject.getJSONArray("result").getJSONObject(i).getString("overview"));
                        movies.setMoviePoster(responseObject.getJSONArray("result").getJSONObject(i).getString("poster_path"));
                        movies.setMovieBackDrop(responseObject.getJSONArray("result").getJSONObject(i).getString("backdrop_path"));
                        movies.setMoviePopularity(responseObject.getJSONArray("result").getJSONObject(i).getInt("popularity"));
                        movies.setMovieRate(responseObject.getJSONArray("result").getJSONObject(i).getDouble("vote_average"));
                        movies.setMovieGenre((int[]) responseObject.getJSONArray("result").getJSONObject(i).get("genre_ids"));
                        listMovies.add(movies);
                    }

                    showRecyclerList(listMovies);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(getActivity(), "Success", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void showSelectedMovies(Movies movies){
        Toast.makeText(getActivity(), R.string.choose+movies.getMovieName(), Toast.LENGTH_SHORT).show();
    }
}
