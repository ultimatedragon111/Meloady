package com.example.marvelexamen2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.marvelexamen2.Media;
import com.squareup.picasso.Picasso;

public class ImageAdapter extends PagerAdapter {
    private Context mContext;
    private String[] media;

    public ImageAdapter(Context mContext, Media media) {
        this.mContext = mContext;
        this.media = new String[]{media.getUrlToImage1(), media.getUrlToImage2(), media.getUrlToImage3()};
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ImageView) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageView = new ImageView(mContext);
        Picasso.get()
                .load(media[position])
                .fit()
                .centerInside()
                .into(imageView);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
