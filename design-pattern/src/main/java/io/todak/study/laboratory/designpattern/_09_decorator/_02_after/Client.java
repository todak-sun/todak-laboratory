package io.todak.study.laboratory.designpattern._09_decorator._02_after;

class Client {

    private CommentService commentService;

    public Client(CommentService commentService) {
        this.commentService = commentService;
    }

    public void writeComment(String comment) {
        commentService.addComment(comment);
    }


}
