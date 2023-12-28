package ru.gmm.demo.model.api;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * UploadFileDto
 */
@lombok.Builder @lombok.NoArgsConstructor
@lombok.AllArgsConstructor

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-27T00:13:58.311485+03:00[Europe/Moscow]")
public class UploadFileDto {

  private String name;

  private String base64Data;

  public UploadFileDto name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @NotNull 
  @Schema(name = "name", example = "file name", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public UploadFileDto base64Data(String base64Data) {
    this.base64Data = base64Data;
    return this;
  }

  /**
   * Get base64Data
   * @return base64Data
  */
  @NotNull 
  @Schema(name = "base64Data", example = "base64Data", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("base64Data")
  public String getBase64Data() {
    return base64Data;
  }

  public void setBase64Data(String base64Data) {
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
    UploadFileDto uploadFileDto = (UploadFileDto) o;
    return Objects.equals(this.name, uploadFileDto.name) &&
        Objects.equals(this.base64Data, uploadFileDto.base64Data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, base64Data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UploadFileDto {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

