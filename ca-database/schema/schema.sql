-- Drop and create schema
DROP SCHEMA IF EXISTS certauthority;
CREATE SCHEMA certauthority;

-- Workaround for DROP USER IF exists
-- This will create user if already does not exist with USAGE privelages
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

-- Certificate Authority table
CREATE TABLE CertificateAuthority (
id              int not null auto_increment,
PRIMARY KEY (id)
) ENGINE = InnoDB;

-- Users table
CREATE TABLE Users (
id				int not null auto_increment,
email			varchar(255) not null,
password		varchar(64) not null,
role			varchar(20) not null default "USER",

PRIMARY KEY (id),
CONSTRAINT email_unique UNIQUE (email)
) ENGINE = InnoDB;