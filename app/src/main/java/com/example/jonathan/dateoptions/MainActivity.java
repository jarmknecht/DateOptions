package com.example.jonathan.dateoptions;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    DateApp dA;
    private LinearLayoutManager llm;
    private RecyclerView rv;
    private RecyclerAdapter ra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            rv = (RecyclerView) findViewById(R.id.recyclerView);
            rv.setHasFixedSize(true);
            llm = new LinearLayoutManager(this);
            llm.setOrientation(LinearLayoutManager.VERTICAL);
            rv.setLayoutManager(llm);
            dA.getInstance().initializeData();
            ra = new RecyclerAdapter();
            rv.setAdapter(ra);
        }
        else {
            rv = (RecyclerView) findViewById(R.id.recyclerView);
            rv.setHasFixedSize(true);
            llm = new LinearLayoutManager(this);
            llm.setOrientation(LinearLayoutManager.VERTICAL);
            rv.setLayoutManager(llm);
            ra = new RecyclerAdapter();
            rv.setAdapter(ra);
        }
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        if (rv != null) {
            Parcelable listState = rv.getLayoutManager().onSaveInstanceState();
            outState.putParcelable("parcel", listState);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search:
                //search();
                return true;
            case R.id.filter:
                //filter();
                return true;
            case R.id.settings:
                //settings();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void HandleClick(DateInfo date) {
        Log.i("Handle click", "main activity");
        Intent mapIntent = new Intent(this, MapsActivity.class);
        mapIntent.putExtra("serialize_data", date);
        startActivity(mapIntent);
    }

}
