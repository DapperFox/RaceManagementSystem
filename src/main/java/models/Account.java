package models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by blakebishop on 6/4/14.
 */
@Entity
@Table(name="account")

public class Account {

    @Id
    @Column(name="id")
    @SequenceGenerator(name="account_seq", sequenceName="account_seq", initialValue=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="account_seq")
    private String id;

    @Column(name="email", unique=true)
    private String email;

    @Column(name="password")
    private String password;

    @OneToMany(fetch=FetchType.EAGER, mappedBy="account", cascade={CascadeType.PERSIST, CascadeType.REMOVE})
    private Set<AccountRole> roles = new HashSet<>();


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addRole(Role user) {
        AccountRole accountRole = new AccountRole();
        accountRole.setRole(user);
        accountRole.setEmail(email);
        roles.add(accountRole);
    }

    public boolean hasRole(Role role) {
        for ( AccountRole accountRole : roles ) {
            if ( accountRole.getRole().equals(role) ) {
                return true;
            }
        }
        return false;
    }
}
