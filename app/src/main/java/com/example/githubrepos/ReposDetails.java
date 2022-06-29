package com.example.githubrepos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class ReposDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repos_details);
        Intent intent=getIntent();

        Model model= (Model) getIntent().getSerializableExtra("currepo");
      //  Log.i("keys", String.valueOf(model.getName()));
//        Toast.makeText(ReposDetails.this,model.getName(),Toast.LENGTH_SHORT).show();
        TextView name,visibility,watchers,forks,lastupdated,createdon;
        name=findViewById(R.id.tv2name);
        visibility=findViewById(R.id.tv2visi);
        watchers=findViewById(R.id.tv2watchers);
        forks=findViewById(R.id.tv2forks);
        lastupdated=findViewById(R.id.tv2lastupdated);
        createdon=findViewById(R.id.tv2created);
        name.setText(model.getName());
        visibility.setText(model.getVisibility());
        watchers.setText(model.getWatchers());
        forks.setText(model.getForks());
        lastupdated.setText(model.getUpdated_at());
        createdon.setText(model.getCreated_at());




    }
}