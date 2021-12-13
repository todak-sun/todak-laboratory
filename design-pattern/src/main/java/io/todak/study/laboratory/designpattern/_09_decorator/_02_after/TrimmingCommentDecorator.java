package io.todak.study.laboratory.designpattern._09_decorator._02_after;

class TrimmingCommentDecorator extends CommentDecorator {

    public TrimmingCommentDecorator(CommentService commentService) {
        super(commentService);
    }

    @Override
    public void addComment(String comment) {
        System.out.println(this.getClass());
        super.addComment(trim(comment));
    }

    private String trim(String comment) {
        return comment.replace("...", "");
    }

}
