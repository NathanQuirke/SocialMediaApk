package com.example.lab2firebase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class Reading extends AppCompatActivity {
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference postbookref = db.collection("Postbook");

    private DetailsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityreading);
        FloatingActionButton buttonAddPost = findViewById(R.id.button_add_post);
        buttonAddPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Reading.this, Post.class));
            }
        });

        setUpRecyclerView();
    }

    private void setUpRecyclerView() {
        Query query = postbookref.limit(5);
        // used this in above line but sorting wasn't returning 5 newest, might need in future
        // .orderBy("title", Query.Direction.ASCENDING).
        FirestoreRecyclerOptions<Details> options = new FirestoreRecyclerOptions.Builder<Details>().setQuery(query, Details.class).build();

        adapter = new DetailsAdapter(options);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
    public void Post(View view) {
        startActivity(new Intent(Reading.this, Post.class));
    }
}