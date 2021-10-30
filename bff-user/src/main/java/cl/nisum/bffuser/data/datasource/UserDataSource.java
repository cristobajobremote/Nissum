package cl.nisum.bffuser.data.datasource;

import cl.nisum.bffuser.common.enumeration.ExceptionTextEnum;
import cl.nisum.bffuser.common.exception.NotImplementedException;
import cl.nisum.bffuser.data.datasource.impl.database.model.UserDataBaseModel;
import cl.nisum.bffuser.domain.entity.UserEntity;

import java.util.Optional;

public interface UserDataSource {

    default  void create(UserEntity userEntity){
        throw new NotImplementedException(ExceptionTextEnum.MESSAGE_WARNING_FEATURE_NOT_IMPLEMENTED.getValue());
    }

    default Optional<UserDataBaseModel> findUserByEmail(String email){
        throw new NotImplementedException(ExceptionTextEnum.MESSAGE_WARNING_FEATURE_NOT_IMPLEMENTED.getValue());
    }
}
