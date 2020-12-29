package by.belotskiy.shapes.parser;

import by.belotskiy.shapes.validator.EllipseValidator;

import java.util.ArrayList;
import java.util.List;

public class EllipseParser {
    private static final String DELIMITER = "\\s";

    public List<Integer> parse(String data){
        List<Integer> coords = new ArrayList<>();
        if(EllipseValidator.isCorrect(data)){
            String[] numbers = data.split(DELIMITER);
            for(String number : numbers){
                coords.add(Integer.parseInt(number));
            }
        }
        return coords;
    }
}
