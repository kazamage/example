package jp.pgw.develop.swallow.example.model.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by kazamage on 2015/06/28.
 */
@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_users")
    @SequenceGenerator(name = "seq_users", sequenceName = "seq_users")
    @Column(name = "id")
    private Long id;

    @Column(name = "username", nullable = false, length = 127)
    private String username;

    @Column(name = "encoded_password", nullable = false)
    private String encodedPassword;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEncodedPassword() {
        return encodedPassword;
    }

    public void setEncodedPassword(String encodedPassword) {
        this.encodedPassword = encodedPassword;
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final User user = (User) o;
        return Objects.equals(id, user.id);
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
