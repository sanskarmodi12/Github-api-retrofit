package com.example.githubrepos;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.viewHolder>{
    List<Model> list;
    Context context;

    public Adapter(List<Model> list) {
        this.list = list;
        Log.i("checksiz", String.valueOf(list.size()));
//        this.context = context;
    }

    @NonNull
    @Override
    public Adapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        View view=  LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.viewHolder holder, int position) {
        Model model=list.get(position);

        holder.tvlanguage.setText(model.getLanguage());
        holder.tvname.setText(model.getName());
        holder.tvcreated.setText(model.getCreated_at());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,ReposDetails.class);
                intent.putExtra("currepo",model);

                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        private TextView tvlanguage,tvname,tvcreated;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

           tvcreated= itemView.findViewById(R.id.tvcreated);
           tvlanguage=itemView.findViewById(R.id.tvlanguage);
           tvname=itemView.findViewById(R.id.tvname);

        }
    }
}
