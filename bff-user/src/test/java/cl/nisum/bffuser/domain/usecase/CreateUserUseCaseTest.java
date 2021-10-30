package cl.nisum.bffuser.domain.usecase;

import cl.nisum.bffuser.api.mapper.CreateUserApiMapper;
import cl.nisum.bffuser.api.swagger.model.Phone;
import cl.nisum.bffuser.api.swagger.model.UserRequest;
import cl.nisum.bffuser.api.validator.ValidatorData;
import cl.nisum.bffuser.common.exception.*;
import cl.nisum.bffuser.data.repository.CreateUserRepository;
import cl.nisum.bffuser.data.repository.FindUserByEmailRepository;
import cl.nisum.bffuser.domain.entity.ImmutableUserEntity;
import cl.nisum.bffuser.domain.entity.UserEntity;
import org.hibernate.exception.SQLGrammarException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;
@RunWith(MockitoJUnitRunner.class)
public class CreateUserUseCaseTest {

    @InjectMocks
    private CreateUserUseCase createUserUseCase;
    @Mock
    private  CreateUserApiMapper userCreateApiMapper;
    @Mock
    private  ValidatorData validatorData;
    @Mock
    private CreateUserRepository createUserRepository;
    @Mock
    private FindUserByEmailRepository findUserByEmailRepository;

    UserEntity userEntity;
    UserRequest userRequest;
    String token;
    String email;
    Phone phone;
    @Before
    public void setUp(){
        token = "vsdfsdfsfsdsdg";
        userRequest = new UserRequest();
        userEntity= ImmutableUserEntity.builder().setEmail("cristobalweisser@gmail.com").
                setName("Cristobal").setPassword("password").build();
        email = "cristobalweisser@gmail.com";
        phone = new Phone();
    }


    @Test (expected = PasswordException.class )
    public void when_create_then_save_and_return_PasswordException() {
        when(userCreateApiMapper.mapApiModelToDomainEntity(any(),any())).thenReturn(userEntity);
        when(validatorData.isValidPassword(any())).thenReturn(false);
        createUserUseCase.create(userRequest,token);
        verify(createUserRepository).create(userEntity);
    }

    @Test (expected = EmailUserException.class )
    public void when_create_then_save_and_return_EmailUserException() {
        when(userCreateApiMapper.mapApiModelToDomainEntity(any(),any())).thenReturn(userEntity);
        when(validatorData.isValidPassword(any())).thenReturn(true);
        when(validatorData.isValidEmail(any())).thenReturn(false);
        createUserUseCase.create(userRequest,token);
        verify(createUserRepository).create(userEntity);
    }
}