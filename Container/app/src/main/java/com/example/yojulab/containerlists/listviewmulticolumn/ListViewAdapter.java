package com.example.yojulab.containerlists.listviewmulticolumn;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.yojulab.containerlists.R;

import java.util.ArrayList;
import java.util.HashMap;

import static com.example.yojulab.containerlists.listviewmulticolumn.Constants.*;
import static java.lang.Thread.sleep;

/**
 * Created by yojulab on 17. 11. 9.
 */

public class ListViewAdapter extends BaseAdapter {
    public ArrayList<HashMap<String, String>> list;
    Activity activity;
    TextView txtFirst;
    TextView txtSecond;
    TextView txtThird;
    TextView txtFourth;
    LayoutInflater inflater;
    View convertView;
    public ListViewAdapter(Activity activity, ArrayList<HashMap<String, String>> list, int column) {
//        super();
        this.activity = activity;
        this.list = list;
        this.inflater = activity.getLayoutInflater();
        this.convertView = inflater.inflate(column, null);

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {

        return list.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

//        if (this.convertView == null) {

            txtFirst = (TextView) this.convertView.findViewById(R.id.name);
            txtSecond = (TextView) this.convertView.findViewById(R.id.gender);
            txtThird = (TextView) this.convertView.findViewById(R.id.age);
            txtFourth = (TextView) this.convertView.findViewById(R.id.status);
//        }

        HashMap<String, String> map = list.get(position);
        txtFirst.setText(map.get(FIRST_COLUMN));
        txtSecond.setText(map.get(SECOND_COLUMN));
        txtThird.setText(map.get(THIRD_COLUMN));
        txtFourth.setText(map.get(FOURTH_COLUMN));
//        try {
//            sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return this.convertView;
    }
}
