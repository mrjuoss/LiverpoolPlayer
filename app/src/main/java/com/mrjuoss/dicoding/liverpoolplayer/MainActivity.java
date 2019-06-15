package com.mrjuoss.dicoding.liverpoolplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvPlayer;
    private ArrayList<Player> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvPlayer = findViewById(R.id.rv_player);
        rvPlayer.setHasFixedSize(true);
        
        list.addAll(PlayerData.getListData());
        showRecycleView();
    }

    private void showRecycleView() {
        rvPlayer.setLayoutManager(new LinearLayoutManager(this));
        PlayerAdapter playerAdapter = new PlayerAdapter(this);
        playerAdapter.setListPlayer(list);
        rvPlayer.setAdapter(playerAdapter);
    }
}
