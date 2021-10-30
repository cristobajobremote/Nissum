package cl.nisum.bffuser.api.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * EmptyDataResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-10-24T22:11:56.183Z[GMT]")


public class EmptyDataResponse   {
  @JsonProperty("data")
  private String data = null;

  @JsonProperty("notifications")
  private String notifications = null;

  public EmptyDataResponse data(String data) {
    this.data = data;
    return this;
  }

  /**
   * Get data
   * @return data
   **/
  @Schema(description = "")
  
    public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public EmptyDataResponse notifications(String notifications) {
    this.notifications = notifications;
    return this;
  }

  /**
   * Get notifications
   * @return notifications
   **/
  @Schema(description = "")
  
    public String getNotifications() {
    return notifications;
  }

  public void setNotifications(String notifications) {
    this.notifications = notifications;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EmptyDataResponse emptyDataResponse = (EmptyDataResponse) o;
    return Objects.equals(this.data, emptyDataResponse.data) &&
        Objects.equals(this.notifications, emptyDataResponse.notifications);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, notifications);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EmptyDataResponse {\n");
    
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    notifications: ").append(toIndentedString(notifications)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
