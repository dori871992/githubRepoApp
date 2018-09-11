package com.dorianmusaj.repo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubRepository {

    @JsonIgnoreProperties(ignoreUnknown = true)
    public class Owner {

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
    }

    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("owner")
    private Owner owner;

    @JsonProperty("description")
    private String description;

    public GithubRepository() {
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


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
