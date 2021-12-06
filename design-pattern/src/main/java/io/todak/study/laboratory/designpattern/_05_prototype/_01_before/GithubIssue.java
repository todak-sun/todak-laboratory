package io.todak.study.laboratory.designpattern._05_prototype._01_before;

public class GithubIssue {

    private int id;
    private String title;

    private GithubRepository repository;

    public GithubIssue(GithubRepository repository) {
        this.repository = repository;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return String.join("/", "https://github.com", this.repository.getUser(), this.repository.getName(), "issue", this.id + "");
    }
}
