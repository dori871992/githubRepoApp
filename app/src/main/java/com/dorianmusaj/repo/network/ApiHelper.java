package com.dorianmusaj.repo.network;

import com.dorianmusaj.repo.model.GithubRepository;
import com.dorianmusaj.repo.model.RepositoryDetails;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiHelper {

    @GET("repositories/{id}")
    Observable<RepositoryDetails> getGithubRepository(@Path("id") int id);


    @GET("repositories?since=364")
    Observable<List<GithubRepository>> getGithubRepositories();
}
