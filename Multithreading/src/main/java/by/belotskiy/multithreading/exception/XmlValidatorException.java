package by.belotskiy.multithreading.exception;

public class XmlValidatorException extends Exception{

    public XmlValidatorException() {
        super();
    }

    public XmlValidatorException(String message) {
        super(message);
    }

    public XmlValidatorException(String message, Throwable cause) {
        super(message, cause);
    }

    public XmlValidatorException(Throwable cause) {
        super(cause);
    }

}
