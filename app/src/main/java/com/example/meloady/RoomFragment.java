package com.example.meloady;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jean.jcplayer.JcPlayerManagerListener;
import com.example.jean.jcplayer.general.JcStatus;
import com.example.jean.jcplayer.general.errors.OnInvalidPathListener;
import com.example.jean.jcplayer.model.JcAudio;
import com.example.jean.jcplayer.view.JcPlayerView;
import com.google.android.material.datepicker.SingleDateSelector;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Source;



import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RoomFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RoomFragment extends Fragment implements  IOnBackPressed, JcPlayerManagerListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ROOM_NAME = "param1";
//    private static final String ROOM_ID = "param2";
    //private Song CURRENT_SONG
    public ArrayList<Song> roomPlaylist= new ArrayList<>();

    public FirebaseFirestore db;

    // TODO: Rename and change types of parameters
    private String roomNameRecuperado;
    private String roomIdRecuperado;
    private Song songPlaying;


    public RoomFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment RoomFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RoomFragment newInstance(String param1) {
        RoomFragment fragment = new RoomFragment();
        Bundle args = new Bundle();
        args.putString(ROOM_NAME, param1);
//        args.putString(ROOM_ID, param2);
        fragment.setArguments(args);
        return fragment;
    }

//    public static RoomFragment newInstance(String roomname,String username) {
//        GuideDetailFragment fragment = new GuideDetailFragment();
//        Bundle args = new Bundle();
//        args.putInt(ICONO,icono);
//        args.putString(NAME,nombre);
//        args.putString(CITY,city);
//        args.putString(PRICE,price);
//        args.putString(DESC,desc);
//        args.putSerializable(IMAGENES,imagenes);
//
//
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_room,container,false);
        TextView roomName= view.findViewById(R.id.roomNameDetail);
        TextView roomId = view.findViewById(R.id.roomIdDetail);
        JcPlayerView jcplayerView = (JcPlayerView) view.findViewById(R.id.jcplayer);

        ArrayList<JcAudio> jcAudios = new ArrayList<>();
        jcAudios.add(JcAudio.createFromURL("url audio","https://firebasestorage.googleapis.com/v0/b/meloady-1dde4.appspot.com/o/Audios%2F1234.mp3?alt=media&token=e002ef77-687b-4786-9686-d6cb56ae35de"));
        jcAudios.add(JcAudio.createFromURL("url audio2","https://firebasestorage.googleapis.com/v0/b/meloady-1dde4.appspot.com/o/Audios%2F123.mp3?alt=media&token=020a1325-f52c-4316-ace4-2057b3b10f83"));
        jcAudios.add(JcAudio.createFromURL("url audio3","https://firebasestorage.googleapis.com/v0/b/meloady-1dde4.appspot.com/o/Audios%2Fmanolo.mp3?alt=media&token=0e55525a-db38-4d87-b808-c31640e63b75"));
//        jcAudios.add(JcAudio.createFromAssets("Asset audio", "audio.mp3"));
//        jcAudios.add(JcAudio.createFromRaw("Raw audio", R.raw.audio));
        jcplayerView.initPlaylist(jcAudios, null);
        jcplayerView.initAnonPlaylist(jcAudios);

        jcplayerView.createNotification(); // default icon
        jcplayerView.setJcPlayerManagerListener(this);
        db = FirebaseFirestore.getInstance();

//        db.collection("users").document().get(Source.valueOf("2oY8ZNLxXdQy7NUvMyO5")).addOnSuccessListener(v ->{
//           roomId.setText(v.);
//        });
        if(getArguments() !=null){
            roomNameRecuperado = getArguments().getString(ROOM_NAME);
//            roomIdRecuperado = getArguments().getString(ROOM_ID);
//            songPlaying = getArguments().getBundle()

            roomName.setText(roomNameRecuperado);


            roomId.setText(roomIdRecuperado);
        }

        return view;
    }

    private void getSongsInList(){

    }

    @Override
    public boolean onBackPressed() {
        toRoomsFragment();
        return true;
    }

    public void toRoomsFragment(){
        Fragment fragment = new RoomsFragment();
        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onCompletedAudio() {

    }

    @Override
    public void onContinueAudio(JcStatus jcStatus) {

    }

    @Override
    public void onJcpError(Throwable throwable) {

    }

    @Override
    public void onPaused(JcStatus jcStatus) {
        super.onPause();
        Log.i("TTT FUNCIONA", "PAUSADO");
    }

    @Override
    public void onPlaying(JcStatus jcStatus) {

    }

    @Override
    public void onPreparedAudio(JcStatus jcStatus) {
        Log.i("Working", "Se acabo");
    }

    @Override
    public void onStopped( @NonNull JcStatus jcStatus) {

    }

    @Override
    public void onTimeChanged(@NonNull JcStatus jcStatus) {
        Log.i("No funciona", String.valueOf(jcStatus.getCurrentPosition()/1000));
    }

    private static void updateProgress(JcStatus jcStatus, float progress) {
    }

}