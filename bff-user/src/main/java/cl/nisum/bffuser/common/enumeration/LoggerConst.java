package cl.nisum.bffuser.common.enumeration;

public enum LoggerConst {

    TAG_SUCCESS_EXECUTE_USER_CREATE("SUCCESS_EXECUTE_USER_CREATE"),
    TAG_FAILURE_EXECUTE_USER_CREATE("FAILURE_EXECUTE_USER_CREATE"),
    TAG_FAILURE_EXECUTE_USER_FIND("FAILURE_EXECUTE_USER_FIND");

    private String value;

    LoggerConst(String value){
        this.value = value;

    }
    public String getValue(){
        return value;
    }
}
