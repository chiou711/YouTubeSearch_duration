package com.cw.ref.youtubesearch_duration.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.cw.ref.youtubesearch_duration.R;
import com.cw.ref.youtubesearch_duration.api.CustomVolleyRequest;
import com.cw.ref.youtubesearch_duration.data.VideoData;

import java.util.List;

/**
 * Created by sodha on 9/3/16.
 */
public class MainActivityListAdapter extends RecyclerView.Adapter<MainActivityListAdapter.ViewHolder> {
    private ImageLoader imageLoader;
    private Context context;
    List<VideoData> videoList;


    public MainActivityListAdapter(Context context, List<VideoData> videoList) {
        super();
        this.context = context;
        this.videoList = videoList;
    }

    @Override
    public MainActivityListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.yt_video_row_card, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MainActivityListAdapter.ViewHolder holder, int position) {
        VideoData video = videoList.get(position);
        imageLoader = CustomVolleyRequest.getInstance(context).getImageLoader();
        imageLoader.get(video.getMediumThumbnail(), ImageLoader.getImageListener(holder.imageView, R.drawable.ic_action_android, R.drawable.ic_action_android));
        holder.imageView.setImageUrl(video.getMediumThumbnail(), imageLoader);
        holder.imageView.setBackgroundColor(Color.BLACK);
        holder.uploaderName.setText(video.getChannelTitle());
        holder.videoName.setText(video.getVideoTitle());
        holder.views.setText(video.getViewCount() + " views");
        holder.duration.setText(video.getDuration());
        holder.timeAgo.setText(video.getTimeAgo());
    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }
    public void addAll(List<VideoData> newVideoList) {
        videoList.addAll(newVideoList);
    }
    public void removeAll() {
        videoList.clear();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public NetworkImageView imageView;
        public TextView videoName;
        public TextView uploaderName;
        public TextView views;
        public TextView duration;
        public TextView timeAgo;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (NetworkImageView)itemView.findViewById(R.id.videoListThumbnail);
            videoName = (TextView)itemView.findViewById(R.id.videoListName);
            uploaderName = (TextView)itemView.findViewById(R.id.videoListUploaderName);
            timeAgo = (TextView)itemView.findViewById(R.id.videoListPublishedAt);
            views = (TextView)itemView.findViewById(R.id.videoListViews);
            duration = (TextView)itemView.findViewById(R.id.videoListDuration);
        }
    }
}
