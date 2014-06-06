package models;

import javax.persistence.*;

@Entity
@Table(name="accountRole")
public class AccountRole {
	@Id
	@Column(name="id")
	@SequenceGenerator(name="account_role_seq", sequenceName="account_role_seq", initialValue=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="account_role_seq")
	private Long id;
	
	
	@Column(name="email")
	private String email;
	
	@Column(name="role")
	@Enumerated(EnumType.STRING)
	private Role role;

	@OneToOne(mappedBy="role")
	private Account account;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String username) {
		this.email = username;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
