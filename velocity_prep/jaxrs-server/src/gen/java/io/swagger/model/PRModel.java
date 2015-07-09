package io.swagger.model;


import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class PRModel  {
  
  private Integer prId = null;
  private String prTitle = null;
  private String prDesc = null;
  private String prDate = null;
  private String prAuthor = null;

  
  /**
   **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("prId")
  public Integer getPrId() {
    return prId;
  }
  public void setPrId(Integer prId) {
    this.prId = prId;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("prTitle")
  public String getPrTitle() {
    return prTitle;
  }
  public void setPrTitle(String prTitle) {
    this.prTitle = prTitle;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("prDesc")
  public String getPrDesc() {
    return prDesc;
  }
  public void setPrDesc(String prDesc) {
    this.prDesc = prDesc;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("prDate")
  public String getPrDate() {
    return prDate;
  }
  public void setPrDate(String prDate) {
    this.prDate = prDate;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("prAuthor")
  public String getPrAuthor() {
    return prAuthor;
  }
  public void setPrAuthor(String prAuthor) {
    this.prAuthor = prAuthor;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class PRModel {\n");
    
    sb.append("  prId: ").append(prId).append("\n");
    sb.append("  prTitle: ").append(prTitle).append("\n");
    sb.append("  prDesc: ").append(prDesc).append("\n");
    sb.append("  prDate: ").append(prDate).append("\n");
    sb.append("  prAuthor: ").append(prAuthor).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
