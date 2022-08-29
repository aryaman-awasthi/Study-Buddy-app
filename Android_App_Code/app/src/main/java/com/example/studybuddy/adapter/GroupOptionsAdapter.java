package com.example.studybuddy.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studybuddy.R;

import java.util.HashMap;
import java.util.List;

public class GroupOptionsAdapter extends RecyclerView.Adapter<GroupOptionsAdapter.myViewHolder>{
    List<String> options;
    List<Integer> icons;
    HashMap<Integer, Integer> sub;

    public GroupOptionsAdapter(List<String> options, List<Integer> icons, HashMap<Integer, Integer> sub){
        this.options = options;
        this.icons = icons;
        this.sub = sub;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_group_option, parent, false);
        return new GroupOptionsAdapter.myViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.option.setText(options.get(position));
        holder.icon.setImageResource(icons.get(position));
        if (sub.get(position) != null){
            holder.count.setText(sub.get(position) + "");
        }
        else {
            holder.count.setText("");
        }
        if (position == getItemCount() - 1){
            holder.divider.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return options.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView option, count;
        View divider;
        ImageView icon;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.icon);
            option = itemView.findViewById(R.id.option);
            count = itemView.findViewById(R.id.count);
            divider = itemView.findViewById(R.id.view);
        }
    }
}
