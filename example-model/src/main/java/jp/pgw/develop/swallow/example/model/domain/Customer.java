package jp.pgw.develop.swallow.example.model.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by kazamage on 2015/06/28.
 */
@Entity
@Table(name = "customers")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_customers")
    @SequenceGenerator(name = "seq_customers", sequenceName = "seq_customers")
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name", nullable = false, length = 127)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 127)
    private String lastName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
        final Customer customer = (Customer) o;
        return Objects.equals(id, customer.id);
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
