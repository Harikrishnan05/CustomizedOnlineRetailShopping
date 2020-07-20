package com.hai.appproject;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class ViewHolder extends RecyclerView.ViewHolder {
    View mview;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        mview=itemView;
    }
    public void setDetails(Context ctx, String name, String mobile, String price,String available,String url,String mail1)
    {
        TextView mmobile = mview.findViewById(R.id.postmobile);
        TextView mtitle = mview.findViewById(R.id.post_title);
        TextView mdesc = mview.findViewById(R.id.post_des);
        ImageView mimage = mview.findViewById(R.id.post_image);
        TextView mail = mview.findViewById(R.id.maildetail);
        mmobile.setText("Contact: "+mobile);
        mtitle.setText("Name: "+name);
        mdesc.setText("Price: "+price+"  "+"Old or New: "+available);
        mail.setText("Email: "+mail1);

        Picasso.get().load(url).into(mimage);
    }


}