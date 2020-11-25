package com.example.task3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetielsActivity extends AppCompatActivity {
    private TextView title , description , isComplete;
    private ImageView image;
    private Button back;
    private Bundle exters;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detiels);

        exters = getIntent().getExtras();

        back = (Button) findViewById(R.id.dback);
        title = (TextView)  findViewById(R.id.dtitle);
        description = (TextView) findViewById(R.id.ddiscription);
        image = (ImageView) findViewById(R.id.dimage);
        isComplete = (TextView) findViewById(R.id.des_isComplete);
        if(exters != null){
            title.setText(exters.getString("title"));
            description.setText(exters.getString("description"));
            image.setImageResource(exters.getInt("image"));
            if(exters.getBoolean("isComplete")){
                isComplete.setText("this task is completed");

            }
            else{
                isComplete.setText("");
            }
        }
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}