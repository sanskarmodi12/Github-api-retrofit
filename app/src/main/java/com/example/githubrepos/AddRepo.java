package com.example.githubrepos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AddRepo extends AppCompatActivity {
    Button addbt,delbt;
    String url="https://api.github.com/user/";
    String token="token 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";
    String accept="application/vnd.github.v3+json";
    String url2="https://api.github.com/repos/sanskarmodi12/";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_repo);
        addbt=(Button) findViewById(R.id.addbt2);
        delbt=(Button)findViewById(R.id.btdel);
        //btupdate=(Button)findViewById(R.id.btupdate);
        EditText reponame=(EditText)findViewById(R.id.et_reponame);

        addbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(reponame.getText().toString().equals(""))
                {
                    Toast.makeText(AddRepo.this,"Pls enter name ",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Retrofit retrofit=new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();

                    Myapi myapi=retrofit.create(Myapi.class);
                    String name=reponame.getText().toString();
                    //Model model =new Model(name,"0","0","166","public","99","java");
                    Postdata postdata =new Postdata(name);

                    Call<Postdata> call=myapi.addRepos(token,postdata);
                    call.enqueue(new Callback<Postdata>() {
                        @Override
                        public void onResponse(Call<Postdata> call, Response<Postdata> response) {
                            Log.i("data", String.valueOf(response.body()));
                            Toast.makeText(AddRepo.this,"success",Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<Postdata> call, Throwable t) {

                        }
                    });


                }

            }
        });

        delbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(reponame.getText().toString().equals(""))
                {
                    Toast.makeText(AddRepo.this,"Pls enter name ",Toast.LENGTH_SHORT).show();
                }
                else {
                    Retrofit retrofit = new Retrofit.Builder().baseUrl(url2).addConverterFactory(GsonConverterFactory.create()).build();

                    Myapi myapi = retrofit.create(Myapi.class);
                    String name = reponame.getText().toString();
                    //Model model =new Model(name,"0","0","166","public","99","java");
//                    Postdata postdata = new Postdata(name);

                    Call<Void> call = myapi.removeRepo(name,token);
                    call.enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {
                            Toast.makeText(AddRepo.this,"success",Toast.LENGTH_SHORT).show();


                        }

                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {

                        }
                    });


                }

            }
        });

//        btupdate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(reponame.getText().toString().equals(""))
//                {
//                    Toast.makeText(AddRepo.this,"Pls enter name ",Toast.LENGTH_SHORT).show();
//                }
//                else {
//                    Retrofit retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
//
//                    Myapi myapi = retrofit.create(Myapi.class);
//                    String name = reponame.getText().toString();
//                    //Model model =new Model(name,"0","0","166","public","99","java");
//                    Postdata postdata = new Postdata("demoupdate");
//                    Call<Postdata> call=myapi.updateRepo(name,token,postdata);
//                    call.enqueue(new Callback<Postdata>() {
//                        @Override
//                        public void onResponse(Call<Postdata> call, Response<Postdata> response) {
//                            Toast.makeText(AddRepo.this,"success",Toast.LENGTH_SHORT).show();
//                        }
//
//                        @Override
//                        public void onFailure(Call<Postdata> call, Throwable t) {
//
//                        }
//                    });
//
//
//                }
//
//            }
//        });




    }
}