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
import android.view.View;
import android.widget.PopupMenu;
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
    private List<DateInfo> searchList = new ArrayList<>();
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
        MenuItem searchItem = menu.findItem(R.id.search);
        searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchItem.setOnActionExpandListener(new MenuItem.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                rv = (RecyclerView) findViewById(R.id.recyclerView);
                rv.setHasFixedSize(true);
                llm = new LinearLayoutManager(getBaseContext());
                llm.setOrientation(LinearLayoutManager.VERTICAL);
                rv.setLayoutManager(llm);
                ra = new RecyclerAdapter();
                rv.setAdapter(ra);
                return true;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search:
                search();
                return true;
            case R.id.filter:
                View menuItemView = findViewById(R.id.filter);
                filter(menuItemView);
                return true;
            case R.id.settings:
                //settings();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void filter(View menuItemView) {
        PopupMenu popupMenu = new PopupMenu(this, menuItemView);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
        popupMenu.show();
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                //Toast.makeText(getBaseContext(), "You clicked " + item.getTitle(), Toast.LENGTH_LONG).show();
                if (item.getTitle().toString().matches("Low to High Stars")) {
                    oldList = new ArrayList<>((DateApp.getInstance().getDates()));
                    newList.clear();
                    for (int r = 1; r <= 5; r++) {
                        for (int i = 0; i < oldList.size(); i++) {
                            if (oldList.get(i).getRating() == r) {
                                newList.add(oldList.get(i));
                            }
                        }
                    }
                    rv = (RecyclerView) findViewById(R.id.recyclerView);
                    rv.setHasFixedSize(true);
                    llm = new LinearLayoutManager(getBaseContext());
                    llm.setOrientation(LinearLayoutManager.VERTICAL);
                    rv.setLayoutManager(llm);
                    ra = new RecyclerAdapter(newList);
                    DateApp.getInstance().setDates(newList);
                    rv.setAdapter(ra);
                    return true;
                }

                if (item.getTitle().toString().matches("High to Low Stars")) {
                    oldList = new ArrayList<>((DateApp.getInstance().getDates()));
                    newList.clear();
                    for (int r = 5; r > 0; r--) {
                        for (int i = 0; i < oldList.size(); i++) {
                            if (oldList.get(i).getRating() == r) {
                                newList.add(oldList.get(i));
                            }
                        }
                    }
                    rv = (RecyclerView) findViewById(R.id.recyclerView);
                    rv.setHasFixedSize(true);
                    llm = new LinearLayoutManager(getBaseContext());
                    llm.setOrientation(LinearLayoutManager.VERTICAL);
                    rv.setLayoutManager(llm);
                    ra = new RecyclerAdapter(newList);
                    DateApp.getInstance().setDates(newList);
                    rv.setAdapter(ra);
                    return true;
                }

                return true;
            }
        });

    }

    private void search() {
        oldList = new ArrayList<>((DateApp.getInstance().getDates()));
        searchList.clear();
        set.clear();
        searchView.setQueryHint("Find Date Option"); //clicking on any menu item makes da getDates 0??
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                String lowercaseQuery = query.toLowerCase();
                String[] splitedQuery = lowercaseQuery.split("\\s+");
                for (int i = 0; i < oldList.size(); i++) {
                    String name = oldList.get(i).getName().toLowerCase();
                    String[] splitedName = name.split("\\s+");
                    for (int d = 0; d < splitedQuery.length; d++) {
                        String strQuery = splitedQuery[d];
                        int queryLength = strQuery.length();
                        for (int j = 0; j < splitedName.length; j++) {
                            String splitName = splitedName[j];
                            if (queryLength > splitName.length()) {
                                continue;
                            } else {
                                String substringSplitName = splitName.substring(0, queryLength);
                                if (substringSplitName.matches(lowercaseQuery)) {
                                    //set.add(oldList.get(i));
                                    int timesSeen = 0;
                                    for (int z = 0; z < searchList.size(); z++) {
                                        if (searchList.get(z).getName().toLowerCase().matches(name)) {
                                            timesSeen++;
                                        }
                                    }
                                    if (timesSeen == 0) {
                                       searchList.add(oldList.get(i));
                                    }
                                }
                            }
                        }
                    }
                }
                //searchList.addAll(set);
                rv = (RecyclerView) findViewById(R.id.recyclerView);
                rv.setHasFixedSize(true);
                llm = new LinearLayoutManager(getBaseContext());
                llm.setOrientation(LinearLayoutManager.VERTICAL);
                rv.setLayoutManager(llm);
                ra = new RecyclerAdapter(searchList);
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
