package io.todak.study.laboratory.designpattern._09_decorator._02_after;

class SpamFilteringCommentDecorator extends CommentDecorator {

    public SpamFilteringCommentDecorator(CommentService commentService) {
        super(commentService);
    }

    @Override
    public void addComment(String comment) {
        System.out.println(this.getClass());
        if (isNotSpam(comment)) {
            super.addComment(comment);
        }
    }

    private boolean isNotSpam(String comment) {
        return !comment.contains("http:");
    }

}
