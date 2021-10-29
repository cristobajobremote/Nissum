package cl.nissum.register.domain.entity;


import org.immutables.value.Value;

import javax.annotation.Nullable;
import java.math.BigDecimal;
import java.util.UUID;

@Value.Immutable
@Value.Style(get = "get*", init = "set*")
public abstract class PhoneEntity {
    @Nullable
    public abstract UUID getId();

    public abstract String getNumber() ;

    public abstract int getCityCode();

    public abstract int getCountryCode();



}
