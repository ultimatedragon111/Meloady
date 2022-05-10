package com.example.meloady;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RoomsFragment#} factory method to
 * create an instance of this fragment.
 */
public class RoomsFragment extends Fragment {

    //    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//
//    public RoomsFragment() {
//        // Required empty public constructor
//    }
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment RoomsFragment.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static RoomsFragment newInstance(String param1, String param2) {
//        RoomsFragment fragment = new RoomsFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_rooms, container, false);
//    }
    private RecyclerView recyclerView;
    private TextView title;
    Fragment fragment;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    List<Room> rooms = new ArrayList<>();
    private FrameLayout roomsFrame;
    BottomNavigationView roomsNav;

    //private RoomFragment roomFragment;
    private UploadSongFragment uploadSongFragment;
    private AddFragment addFragment;
    private CreateRoomFragment createRoomFragment;
    private FirebaseFirestore db;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @androidx.annotation.Nullable ViewGroup container, @androidx.annotation.Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rooms, container, false);
        title = view.findViewById(R.id.RoomsTitle);
        recyclerView = view.findViewById(R.id.RoomsRecycler);
        roomsFrame =(FrameLayout) view.findViewById(R.id.rooms_frame);
        roomsNav = (BottomNavigationView) view.findViewById(R.id.navigation);

        //roomFragment = new RoomFragment();
        uploadSongFragment = new UploadSongFragment();
        addFragment = new AddFragment();
        createRoomFragment = new CreateRoomFragment();



        roomsNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_add:
                        replaceFragment(createRoomFragment);
                        return true;
                    case R.id.nav_upload:
                        replaceFragment(uploadSongFragment);
                        return true;
                    default:
                        return false;
                }
            }
        });


//        Room room1 = new Room("a","test1",true);
//        Room room1 = new Room("a","test1",true);
//        Room room1 = new Room("a","test1",true);
//        Room room1 = new Room("a","test1",true);
        db = FirebaseFirestore.getInstance();
        db.collection("rooms")
                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {

            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    List<Room> roomRetrieve = new ArrayList<>();
                    for (QueryDocumentSnapshot q : task.getResult()){

                        Room tmproom = new Room();
                        tmproom.setId(q.getId());
                        tmproom = q.toObject(Room.class);
                        roomRetrieve.add(tmproom);
                    }
                    RoomsAdapter roomsAdapter = new RoomsAdapter(roomRetrieve, getContext());
                    recyclerView.setAdapter(roomsAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

                }
            }
        });
        return view;
    }

    public void replaceFragment(Fragment fragment) {
//        fragment = new RoomFragment();

        fragmentManager = getParentFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
}