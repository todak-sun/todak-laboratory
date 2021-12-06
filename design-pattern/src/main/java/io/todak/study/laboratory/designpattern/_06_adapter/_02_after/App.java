package io.todak.study.laboratory.designpattern._06_adapter._02_after;

import io.todak.study.laboratory.designpattern._06_adapter._02_after.security.LoginHandler;
import io.todak.study.laboratory.designpattern._06_adapter._02_after.security.UserDetailsService;

public class App {

    public static void main(String[] args) {
        AccountService accountService = new AccountService();
        UserDetailsService userDetailsService = new AccountUserDetailsService(accountService);
        LoginHandler loginHandler = new LoginHandler(userDetailsService);

        String login = loginHandler.login("todak", "todak");
        System.out.println(login);
    }

}
