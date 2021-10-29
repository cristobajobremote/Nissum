package cl.nissum.register.domain.repository;

import cl.nissum.register.common.enumeration.ExceptionTextEnum;
import cl.nissum.register.common.exception.NotImplementedException;
import cl.nissum.register.domain.entity.UserEntity;

public interface UserRepository {

    default void create(UserEntity userEntity){
        throw new NotImplementedException(ExceptionTextEnum.MESSAGE_WARNING_FEATURE_NOT_IMPLEMENTED.getValue());
    }

    default UserEntity findUserByEmail(String email){
        throw new NotImplementedException(ExceptionTextEnum.MESSAGE_WARNING_FEATURE_NOT_IMPLEMENTED.getValue());
    }
}
