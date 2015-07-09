package io.swagger.model;

import io.swagger.model.ZabbixModel;
import java.util.*;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class ZabbixListModel  {
  
  private Integer count = null;
  private List<ZabbixModel> zabbixList = new ArrayList<ZabbixModel>() ;

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("count")
  public Integer getCount() {
    return count;
  }
  public void setCount(Integer count) {
    this.count = count;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("zabbixList")
  public List<ZabbixModel> getZabbixList() {
    return zabbixList;
  }
  public void setZabbixList(List<ZabbixModel> zabbixList) {
    this.zabbixList = zabbixList;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class ZabbixListModel {\n");
    
    sb.append("  count: ").append(count).append("\n");
    sb.append("  zabbixList: ").append(zabbixList).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
