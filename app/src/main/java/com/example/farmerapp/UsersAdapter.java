package com.example.farmerapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class UsersAdapter extends ArrayAdapter<Users> {
    public UsersAdapter(Context context, List<Users> users){
        super(context,0,users);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View listView = convertView;
        if (listView == null)
            listView= LayoutInflater.from(getContext()).inflate(R.layout.activity_users, parent, false);

        Users currentUser = getItem(position);
        ImageView imageView = (ImageView) listView.findViewById(R.id.imageLogo);

        int id= currentUser.getId();
        String name = currentUser.getName();
        String imageUrl = currentUser.getImageUrl();
        String collegeName = currentUser.getCollegeName();
        String rollNo = currentUser.getRoll().toString();

        TextView idView = (TextView) listView.findViewById(R.id.id);
        TextView nameView = ( TextView) listView.findViewById(R.id.name);
        TextView collegeView =( TextView) listView.findViewById(R.id.collegeName);
        TextView rollNoView = ( TextView) listView.findViewById(R.id.roll);

        idView.setText(id);
        nameView.setText(name);
        collegeView.setText(collegeName);
        rollNoView.setText(rollNo);

        UserImage userImage = new UserImage(imageUrl);
        return listView;
    }
    private class UserImage extends AsyncTAsk<String,Void, Bitmap>{
        public UserImage(ImageView imageView){

        }
    }
}
