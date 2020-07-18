package com.hai.appproject;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class ViewHolder extends RecyclerView.ViewHolder {
    View mview;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        mview=itemView;
    }
    public void setDetails(Context ctx, String name, String mobile, String price,String available,String url)
    {
        TextView mtitle = mview.findViewById(R.id.post_title);
        TextView mdesc = mview.findViewById(R.id.post_des);
        ImageView mimage = mview.findViewById(R.id.post_image);
        mtitle.setText("Name "+name+"  "+"Contact "+mobile);
        mdesc.setText("Price "+price+"  "+"Old or New "+available);
        Picasso.get().load(url).into(mimage);
    }


}