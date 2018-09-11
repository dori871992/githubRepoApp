package com.dorianmusaj.repo.ui.repo;

import com.dorianmusaj.repo.model.GithubRepository;
import com.dorianmusaj.repo.model.RepositoryDetails;
import com.dorianmusaj.repo.ui.basic.MvpBasicView;

public interface MvpRepoView extends MvpBasicView {

    void showRepoDetails(RepositoryDetails repository);
}
