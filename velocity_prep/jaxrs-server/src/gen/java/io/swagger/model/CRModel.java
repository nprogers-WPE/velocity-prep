package io.swagger.model;


import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class CRModel  {
  
  private Integer crId = null;
  private String crTitle = null;
  private String crDesc = null;
  private String crDate = null;
  private String crAuthor = null;

  
  /**
   **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("crId")
  public Integer getCrId() {
    return crId;
  }
  public void setCrId(Integer crId) {
    this.crId = crId;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("crTitle")
  public String getCrTitle() {
    return crTitle;
  }
  public void setCrTitle(String crTitle) {
    this.crTitle = crTitle;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("crDesc")
  public String getCrDesc() {
    return crDesc;
  }
  public void setCrDesc(String crDesc) {
    this.crDesc = crDesc;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("crDate")
  public String getCrDate() {
    return crDate;
  }
  public void setCrDate(String crDate) {
    this.crDate = crDate;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("crAuthor")
  public String getCrAuthor() {
    return crAuthor;
  }
  public void setCrAuthor(String crAuthor) {
    this.crAuthor = crAuthor;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class CRModel {\n");
    
    sb.append("  crId: ").append(crId).append("\n");
    sb.append("  crTitle: ").append(crTitle).append("\n");
    sb.append("  crDesc: ").append(crDesc).append("\n");
    sb.append("  crDate: ").append(crDate).append("\n");
    sb.append("  crAuthor: ").append(crAuthor).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
