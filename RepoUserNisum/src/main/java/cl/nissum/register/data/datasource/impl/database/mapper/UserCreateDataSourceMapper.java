package cl.nissum.register.data.datasource.impl.database.mapper;


import cl.nissum.register.data.datasource.impl.database.model.PhoneDataBaseModel;
import cl.nissum.register.data.datasource.impl.database.model.UserDataBaseModel;
import cl.nissum.register.domain.entity.PhoneEntity;
import cl.nissum.register.domain.entity.UserEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

@Mapper(componentModel = "spring",imports = {Timestamp.class, Instant.class, UUID.class}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserCreateDataSourceMapper {


    @Mapping(target = "id", source ="id")
    @Mapping(target = "name", source ="userEntity.name" )
    @Mapping(target = "email", source ="userEntity.email" )
    @Mapping(target = "password", source ="userEntity.password" )
    @Mapping(target = "token", source ="userEntity.token" )
    @Mapping(target = "created", expression = "java(new Timestamp(Instant.now().toEpochMilli()))" )
    @Mapping(target = "modified", ignore = true )
    @Mapping(target = "lastLogin", expression =  "java(new Timestamp(Instant.now().toEpochMilli()))" )
    @Mapping(target = "active", source ="userEntity.isUserActive" )
    @Mapping(target = "phones", source ="userEntity.phones" )
    UserDataBaseModel mapDomainEntityToDataSourceModel(UserEntity userEntity, String id);

    @Mapping(target = "id", expression ="java(phone.getId()!=null ? phone.getId().toString() : null )" )
    @Mapping(target = "number", source ="number" )
    @Mapping(target = "cityCode", source ="cityCode" )
    @Mapping(target = "countryCode", source ="countryCode" )
    PhoneDataBaseModel mapDomainEntityToDataSourceModel(PhoneEntity phone);

    @Mapping(target = "id", expression ="java(userEntity.getId().toString())")
    @Mapping(target = "name", source ="userEntity.name" )
    @Mapping(target = "email", source ="userEntity.email" )
    @Mapping(target = "password", source ="userEntity.password" )
    @Mapping(target = "token", source ="userEntity.token" )
    @Mapping(target = "created", expression = "java(new Timestamp(Instant.now().toEpochMilli()))" )
    @Mapping(target = "modified", ignore = true )
    @Mapping(target = "lastLogin", expression =  "java(new Timestamp(Instant.now().toEpochMilli()))" )
    @Mapping(target = "active", source ="userEntity.isUserActive" )
    @Mapping(target = "phones", source ="userEntity.phones" )
    UserDataBaseModel mapDomainEntityToDataSourceModel(UserEntity userEntity);
}
