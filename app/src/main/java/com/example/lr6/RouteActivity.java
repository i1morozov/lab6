package com.example.lr6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class RouteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route);

        Intent intent1 = getIntent();
        ArrayList<PointOfInterest> points = intent1.getParcelableArrayListExtra("pois");
        ArrayList<String> names = new ArrayList<>();
        for(int count = 0; count < points.size();++count){
            names.add(points.get(count).getName());
        }
        ListView listView = findViewById(R.id.listView2);
        //Position placeAdapter = new Position(this, points, new User());

        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, names);
        listView.setAdapter(adapter);
        //listView.setAdapter(placeAdapter);
        Button OKButton = findViewById(R.id.button3);

        OKButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<PointOfInterest> routeSightseeings = new ArrayList<>();
                SparseBooleanArray chosenPositions = listView.getCheckedItemPositions();
                for (int i = 0; i < chosenPositions.size(); i++)
                    if (chosenPositions.valueAt(i))
                        routeSightseeings.add(points.get(chosenPositions.keyAt(i)));

                /*Uri uri = Uri.parse("yandexnavi://build_route_on_map?lat_from=55.75&lon_from=37.58&lat_to=55.75&lon_to=37.64&lat_via_0=55.75&lon_via_0=37.62");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setPackage("ru.yandex.yandexnavi");
                startActivity(intent);*/
                Intent intent = new Intent("ru.yandex.yandexnavi.action.BUILD_ROUTE_ON_MAP");
                intent.setPackage("ru.yandex.yandexnavi");
                PackageManager pm = getPackageManager();
                List<ResolveInfo> infos = pm.queryIntentActivities(intent, 0);
                intent.putExtra("lat_from", routeSightseeings.get(0).getPoint().getLatitude());
                intent.putExtra("lon_from", routeSightseeings.get(0).getPoint().getLongitude());
                intent.putExtra("lat_to", routeSightseeings.get(routeSightseeings.size()-1).getPoint().getLatitude());
                intent.putExtra("lon_to", routeSightseeings.get(routeSightseeings.size()-1).getPoint().getLongitude());
                for(int count = 1; count < routeSightseeings.size()-1; ++count){
                    intent.putExtra("lat_via_"+(count-1), routeSightseeings.get(count).getPoint().getLatitude());
                    intent.putExtra("lon_via_"+(count-1), routeSightseeings.get(count).getPoint().getLongitude());

                }
                startActivity(intent);
            }
        });

    }
}







        /*OK.setOnClickListener(v -> {
            ArrayList<PointOfInterest> routeSightseeings = new ArrayList<>();
            SparseBooleanArray chosenPositions = listView.getCheckedItemPositions();
            for (int i = 0; i < chosenPositions.size(); i++)
                if (chosenPositions.valueAt(i))
                    routeSightseeings.add(sightseeings.get(chosenPositions.keyAt(i)));
            Intent intent2 = new Intent();
            intent2.putParcelableArrayListExtra("pois", routeSightseeings);
            setResult(RESULT_OK, intent2);
            finish();
        });*/

        /*       OK.setOnClickListener(v -> {
            ArrayList<PointOfInterest> routeSightseeings = new ArrayList<>();
            SparseBooleanArray chosenPositions = listView.getCheckedItemPositions();
            for (int i = 0; i < chosenPositions.size(); i++)
                if (chosenPositions.valueAt(i))
                    routeSightseeings.add(sightseeings.get(chosenPositions.keyAt(i)));
            Intent intent2 = new Intent();
            intent2.putParcelableArrayListExtra("pois", routeSightseeings);
            setResult(RESULT_OK, intent2);
            finish();
        });
    }*/



/*

    Intent intent = new Intent("ru.yandex.yandexnavi.action.BUILD_ROUTE_ON_MAP");
        intent.setPackage("ru.yandex.yandexnavi");

                PackageManager pm = getPackageManager();
                List<ResolveInfo> infos = pm.queryIntentActivities(intent, 0);

// Проверяем, установлен ли Яндекс.Навигатор
        if(infos == null || infos.size() == 0) {
        // Если нет - будем открывать страничку Навигатора в Google Play
        intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("market://details?id=ru.yandex.yandexnavi"));
        }
        else {
        intent.putExtra("lat_from", 55.751802);
        intent.putExtra("lon_from", 37.586684);
        intent.putExtra("lat_to", 55.758192);
        intent.putExtra("lon_to", 37.642817);
        }*/