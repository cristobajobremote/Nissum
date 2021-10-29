package cl.nissum.register.api.mapper;

import cl.nissum.register.api.swagger.model.CreateUserResponse;
import cl.nissum.register.api.swagger.model.Phone;
import cl.nissum.register.api.swagger.model.UserRequest;
import cl.nissum.register.domain.entity.ImmutablePhoneEntity;
import cl.nissum.register.domain.entity.ImmutableUserEntity;
import cl.nissum.register.domain.entity.ImmutableUserEntity.Builder;
import cl.nissum.register.domain.entity.PhoneEntity;
import cl.nissum.register.domain.entity.UserEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-10-29T11:27:36-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 15.0.2 (Oracle Corporation)"
)
@Component
public class CreateUserApiMapperImpl implements CreateUserApiMapper {

    @Override
    public CreateUserResponse mapDomainEntityToApiModel(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        CreateUserResponse createUserResponse = new CreateUserResponse();

        createUserResponse.setLastLogin( userEntity.getLastLogin() );
        createUserResponse.setCreated( userEntity.getCreated() );
        createUserResponse.setIsactive( userEntity.getIsUserActive() );
        createUserResponse.setModified( userEntity.getModified() );
        createUserResponse.setId( userEntity.getId() );
        createUserResponse.setToken( userEntity.getToken() );

        return createUserResponse;
    }

    @Override
    public UserEntity mapApiModelToDomainEntity(UserRequest userRequest, String token) {
        if ( userRequest == null && token == null ) {
            return null;
        }

        Builder userEntity = ImmutableUserEntity.builder();

        if ( userRequest != null ) {
            userEntity.setPassword( userRequest.getPassword() );
            userEntity.setName( userRequest.getName() );
            userEntity.setPhones( phoneListToPhoneEntityIterable( userRequest.getPhones() ) );
            userEntity.setEmail( userRequest.getEmail() );
        }
        if ( token != null ) {
            userEntity.setToken( token );
        }

        return userEntity.build();
    }

    @Override
    public PhoneEntity mapApiModelToDomainEntity(Phone phone) {
        if ( phone == null ) {
            return null;
        }

        cl.nissum.register.domain.entity.ImmutablePhoneEntity.Builder phoneEntity = ImmutablePhoneEntity.builder();

        phoneEntity.setNumber( phone.getNumber() );
        phoneEntity.setCityCode( phone.getCityCode() );
        phoneEntity.setCountryCode( phone.getCountryCode() );

        return phoneEntity.build();
    }

    protected Iterable<PhoneEntity> phoneListToPhoneEntityIterable(List<Phone> list) {
        if ( list == null ) {
            return null;
        }

        ArrayList<PhoneEntity> iterable = new ArrayList<PhoneEntity>( list.size() );
        for ( Phone phone : list ) {
            iterable.add( mapApiModelToDomainEntity( phone ) );
        }

        return iterable;
    }
}
