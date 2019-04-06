package com.example.todo_app;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

class Myadapter extends ArrayAdapter {
    public Myadapter(Context context, ArrayList<Information> infoArrayList) {
        super(context,0,infoArrayList);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        final Information currentinformation = (Information) getItem(position);
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.card, parent, false);
        }
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.text);
        nameTextView.setText(currentinformation.getName());
        final RelativeLayout relativeLayout =listItemView.findViewById(R.id.card);
         final CheckBox checkBox = listItemView.findViewById(R.id.checkbox);
        if(currentinformation.getEnable()==1)
        {
            relativeLayout.setBackgroundColor(Color.parseColor("#4FBD4F"));
            checkBox.setVisibility(View.INVISIBLE);
        }
        else {
            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (checkBox.isChecked()) {
                        relativeLayout.setBackgroundColor(Color.parseColor("#4FBD4F"));
                        checkBox.setVisibility(View.INVISIBLE);
                        currentinformation.setEnable(1);
                    }
                }
            });
        }
        return listItemView;
    }
}
