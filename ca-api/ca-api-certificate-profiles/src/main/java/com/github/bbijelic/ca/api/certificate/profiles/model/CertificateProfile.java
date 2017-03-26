/*
 * Certificate Authority Service API
 * API for management of certificate profiles
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.github.bbijelic.ca.api.certificate.profiles.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;

/**
 * CertificateProfile
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-03-26T01:52:53.407Z")
public class CertificateProfile   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("description")
  private String description = null;

  public CertificateProfile name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Name of the certificate profile
   * @return name
  **/
  @JsonProperty("name")
  @ApiModelProperty(required = true, value = "Name of the certificate profile")
  @NotNull
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CertificateProfile description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Description of the certificate profile
   * @return description
  **/
  @JsonProperty("description")
  @ApiModelProperty(value = "Description of the certificate profile")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CertificateProfile certificateProfile = (CertificateProfile) o;
    return Objects.equals(this.name, certificateProfile.name) &&
        Objects.equals(this.description, certificateProfile.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CertificateProfile {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

