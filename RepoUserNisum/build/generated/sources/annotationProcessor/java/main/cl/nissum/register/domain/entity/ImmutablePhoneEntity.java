package cl.nissum.register.domain.entity;

import com.google.common.base.MoreObjects;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link PhoneEntity}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutablePhoneEntity.builder()}.
 */
@Generated(from = "PhoneEntity", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
public final class ImmutablePhoneEntity extends PhoneEntity {
  private final @Nullable UUID id;
  private final String number;
  private final int cityCode;
  private final int countryCode;

  private ImmutablePhoneEntity(
      @Nullable UUID id,
      String number,
      int cityCode,
      int countryCode) {
    this.id = id;
    this.number = number;
    this.cityCode = cityCode;
    this.countryCode = countryCode;
  }

  /**
   * @return The value of the {@code id} attribute
   */
  @Override
  public @Nullable UUID getId() {
    return id;
  }

  /**
   * @return The value of the {@code number} attribute
   */
  @Override
  public String getNumber() {
    return number;
  }

  /**
   * @return The value of the {@code cityCode} attribute
   */
  @Override
  public int getCityCode() {
    return cityCode;
  }

  /**
   * @return The value of the {@code countryCode} attribute
   */
  @Override
  public int getCountryCode() {
    return countryCode;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link PhoneEntity#getId() id} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for id (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutablePhoneEntity withId(@Nullable UUID value) {
    if (this.id == value) return this;
    return new ImmutablePhoneEntity(value, this.number, this.cityCode, this.countryCode);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link PhoneEntity#getNumber() number} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for number
   * @return A modified copy of the {@code this} object
   */
  public final ImmutablePhoneEntity withNumber(String value) {
    String newValue = Objects.requireNonNull(value, "number");
    if (this.number.equals(newValue)) return this;
    return new ImmutablePhoneEntity(this.id, newValue, this.cityCode, this.countryCode);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link PhoneEntity#getCityCode() cityCode} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for cityCode
   * @return A modified copy of the {@code this} object
   */
  public final ImmutablePhoneEntity withCityCode(int value) {
    if (this.cityCode == value) return this;
    return new ImmutablePhoneEntity(this.id, this.number, value, this.countryCode);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link PhoneEntity#getCountryCode() countryCode} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for countryCode
   * @return A modified copy of the {@code this} object
   */
  public final ImmutablePhoneEntity withCountryCode(int value) {
    if (this.countryCode == value) return this;
    return new ImmutablePhoneEntity(this.id, this.number, this.cityCode, value);
  }

  /**
   * This instance is equal to all instances of {@code ImmutablePhoneEntity} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutablePhoneEntity
        && equalTo((ImmutablePhoneEntity) another);
  }

  private boolean equalTo(ImmutablePhoneEntity another) {
    return Objects.equals(id, another.id)
        && number.equals(another.number)
        && cityCode == another.cityCode
        && countryCode == another.countryCode;
  }

  /**
   * Computes a hash code from attributes: {@code id}, {@code number}, {@code cityCode}, {@code countryCode}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + Objects.hashCode(id);
    h += (h << 5) + number.hashCode();
    h += (h << 5) + cityCode;
    h += (h << 5) + countryCode;
    return h;
  }

  /**
   * Prints the immutable value {@code PhoneEntity} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("PhoneEntity")
        .omitNullValues()
        .add("id", id)
        .add("number", number)
        .add("cityCode", cityCode)
        .add("countryCode", countryCode)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link PhoneEntity} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable PhoneEntity instance
   */
  public static ImmutablePhoneEntity copyOf(PhoneEntity instance) {
    if (instance instanceof ImmutablePhoneEntity) {
      return (ImmutablePhoneEntity) instance;
    }
    return ImmutablePhoneEntity.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutablePhoneEntity ImmutablePhoneEntity}.
   * <pre>
   * ImmutablePhoneEntity.builder()
   *    .setId(UUID | null) // nullable {@link PhoneEntity#getId() id}
   *    .setNumber(String) // required {@link PhoneEntity#getNumber() number}
   *    .setCityCode(int) // required {@link PhoneEntity#getCityCode() cityCode}
   *    .setCountryCode(int) // required {@link PhoneEntity#getCountryCode() countryCode}
   *    .build();
   * </pre>
   * @return A new ImmutablePhoneEntity builder
   */
  public static ImmutablePhoneEntity.Builder builder() {
    return new ImmutablePhoneEntity.Builder();
  }

  /**
   * Builds instances of type {@link ImmutablePhoneEntity ImmutablePhoneEntity}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "PhoneEntity", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_NUMBER = 0x1L;
    private static final long INIT_BIT_CITY_CODE = 0x2L;
    private static final long INIT_BIT_COUNTRY_CODE = 0x4L;
    private long initBits = 0x7L;

    private @Nullable UUID id;
    private @Nullable String number;
    private int cityCode;
    private int countryCode;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code PhoneEntity} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(PhoneEntity instance) {
      Objects.requireNonNull(instance, "instance");
      @Nullable UUID idValue = instance.getId();
      if (idValue != null) {
        setId(idValue);
      }
      setNumber(instance.getNumber());
      setCityCode(instance.getCityCode());
      setCountryCode(instance.getCountryCode());
      return this;
    }

    /**
     * Initializes the value for the {@link PhoneEntity#getId() id} attribute.
     * @param id The value for id (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setId(@Nullable UUID id) {
      this.id = id;
      return this;
    }

    /**
     * Initializes the value for the {@link PhoneEntity#getNumber() number} attribute.
     * @param number The value for number 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setNumber(String number) {
      this.number = Objects.requireNonNull(number, "number");
      initBits &= ~INIT_BIT_NUMBER;
      return this;
    }

    /**
     * Initializes the value for the {@link PhoneEntity#getCityCode() cityCode} attribute.
     * @param cityCode The value for cityCode 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setCityCode(int cityCode) {
      this.cityCode = cityCode;
      initBits &= ~INIT_BIT_CITY_CODE;
      return this;
    }

    /**
     * Initializes the value for the {@link PhoneEntity#getCountryCode() countryCode} attribute.
     * @param countryCode The value for countryCode 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setCountryCode(int countryCode) {
      this.countryCode = countryCode;
      initBits &= ~INIT_BIT_COUNTRY_CODE;
      return this;
    }

    /**
     * Builds a new {@link ImmutablePhoneEntity ImmutablePhoneEntity}.
     * @return An immutable instance of PhoneEntity
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutablePhoneEntity build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutablePhoneEntity(id, number, cityCode, countryCode);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_NUMBER) != 0) attributes.add("number");
      if ((initBits & INIT_BIT_CITY_CODE) != 0) attributes.add("cityCode");
      if ((initBits & INIT_BIT_COUNTRY_CODE) != 0) attributes.add("countryCode");
      return "Cannot build PhoneEntity, some of required attributes are not set " + attributes;
    }
  }
}
