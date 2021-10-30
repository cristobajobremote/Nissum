package cl.nisum.bffuser.domain.entity;

import org.immutables.value.Value;

import javax.annotation.Nullable;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Value.Immutable
@Value.Style(get = "get*", init = "set*")
public abstract class UserEntity {
    @Nullable
    public abstract UUID getId();

    public abstract String getName();

    public abstract String getEmail();

    public abstract String getPassword();
    @Nullable
    public abstract String getToken();
    @Nullable
    public abstract OffsetDateTime getCreated();
    @Nullable
    public abstract OffsetDateTime getModified();
    @Nullable
    public abstract OffsetDateTime getLastLogin();
    @Nullable
    public abstract Boolean getIsUserActive();
    @Nullable
    public abstract List<PhoneEntity> getPhones();


}
