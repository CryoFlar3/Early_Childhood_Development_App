package com.example.earlychildhooddevelopmentapp.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.earlychildhooddevelopmentapp.Model.Calculate;
import com.example.earlychildhooddevelopmentapp.R;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private Calculate calculate = new Calculate();
    private DatePicker birthDatePicker;
    private EditText prematureEditText;
    private Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        birthDatePicker = findViewById(R.id.birthDatePicker);
        prematureEditText = findViewById(R.id.prematureEditText);
        startButton = findViewById(R.id.startButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePicker birth = birthDatePicker;
                String value = prematureEditText.getText().toString();
                if(value.equals("")){
                    value = "0";
                }

                int premature = Integer.parseInt(value);

                Date trueDate = calculate.Calculate(birth, premature);
                int years = calculate.getYear(trueDate);
                int months = calculate.getMonth(trueDate);
//                boolean early = false;
//                if (premature > 0){
//                    early = true;
//                }

                startMilestone(years, months);
            }
        });
    }

    private void startMilestone(int years, int months) {
        Intent intent = new Intent(this, MilestoneActivity.class);
        intent.putExtra("years", years);
        intent.putExtra("months", months);
//        intent.putExtra("perfect", premature);
        startActivity(intent);
    }
}
