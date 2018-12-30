package com.cw.ref.youtubesearch_duration.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.cw.ref.youtubesearch_duration.R;
import com.cw.ref.youtubesearch_duration.api.CustomVolleyRequest;
import com.cw.ref.youtubesearch_duration.config.EndPoints;
import com.cw.ref.youtubesearch_duration.data.VideoData;

/**
 * Created by sodha on 10/3/16.
 */
public class VideoDetail extends AppCompatActivity {
    private VideoData videoDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yt_video_detail);

        try {
            videoDetail = (VideoData)getIntent().getSerializableExtra("ob");
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: 10/3/16 Handle Error
            Toast.makeText(getApplicationContext(), "Some Error", Toast.LENGTH_LONG).show();
        }

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(videoDetail.getVideoTitle());
        generateView(getApplicationContext());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
            return  true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void generateView(Context context) {
        NetworkImageView imageView = (NetworkImageView)findViewById(R.id.videoDetailThumbnail);
        ImageLoader imageLoader = CustomVolleyRequest.getInstance(context).getImageLoader();
        imageLoader.get(videoDetail.getLargeThumbnail(), ImageLoader.getImageListener(imageView, R.drawable.ic_action_android, R.drawable.ic_action_android));
        imageView.setImageUrl(videoDetail.getLargeThumbnail(), imageLoader);
        ((TextView)findViewById(R.id.detailLikes)).setText(videoDetail.getLikeCount());
        ((TextView)findViewById(R.id.detailDislike)).setText(videoDetail.getDislikeCount());
        ((TextView)findViewById(R.id.detailDuration)).setText(videoDetail.getDuration());
        ((TextView)findViewById(R.id.detailViews)).setText(videoDetail.getViewCount() + " views");
        ((TextView)findViewById(R.id.detailTitle)).setText(videoDetail.getVideoTitle());
        ((TextView)findViewById(R.id.detailUploaderName)).setText(videoDetail.getChannelTitle());
        ((TextView)findViewById(R.id.detailFavorite)).setText(videoDetail.getFavouriteCount());
        FloatingActionButton playButton =   (FloatingActionButton)findViewById(R.id.playButton);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(EndPoints.YOUTUBE_URL_VIDEO + videoDetail.getVideoId())));
            }
        });
    }
}
