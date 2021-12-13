package io.todak.study.laboratory.designpattern._09_decorator._02_after;

class CommentDecorator implements CommentService {

    private CommentService commentService;

    public CommentDecorator(CommentService commentService) {
        this.commentService = commentService;
    }

    @Override
    public void addComment(String comment) {
        this.commentService.addComment(comment);
    }
}
