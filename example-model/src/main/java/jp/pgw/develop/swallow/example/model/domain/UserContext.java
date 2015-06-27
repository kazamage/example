package jp.pgw.develop.swallow.example.model.domain;

import org.springframework.security.core.authority.AuthorityUtils;

/**
 * Created by kazamage on 2015/06/28.
 */
public class UserContext extends org.springframework.security.core.userdetails.User {

    private final User user;

    public UserContext(User user) {
        super(user.getUsername(), user.getEncodedPassword(), AuthorityUtils.createAuthorityList("ROLE_USER"));
        this.user = user;
    }

}
