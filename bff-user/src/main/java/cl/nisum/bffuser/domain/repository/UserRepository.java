package cl.nisum.bffuser.domain.repository;

import cl.nisum.bffuser.common.enumeration.ExceptionTextEnum;
import cl.nisum.bffuser.common.exception.NotImplementedException;
import cl.nisum.bffuser.domain.entity.UserEntity;

public interface UserRepository {

    default void create(UserEntity userEntity){
        throw new NotImplementedException(ExceptionTextEnum.MESSAGE_WARNING_FEATURE_NOT_IMPLEMENTED.getValue());
    }

    default UserEntity findUserByEmail(String email){
        throw new NotImplementedException(ExceptionTextEnum.MESSAGE_WARNING_FEATURE_NOT_IMPLEMENTED.getValue());
    }
}
