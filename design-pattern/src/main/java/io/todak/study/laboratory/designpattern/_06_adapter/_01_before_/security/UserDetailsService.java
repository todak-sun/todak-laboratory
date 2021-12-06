package io.todak.study.laboratory.designpattern._06_adapter._01_before_.security;

public interface UserDetailsService {
    UserDetails loadUser(String username);
}
