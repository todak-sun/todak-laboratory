package io.todak.study.laboratory.designpattern._09_decorator._01_before;

class TrimmingCommentService extends CommentService {

    @Override
    public void addComment(String comment) {
        super.addComment(this.trim(comment));
    }

    private String trim(String comment) {
        return comment.replace("...", "");
    }
}
