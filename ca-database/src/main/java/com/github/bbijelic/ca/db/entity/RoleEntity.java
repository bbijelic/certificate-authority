package com.github.bbijelic.ca.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Role entity
 * 
 * @author Bojan Bijelić
 */
@Entity
@Table(name="Role")
public class RoleEntity {
    
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
     * Slug
     */
    @Column(name="slug", updatable=false, insertable=false, nullable=false)
    private String slug;
    
    public String getSlug() {
        return slug;
    }
    
    public void setSlug(String slug) {
        this.slug = slug;
    }
    
    /**
     * Role name
     */
    @Column(name="name", updatable=false, insertable=false, nullable=false)
    private String name;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Role description
     */
    @Column(name="description", updatable=false, insertable=false, nullable=false)
    private String description;
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("RoleEntity [id=").append(id)
                .append(", slug=").append(slug)
                .append(", name=").append(name)
                .append(", description=").append(description)
                .append("]");
        return builder.toString();
    }
}
