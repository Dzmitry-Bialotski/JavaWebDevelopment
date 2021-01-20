package by.belotskiy.multithreading.exception;

public class CarTransferException extends Exception{
    public CarTransferException() {
        super();
    }
    public CarTransferException(String message) {
        super(message);
    }

    public CarTransferException(String message, Throwable cause) {
        super(message, cause);
    }

    public CarTransferException(Throwable cause) {
        super(cause);
    }

}
