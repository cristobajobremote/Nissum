package cl.nisum.bffuser.api.mapper;

import cl.nisum.bffuser.api.swagger.model.FindUserResponse;
import cl.nisum.bffuser.domain.entity.UserEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)

public interface FindUserApiMapper {

    @Mapping(target = "id", source ="id")
    @Mapping(target = "name", source ="name")
    @Mapping(target = "email", source ="email")
    @Mapping(target = "token", source ="token" )
    @Mapping(target = "created", source ="created" )
    @Mapping(target = "modified", source ="modified" )
    @Mapping(target = "lastLogin", source ="lastLogin" )
    @Mapping(target = "isActive", source ="isUserActive" )
    FindUserResponse mapDomainEntityToApiModel(UserEntity userEntity);
}
