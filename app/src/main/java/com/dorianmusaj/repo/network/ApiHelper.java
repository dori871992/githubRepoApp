package com.dorianmusaj.repo.network;

import com.dorianmusaj.repo.model.GithubRepository;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiHelper {

    @GET("/api/products/getAllMarketProducts")
    Observable<GithubRepository> getGithubRepository(@Query("id") int id);


    @GET("repositories?since=364")
    Observable<List<GithubRepository>> getGithubRepositories();
}
