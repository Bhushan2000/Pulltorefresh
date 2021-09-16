package com.example.pulltorefresh;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.AdapterViewHolder> {

    private List<Integer> integerList;

    public Adapter(List<Integer> integerList) {
        this.integerList = integerList;
    }

    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout,parent,false);

        return new AdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder holder, int position) {
        holder.tvNumber.setText(integerList.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return integerList.size();
    }

    class AdapterViewHolder extends RecyclerView.ViewHolder{
        TextView tvNumber;

        public AdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNumber = itemView.findViewById(R.id.tvNumber);

        }
    }
}
