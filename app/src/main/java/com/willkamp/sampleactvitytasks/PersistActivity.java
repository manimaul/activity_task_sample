package com.willkamp.sampleactvitytasks;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class PersistActivity extends AppCompatActivity {

    public static void start(Activity activity) {
        Intent intent = new Intent(activity, PersistActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persist);

        TextView tv = (TextView) findViewById(R.id.text_view);
        tv.setText(getString(R.string.title_activity_persist) + System.identityHashCode(this));

        findViewById(R.id.task_activity_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TaskActivity.start(getApplicationContext());
            }
        });

        findViewById(R.id.persist_activity_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PersistActivity.start(PersistActivity.this);
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
