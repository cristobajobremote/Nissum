package cl.nissum.register.domain.entity;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import java.time.OffsetDateTime;
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
 * Immutable implementation of {@link UserEntity}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableUserEntity.builder()}.
 */
@Generated(from = "UserEntity", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
public final class ImmutableUserEntity extends UserEntity {
  private final @Nullable UUID id;
  private final String name;
  private final String email;
  private final String password;
  private final @Nullable String token;
  private final @Nullable OffsetDateTime created;
  private final @Nullable OffsetDateTime modified;
  private final @Nullable OffsetDateTime lastLogin;
  private final @Nullable Boolean isUserActive;
  private final @Nullable ImmutableList<PhoneEntity> phones;

  private ImmutableUserEntity(
      @Nullable UUID id,
      String name,
      String email,
      String password,
      @Nullable String token,
      @Nullable OffsetDateTime created,
      @Nullable OffsetDateTime modified,
      @Nullable OffsetDateTime lastLogin,
      @Nullable Boolean isUserActive,
      @Nullable ImmutableList<PhoneEntity> phones) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.password = password;
    this.token = token;
    this.created = created;
    this.modified = modified;
    this.lastLogin = lastLogin;
    this.isUserActive = isUserActive;
    this.phones = phones;
  }

  /**
   * @return The value of the {@code id} attribute
   */
  @Override
  public @Nullable UUID getId() {
    return id;
  }

  /**
   * @return The value of the {@code name} attribute
   */
  @Override
  public String getName() {
    return name;
  }

  /**
   * @return The value of the {@code email} attribute
   */
  @Override
  public String getEmail() {
    return email;
  }

  /**
   * @return The value of the {@code password} attribute
   */
  @Override
  public String getPassword() {
    return password;
  }

  /**
   * @return The value of the {@code token} attribute
   */
  @Override
  public @Nullable String getToken() {
    return token;
  }

  /**
   * @return The value of the {@code created} attribute
   */
  @Override
  public @Nullable OffsetDateTime getCreated() {
    return created;
  }

  /**
   * @return The value of the {@code modified} attribute
   */
  @Override
  public @Nullable OffsetDateTime getModified() {
    return modified;
  }

  /**
   * @return The value of the {@code lastLogin} attribute
   */
  @Override
  public @Nullable OffsetDateTime getLastLogin() {
    return lastLogin;
  }

  /**
   * @return The value of the {@code isUserActive} attribute
   */
  @Override
  public @Nullable Boolean getIsUserActive() {
    return isUserActive;
  }

  /**
   * @return The value of the {@code phones} attribute
   */
  @Override
  public @Nullable ImmutableList<PhoneEntity> getPhones() {
    return phones;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link UserEntity#getId() id} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for id (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableUserEntity withId(@Nullable UUID value) {
    if (this.id == value) return this;
    return new ImmutableUserEntity(
        value,
        this.name,
        this.email,
        this.password,
        this.token,
        this.created,
        this.modified,
        this.lastLogin,
        this.isUserActive,
        this.phones);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link UserEntity#getName() name} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for name
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableUserEntity withName(String value) {
    String newValue = Objects.requireNonNull(value, "name");
    if (this.name.equals(newValue)) return this;
    return new ImmutableUserEntity(
        this.id,
        newValue,
        this.email,
        this.password,
        this.token,
        this.created,
        this.modified,
        this.lastLogin,
        this.isUserActive,
        this.phones);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link UserEntity#getEmail() email} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for email
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableUserEntity withEmail(String value) {
    String newValue = Objects.requireNonNull(value, "email");
    if (this.email.equals(newValue)) return this;
    return new ImmutableUserEntity(
        this.id,
        this.name,
        newValue,
        this.password,
        this.token,
        this.created,
        this.modified,
        this.lastLogin,
        this.isUserActive,
        this.phones);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link UserEntity#getPassword() password} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for password
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableUserEntity withPassword(String value) {
    String newValue = Objects.requireNonNull(value, "password");
    if (this.password.equals(newValue)) return this;
    return new ImmutableUserEntity(
        this.id,
        this.name,
        this.email,
        newValue,
        this.token,
        this.created,
        this.modified,
        this.lastLogin,
        this.isUserActive,
        this.phones);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link UserEntity#getToken() token} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for token (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableUserEntity withToken(@Nullable String value) {
    if (Objects.equals(this.token, value)) return this;
    return new ImmutableUserEntity(
        this.id,
        this.name,
        this.email,
        this.password,
        value,
        this.created,
        this.modified,
        this.lastLogin,
        this.isUserActive,
        this.phones);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link UserEntity#getCreated() created} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for created (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableUserEntity withCreated(@Nullable OffsetDateTime value) {
    if (this.created == value) return this;
    return new ImmutableUserEntity(
        this.id,
        this.name,
        this.email,
        this.password,
        this.token,
        value,
        this.modified,
        this.lastLogin,
        this.isUserActive,
        this.phones);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link UserEntity#getModified() modified} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for modified (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableUserEntity withModified(@Nullable OffsetDateTime value) {
    if (this.modified == value) return this;
    return new ImmutableUserEntity(
        this.id,
        this.name,
        this.email,
        this.password,
        this.token,
        this.created,
        value,
        this.lastLogin,
        this.isUserActive,
        this.phones);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link UserEntity#getLastLogin() lastLogin} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for lastLogin (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableUserEntity withLastLogin(@Nullable OffsetDateTime value) {
    if (this.lastLogin == value) return this;
    return new ImmutableUserEntity(
        this.id,
        this.name,
        this.email,
        this.password,
        this.token,
        this.created,
        this.modified,
        value,
        this.isUserActive,
        this.phones);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link UserEntity#getIsUserActive() isUserActive} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for isUserActive (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableUserEntity withIsUserActive(@Nullable Boolean value) {
    if (Objects.equals(this.isUserActive, value)) return this;
    return new ImmutableUserEntity(
        this.id,
        this.name,
        this.email,
        this.password,
        this.token,
        this.created,
        this.modified,
        this.lastLogin,
        value,
        this.phones);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link UserEntity#getPhones() phones}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableUserEntity withPhones(@Nullable PhoneEntity... elements) {
    if (elements == null) {
      return new ImmutableUserEntity(
          this.id,
          this.name,
          this.email,
          this.password,
          this.token,
          this.created,
          this.modified,
          this.lastLogin,
          this.isUserActive,
          null);
    }
    @Nullable ImmutableList<PhoneEntity> newValue = elements == null ? null : ImmutableList.copyOf(elements);
    return new ImmutableUserEntity(
        this.id,
        this.name,
        this.email,
        this.password,
        this.token,
        this.created,
        this.modified,
        this.lastLogin,
        this.isUserActive,
        newValue);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link UserEntity#getPhones() phones}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of phones elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableUserEntity withPhones(@Nullable Iterable<? extends PhoneEntity> elements) {
    if (this.phones == elements) return this;
    @Nullable ImmutableList<PhoneEntity> newValue = elements == null ? null : ImmutableList.copyOf(elements);
    return new ImmutableUserEntity(
        this.id,
        this.name,
        this.email,
        this.password,
        this.token,
        this.created,
        this.modified,
        this.lastLogin,
        this.isUserActive,
        newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableUserEntity} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableUserEntity
        && equalTo((ImmutableUserEntity) another);
  }

  private boolean equalTo(ImmutableUserEntity another) {
    return Objects.equals(id, another.id)
        && name.equals(another.name)
        && email.equals(another.email)
        && password.equals(another.password)
        && Objects.equals(token, another.token)
        && Objects.equals(created, another.created)
        && Objects.equals(modified, another.modified)
        && Objects.equals(lastLogin, another.lastLogin)
        && Objects.equals(isUserActive, another.isUserActive)
        && Objects.equals(phones, another.phones);
  }

  /**
   * Computes a hash code from attributes: {@code id}, {@code name}, {@code email}, {@code password}, {@code token}, {@code created}, {@code modified}, {@code lastLogin}, {@code isUserActive}, {@code phones}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + Objects.hashCode(id);
    h += (h << 5) + name.hashCode();
    h += (h << 5) + email.hashCode();
    h += (h << 5) + password.hashCode();
    h += (h << 5) + Objects.hashCode(token);
    h += (h << 5) + Objects.hashCode(created);
    h += (h << 5) + Objects.hashCode(modified);
    h += (h << 5) + Objects.hashCode(lastLogin);
    h += (h << 5) + Objects.hashCode(isUserActive);
    h += (h << 5) + Objects.hashCode(phones);
    return h;
  }

  /**
   * Prints the immutable value {@code UserEntity} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("UserEntity")
        .omitNullValues()
        .add("id", id)
        .add("name", name)
        .add("email", email)
        .add("password", password)
        .add("token", token)
        .add("created", created)
        .add("modified", modified)
        .add("lastLogin", lastLogin)
        .add("isUserActive", isUserActive)
        .add("phones", phones)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link UserEntity} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable UserEntity instance
   */
  public static ImmutableUserEntity copyOf(UserEntity instance) {
    if (instance instanceof ImmutableUserEntity) {
      return (ImmutableUserEntity) instance;
    }
    return ImmutableUserEntity.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableUserEntity ImmutableUserEntity}.
   * <pre>
   * ImmutableUserEntity.builder()
   *    .setId(UUID | null) // nullable {@link UserEntity#getId() id}
   *    .setName(String) // required {@link UserEntity#getName() name}
   *    .setEmail(String) // required {@link UserEntity#getEmail() email}
   *    .setPassword(String) // required {@link UserEntity#getPassword() password}
   *    .setToken(String | null) // nullable {@link UserEntity#getToken() token}
   *    .setCreated(java.time.OffsetDateTime | null) // nullable {@link UserEntity#getCreated() created}
   *    .setModified(java.time.OffsetDateTime | null) // nullable {@link UserEntity#getModified() modified}
   *    .setLastLogin(java.time.OffsetDateTime | null) // nullable {@link UserEntity#getLastLogin() lastLogin}
   *    .setIsUserActive(Boolean | null) // nullable {@link UserEntity#getIsUserActive() isUserActive}
   *    .setPhones(List&amp;lt;cl.nissum.register.domain.entity.PhoneEntity&amp;gt; | null) // nullable {@link UserEntity#getPhones() phones}
   *    .build();
   * </pre>
   * @return A new ImmutableUserEntity builder
   */
  public static ImmutableUserEntity.Builder builder() {
    return new ImmutableUserEntity.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableUserEntity ImmutableUserEntity}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "UserEntity", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_NAME = 0x1L;
    private static final long INIT_BIT_EMAIL = 0x2L;
    private static final long INIT_BIT_PASSWORD = 0x4L;
    private long initBits = 0x7L;

    private @Nullable UUID id;
    private @Nullable String name;
    private @Nullable String email;
    private @Nullable String password;
    private @Nullable String token;
    private @Nullable OffsetDateTime created;
    private @Nullable OffsetDateTime modified;
    private @Nullable OffsetDateTime lastLogin;
    private @Nullable Boolean isUserActive;
    private ImmutableList.Builder<PhoneEntity> phones = null;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code UserEntity} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(UserEntity instance) {
      Objects.requireNonNull(instance, "instance");
      @Nullable UUID idValue = instance.getId();
      if (idValue != null) {
        setId(idValue);
      }
      setName(instance.getName());
      setEmail(instance.getEmail());
      setPassword(instance.getPassword());
      @Nullable String tokenValue = instance.getToken();
      if (tokenValue != null) {
        setToken(tokenValue);
      }
      @Nullable OffsetDateTime createdValue = instance.getCreated();
      if (createdValue != null) {
        setCreated(createdValue);
      }
      @Nullable OffsetDateTime modifiedValue = instance.getModified();
      if (modifiedValue != null) {
        setModified(modifiedValue);
      }
      @Nullable OffsetDateTime lastLoginValue = instance.getLastLogin();
      if (lastLoginValue != null) {
        setLastLogin(lastLoginValue);
      }
      @Nullable Boolean isUserActiveValue = instance.getIsUserActive();
      if (isUserActiveValue != null) {
        setIsUserActive(isUserActiveValue);
      }
      @Nullable List<PhoneEntity> phonesValue = instance.getPhones();
      if (phonesValue != null) {
        addAllPhones(phonesValue);
      }
      return this;
    }

    /**
     * Initializes the value for the {@link UserEntity#getId() id} attribute.
     * @param id The value for id (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setId(@Nullable UUID id) {
      this.id = id;
      return this;
    }

    /**
     * Initializes the value for the {@link UserEntity#getName() name} attribute.
     * @param name The value for name 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setName(String name) {
      this.name = Objects.requireNonNull(name, "name");
      initBits &= ~INIT_BIT_NAME;
      return this;
    }

    /**
     * Initializes the value for the {@link UserEntity#getEmail() email} attribute.
     * @param email The value for email 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setEmail(String email) {
      this.email = Objects.requireNonNull(email, "email");
      initBits &= ~INIT_BIT_EMAIL;
      return this;
    }

    /**
     * Initializes the value for the {@link UserEntity#getPassword() password} attribute.
     * @param password The value for password 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setPassword(String password) {
      this.password = Objects.requireNonNull(password, "password");
      initBits &= ~INIT_BIT_PASSWORD;
      return this;
    }

    /**
     * Initializes the value for the {@link UserEntity#getToken() token} attribute.
     * @param token The value for token (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setToken(@Nullable String token) {
      this.token = token;
      return this;
    }

    /**
     * Initializes the value for the {@link UserEntity#getCreated() created} attribute.
     * @param created The value for created (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setCreated(@Nullable OffsetDateTime created) {
      this.created = created;
      return this;
    }

    /**
     * Initializes the value for the {@link UserEntity#getModified() modified} attribute.
     * @param modified The value for modified (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setModified(@Nullable OffsetDateTime modified) {
      this.modified = modified;
      return this;
    }

    /**
     * Initializes the value for the {@link UserEntity#getLastLogin() lastLogin} attribute.
     * @param lastLogin The value for lastLogin (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setLastLogin(@Nullable OffsetDateTime lastLogin) {
      this.lastLogin = lastLogin;
      return this;
    }

    /**
     * Initializes the value for the {@link UserEntity#getIsUserActive() isUserActive} attribute.
     * @param isUserActive The value for isUserActive (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setIsUserActive(@Nullable Boolean isUserActive) {
      this.isUserActive = isUserActive;
      return this;
    }

    /**
     * Adds one element to {@link UserEntity#getPhones() phones} list.
     * @param element A phones element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addPhones(PhoneEntity element) {
      if (this.phones == null) {
        this.phones = ImmutableList.builder();
      }
      this.phones.add(element);
      return this;
    }

    /**
     * Adds elements to {@link UserEntity#getPhones() phones} list.
     * @param elements An array of phones elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addPhones(PhoneEntity... elements) {
      if (this.phones == null) {
        this.phones = ImmutableList.builder();
      }
      this.phones.add(elements);
      return this;
    }


    /**
     * Sets or replaces all elements for {@link UserEntity#getPhones() phones} list.
     * @param elements An iterable of phones elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setPhones(@Nullable Iterable<? extends PhoneEntity> elements) {
      if (elements == null) {
        this.phones = null;
        return this;
      }
      this.phones = ImmutableList.builder();
      return addAllPhones(elements);
    }

    /**
     * Adds elements to {@link UserEntity#getPhones() phones} list.
     * @param elements An iterable of phones elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllPhones(Iterable<? extends PhoneEntity> elements) {
      Objects.requireNonNull(elements, "phones element");
      if (this.phones == null) {
        this.phones = ImmutableList.builder();
      }
      this.phones.addAll(elements);
      return this;
    }

    /**
     * Builds a new {@link ImmutableUserEntity ImmutableUserEntity}.
     * @return An immutable instance of UserEntity
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableUserEntity build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableUserEntity(
          id,
          name,
          email,
          password,
          token,
          created,
          modified,
          lastLogin,
          isUserActive,
          phones == null ? null : phones.build());
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_NAME) != 0) attributes.add("name");
      if ((initBits & INIT_BIT_EMAIL) != 0) attributes.add("email");
      if ((initBits & INIT_BIT_PASSWORD) != 0) attributes.add("password");
      return "Cannot build UserEntity, some of required attributes are not set " + attributes;
    }
  }
}
