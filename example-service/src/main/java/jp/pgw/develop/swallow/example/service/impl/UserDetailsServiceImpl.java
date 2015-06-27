package jp.pgw.develop.swallow.example.service.impl;

import jp.pgw.develop.swallow.example.model.domain.User;
import jp.pgw.develop.swallow.example.model.domain.UserContext;
import jp.pgw.develop.swallow.example.persistence.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by kazamage on 2015/06/28.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Inject
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("The requested user is not found.");
        }
        return new UserContext(user);
    }

}
