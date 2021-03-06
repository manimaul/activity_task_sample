package com.willkamp.sampleactvitytasks;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class TaskActivity extends AppCompatActivity {

    public static void start(Context appContext) {
        Intent intent = new Intent(appContext, TaskActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
        appContext.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        TextView tv = (TextView) findViewById(R.id.text_view);
        tv.setText(getString(R.string.title_activity_task) + System.identityHashCode(this));

        findViewById(R.id.task_activity_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TaskActivity.start(getApplicationContext());
            }
        });

        findViewById(R.id.persist_activity_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PersistActivity.start(TaskActivity.this);
            }
        });

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                Intent intent = getParentActivityIntent();
                if (intent != null) {
                    startActivity(intent);
                }
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
