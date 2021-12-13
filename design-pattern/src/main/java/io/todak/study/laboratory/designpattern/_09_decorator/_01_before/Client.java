package io.todak.study.laboratory.designpattern._09_decorator._01_before;

class Client {

    private CommentService commentService;

    private boolean enabledSpamFilter;
    private boolean enabledTrimming;

    public Client(CommentService commentService) {
        this.commentService = commentService;
    }

    private void writeComment(String comment) {
        commentService.addComment(comment);
    }

    public static void main(String[] args) {
//        new TrimmingCommentService();
        Client client = new Client(new SpamFilteringCommentService());
        client.writeComment("오징어 게임");
        client.writeComment("보는게 하는거 보다 재밌을 수가 없지...");
        client.writeComment("http://wow.wow.com");
        client.writeComment("...에휴...");

    }

}
