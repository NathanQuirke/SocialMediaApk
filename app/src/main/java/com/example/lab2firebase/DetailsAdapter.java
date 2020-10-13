package com.example.lab2firebase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class DetailsAdapter extends FirestoreRecyclerAdapter<Details, DetailsAdapter.DetailsHolder> {
    public DetailsAdapter(@NonNull FirestoreRecyclerOptions<Details> options) {
        super(options);
    }

    @NonNull
    @Override
    public DetailsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item, parent, false);
        return new DetailsHolder(v);
    }

    @Override
    protected void onBindViewHolder(@NonNull DetailsHolder holder, int position, @NonNull Details model) {
        holder.textViewTitle.setText(model.getTitle());
        holder.textViewDescription.setText(model.getDescription());
    }

    class DetailsHolder extends RecyclerView.ViewHolder {
       TextView textViewTitle;
       TextView textViewDescription;

       public DetailsHolder(View itemView) {
           super(itemView);
           textViewTitle = itemView.findViewById(R.id.text_view_title);
           textViewDescription = itemView.findViewById(R.id.text_view_description);
       }
   }
}


