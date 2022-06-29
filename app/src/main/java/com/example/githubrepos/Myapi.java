package com.example.githubrepos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface Myapi {
    @GET("repos")
    Call<List<Model>> getModels();

    @POST("repos")
    Call<Postdata> addRepos(@Header("Authorization") String token,@Body Postdata postdata);

    @DELETE("{reponame}")
    Call<Void> removeRepo(@Path("reponame") String reponame,@Header("Authorization") String token);

    @PUT("{reponame}")
    Call<Postdata> updateRepo(@Path("reponame") String reponame,@Header("Authorization") String token,@Body Postdata postdata);



}
