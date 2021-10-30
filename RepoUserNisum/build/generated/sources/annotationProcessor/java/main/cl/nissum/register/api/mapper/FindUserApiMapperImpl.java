package cl.nissum.register.api.mapper;

import cl.nissum.register.api.swagger.model.FindUserResponse;
import cl.nissum.register.api.swagger.model.Phone;
import cl.nissum.register.domain.entity.PhoneEntity;
import cl.nissum.register.domain.entity.UserEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-10-29T16:08:54-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 15.0.2 (Oracle Corporation)"
)
@Component
public class FindUserApiMapperImpl implements FindUserApiMapper {

    @Override
    public FindUserResponse mapDomainEntityToApiModel(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        FindUserResponse findUserResponse = new FindUserResponse();

        findUserResponse.setLastLogin( userEntity.getLastLogin() );
        findUserResponse.setCreated( userEntity.getCreated() );
        findUserResponse.setName( userEntity.getName() );
        findUserResponse.setModified( userEntity.getModified() );
        findUserResponse.setId( userEntity.getId() );
        findUserResponse.setIsActive( userEntity.getIsUserActive() );
        findUserResponse.setEmail( userEntity.getEmail() );
        findUserResponse.setToken( userEntity.getToken() );
        findUserResponse.setPhones( phoneEntityListToPhoneList( userEntity.getPhones() ) );

        return findUserResponse;
    }

    protected Phone phoneEntityToPhone(PhoneEntity phoneEntity) {
        if ( phoneEntity == null ) {
            return null;
        }

        Phone phone = new Phone();

        phone.setNumber( phoneEntity.getNumber() );
        phone.setCityCode( phoneEntity.getCityCode() );
        phone.setCountryCode( phoneEntity.getCountryCode() );

        return phone;
    }

    protected List<Phone> phoneEntityListToPhoneList(List<PhoneEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<Phone> list1 = new ArrayList<Phone>( list.size() );
        for ( PhoneEntity phoneEntity : list ) {
            list1.add( phoneEntityToPhone( phoneEntity ) );
        }

        return list1;
    }
}
