package com.dorianmusaj.repo.ui.main;

import android.content.Context;

import com.dorianmusaj.repo.R;
import com.dorianmusaj.repo.model.GithubRepository;
import com.dorianmusaj.repo.network.ApiHelper;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class MainPresenter implements MvpMainPresenter {

    private MvpMainView mainView;
    private Context context;
    private ApiHelper apiHelper;

    //I should have used DI here with dagger 2 but avoided it so I could finish assignment faster
    public MainPresenter(Context context, MvpMainView view){
        this.mainView = view;
        this.context=context;

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        apiHelper=retrofit.create(ApiHelper.class);

    }

    @Override
    public void getRepositories() {

        mainView.loadingStarted();

        apiHelper.getGithubRepositories()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<GithubRepository>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<GithubRepository> list) {

                        mainView.showRepoList(list);
                    }

                    @Override
                    public void onError(Throwable e) {

                        mainView.loadingFinished(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                        mainView.loadingFinished(null);
                    }
                });

    }
}
