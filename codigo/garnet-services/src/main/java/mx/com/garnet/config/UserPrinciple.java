package mx.com.garnet.config;



import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Objects;

public class UserPrinciple implements UserDetails {
	private static final long serialVersionUID = 1L;

	private Long idUsuario;

    private String name;

    private String username;

    private String email;

    @JsonIgnore
    private String password;


    private Collection<? extends GrantedAuthority> authorities;

    public UserPrinciple(Long id, String name, 
			    		String username, String email, String password) {
        this.idUsuario = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public static UserPrinciple build() {
    	 /*
    	  UserPrinciple userPrinciple=new UserPrinciple(
    			  th.getIdTarjetahabiente().longValue(),
    			  th.getDatPersona().getNombre(),
    			  th.getCorreo(),
    			  th.getCorreo(),
    			  th.getPassword()
          );
    	  */
       return null;
    }

    public Long getId() {
        return idUsuario;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
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

    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        UserPrinciple user = (UserPrinciple) o;
        return Objects.equals(idUsuario, user.idUsuario);
    }
}