public class IsIntegerCheck {
    static boolean isIntegerCheck(String s) {
        try {
         Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
        }
        return false;
    }
}
