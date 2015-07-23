package com.willkamp.sampleactvitytasks;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = (TextView) findViewById(R.id.text_view);
        tv.setText(getString(R.string.title_activity_main) + System.identityHashCode(this));

        findViewById(R.id.task_activity_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TaskActivity.start(getApplicationContext());
            }
        });

        findViewById(R.id.persist_activity_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PersistActivity.start(MainActivity.this);
            }
        });
    }
}
