package com.dorianmusaj.repo.ui.main;

import com.dorianmusaj.repo.model.GithubRepository;
import com.dorianmusaj.repo.ui.basic.MvpBasicView;

import java.util.List;

public interface MvpMainView extends MvpBasicView {

    void showRepoList(List<GithubRepository> repos);
}
