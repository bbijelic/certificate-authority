-- Drop and create schema
DROP SCHEMA IF EXISTS certauthority;
CREATE SCHEMA certauthority;

-- Workaround for DROP USER IF exists
-- This will create user if already does not exist with USAGE privelages
-- ---------------------
-- Database & User Setup
-- ---------------------

GRANT USAGE ON certauthority.* TO 'causer'@'%';
FLUSH PRIVILEGES;
-- Drop user
DROP USER causer;

-- Create user
CREATE USER 'causer'@'%' IDENTIFIED BY 'causer';
-- Grant all privileges
GRANT ALL PRIVILEGES ON certauthority. * TO 'causer'@'%';

-- Flush privileges
FLUSH PRIVILEGES;

-- Use created database
USE certauthority;

-- ---------------------
-- Service tables
-- ---------------------

-- Certificate Authority table
CREATE TABLE CertificateAuthority (
id              int not null auto_increment,
PRIMARY KEY (id)
) ENGINE = InnoDB;

-- ---------------------
-- Access control tables
-- ---------------------

-- Roles table
CREATE TABLE Role (
id				int not null auto_increment,
slug			varchar(100) not null,
name			varchar(100) not null,
description		varchar(255),

PRIMARY KEY (id),
CONSTRAINT role_slug_unique UNIQUE (slug),
CONSTRAINT role_name_unique UNIQUE (name)
) ENGINE = InnoDB;

-- Principal table
CREATE TABLE Principal (
id				int not null auto_increment,
email			varchar(255) not null,
password		varchar(64) not null,
salt            varchar(64) not null,
created_at		timestamp not null default current_timestamp,

PRIMARY KEY (id),
CONSTRAINT email_unique UNIQUE (email)
) ENGINE = InnoDB;

-- Principal to Role mapping table
CREATE TABLE PrincipalRoleMap (
principal_id	int not null,
role_id			int not null,

PRIMARY KEY (principal_id, role_id),
CONSTRAINT user_role_principal_fk FOREIGN KEY (principal_id) REFERENCES Principal (id),
CONSTRAINT user_role_role_fk FOREIGN KEY (role_id) REFERENCES Role (id)
) ENGINE = InnoDB;