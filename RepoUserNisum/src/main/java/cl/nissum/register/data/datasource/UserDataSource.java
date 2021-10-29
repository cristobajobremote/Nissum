package cl.nissum.register.data.datasource;

import cl.nissum.register.common.enumeration.ExceptionTextEnum;
import cl.nissum.register.common.exception.NotImplementedException;
import cl.nissum.register.data.datasource.impl.database.model.UserDataBaseModel;
import cl.nissum.register.domain.entity.UserEntity;

import java.util.Optional;

public interface UserDataSource {

    default  void create(UserEntity userEntity){
        throw new NotImplementedException(ExceptionTextEnum.MESSAGE_WARNING_FEATURE_NOT_IMPLEMENTED.getValue());
    }

    default Optional<UserDataBaseModel> findUserByEmail(String email){
        throw new NotImplementedException(ExceptionTextEnum.MESSAGE_WARNING_FEATURE_NOT_IMPLEMENTED.getValue());
    }
}
