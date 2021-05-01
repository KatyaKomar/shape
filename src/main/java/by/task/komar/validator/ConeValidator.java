package by.task.komar.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConeValidator {
    final static String CONE_REGULAR = "^(((-?(((\\d)+\\.?(\\d)*)|((\\d)*\\.?(\\d)+)))(\\s)+){3})(^([1-9](\\d)*\\.?(\\d)*)|((\\d)*\\.?(\\d)*[1-9](\\d)*))(\\s)+(([1-9](\\d)*\\.?(\\d)*)|((\\d)*\\.?(\\d)*[1-9](\\d)*))$";

    public static boolean isValidate(String data) {
        Pattern pattern = Pattern.compile(CONE_REGULAR);
        Matcher matcher = pattern.matcher(data);
        return matcher.matches();
    }
}
