package io.todak.study.laboratory.designpattern._05_prototype._01_before;

class App {

    public static void main(String[] args) {
        GithubRepository repository = new GithubRepository();
        repository.setUser("todak-sun");
        repository.setName("todak-laboratory");

        GithubIssue githubIssue = new GithubIssue(repository);
        githubIssue.setId(1);
        githubIssue.setTitle("뭐지?");

        String url = githubIssue.getUrl();
        System.out.println("url : " + url);
    }

}
