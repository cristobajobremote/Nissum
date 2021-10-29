package cl.nissum.register.data.datasource.impl.database.gateway;

import cl.nissum.register.common.enumeration.ExceptionTextEnum;
import cl.nissum.register.common.exception.NotImplementedException;
import cl.nissum.register.data.datasource.impl.database.model.PhoneDataBaseModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PhoneDataSourceGateway extends JpaRepository<PhoneDataBaseModel, UUID> {

    default Optional<PhoneDataBaseModel> findById(UUID uuid){
        throw new NotImplementedException(ExceptionTextEnum.MESSAGE_WARNING_FEATURE_NOT_IMPLEMENTED.getValue());
    }
}
