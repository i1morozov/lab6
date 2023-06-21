package com.example.lr6;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import com.yandex.mapkit.Animation;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.map.CameraPosition;

import com.yandex.mapkit.mapview.MapView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final String MAPKIT_API_KEY = "83e1cf3d-1da1-4ea7-a7d3-eecc90ccceb2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MapKitFactory.setApiKey(MAPKIT_API_KEY);

    }

    public void nextEvent(View v) {
        EditText name = findViewById(R.id.name);
        EditText surname = findViewById(R.id.surname);
        EditText e_mail = findViewById(R.id.e_mail);
        if (name.getText().toString().equals("")) {
            Toast.makeText(MainActivity.this, "Заполните все необходимые поля", Toast.LENGTH_SHORT).show();
        } else {
            User user = new User(name.getText().toString(), surname.getText().toString(), e_mail.getText().toString());
            Intent intent = new Intent(this, ActivityList.class);
            intent.putExtra("user", user);
            startActivity(intent);
        }
    }
}
