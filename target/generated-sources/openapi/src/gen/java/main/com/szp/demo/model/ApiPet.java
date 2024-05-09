package com.szp.demo.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * ApiPet
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-09T11:31:28.289091+02:00[Europe/Budapest]", comments = "Generator version: 7.5.0")
public class ApiPet {

  /**
   * Gets or Sets petType
   */
  public enum PetTypeEnum {
    CAT("Cat"),
    
    DOG("Dog");

    private String value;

    PetTypeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static PetTypeEnum fromValue(String value) {
      for (PetTypeEnum b : PetTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private PetTypeEnum petType;

  private Long ownerId;

  /**
   * Type of tracker, only dogs can have medium
   */
  public enum TrackerTypeEnum {
    SMALL("small"),
    
    MEDIUM("medium"),
    
    BIG("big");

    private String value;

    TrackerTypeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TrackerTypeEnum fromValue(String value) {
      for (TrackerTypeEnum b : TrackerTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private TrackerTypeEnum trackerType;

  private Boolean inZone;

  private Boolean lostTracker;

  public ApiPet() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ApiPet(PetTypeEnum petType, Long ownerId) {
    this.petType = petType;
    this.ownerId = ownerId;
  }

  public ApiPet petType(PetTypeEnum petType) {
    this.petType = petType;
    return this;
  }

  /**
   * Get petType
   * @return petType
  */
  @NotNull 
  @Schema(name = "petType", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("petType")
  public PetTypeEnum getPetType() {
    return petType;
  }

  public void setPetType(PetTypeEnum petType) {
    this.petType = petType;
  }

  public ApiPet ownerId(Long ownerId) {
    this.ownerId = ownerId;
    return this;
  }

  /**
   * The owner's ID
   * @return ownerId
  */
  @NotNull 
  @Schema(name = "ownerId", description = "The owner's ID", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("ownerId")
  public Long getOwnerId() {
    return ownerId;
  }

  public void setOwnerId(Long ownerId) {
    this.ownerId = ownerId;
  }

  public ApiPet trackerType(TrackerTypeEnum trackerType) {
    this.trackerType = trackerType;
    return this;
  }

  /**
   * Type of tracker, only dogs can have medium
   * @return trackerType
  */
  
  @Schema(name = "trackerType", description = "Type of tracker, only dogs can have medium", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("trackerType")
  public TrackerTypeEnum getTrackerType() {
    return trackerType;
  }

  public void setTrackerType(TrackerTypeEnum trackerType) {
    this.trackerType = trackerType;
  }

  public ApiPet inZone(Boolean inZone) {
    this.inZone = inZone;
    return this;
  }

  /**
   * If the pet is in the power saving zone
   * @return inZone
  */
  
  @Schema(name = "inZone", description = "If the pet is in the power saving zone", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("inZone")
  public Boolean getInZone() {
    return inZone;
  }

  public void setInZone(Boolean inZone) {
    this.inZone = inZone;
  }

  public ApiPet lostTracker(Boolean lostTracker) {
    this.lostTracker = lostTracker;
    return this;
  }

  /**
   * If the tracker is lost, only for cats
   * @return lostTracker
  */
  
  @Schema(name = "lostTracker", description = "If the tracker is lost, only for cats", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("lostTracker")
  public Boolean getLostTracker() {
    return lostTracker;
  }

  public void setLostTracker(Boolean lostTracker) {
    this.lostTracker = lostTracker;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiPet apiPet = (ApiPet) o;
    return Objects.equals(this.petType, apiPet.petType) &&
        Objects.equals(this.ownerId, apiPet.ownerId) &&
        Objects.equals(this.trackerType, apiPet.trackerType) &&
        Objects.equals(this.inZone, apiPet.inZone) &&
        Objects.equals(this.lostTracker, apiPet.lostTracker);
  }

  @Override
  public int hashCode() {
    return Objects.hash(petType, ownerId, trackerType, inZone, lostTracker);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiPet {\n");
    sb.append("    petType: ").append(toIndentedString(petType)).append("\n");
    sb.append("    ownerId: ").append(toIndentedString(ownerId)).append("\n");
    sb.append("    trackerType: ").append(toIndentedString(trackerType)).append("\n");
    sb.append("    inZone: ").append(toIndentedString(inZone)).append("\n");
    sb.append("    lostTracker: ").append(toIndentedString(lostTracker)).append("\n");
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

