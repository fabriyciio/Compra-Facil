package  com.project.cotafacil.model.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class JwtUser implements UserDetails {

	private static final long serialVersionUID = -8328911063439191378L;
	
	private Long id;
	private String username;
	private String password;
	
	public JwtUser(Long id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}
	
	public JwtUser(String username, String password) {
		this.username = username;
		this.password = password;
	}


	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	public Long getId() {
		return id;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return new ArrayList();
	}

}
