package com.example.ybdesire.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btn1ClickEvent(View target){
        TextView txt=(TextView)findViewById(R.id.textView);//find output label by id
        txt.setText("Hello world! click by button!!");

    }
}
