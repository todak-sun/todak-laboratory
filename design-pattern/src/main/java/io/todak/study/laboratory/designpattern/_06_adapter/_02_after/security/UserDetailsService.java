package io.todak.study.laboratory.designpattern._06_adapter._02_after.security;

public interface UserDetailsService {
    UserDetails loadUser(String username);
}
