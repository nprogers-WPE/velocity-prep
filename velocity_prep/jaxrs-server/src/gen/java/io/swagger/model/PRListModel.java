package io.swagger.model;

import io.swagger.model.PRModel;
import java.util.*;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class PRListModel  {
  
  private Integer count = null;
  private List<PRModel> prList = new ArrayList<PRModel>() ;

  
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
  @JsonProperty("prList")
  public List<PRModel> getPrList() {
    return prList;
  }
  public void setPrList(List<PRModel> prList) {
    this.prList = prList;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class PRListModel {\n");
    
    sb.append("  count: ").append(count).append("\n");
    sb.append("  prList: ").append(prList).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
