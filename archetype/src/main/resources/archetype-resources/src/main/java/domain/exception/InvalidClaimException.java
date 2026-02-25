package ${package}.domain.exception;

public class InvalidClaimException extends Exception{

    public InvalidClaimException(String errorMessage) {
        super(errorMessage);
    }
}
