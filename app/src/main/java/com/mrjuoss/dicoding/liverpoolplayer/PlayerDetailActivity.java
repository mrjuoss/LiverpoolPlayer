package com.mrjuoss.dicoding.liverpoolplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class PlayerDetailActivity extends AppCompatActivity {

    private static final String TAG = "PlayerDetailActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_detail);

        Log.d(TAG, "onCreate: PlayerDetaikActivity dijalankan");
        
        getPlayerIntent();
    }

    private void getPlayerIntent() {
        Log.d(TAG, "getPlayerIntent: checking for incoming intent");
        
        if (getIntent().hasExtra("player_group") 
                && getIntent().hasExtra("player_name") 
                && getIntent().hasExtra("player_number")
                && getIntent().hasExtra("player_photo")
                && getIntent().hasExtra("player_description"))
        {
            String playerGroup = getIntent().getStringExtra("player_group");
            String playerName = getIntent().getStringExtra("player_name");
            String playerNumber = getIntent().getStringExtra("player_number");
            String playerPhoto = getIntent().getStringExtra("player_photo");
            String playerDescription = getIntent().getStringExtra("player_description");
            
            setPlayerContent(playerGroup, playerName, playerNumber, playerPhoto, playerDescription);
        }
    }

    private void setPlayerContent(String playerGroup, String playerName, String playerNumber, String playerPhoto, String playerDescription) {
        Log.d(TAG, "setPlayerContent: Setting");
        TextView group = findViewById(R.id.tv_group);
        TextView name = findViewById(R.id.tv_name);
        TextView number  = findViewById(R.id.tv_number);
        ImageView photo = findViewById(R.id.iv_photo);
        TextView description = findViewById(R.id.tv_description);
        
        group.setText(playerGroup);
        name.setText(playerName);
        number.setText(playerNumber);
        Glide.with(this)
                .load(playerPhoto)
                .into(photo);
        description.setText(playerDescription);
        
    }
}
