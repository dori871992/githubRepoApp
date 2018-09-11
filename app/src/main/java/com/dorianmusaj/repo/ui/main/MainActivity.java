package com.dorianmusaj.repo.ui.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.dorianmusaj.repo.R;
import com.dorianmusaj.repo.adapter.RepositoriesAdapter;
import com.dorianmusaj.repo.model.GithubRepository;
import com.dorianmusaj.repo.ui.basic.BasicActivity;
import com.dorianmusaj.repo.ui.repo.RepositoryActivity;
import com.dorianmusaj.repo.utils.ItemClickSupport;

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

        ItemClickSupport.addTo(mRecyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                Intent repoActivity = new Intent(MainActivity.this, RepositoryActivity.class);
                repoActivity.putExtra("repoId",mRepositoriesAdapter.getItemAtPosition(position).getId());
                startActivity(repoActivity);
            }
        });

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
