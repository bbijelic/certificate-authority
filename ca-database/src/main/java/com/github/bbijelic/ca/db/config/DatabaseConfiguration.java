package com.github.bbijelic.ca.db.config;

import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Database configuration
 */
public class DatabaseConfiguration extends Configuration {

    @Valid
    @NotNull
    @JsonProperty("DataSource")
    private DataSourceFactory dataSourceFactory = new DataSourceFactory();

    public DataSourceFactory getDataSourceFactory() {
        return dataSourceFactory;
    }

    public void setDataSourceFactory(DataSourceFactory dataSourceFactory) {
        this.dataSourceFactory = dataSourceFactory;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("DatabaseConfiguration [dataSourceFactory=").append(dataSourceFactory).append("]");
        return builder.toString();
    }

}
