package com.example.android.reportcard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ReportCard rc = new ReportCard(1, 2016);
        System.out.println(rc);
        rc.addGrade(101, "Android", "Incomplete");
        rc.addGrade(202, "Android Advanced", "Incomplete");
        rc.addGrade(110, "Making classes", "A");
        rc.removeGrade(202);
        System.out.println(rc);
    }
}
