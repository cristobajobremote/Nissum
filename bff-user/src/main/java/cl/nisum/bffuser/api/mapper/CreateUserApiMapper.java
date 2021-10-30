package cl.nisum.bffuser.api.mapper;

import cl.nisum.bffuser.api.swagger.model.CreateUserResponse;
import cl.nisum.bffuser.api.swagger.model.Phone;
import cl.nisum.bffuser.api.swagger.model.UserRequest;
import cl.nisum.bffuser.domain.entity.PhoneEntity;
import cl.nisum.bffuser.domain.entity.UserEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CreateUserApiMapper {

    @Mapping(target = "id", source ="id")
    @Mapping(target = "token", source ="token" )
    @Mapping(target = "created", source ="created" )
    @Mapping(target = "modified", source ="modified" )
    @Mapping(target = "lastLogin", source ="lastLogin" )
    @Mapping(target = "isactive", source ="isUserActive" )
    CreateUserResponse mapDomainEntityToApiModel(UserEntity userEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "modified", ignore = true)
    @Mapping(target = "lastLogin", ignore = true)
    @Mapping(target = "isUserActive", ignore = true)
    @Mapping(target = "name", source ="userRequest.name")
    @Mapping(target = "email", source ="userRequest.email" )
    @Mapping(target = "password", source ="userRequest.password" )
    @Mapping(target = "token", source ="token" )
    @Mapping(target = "phones", source ="userRequest.phones" )
    UserEntity mapApiModelToDomainEntity(UserRequest userRequest, String token);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "number", source ="number" )
    @Mapping(target = "cityCode",  source ="cityCode")
    @Mapping(target = "countryCode", source ="countryCode" )
    PhoneEntity mapApiModelToDomainEntity(Phone phone);
}
