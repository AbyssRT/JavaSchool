import java.io.PrintStream;
import java.util.Scanner;

public class MainLuckyNumber {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        PrintStream sout = System.out;
        String instr;
        String number;
        String lucky;
        while (true) {
            do {
                sout.println("Введите шестизначное число:");
                instr = scn.nextLine();
            } while (validator(instr));
            number = String.format("%06d", Integer.valueOf(instr));
            var v1 = number.substring(0, 3);
            var v2 = number.substring(3, 6);
            if (v1.equals(v2)) {
                lucky = "счастливый";
            } else {
                lucky = "не счастливый";
            }
            sout.format("%s %s номер билета\n", number, lucky);
        }
    }

    static boolean validator(String instr) {
        boolean flag = false;
        PrintStream sout = System.out;
        if (instr.length() > 6) {
            sout.println("Ошибка! Необходимо ввести число из шести знаков или меньше");
            flag = true;
        }
        try {
            int i = Integer.valueOf(instr);
            if (i<0) {
                sout.println("Ошибка! Номер билета не может быть отрицательным");
                flag = true;
            }
        } catch (NumberFormatException e) {
            sout.println(e.toString());
            sout.println("Ошибка! Это не целое число билета");
            flag = true;
        }
        return flag;
    }
}
