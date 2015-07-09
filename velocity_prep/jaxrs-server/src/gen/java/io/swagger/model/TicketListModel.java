package io.swagger.model;

import java.util.*;
import io.swagger.model.TicketModel;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class TicketListModel  {
  
  private Integer count = null;
  private List<TicketModel> ticketList = new ArrayList<TicketModel>() ;

  
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
  @JsonProperty("ticketList")
  public List<TicketModel> getTicketList() {
    return ticketList;
  }
  public void setTicketList(List<TicketModel> ticketList) {
    this.ticketList = ticketList;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class TicketListModel {\n");
    
    sb.append("  count: ").append(count).append("\n");
    sb.append("  ticketList: ").append(ticketList).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
