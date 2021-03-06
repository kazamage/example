package jp.pgw.develop.swallow.example.persistence.repository;

import jp.pgw.develop.swallow.example.model.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by kazamage on 2015/06/28.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
