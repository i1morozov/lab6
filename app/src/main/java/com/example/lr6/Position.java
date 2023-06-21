package com.example.lr6;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Position extends ArrayAdapter<PointOfInterest> {
    private Context context;

    private ArrayList<PointOfInterest> POIList;

    private User user;

    @Override
    public int getCount() {
        return POIList.size();
    }


    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.list_node, null);
        TextView name = convertView.findViewById(R.id.name);
        TextView time = convertView.findViewById(R.id.time);
        TextView cost = convertView.findViewById(R.id.cost);
        name.setText(POIList.get(position).getName());
        time.setText(POIList.get(position).getTime());
        cost.setText(POIList.get(position).getCost());

        return convertView;
    }

    public Position(Context context, ArrayList<PointOfInterest> POIList, User user) {
        super(context, 0, POIList);
        this.context = context;
        this.POIList = POIList;
        this.user = user;
    }

}
