package com.dorianmusaj.repo.ui.main;

import com.dorianmusaj.repo.model.GithubRepository;

import java.util.List;

public interface MvpMainView {

    void showRepoList(List<GithubRepository> repos);
}
