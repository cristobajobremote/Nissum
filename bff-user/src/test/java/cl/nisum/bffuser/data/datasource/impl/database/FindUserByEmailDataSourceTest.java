package cl.nisum.bffuser.data.datasource.impl.database;

import cl.nisum.bffuser.common.exception.DataSourceException;
import cl.nisum.bffuser.common.exception.UserNotExistException;
import cl.nisum.bffuser.data.datasource.impl.database.gateway.UserDataSourceGateway;
import cl.nisum.bffuser.data.datasource.impl.database.model.UserDataBaseModel;
import org.hibernate.exception.SQLGrammarException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertNotNull;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class FindUserByEmailDataSourceTest {

    @InjectMocks
    private FindUserByEmailDataSource findUserByEmailDataSource;

    @Mock
    private  UserDataSourceGateway userDataSourceGateway;


    private UserDataBaseModel userDataBaseModelFounded;

    @Before
    public void setUp(){
        userDataBaseModelFounded = new UserDataBaseModel();
        userDataBaseModelFounded.setEmail("cristobal@gmail.com");
    }
    @Test
    public void given_find_user_then_return_response(){
        when(userDataSourceGateway.findByEmail(anyString())).thenReturn(Optional.ofNullable(userDataBaseModelFounded));
        Optional<UserDataBaseModel> userDataBaseModel = findUserByEmailDataSource.findUserByEmail("cristobal@gmail.com");
        assertNotNull(userDataBaseModel);

    }

    @Test (expected = UserNotExistException.class)
    public void given_find_user_then_not_exist_return_UserNotExistException(){
        when(userDataSourceGateway.findByEmail(anyString())).thenThrow(UserNotExistException.class);

        findUserByEmailDataSource.findUserByEmail("cristobal@gmail.com");

        verify(userDataSourceGateway).findByEmail("cristobal@gmail.com");

    }

    @Test (expected = DataSourceException.class)
    public void given_find_user_then_return_SQLGrammarException(){
        when(userDataSourceGateway.findByEmail(anyString())).thenThrow(SQLGrammarException.class);

        findUserByEmailDataSource.findUserByEmail("cristobal@gmail.com");
        verify(userDataSourceGateway).findByEmail("cristobal@gmail.com");

    }
}