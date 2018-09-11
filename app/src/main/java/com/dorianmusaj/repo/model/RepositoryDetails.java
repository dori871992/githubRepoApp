package com.dorianmusaj.repo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RepositoryDetails {

    @JsonIgnoreProperties(ignoreUnknown = true)
    public class Owner {

        @JsonProperty("login")
        private String login;
        @JsonProperty("avatar_url")
        private String avatar;

        public Owner() {
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;

        }

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }
    }


    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("owner")
    private Owner owner;
    @JsonProperty("description")
    private String description;
    @JsonProperty("url")
    private String url;
    @JsonProperty("forks_url")
    private String forks_url;
    @JsonProperty("teams_url")
    private String teams_url;
    @JsonProperty("branches_url")
    private String branches_url;
    @JsonProperty("tags_url")
    private String tags_url;
    @JsonProperty("subscribers_url")
    private String subscribers_url;
    @JsonProperty("commits_url")
    private String commits_url;
    @JsonProperty("clone_url")
    private String clone_url;
    @JsonProperty("homepage")
    private String homepage;
    @JsonProperty("stargazers_count")
    private int stargazers_count;
    @JsonProperty("watchers_count")
    private int watchers_count;
    @JsonProperty("forks_count")
    private int forks_count;


    public RepositoryDetails() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getForks_url() {
        return forks_url;
    }

    public void setForks_url(String forks_url) {
        this.forks_url = forks_url;
    }

    public String getTeams_url() {
        return teams_url;
    }

    public void setTeams_url(String teams_url) {
        this.teams_url = teams_url;
    }

    public String getBranches_url() {
        return branches_url;
    }

    public void setBranches_url(String branches_url) {
        this.branches_url = branches_url;
    }

    public String getTags_url() {
        return tags_url;
    }

    public void setTags_url(String tags_url) {
        this.tags_url = tags_url;
    }

    public String getSubscribers_url() {
        return subscribers_url;
    }

    public void setSubscribers_url(String subscribers_url) {
        this.subscribers_url = subscribers_url;
    }

    public String getCommits_url() {
        return commits_url;
    }

    public void setCommits_url(String commits_url) {
        this.commits_url = commits_url;
    }

    public String getClone_url() {
        return clone_url;
    }

    public void setClone_url(String clone_url) {
        this.clone_url = clone_url;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public int getStargazers_count() {
        return stargazers_count;
    }

    public void setStargazers_count(int stargazers_count) {
        this.stargazers_count = stargazers_count;
    }

    public int getWatchers_count() {
        return watchers_count;
    }

    public void setWatchers_count(int watchers_count) {
        this.watchers_count = watchers_count;
    }

    public int getForks_count() {
        return forks_count;
    }

    public void setForks_count(int forks_count) {
        this.forks_count = forks_count;
    }
}
