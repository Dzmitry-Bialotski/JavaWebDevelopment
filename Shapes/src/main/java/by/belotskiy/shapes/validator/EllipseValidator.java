package by.belotskiy.shapes.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EllipseValidator {
    private static final String ELLIPSE_PATTERN_INPUT = "^-?\\d+\\s-?\\d+\\s-?\\d+\\s-?\\d+$";

    public static boolean isCorrect(String input){
        Pattern pattern = Pattern.compile(ELLIPSE_PATTERN_INPUT);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
