package com.example.imagegallery;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 3);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.images);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        MainActivity.ImageGalleryAdapter adapter = new MainActivity.ImageGalleryAdapter(this, Image.getImages());
        recyclerView.setAdapter(adapter);
    }

    private class ImageGalleryAdapter extends RecyclerView.Adapter<ImageGalleryAdapter.MyViewHolder>  {

        @Override
        public ImageGalleryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            Context context = parent.getContext();
            LayoutInflater inflater = LayoutInflater.from(context);

            View photoView = inflater.inflate(R.layout.image, parent, false);

            ImageGalleryAdapter.MyViewHolder viewHolder = new ImageGalleryAdapter.MyViewHolder(photoView);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ImageGalleryAdapter.MyViewHolder holder, int position) {

            Image image = mImages[position];
            ImageView imageView = holder.mPhotoImageView;

            Glide.with(mContext)
                    .load(image.getUrl())
                    .placeholder(R.drawable.ic_autorenew_black)
                    .into(imageView);
        }

        @Override
        public int getItemCount() {
            return (mImages.length);
        }

        public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            public ImageView mPhotoImageView;

            public MyViewHolder(View itemView) {

                super(itemView);
                mPhotoImageView = (ImageView) itemView.findViewById(R.id.photo);
                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View view) {

                int position = getAdapterPosition();
                if(position != RecyclerView.NO_POSITION) {
                    Image image = mImages[position];

                    Intent intent = new Intent(mContext, ImageActivity.class);
                    intent.putExtra(ImageActivity.EXTRA_IMAGE, image);
                    startActivity(intent);
                }
            }
        }

        private Image[] mImages;
        private Context mContext;

        public ImageGalleryAdapter(Context context, Image[] images) {
            mContext = context;
            mImages = images;
        }
    }
}
