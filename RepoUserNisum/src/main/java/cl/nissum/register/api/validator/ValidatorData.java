package cl.nissum.register.api.validator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ValidatorData {
    @Value("${regular.phrase.password}")
    private String regularPassword;
    @Value("${regular.phrase.email}")
    private String regularEmail;

    public  boolean isValidEmail(String email){
        Pattern pat = Pattern.compile(regularEmail);
        return isValid(email, pat);
    }

    public boolean isValidPassword(String password){
        Pattern pat = Pattern.compile(regularPassword);
        return isValid(password, pat);
    }

    private boolean isValid(String field, Pattern pat) {
        Matcher mat = pat.matcher(field);
        return mat.matches();
    }


}
