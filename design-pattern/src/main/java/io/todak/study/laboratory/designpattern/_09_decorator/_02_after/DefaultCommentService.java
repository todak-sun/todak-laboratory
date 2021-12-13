package io.todak.study.laboratory.designpattern._09_decorator._02_after;

class DefaultCommentService implements CommentService {

    @Override
    public void addComment(String comment) {
        System.out.println(comment);
    }
}
