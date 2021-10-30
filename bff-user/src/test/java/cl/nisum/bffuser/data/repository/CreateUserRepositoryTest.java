package cl.nisum.bffuser.data.repository;

import cl.nisum.bffuser.common.exception.DataSourceException;
import cl.nisum.bffuser.common.exception.RepositoryException;
import cl.nisum.bffuser.data.datasource.impl.database.CreateUserDataSource;
import cl.nisum.bffuser.domain.entity.ImmutableUserEntity;
import cl.nisum.bffuser.domain.entity.UserEntity;
import org.hibernate.exception.SQLGrammarException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;
@RunWith(MockitoJUnitRunner.class)
public class CreateUserRepositoryTest {
    @InjectMocks
    private CreateUserRepository createUserRepository;
    @Mock
    private CreateUserDataSource createUserDataSource;

    UserEntity userEntity;

    public void setUp(){
        userEntity= ImmutableUserEntity.builder().setEmail("cristobalweisser@gmail.com").build();
    }
    @Test
    public void when_create_user_then_save(){
        doAnswer(i-> null).when(createUserDataSource).create(userEntity);
        createUserRepository.create(userEntity);
        verify(createUserDataSource).create(userEntity);
    }
    @Test(expected = DataSourceException.class)
    public void when_create_user_then_return_DataSourceException(){
        doThrow(DataSourceException.class).when(createUserDataSource).create(userEntity);
        createUserRepository.create(userEntity);
        verify(createUserDataSource).create(userEntity);
    }

    @Test(expected = RepositoryException.class)
    public void when_create_user_then_return_SQLGrammarException(){
        doThrow(SQLGrammarException.class).when(createUserDataSource).create(userEntity);
        createUserRepository.create(userEntity);
        verify(createUserDataSource).create(userEntity);
    }
}