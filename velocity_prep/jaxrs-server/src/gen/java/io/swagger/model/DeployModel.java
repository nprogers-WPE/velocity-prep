package io.swagger.model;

import io.swagger.model.PRListModel;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class DeployModel  {
  
  private String version = null;
  private String repo = null;
  private String releaseDate = null;
  private PRListModel prs = null;

  
  /**
   **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("version")
  public String getVersion() {
    return version;
  }
  public void setVersion(String version) {
    this.version = version;
  }

  
  /**
   **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("repo")
  public String getRepo() {
    return repo;
  }
  public void setRepo(String repo) {
    this.repo = repo;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("releaseDate")
  public String getReleaseDate() {
    return releaseDate;
  }
  public void setReleaseDate(String releaseDate) {
    this.releaseDate = releaseDate;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("prs")
  public PRListModel getPrs() {
    return prs;
  }
  public void setPrs(PRListModel prs) {
    this.prs = prs;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeployModel {\n");
    
    sb.append("  version: ").append(version).append("\n");
    sb.append("  repo: ").append(repo).append("\n");
    sb.append("  releaseDate: ").append(releaseDate).append("\n");
    sb.append("  prs: ").append(prs).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
