package cl.nissum.register.data.datasource.impl.database.gateway;

import cl.nissum.register.data.datasource.impl.database.model.UserDataBaseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface UserDataSourceGateway extends JpaRepository<UserDataBaseModel, UUID> {

    @Query(value="SELECT id, name, email, password,token,active,created, modified ,last_login from user where email=:email ", nativeQuery = true)
     Optional<UserDataBaseModel> findByEmail(@Param("email") String email);

}
