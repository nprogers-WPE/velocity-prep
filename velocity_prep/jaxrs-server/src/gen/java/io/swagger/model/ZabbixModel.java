package io.swagger.model;


import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class ZabbixModel  {
  
  private Integer zabbixId = null;
  private String zabbixDesc = null;
  private String zabbixDate = null;

  
  /**
   **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("zabbixId")
  public Integer getZabbixId() {
    return zabbixId;
  }
  public void setZabbixId(Integer zabbixId) {
    this.zabbixId = zabbixId;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("zabbixDesc")
  public String getZabbixDesc() {
    return zabbixDesc;
  }
  public void setZabbixDesc(String zabbixDesc) {
    this.zabbixDesc = zabbixDesc;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("zabbixDate")
  public String getZabbixDate() {
    return zabbixDate;
  }
  public void setZabbixDate(String zabbixDate) {
    this.zabbixDate = zabbixDate;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class ZabbixModel {\n");
    
    sb.append("  zabbixId: ").append(zabbixId).append("\n");
    sb.append("  zabbixDesc: ").append(zabbixDesc).append("\n");
    sb.append("  zabbixDate: ").append(zabbixDate).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
