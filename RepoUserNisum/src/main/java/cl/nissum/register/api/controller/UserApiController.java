package cl.nissum.register.api.controller;

import cl.nissum.register.api.delegate.FindUserDelegate;
import cl.nissum.register.api.delegate.RegisterUserDelegate;
import cl.nissum.register.api.passport.JWTToken;
import cl.nissum.register.api.swagger.model.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;



@Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-10-24T22:11:56.183Z[GMT]")
@RestController
public class UserApiController implements UserApi {

    private static final Logger log = LoggerFactory.getLogger(UserApiController.class);

    private final RegisterUserDelegate registerUserDelegate;
    private final FindUserDelegate findUserDelegate;
    private final ObjectMapper objectMapper;
    private final JWTToken jwtToken;
    private final HttpServletRequest request;

    @Autowired
    public UserApiController(RegisterUserDelegate registerUserDelegate,
                             FindUserDelegate findUserDelegate,
                             ObjectMapper objectMapper,
                             HttpServletRequest request,
                             JWTToken jwtToken) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.registerUserDelegate = registerUserDelegate;
        this.findUserDelegate = findUserDelegate;
        this.jwtToken = jwtToken;
    }

    public ResponseEntity<CreateUserResponse> registerUser(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody UserRequest requestBody) {
        String contentType = request.getHeader("Content-Type");

        if (contentType != null && contentType.contains("application/json")) {
            return  registerUserDelegate.registerUser(requestBody, request);
        }

        return new ResponseEntity<CreateUserResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<FindUserResponse> findUser(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody FindUserRequest findUserRequest) {
        String contentType = request.getHeader("Content-Type");
        if (contentType != null && contentType.contains("application/json")) {
            return findUserDelegate.findUserResponse(findUserRequest);
        }
        return new ResponseEntity<FindUserResponse>(HttpStatus.NOT_IMPLEMENTED);
    }


    @Override
    public ResponseEntity<PassportToken> passport(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody PassportUser passportUser) {
        String contentType = request.getHeader("Content-Type");
        if (contentType != null && contentType.contains("application/json")) {
            PassportToken passportToken= new PassportToken();
            passportToken.setToken(jwtToken.getJWTToken(passportUser.getName()));
            return ResponseEntity.ok(passportToken);
        }
        return new ResponseEntity<PassportToken>(HttpStatus.NOT_IMPLEMENTED);
    }

}
