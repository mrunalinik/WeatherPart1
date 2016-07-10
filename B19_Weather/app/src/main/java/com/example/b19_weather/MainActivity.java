package com.example.b19_weather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.b19_weather.common.WConstants;
import com.example.b19_weather.tasks.WeatherTask;

public class MainActivity extends AppCompatActivity {

    private Button getDataBtn;
    private TextView resultTv;
    private EditText cityET, stateET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init(){
        getDataBtn = (Button) findViewById(R.id.getDataBtn);
        resultTv = (TextView) findViewById(R.id.resultTv);
        cityET = (EditText) findViewById(R.id.cityET);
        stateET = (EditText) findViewById(R.id.stateET);


        getDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String state = stateET.getText().toString();
                String city = cityET.getText().toString();

                String url = WConstants.URL_HEAD + state + "/" + city + WConstants.URL_TAIL;
                String[] urlArray = new String[]{url};

                WeatherTask weatherTask = new WeatherTask();
                weatherTask.execute(urlArray);
            }
        });
    }
}
