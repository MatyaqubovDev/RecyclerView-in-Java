package dev.matyaqubov.recyclerviewnetworkingwithasynchttp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import dev.matyaqubov.recyclerviewnetworkingwithasynchttp.R;
import dev.matyaqubov.recyclerviewnetworkingwithasynchttp.model.Player;

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<Player> players;

    public MainAdapter(Context context, List<Player> players) {
        this.context = context;
        this.players = players;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_player, parent, false);
        return new PlayerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof PlayerViewHolder){
            Player player =players.get(position);

            ((PlayerViewHolder) holder).textViewName.setText(player.getName());
            ((PlayerViewHolder) holder).textViewLocation.setText(player.getCity() + " , " + player.getCountry());

            Glide.with(context).load(player.getImgURL()).into(((PlayerViewHolder) holder).imageViewProfile);
        }
    }

    @Override
    public int getItemCount() {
        return players.size();
    }


    class PlayerViewHolder extends RecyclerView.ViewHolder {

        public View view;
        private ImageView imageViewProfile;
        private TextView textViewName, textViewLocation;

        public PlayerViewHolder(@NonNull View view) {
            super(view);

            this.view = view;
            this.imageViewProfile=view.findViewById(R.id.img_profile);
            this.textViewName = view.findViewById(R.id.tv_name);
            this.textViewLocation = view.findViewById(R.id.tv_counrty);

        }
    }
}
