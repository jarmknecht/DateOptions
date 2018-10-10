package com.example.jonathan.dateoptions;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends AppCompatActivity {

    DateApp dA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rv = (RecyclerView) findViewById(R.id.recyclerView);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(llm);
        dA.getInstance().initializeData();
        RecyclerAdapter ra = new RecyclerAdapter(dA.getInstance().getDates());
        rv.setAdapter(ra);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       // getMenuInflater().inflate(R.menu, menu);
        return true;
    }

    public void HandleClick() {
        Log.i("Handle click", "main activity");
        Intent mapIntent = new Intent(this, MapsActivity.class);
        mapIntent.putExtra("ID", "HEY");
        startActivity(mapIntent); //when a new map activity is made remakes cards like when it is rotated
    }

}
