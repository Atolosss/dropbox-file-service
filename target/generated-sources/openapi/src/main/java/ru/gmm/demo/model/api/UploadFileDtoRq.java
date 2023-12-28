package ru.gmm.demo.model.api;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Arrays;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * UploadFileDtoRq
 */
@lombok.Builder @lombok.NoArgsConstructor
@lombok.AllArgsConstructor

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-27T00:13:58.311485+03:00[Europe/Moscow]")
public class UploadFileDtoRq {

  private byte[] base64Data;

  public UploadFileDtoRq base64Data(byte[] base64Data) {
    this.base64Data = base64Data;
    return this;
  }

  /**
   * Get base64Data
   * @return base64Data
  */
  
  @Schema(name = "base64Data", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("base64Data")
  public byte[] getBase64Data() {
    return base64Data;
  }

  public void setBase64Data(byte[] base64Data) {
    this.base64Data = base64Data;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UploadFileDtoRq uploadFileDtoRq = (UploadFileDtoRq) o;
    return Arrays.equals(this.base64Data, uploadFileDtoRq.base64Data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(Arrays.hashCode(base64Data));
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UploadFileDtoRq {\n");
    sb.append("    base64Data: ").append(toIndentedString(base64Data)).append("\n");
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

