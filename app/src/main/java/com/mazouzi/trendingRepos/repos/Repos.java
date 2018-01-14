package com.mazouzi.trendingRepos.repos;

//A Repository has a name, description, Numbers of stars , username and the avatar of the owner
public class Repos {
    private String repositoryName;
    private String repositoryDescription;
    private String numbersStars;
    private String username;
    private String avatar;

    // Constructors
    public Repos() {
        super();
    }
    public Repos(String repositoryDescription, String numbersStars, String repositoryName, String username, String avatar) {
        this.repositoryDescription = repositoryDescription;
        this.numbersStars = numbersStars;
        this.repositoryName = repositoryName;
        this.username = username;
        this.avatar = avatar;
    }

    // getters and setters
    public String getRepositoryDescription() {
        return repositoryDescription;
    }

    public void setRepositoryDescription(String repositoryDescription) {
        this.repositoryDescription = repositoryDescription;
    }

    public String getNumbersStars() {
        return numbersStars;
    }

    public void setNumbersStars(String numbersStars) {
        this.numbersStars = numbersStars;
    }

    public String getRepositoryName() {
        return repositoryName;
    }

    public void setRepositoryName(String repositoryName) {
        this.repositoryName = repositoryName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
