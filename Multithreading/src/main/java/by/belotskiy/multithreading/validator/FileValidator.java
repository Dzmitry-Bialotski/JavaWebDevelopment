package by.belotskiy.multithreading.validator;

import by.belotskiy.multithreading.exception.XmlValidatorException;

public interface FileValidator {
    boolean validate(String filePath,String sxdName) throws XmlValidatorException;
}
