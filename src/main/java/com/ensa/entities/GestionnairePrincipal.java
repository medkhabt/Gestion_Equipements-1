package com.ensa.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class GestionnairePrincipal implements UserDetails {
	
	private Gestionnaire user;
	
	public GestionnairePrincipal(Gestionnaire Gestionnaire) {
		this.user = Gestionnaire;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        // Extract list of permissions (name)
        this.user.getRoles().forEach(role -> {
            GrantedAuthority authority = new SimpleGrantedAuthority(role.getRole());
            authorities.add(authority);
        });

        // Extract list of roles (ROLE_name)
        this.user.getRoles().forEach(role -> {
            GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + role.getRole());
            authorities.add(authority);
        });

        return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return this.user.actived = true;
	}

	

}
