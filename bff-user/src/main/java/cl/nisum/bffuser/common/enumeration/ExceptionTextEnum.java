package cl.nisum.bffuser.common.enumeration;

public enum ExceptionTextEnum {

    SEVERITY_WARNING("WARNING"),
    SEVERITY_ERROR("ERROR"),
    MESSAGE_WARNING_FEATURE_NOT_IMPLEMENTED("Feature not implemented"),
    USER_NOT_EXIST_EXCEPTION("The user not exists in our databases"),
    USER_EXIST_EXCEPTION("The user already exists in our databases");

    private String value;

    ExceptionTextEnum(String value){
        this.value = value;
    }
    public String getValue(){
        return value;
    }

}
