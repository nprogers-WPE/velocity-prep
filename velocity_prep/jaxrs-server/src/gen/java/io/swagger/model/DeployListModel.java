package io.swagger.model;

import io.swagger.model.DeployModel;
import java.util.*;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class DeployListModel  {
  
  private Integer count = null;
  private List<DeployModel> deployList = new ArrayList<DeployModel>() ;

  
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
  @JsonProperty("deployList")
  public List<DeployModel> getDeployList() {
    return deployList;
  }
  public void setDeployList(List<DeployModel> deployList) {
    this.deployList = deployList;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeployListModel {\n");
    
    sb.append("  count: ").append(count).append("\n");
    sb.append("  deployList: ").append(deployList).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
