package cl.nisum.bffuser.data.datasource.impl.database.mapper;

import cl.nisum.bffuser.data.datasource.impl.database.model.PhoneDataBaseModel;
import cl.nisum.bffuser.data.datasource.impl.database.model.UserDataBaseModel;
import cl.nisum.bffuser.domain.entity.PhoneEntity;
import cl.nisum.bffuser.domain.entity.UserEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.UUID;

@Mapper(componentModel = "spring", imports = {OffsetDateTime.class, ZoneId.class, Instant.class, UUID.class}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserFindDataSourceMapper {

    @Mapping(target = "id", expression="java(UUID.fromString(userDataBaseModel.getId()))")
    @Mapping(target = "name", source ="name" )
    @Mapping(target = "email", source ="email" )
    @Mapping(target = "password", source ="password" )
    @Mapping(target = "token", source ="token" )
    @Mapping(target = "created", expression ="java( userDataBaseModel.getCreated()!=null ? OffsetDateTime.ofInstant(Instant.ofEpochMilli(userDataBaseModel.getCreated().getTime()), ZoneId.systemDefault()): null)" )
    @Mapping(target = "modified", expression ="java(userDataBaseModel.getModified()!=null ? OffsetDateTime.ofInstant(Instant.ofEpochMilli(userDataBaseModel.getModified().getTime()), ZoneId.systemDefault()): null)" )
    @Mapping(target = "lastLogin", expression ="java(userDataBaseModel.getLastLogin()!=null ? OffsetDateTime.ofInstant(Instant.ofEpochMilli(userDataBaseModel.getLastLogin().getTime()), ZoneId.systemDefault()): null)"  )
    @Mapping(target = "isUserActive", source ="active" )
    @Mapping(target = "phones", source ="phones" )
    UserEntity mapDataSourceModelToDomainEntity(UserDataBaseModel userDataBaseModel);

    @Mapping(target = "id", expression ="java(UUID.fromString(phone.getId()))" )
    @Mapping(target = "number", source ="number" )
    @Mapping(target = "cityCode", source ="cityCode" )
    @Mapping(target = "countryCode", source ="countryCode" )
    PhoneEntity mapDomainEntityToDataSourceModel(PhoneDataBaseModel  phone);
}
