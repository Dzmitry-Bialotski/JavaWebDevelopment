package by.belotskiy.shapes.validator;

import java.io.File;

public class FileValidator {

    public static boolean isExistAndNotEmpty(String fileName){
        if(fileName == null){
            return false;
        }
        File file = new File(fileName);
        boolean isExist = file.isFile();
        boolean isNotEmpty = !(file.length() == 0);
        return isExist && isNotEmpty;
    }
}
