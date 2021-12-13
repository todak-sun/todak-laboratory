package io.todak.study.laboratory.designpattern._09_decorator._02_after;

class App {

    private static boolean enabledSpamFilter = true;
    private static boolean enabledTrimming = true;

    public static void main(String[] args) {
        CommentService commentService = new DefaultCommentService();

        if (enabledSpamFilter) {
            commentService = new SpamFilteringCommentDecorator(commentService);
        }

        if (enabledTrimming) {
            commentService = new TrimmingCommentDecorator(commentService);
        }

        Client client = new Client(commentService);
        client.writeComment("오징어 게임");
        client.writeComment("보는게 하는거 보다 재밌을 수가 없지...");
        client.writeComment("http://wow.wow.com");
        client.writeComment("...에휴...");

    }


}
