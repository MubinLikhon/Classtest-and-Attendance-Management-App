package assistant.genuinecoder.s_assistant.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.GridView;

import java.util.ArrayList;

import assistant.genuinecoder.s_assistant.R;
import assistant.genuinecoder.s_assistant.main.components.About;
import assistant.genuinecoder.s_assistant.main.components.GridAdapter;
import assistant.genuinecoder.s_assistant.main.components.SettingsActivity;
import assistant.genuinecoder.s_assistant.main.database.DatabaseHandler;

public class AppBase extends AppCompatActivity {

    public static ArrayList<String> divisions;
    public static DatabaseHandler handler;
    public static Activity activity;
    ArrayList<String> basicFields;
    GridAdapter adapter;
    GridView gridView;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mai_menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_layout);
        basicFields = new ArrayList<>();
        handler = new DatabaseHandler(this);
        activity = this;

        getSupportActionBar().show();
        divisions = new ArrayList<>();

        divisions.add("CSE-433 Software Engineering");
        divisions.add("CSE-343 Artificial Intelligence");
        divisions.add("CSE-243 Object Oriented Programming");
        divisions.add("CSE-143 Structured Programming");
        gridView = (GridView) findViewById(R.id.grid);
        basicFields.add("ATTENDANCE");
        //sicFields.add("SCHEDULER");
        //icFields.add("NOTES");
        basicFields.add("PROFILE");
        basicFields.add("Top CT Calculator");
        adapter = new GridAdapter(this, basicFields);
        gridView.setAdapter(adapter);
    }

    public void loadSettings(MenuItem item) {
        Intent launchIntent = new Intent(this, SettingsActivity.class);
        startActivity(launchIntent);
    }

    public void loadAbout(MenuItem item) {
        Intent launchIntent = new Intent(this, About.class);
        startActivity(launchIntent);
    }
}
