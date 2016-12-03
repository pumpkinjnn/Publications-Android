package edu.grinnell.grinnell_publications_android.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import edu.grinnell.grinnell_publications_android.Models.Interfaces.UserInterface;
import edu.grinnell.grinnell_publications_android.Models.Realm.RealmPublication;
import edu.grinnell.grinnell_publications_android.R;

/**
 * {@link Fragment} to display users' subscribed publications.
 * @author Larry Boateng Asante
 */
public class PublicationsFragment extends Fragment
        implements UserInterface, SearchView.OnQueryTextListener {

    public static final int DEFAULT_POSITION = 0;

    private RecyclerView mRecyclerView;
    private List<RealmPublication> mPublications;
    private LinearLayoutManager mLayoutManager;

    public PublicationsFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        initializeUI();
        setHasOptionsMenu(true);

        final View view = inflater.inflate(R.layout.fragment_publications, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.publications_rv);
        configureViews();

        return view;
    }

    private void configureViews() {
        mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mLayoutManager);
    }

    @Override
    public void initializeUI() {

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu, menu);

        final MenuItem item = menu.findItem(R.id.menu_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setQueryHint("Search by Title");
        searchView.setOnQueryTextListener(this);
        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                return false;
            }
        });

        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String query) {
        if (query.length() <= 0) {
            //TODO: Set default recyclerview
        }
        //TODO: use recyclerview.adapter to filter by query
        //      apply filtered recyclerview.adapter to recyclerview
        return true;
    }
}