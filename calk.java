import java.util.Scanner;
import java.lang.Exception;
public class calk {
    public static void main(String[] args) throws Exception {
        String string = new String();
        calc(string);

    }

    public static String calc(String input) throws Exception {
        System.out.println("Введие уравнение");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strings = str.split(" ", 3);
        int l1 = str.length();
        str = str.replaceAll("\\s+","");
        int l2 = str.length();
        int l3 = l1 - l2;
        if (l3!=2){
            throw new Exception("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)\n" +
                    "\n");
        }

        try {
            boolean arabNumb2 = IsIntegerCheck.isIntegerCheck(strings[2]);
        } catch (ArrayIndexOutOfBoundsException exp) {
            System.out.println("Не является математическим выражением");
        }
        boolean arabNumbs1 = IsIntegerCheck.isIntegerCheck(strings[0]);
        boolean arabNumbs2 = IsIntegerCheck.isIntegerCheck(strings[2]);
        if (arabNumbs1 && arabNumbs2) {
            int an1 = Integer.parseInt(strings[0]);
            int an2 = Integer.parseInt(strings[2]);
            if (an1<1 || an1>10 || an2<1 || an2>10){
                throw new Exception("Неудовлетворительное значение переменных");
            }
            String ss = new String();
            ss = strings[1];
            int sum;
            switch (ss) {
                case "-":
                    sum = an1 - an2;
                    String value = Integer.toString(sum);
                    System.out.println(sum);
                    break;
                case "/":
                    sum = an1 / an2;
                    String value1 = Integer.toString(sum);
                    System.out.println(sum);
                    break;
                case "*":
                    sum = an1 * an2;
                    String value2 = Integer.toString(sum);
                    System.out.println(sum);
                    break;
                case "+":
                    sum = an1 + an2;
                    String value3 = Integer.toString(sum);
                    System.out.println(sum);
                    break;
                default: throw new Exception("не является математической операцией");
            }
        } else if (arabNumbs1 != arabNumbs2){
            throw new Exception("Разные системы счисления");
        } else if (!arabNumbs1 && !arabNumbs2) {
            romeNumbs rome1 = romeNumbs.valueOf(strings[0]);
            romeNumbs rome2 = romeNumbs.valueOf(strings[2]);
            int rn1 = rome1.getArab();
            int rn2 = rome2.getArab();
            int rn3;
            if(rn1<1 || rn1>10 || rn2<1 || rn2>10){
                throw new Exception("Неудовлетворительные значения переменных");
            };
            String ss = new String();
            ss = strings[1];

            switch (ss) {
                case "-":
                    rn3 = rn1 - rn2;
                    if (rn3<0){
                        throw new Exception("В римской системе нет отрицательных чисел");
                    } else if (rn3 == 0){
                        throw new Exception("В римской системе нет нуля");
                    }
                    System.out.println(romeNumbs.values()[rn3]);
                    break;
                case "/":
                    rn3 = rn1 / rn2;
                    System.out.println(romeNumbs.values()[rn3]);
                    break;
                case "*":
                    rn3 = rn1 * rn2;
                    System.out.println(romeNumbs.values()[rn3]);
                    break;
                case "+":
                    rn3 = rn1 + rn2;
                    System.out.println(romeNumbs.values()[rn3]);
                    break;
                default: throw new Exception("не является математической операцией");
            }
        }
        return str;
    }
}