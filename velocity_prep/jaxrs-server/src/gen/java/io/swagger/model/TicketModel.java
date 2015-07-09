package io.swagger.model;


import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class TicketModel  {
  
  private Integer ticketId = null;
  private String ticketDesc = null;
  private String ticketDate = null;

  
  /**
   **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("ticketId")
  public Integer getTicketId() {
    return ticketId;
  }
  public void setTicketId(Integer ticketId) {
    this.ticketId = ticketId;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("ticketDesc")
  public String getTicketDesc() {
    return ticketDesc;
  }
  public void setTicketDesc(String ticketDesc) {
    this.ticketDesc = ticketDesc;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("ticketDate")
  public String getTicketDate() {
    return ticketDate;
  }
  public void setTicketDate(String ticketDate) {
    this.ticketDate = ticketDate;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class TicketModel {\n");
    
    sb.append("  ticketId: ").append(ticketId).append("\n");
    sb.append("  ticketDesc: ").append(ticketDesc).append("\n");
    sb.append("  ticketDate: ").append(ticketDate).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
