package com.dorianmusaj.repo.ui.main;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.dorianmusaj.repo.R;
import com.dorianmusaj.repo.adapter.RepositoriesAdapter;
import com.dorianmusaj.repo.model.GithubRepository;
import com.dorianmusaj.repo.ui.basic.BasicActivity;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends BasicActivity implements  MvpMainView {

    private RepositoriesAdapter mRepositoriesAdapter;
    private Unbinder mUnBinder;
    private MainPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUnBinder=ButterKnife.bind(this);
        presenter=new MainPresenter(this, this);


        mRepositoriesAdapter=new RepositoriesAdapter(this);

        RecyclerView mRecyclerView=findViewById(R.id.repos_lv);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mRepositoriesAdapter);

        presenter.getRepositories();

    }

    @Override
    public void showRepoList(List<GithubRepository> repos) {

        mRepositoriesAdapter.setData(repos);
    }


    @Override
    protected void onDestroy() {
        if (mUnBinder != null) {
            mUnBinder.unbind();
        }
        super.onDestroy();
    }
}
