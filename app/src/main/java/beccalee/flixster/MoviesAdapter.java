package beccalee.flixster;

import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

/**
 * Created by beccalee on 6/15/16.
 */
public class MoviesAdapter extends ArrayAdapter<Movie> {

    private static class ViewHolder {
        TextView title;
        TextView overview;
        ImageView poster;
    }

    public MoviesAdapter(Context context, ArrayList<Movie> movies) {
        super(context, R.layout.item_movie, movies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Get the data item for this position
        Movie movie = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_movie, parent, false);
            viewHolder.title = (TextView) convertView.findViewById(R.id.tvTitle);
            viewHolder.overview = (TextView) convertView.findViewById(R.id.tvOverview);
            viewHolder.poster = (ImageView) convertView.findViewById(R.id.ivPoster);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        String imageUri;
        Context context = getContext();
        if (context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            imageUri = movie.getBackdropUrl();
        }
        else {
            imageUri = movie.getPosterUrl();
        }

        // Lookup view for data population
        //TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        //ImageView ivPoster = (ImageView) convertView.findViewById(R.id.ivPoster);
        //TextView tvOverview = (TextView) convertView.findViewById(R.id.tvOverview);

        // Populate the data into the template view using the data object
        //tvTitle.setText(movie.title);
        //tvOverview.setText(movie.overview);
        viewHolder.title.setText(movie.title);
        viewHolder.overview.setText(movie.overview);
        viewHolder.poster.setImageResource(0);


        Picasso.with(getContext()).load(imageUri).transform(new RoundedCornersTransformation(10, 10))
                .placeholder(R.drawable.loading).into(viewHolder.poster);

        //Log.d("MoviesAdapter", "Position: " + position);

        // Return the completed view to render on screen
        return convertView;


    }

}
