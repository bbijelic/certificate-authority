package com.github.bbijelic.ca.db.entity;

import java.security.Principal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User entity
 * 
 * @author Bojan Bijelić
 */
@Entity
@Table(name="Users")
public class UserEntity implements Principal {
    
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
    private Long id;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * Email
     */
    @Column(name="email", updatable=false, insertable=true, nullable=false, unique=true)
    private String email;
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * Password
     */
    @Column(name="password", updatable=true, insertable=true, nullable=false, unique=false)
    private String password;
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * Role
     */
    @Column(name="role", updatable=true, insertable=true, nullable=false, unique=false)
    private String role;
    
    public String getRole() {
        return role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
    
    @Override
    public String getName() {
        return this.email;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("UserEntity [id=").append(id)
                .append(", email=").append(email)
                .append(", password=").append("***")
                .append(", role=").append(role)
                .append("]");
        return builder.toString();
    }
}
