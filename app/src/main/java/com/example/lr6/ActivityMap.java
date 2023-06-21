package com.example.lr6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.yandex.mapkit.Animation;
import com.yandex.mapkit.MapKitFactory;

//import com.yandex.mapkit.
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.mapview.MapView;

public class ActivityMap extends AppCompatActivity {


    private MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        MapKitFactory.initialize(this);
        setContentView(R.layout.activity_map);
        super.onCreate(savedInstanceState);
        mapView = (MapView) findViewById(R.id.Map);
        PointOfInterest poi = new PointOfInterest();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            poi = extras.getParcelable("data");
        }
        // Перемещение камеры в центр Санкт-Петербурга.
        mapView.getMap().move(
                new CameraPosition(poi.getPoint(), 14.0f, 0.0f, 0.0f),
                new Animation(Animation.Type.SMOOTH, 5),
                null);

        //mapview.
        TextView name = findViewById(R.id.mainName);
        TextView info = findViewById(R.id.mainInfo);
        name.setText(poi.getName());
        info.setText(poi.getInfo());
        mapView.getMap().getMapObjects().addPlacemark(poi.getPoint());
    }

    @Override
    protected void onStop() {
        // Вызов onStop нужно передавать инстансам MapView и MapKit.
        mapView.onStop();
        MapKitFactory.getInstance().onStop();
        super.onStop();
    }

    @Override
    protected void onStart() {
        // Вызов onStart нужно передавать инстансам MapView и MapKit.
        super.onStart();
        MapKitFactory.getInstance().onStart();
        mapView.onStart();
    }
    /*@Override
    protected void onDestroy(){
        super.onDestroy();
    }*/
    /*@Override
    public void onBackPressed() {
        Intent intent = new Intent(ActivityMap.this, ActivityList.class);
        setResult(RESULT_OK, intent);
        finish();
    }*/

}

