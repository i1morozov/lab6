package com.example.lr6;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView;

import com.yandex.mapkit.geometry.Point;

import java.util.ArrayList;

public class ActivityList extends AppCompatActivity {
    ArrayList<PointOfInterest> pois;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);
        ListView listView = findViewById(R.id.listview);
        Button btnToCreateRoute=findViewById(R.id.buttonToCreateRoute);
        User user = getUser();
        ((TextView) findViewById(R.id.textView1)).setText("Здравствуйте, " + user.getName() + "!");
        pois = createList();
        Position placeAdapter = new Position(this, pois, user);
        listView.setClickable(true);
        listView.setAdapter(placeAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ActivityList.this, ActivityMap.class);
                intent.putExtra("data", pois.get(position));
                startActivity(intent);
            }
        });
        btnToCreateRoute.setOnClickListener(v -> {
            Intent intent3 = new Intent(ActivityList.this, RouteActivity.class);
            intent3.putParcelableArrayListExtra("pois", pois);
            startActivity(intent3);
            //ActivityResultLauncher.launch(intent3);
        });
    }
    /*@Override
    protected void onResume(){
        super.onResume();
    }
    @Override
    protected void onRestart(){
        super.onRestart();
    }*/
    private User getUser() {
        Bundle extras = getIntent().getExtras();
        User user = extras.getParcelable("user");
        return user;
    }

    private ArrayList<PointOfInterest> createList() {
        pois = new ArrayList<PointOfInterest>();
        pois.add(new PointOfInterest(new Point(46.086708, 38.981726), "2019", "ст. Каневская", "бесплатно", "круглосуточно"));
        pois.add(new PointOfInterest(new Point(53.122938, 56.142625), "2019", "Воскресенское", "бесплатно", "круглосуточно"));
        pois.add(new PointOfInterest(new Point(62.095747, 126.701580), "2019", "Бердигестях", "бесплатно", "круглосуточно"));
        pois.add(new PointOfInterest(new Point(57.549955, 25.438049), "2019", "Валмиера", "бесплатно", "круглосуточно"));
        pois.add(new PointOfInterest(new Point(59.860069, 38.381134), "2019", "Кириллов", "бесплатно", "круглосуточно"));
        pois.add(new PointOfInterest(new Point(59.373924, 41.030388), "2019", "Шуйское", "бесплатно", "круглосуточно"));
        pois.add(new PointOfInterest(new Point(55.196410, 36.59391), "2020", "Ермолино", "бесплатно", "круглосуточно"));
        return pois;
    }





}