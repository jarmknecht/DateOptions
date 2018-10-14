package com.example.jonathan.dateoptions;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ActionMenuView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    DateApp dA;
    private LinearLayoutManager llm;
    private RecyclerView rv;
    private RecyclerAdapter ra;
    private SearchView searchView;
    private List<DateInfo> oldList;
    private List<DateInfo> newList = new ArrayList<>();
    private Set<DateInfo> set = new HashSet<>();

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
        searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search:
                search();
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

    private void search() {
        oldList = ra.getDates();
        searchView.setQueryHint("\"Look for whole word\"");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(getBaseContext(), query, Toast.LENGTH_LONG).show();
                String lowercaseQuery = query.toLowerCase();
                if (lowercaseQuery.charAt(0) == '"') {
                    String substring = lowercaseQuery.substring(1, lowercaseQuery.length() - 1);
                    for (int i = 0; i < oldList.size(); i++) {
                        if (oldList.get(i).getName().toLowerCase().matches(substring)) {
                           newList.add(oldList.get(i));
                        }
                    }
                }
                else {
                    for (int i = 0; i < lowercaseQuery.length(); i++) {
                        char c = lowercaseQuery.charAt(i);
                        for (int j = 0; j < oldList.size(); j++) {
                            for (int z = 0; z < oldList.get(j).getName().length(); z++) {
                                String name = oldList.get(j).getName().toLowerCase();
                                char d = name.charAt(z);
                                if (c == d) {
                                    set.add(oldList.get(j));
                                }
                            }
                        }
                    }
                    newList.addAll(set);
                }
                rv = (RecyclerView) findViewById(R.id.recyclerView);
                rv.setHasFixedSize(true);
                llm = new LinearLayoutManager(getBaseContext());
                llm.setOrientation(LinearLayoutManager.VERTICAL);
                rv.setLayoutManager(llm);
                ra = new RecyclerAdapter(newList);
                rv.setAdapter(ra);
                searchView.clearFocus();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    public void HandleClick(DateInfo date) {
        Log.i("Handle click", "main activity");
        Intent mapIntent = new Intent(this, MapsActivity.class);
        mapIntent.putExtra("serialize_data", date);
        startActivity(mapIntent);
    }

}
