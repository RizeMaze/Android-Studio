package com.example.submission2;


import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {
    private RecyclerView rvMovie;
    private ArrayList<Model> list = new ArrayList<> ();

    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup container ,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate ( R.layout.fragment_movie , container , false );
    }

    @Override
    public void onViewCreated(@NonNull View view , @Nullable Bundle savedInstanceState) {

        super.onViewCreated ( view , savedInstanceState );
        rvMovie = view.findViewById(R.id.rv_movie);
        rvMovie.setHasFixedSize(true);
        list.addAll(getList());
        showRecyclerList();
    }

    public ArrayList<Model> getList() {
        String[] dataName = getResources().getStringArray(R.array.data_judul_movie);
        String[] dataDescription = getResources().getStringArray(R.array.data_description_movie);
        TypedArray dataPhoto = getResources ().obtainTypedArray ( R.array.data_photo_movie );
        ArrayList<Model> listMovie = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Model model = new Model ();
            model.setName(dataName[i]);
            model.setDescription(dataDescription[i]);
            model.setPhoto(dataPhoto.getResourceId ( i,-1 ));
            listMovie.add( model );
        }
        return listMovie;
    }

    private void showRecyclerList(){
        rvMovie.setLayoutManager(new LinearLayoutManager (getContext ()));
        ListAdapter listHeroAdapter = new ListAdapter (list,getContext ());
        rvMovie.setAdapter(listHeroAdapter);
    }
}
