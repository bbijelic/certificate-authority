package com.github.bbijelic.ca.db.entity;

import java.security.Principal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Principal entity
 * 
 * @author Bojan Bijelić
 */
@Entity
@Table(name="Principal")
public class PrincipalEntity implements Principal {
    
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
     * Salt
     */
    @Column(name="salt", updatable=false, insertable=true, nullable=false, unique=true)
    private String salt;
    
    public String getSalt() {
        return salt;
    }
    
    public void setSalt(String salt) {
        this.salt = salt;
    }
    
    /**
     * Created at
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_at", updatable=false, insertable=true, nullable=false, unique=false)
    private Date createdAt; 
    
    public Date getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    
    @Override
    public String getName() {
        return this.email;
    }
    
    /**
     * Roles
     */
    private Set<RoleEntity> roles = new HashSet<RoleEntity>(0);
    
    @ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinTable(name="PrincipalRoleMap", joinColumns={
        @JoinColumn(name="principal_id", nullable=false, updatable=true)
    }, inverseJoinColumns={
        @JoinColumn(name="role_id", nullable=false, updatable=true)
    })
    public Set<RoleEntity> getRoles() {
        return roles;
    }
    
    public void setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("PrincipalEntity [id=").append(id)
                .append(", email=").append(email)
                .append(", password=").append("***")
                .append(", salt=").append("***")
                .append(", createdAt=").append(createdAt)
                .append(", roles=").append(roles)
                .append("]");
        return builder.toString();
    }
}
