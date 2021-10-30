package cl.nisum.bffuser.api.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.Valid;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class FindUserResponse {

    @JsonProperty("id")
    private UUID id = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("email")
    private String email = null;

    @JsonProperty("phones")
    @Valid
    private List<Phone> phones = null;

    @JsonProperty("created")
    private OffsetDateTime created = null;

    @JsonProperty("modified")
    private OffsetDateTime modified = null;

    @JsonProperty("last_login:")
    private OffsetDateTime lastLogin = null;

    @JsonProperty("token")
    private String token = null;

    @JsonProperty("isActive")
    private Boolean isActive = null;

    public FindUserResponse id(UUID id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     * @return id
     **/
    @Schema(example = "3889cbb6-3516-11ec-8d3d-0242ac130003", description = "")

    @Valid
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public FindUserResponse created(OffsetDateTime created) {
        this.created = created;
        return this;
    }

    /**
     * Get created
     * @return created
     **/
    @Schema(example = "2021-07-21T17:32:28Z", description = "")

    @Valid
    public OffsetDateTime getCreated() {
        return created;
    }

    public void setCreated(OffsetDateTime created) {
        this.created = created;
    }

    public FindUserResponse modified(OffsetDateTime modified) {
        this.modified = modified;
        return this;
    }

    /**
     * Get modified
     * @return modified
     **/
    @Schema(example = "2021-09-21T17:32:28Z", description = "")

    @Valid
    public OffsetDateTime getModified() {
        return modified;
    }

    public void setModified(OffsetDateTime modified) {
        this.modified = modified;
    }

    public FindUserResponse lastLogin(OffsetDateTime lastLogin) {
        this.lastLogin = lastLogin;
        return this;
    }

    /**
     * Get lastLogin
     * @return lastLogin
     **/
    @Schema(example = "2021-09-21T17:32:28Z", description = "")

    @Valid
    public OffsetDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(OffsetDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public FindUserResponse token(String token) {
        this.token = token;
        return this;
    }

    /**
     * Get token
     * @return token
     **/
    @Schema(example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c", description = "")

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public FindUserResponse isActive(Boolean isActive) {
        this.isActive = isActive;
        return this;
    }

    /**
     * Get isactive
     * @return isactive
     **/
    @Schema(example = "true", description = "")

    public Boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    /**
     * Get name
     * @return name
     **/
    @Schema(example = "Cristobal Weisser", description = "")

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FindUserResponse email(String email) {
        this.email = email;
        return this;
    }

    /**
     * Get email
     * @return email
     **/
    @Schema(example = "juan@rodriguez.cl", description = "")

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public FindUserResponse phones(List<Phone> phones) {
        this.phones = phones;
        return this;
    }

    public FindUserResponse addPhonesItem(Phone phonesItem) {
        if (this.phones == null) {
            this.phones = new ArrayList<Phone>();
        }
        this.phones.add(phonesItem);
        return this;
    }

    /**
     * Get phones
     * @return phones
     **/
    @Schema(description = "")
    @Valid
    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FindUserResponse userResponse = (FindUserResponse) o;
        return Objects.equals(this.id, userResponse.id) &&
                Objects.equals(this.created, userResponse.created) &&
                Objects.equals(this.modified, userResponse.modified) &&
                Objects.equals(this.lastLogin, userResponse.lastLogin) &&
                Objects.equals(this.token, userResponse.token) &&
                Objects.equals(this.isActive, userResponse.isActive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, created, modified, lastLogin, token, isActive);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UserResponse {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    created: ").append(toIndentedString(created)).append("\n");
        sb.append("    modified: ").append(toIndentedString(modified)).append("\n");
        sb.append("    lastLogin: ").append(toIndentedString(lastLogin)).append("\n");
        sb.append("    token: ").append(toIndentedString(token)).append("\n");
        sb.append("    isactive: ").append(toIndentedString(isActive)).append("\n");
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
