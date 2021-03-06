package beccalee.flixster;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by beccalee on 6/15/16.
 */
public class Movie {

    public String getTitle() {
        return title;
    }

    public String getPosterUrl() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterUrl);
    }

    public float getRating() {
        return rating;
    }

    public String getReleaseDate() {
        return "Release Date: " + releaseDate;
    }

    public String getOverview() {
        return overview;
    }

    public String getBackdropUrl() {
        return String.format("https://image.tmdb.org/t/p/w780/%s", backdropUrl);
    }

    public String getPopularity() {
        return "Popularity: " + popularity;
    }

    public String title;
    public String posterUrl;
    public float rating;
    public String overview;
    public String backdropUrl;
    public String releaseDate;
    public String popularity;

    public Movie(JSONObject jsonObject) throws JSONException {
        this.title = jsonObject.getString("original_title");
        this.posterUrl = jsonObject.getString("poster_path");
        this.rating = jsonObject.getInt("vote_average");
        this.overview = jsonObject.getString("overview");
        this.backdropUrl = jsonObject.getString("backdrop_path");
        this.releaseDate = jsonObject.getString("release_date");
        this.popularity = jsonObject.getString("popularity");
    }


    public static ArrayList<Movie> fromJSONArray(JSONArray array){
        ArrayList<Movie> results = new ArrayList<>();

        for(int i = 0; i < array.length(); i++){
            try {
                results.add(new Movie(array.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return results;

    }

    @Override
    public String toString() {
        return title + " - " + rating;
    }

}
