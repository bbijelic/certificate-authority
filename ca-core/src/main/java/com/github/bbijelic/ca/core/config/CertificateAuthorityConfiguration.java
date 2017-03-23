package com.github.bbijelic.ca.core.config;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.bbijelic.ca.db.config.DatabaseConfiguration;

import io.dropwizard.Configuration;

/**
 * Certificate Authority Configuration
 * 
 * @author Bojan Bijelić
 */
public class CertificateAuthorityConfiguration extends Configuration {
    
    /**
     * Database configuration
     */
    @Valid
    @NotNull
    @JsonProperty("Database")
    private DatabaseConfiguration databaseConfiguration;
    
    public DatabaseConfiguration getDatabaseConfiguration() {
        return databaseConfiguration;
    }
    
    public void setDatabaseConfiguration(DatabaseConfiguration databaseConfiguration) {
        this.databaseConfiguration = databaseConfiguration;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("CertificateAuthorityConfiguration [databaseConfiguration=").append(databaseConfiguration)
                .append("]");
        return builder.toString();
    }
}
