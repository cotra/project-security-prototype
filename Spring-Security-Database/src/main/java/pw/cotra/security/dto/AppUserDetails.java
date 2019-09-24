package pw.cotra.security.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pw.cotra.po.SysRole;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AppUserDetails implements UserDetails, Serializable {
    private String username;
    private String password;
    private List<SysRole> roles;

    public AppUserDetails(String username, String password) {
        this.password = password;
        this.username = username;
        SysRole role = new SysRole();
        role.setId(1L);
        AuthorityUtils.commaSeparatedStringToAuthorityList("");
        role.setRoleCode("LOOK");

        this.roles = new ArrayList<>();
        this.roles.add(role);
    }

    public AppUserDetails(String username, String password, List<SysRole> list) {
        this.password = password;
        this.username = username;
//        role.setId(1L);
//        AuthorityUtils.commaSeparatedStringToAuthorityList("");
//        role.setRoleCode("LOOK");
        this.roles = list;
//        this.roles.add(role);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<>();
        for (SysRole role : this.roles) {
            list.add(new SimpleGrantedAuthority(role.getRoleCode()));
        }
        return list;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
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
}
