package com.example.jonathan.dateoptions;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rv = (RecyclerView) findViewById(R.id.recyclerView);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(llm);

        RecyclerAdapter ra = new RecyclerAdapter(createList(5));
        rv.setAdapter(ra);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu, menu);
        return true;
    }

}
