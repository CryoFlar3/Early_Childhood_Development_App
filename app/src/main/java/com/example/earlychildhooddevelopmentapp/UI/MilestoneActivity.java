package com.example.earlychildhooddevelopmentapp.UI;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.earlychildhooddevelopmentapp.Model.Headers;
import com.example.earlychildhooddevelopmentapp.Model.Milestone;
import com.example.earlychildhooddevelopmentapp.Model.Page;
import com.example.earlychildhooddevelopmentapp.R;

public class MilestoneActivity extends AppCompatActivity {

    // Classes
    private Page currentPage;
    private Headers headers = new Headers();
    private Milestone milestone = new Milestone();

    // Views
    private TextView headerTextView;
    private TextView milestoneHeaderTextView;
    private TextView progressTextView;
    private TextView cautionTextView;
    private TextView milestoneTextView;
    private TextView cautionHeaderTextView;
    private Button backButton;
    private ImageView imageView;

    // Variables
    private int year;
    private int months;
//    private boolean premature;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_milestone);

        headerTextView = findViewById(R.id.headerTextView);
        milestoneHeaderTextView = findViewById(R.id.milestoneHeaderTextView);
        progressTextView = findViewById(R.id.progressTextView);
        cautionHeaderTextView = findViewById(R.id.cautionHeaderTextView);
        cautionTextView = findViewById(R.id.cautionTextView);
        milestoneTextView = findViewById(R.id.milestoneTextView);
        backButton = findViewById(R.id.backButton);
        imageView = findViewById(R.id.imageView);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMenu();
            }
        });

        Intent intent = getIntent();
        year = intent.getIntExtra("years", 0);
        months = intent.getIntExtra("months", 0);

        if(year > 5){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Oops!");
            builder.setMessage("It looks like your child's age is out side the scope of this app. Please Try again!");
            builder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    startMenu();
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }
        else if (year > 4) {
            loadPage(8);
        }
        else if(year > 3) {
            loadPage(7);
        }
        else if(year > 2) {
            loadPage(6);
        }
        else if(year > 1 || (year == 1 && months > 6)) {
            loadPage(5);
        }
        else if(year == 1 && months >= 0) {
            loadPage(4);
        }
        else if(year == 0 && months > 9) {
            loadPage(3);
        }
        else if(year <= 0 && months > 6) {
            loadPage(2);
        }
        else if(year <= 0 && months > 3){
            loadPage(1);
        }
        else{
            loadPage(0);
        }


    }

    private void loadPage(int choice){
        currentPage = headers.getPage(choice);
        String[] milestone = this.milestone.getMilestone(choice);
        String[] caution = this.milestone.getCaution(choice);

        Drawable drawable = getResources().getDrawable(currentPage.getImageId());
        imageView.setImageDrawable(drawable);

        String pageSub1 = currentPage.getSubHeader1();
        String pageSub2 = currentPage.getSubHeader2();
        String pageHeader = currentPage.getHeader();
        String pageProgress = currentPage.getProgress();
        //Add name if placeholder is included
        pageSub1 = String.format(pageSub1);
        headerTextView.setText(pageHeader);
        milestoneHeaderTextView.setText(pageSub1);
        progressTextView.setText(pageProgress);
        cautionHeaderTextView.setText(pageSub2);

        StringBuilder builder = new StringBuilder();
        for (String s : milestone) {
            builder.append("\n" + s + "\n");
            milestoneTextView.setText(builder.toString());
        }

        StringBuilder builder2 = new StringBuilder();
        for (String s : caution) {
            builder2.append("\n" + s + "\n");
            cautionTextView.setText(builder2.toString());
        }
    }

    private void startMenu() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
