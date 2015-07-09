package io.swagger.model;

import io.swagger.model.CRModel;
import java.util.*;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class CRListModel  {
  
  private Integer count = null;
  private List<CRModel> crList = new ArrayList<CRModel>() ;

  
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
  @JsonProperty("crList")
  public List<CRModel> getCrList() {
    return crList;
  }
  public void setCrList(List<CRModel> crList) {
    this.crList = crList;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class CRListModel {\n");
    
    sb.append("  count: ").append(count).append("\n");
    sb.append("  crList: ").append(crList).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
