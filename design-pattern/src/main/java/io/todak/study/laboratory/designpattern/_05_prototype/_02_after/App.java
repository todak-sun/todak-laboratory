package io.todak.study.laboratory.designpattern._05_prototype._02_after;

public class App {

    public static void main(String[] args) throws CloneNotSupportedException {
        GithubRepository repository = new GithubRepository();
        repository.setUser("todak-sun");
        repository.setName("todak-laboratory");

        GithubIssue githubIssue = new GithubIssue(repository);
        githubIssue.setId(1);
        githubIssue.setTitle("뭐지?");

        String url = githubIssue.getUrl();
        System.out.println("url : " + url);

        GithubIssue clone = (GithubIssue) githubIssue.clone();
        System.out.println(clone.getUrl());

        System.out.println(githubIssue != clone);
        System.out.println(githubIssue.equals(clone));
        System.out.println(githubIssue.getClass() == clone.getClass());
    }

}
