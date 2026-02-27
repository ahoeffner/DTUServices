package dtu.services.api.model;

import java.util.*;
import java.util.Objects;

import jakarta.annotation.Generated;
import jakarta.validation.constraints.*;

import org.jspecify.annotations.Nullable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Definition af en bog.
 */

@Schema(name = "bog", description = "Definition af en bog.")
@JsonTypeName("bog")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-27T10:25:24.903746840Z[Etc/UTC]", comments = "Generator version: 7.19.0")
public class Bog {

  private Long id;

  private @Nullable String titel;

  private String forfatter;

  public Bog() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Bog(Long id, String forfatter) {
    this.id = id;
    this.forfatter = forfatter;
  }

  public Bog id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   */
  @NotNull 
  @Schema(name = "id", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Bog titel(@Nullable String titel) {
    this.titel = titel;
    return this;
  }

  /**
   * Get titel
   * @return titel
   */
  @Size(min = 3) 
  @Schema(name = "titel", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("titel")
  public @Nullable String getTitel() {
    return titel;
  }

  public void setTitel(@Nullable String titel) {
    this.titel = titel;
  }

  public Bog forfatter(String forfatter) {
    this.forfatter = forfatter;
    return this;
  }

  /**
   * Get forfatter
   * @return forfatter
   */
  @NotNull 
  @Schema(name = "forfatter", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("forfatter")
  public String getForfatter() {
    return forfatter;
  }

  public void setForfatter(String forfatter) {
    this.forfatter = forfatter;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Bog bog = (Bog) o;
    return Objects.equals(this.id, bog.id) &&
        Objects.equals(this.titel, bog.titel) &&
        Objects.equals(this.forfatter, bog.forfatter);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, titel, forfatter);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Bog {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    titel: ").append(toIndentedString(titel)).append("\n");
    sb.append("    forfatter: ").append(toIndentedString(forfatter)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(@Nullable Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
