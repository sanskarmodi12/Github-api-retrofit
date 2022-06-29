package com.example.githubrepos;

import java.io.Serializable;

public class Model implements Serializable {
    String name;
    String watchers;
    String forks;
    String created_at;
    String visibility;
    String updated_at;

    public String getName() {
        return name;
    }

    public String getWatchers() {
        return watchers;
    }

    public String getForks() {
        return forks;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getVisibility() {
        return visibility;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public String getLanguage() {
        return language;
    }

    String language;


    public Model(String name, String watchers, String forks, String created_at, String visibility, String updated_at, String language) {
        this.name = name;
        this.watchers = watchers;
        this.forks = forks;
        this.created_at = created_at;
        this.visibility = visibility;
        this.updated_at = updated_at;
        this.language = language;
    }
}
