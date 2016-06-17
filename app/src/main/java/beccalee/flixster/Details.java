package beccalee.flixster;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by beccalee on 6/16/16.
 */
public class Details extends AppCompatActivity{

    RatingBar ratingBar;
    ImageView ivBackdrop;
    TextView tvTitle;
    TextView tvRelease;
    TextView tvOverview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ivBackdrop = (ImageView) findViewById(R.id.ivBackdrop);
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvRelease = (TextView) findViewById(R.id.tvRelease);
        tvOverview = (TextView) findViewById(R.id.tvOverview);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);

        String title = getIntent().getStringExtra("title");
        String release = getIntent().getStringExtra("release");
        String overview = getIntent().getStringExtra("overview");
        String backdropUrl = getIntent().getStringExtra("backdrop");
        float rating = getIntent().getFloatExtra("rating", 0);
        Log.d("uri", backdropUrl);
        //int rating = getIntent().getIntExtra("rating");
        tvTitle.setText(title);
        tvRelease.setText(release);
        tvOverview.setText(overview);
        ratingBar.setRating((float)rating/2);
        //ivBackdrop.setImageURI(ivBackdrop);


        Picasso.with(this.getApplicationContext()).load(backdropUrl).placeholder(R.drawable.loadingsymbol).into(ivBackdrop);

    }


}
