package com.dorianmusaj.repo.ui.repo;

import android.content.Context;

import com.dorianmusaj.repo.model.GithubRepository;
import com.dorianmusaj.repo.model.RepositoryDetails;
import com.dorianmusaj.repo.network.ApiHelper;
import com.dorianmusaj.repo.ui.basic.BasicPresenter;
import com.dorianmusaj.repo.ui.main.MvpMainView;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RepoPresenter implements  MvpRepoPresenter {

    private MvpRepoView repoView;
    private Context context;
    private ApiHelper apiHelper;

    public RepoPresenter (Context context, MvpRepoView view)
    {
        this.repoView = view;
        this.context=context;

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        apiHelper=retrofit.create(ApiHelper.class);
    }


    @Override
    public void getRepoDetails(int id) {
        repoView.loadingStarted();
        apiHelper.getGithubRepository(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RepositoryDetails>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RepositoryDetails item) {

                        repoView.showRepoDetails(item);
                    }

                    @Override
                    public void onError(Throwable e) {

                        repoView.loadingFinished(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                        repoView.loadingFinished(null);
                    }
                });
    }
}
