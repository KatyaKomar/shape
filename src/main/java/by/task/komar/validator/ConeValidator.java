package by.task.komar.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConeValidator {
    final static String CONEREGULAR = "^(((-?(((\\d)+\\.?(\\d)*)|((\\d)*\\.?(\\d)+)))(\\s)+){3})(^([1-9](\\d)*\\.?(\\d)*)|((\\d)*\\.?(\\d)*[1-9](\\d)*))(\\s)+(([1-9](\\d)*\\.?(\\d)*)|((\\d)*\\.?(\\d)*[1-9](\\d)*))$";

    public static boolean isValidate(String string) {
        Pattern pattern = Pattern.compile(CONEREGULAR);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }
}
