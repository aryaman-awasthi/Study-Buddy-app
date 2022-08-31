package com.example.studybuddy.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studybuddy.R;
import com.example.studybuddy.model.Module;
import com.example.studybuddy.model.Modules;

import java.util.List;

public class AddModuleAdapter extends RecyclerView.Adapter<AddModuleAdapter.mViewHolder> {
    List<Modules> modules;
    public AddModuleAdapter(List<Modules> modules){
        this.modules = modules;
    }
    @NonNull
    @Override
    public mViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_add_module, parent, false);
        return new AddModuleAdapter.mViewHolder(view);
    }

    @SuppressLint({"DefaultLocale", "SetTextI18n"})
    @Override
    public void onBindViewHolder(@NonNull mViewHolder holder, int position) {
        holder.module.setText(modules.get(position).getName());
        holder.count.setText((position+1)+". ");
        if (position == getItemCount()-1){
            holder.divider.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return modules.size();
    }

    public class mViewHolder extends RecyclerView.ViewHolder {
        TextView module, count;
        View divider;
        public mViewHolder(@NonNull View itemView) {
            super(itemView);
            module = itemView.findViewById(R.id.modules);
            divider = itemView.findViewById(R.id.view);
            count = itemView.findViewById(R.id.count);
        }
    }
}
