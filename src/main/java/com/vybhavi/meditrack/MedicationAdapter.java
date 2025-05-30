package com.vybhavi.meditrack;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MedicationAdapter extends RecyclerView.Adapter<MedicationAdapter.MedicationViewHolder> {

    private List<Medication> list;

    public void setList(List<Medication> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MedicationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_medication_card, parent, false);
        return new MedicationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MedicationViewHolder holder, int position) {
        Medication med = list.get(position);
        holder.name.setText(med.getName());
        holder.info.setText(
                holder.itemView.getContext().getString(R.string.medication_info, med.getDosage(), med.getTime())
        );

    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public static class MedicationViewHolder extends RecyclerView.ViewHolder {
        TextView name, info;

        MedicationViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tvName);
            info = itemView.findViewById(R.id.tvInfo);

        }
    }
}
