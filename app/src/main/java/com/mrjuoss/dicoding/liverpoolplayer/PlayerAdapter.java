package com.mrjuoss.dicoding.liverpoolplayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder> {
    private Context context;
    private ArrayList<Player> listPlayer;

    public PlayerAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public PlayerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_player, parent, false);
        return new PlayerViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerViewHolder holder, int position) {
        // Add Photo Animation
        holder.civPlayerPhoto.setAnimation(AnimationUtils.loadAnimation(context, R.anim.fade_transition));
        holder.rlContainer.setAnimation(AnimationUtils.loadAnimation(context, R.anim.fade_scale));

        holder.tvGroupPlayer.setText(getListPlayer().get(position).getGroup());
        holder.tvPlayerName.setText(getListPlayer().get(position).getName());
        holder.tvPlayerNumber.setText(getListPlayer().get(position).getNumber());

        Glide.with(context)
                .load(getListPlayer().get(position).getPhoto())
                .apply(new RequestOptions().override(75,75))
                .into(holder.civPlayerPhoto);

        //holder.tvPlayerDescription.setText(getListPlayer().get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return getListPlayer().size() > 0 ? getListPlayer().size() : 1;
    }

    public ArrayList<Player> getListPlayer() {
        return listPlayer;
    }

    public void setListPlayer(ArrayList<Player> listPlayer) {
        this.listPlayer = listPlayer;
    }

    public class PlayerViewHolder extends RecyclerView.ViewHolder {
        TextView tvGroupPlayer;
        TextView tvPlayerName;
        TextView tvPlayerNumber;
        TextView tvPlayerDescription;

        CircleImageView civPlayerPhoto;

        RelativeLayout rlContainer;
        public PlayerViewHolder(@NonNull View itemView) {
            super(itemView);

            tvGroupPlayer = itemView.findViewById(R.id.tv_group_player);
            tvPlayerName = itemView.findViewById(R.id.tv_player_name);
            tvPlayerNumber = itemView.findViewById(R.id.tv_player_number);
            civPlayerPhoto = itemView.findViewById(R.id.civ_player_photo);

            rlContainer = itemView.findViewById(R.id.rl_container);
        }
    }
}
