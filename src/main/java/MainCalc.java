import javax.naming.Context;
import java.io.PrintStream;
import java.util.Scanner;

public class MainCalc {
    static final PrintStream sout = System.out;
    static final Scanner scn = new Scanner(System.in);
    static boolean flagOk;
    static String strtype;
    static boolean zeroErr;

    public static void main(String[] args) {
        float var1;
        float var2;
        byte oper;
        String out;

        while (true) {
            zeroErr = false;
            flagOk = true;
            do {
                sout.print("Введите первый операнд: ");
                var1 = validatorOprnd(scn.nextLine());
            } while (flagOk);

            flagOk = true;
            do {
                sout.print("Введите второй операнд: ");
                var2 = validatorOprnd(scn.nextLine());
            } while (flagOk);

            flagOk = true;
            do {
                sout.print("Введите оператор: ");
                oper = validatorOpertr(scn.nextLine());
            } while (flagOk);

            double res = calculate(var1, var2, oper);
            out =  String.format( "Результат: %s %s %s = ",
                    var1, strtype, var2);
            if (zeroErr) {
                out = out + "Ошибка! Деление на 0 даёт неопределённость";
            } else {
                out = out + String.valueOf(res);
            }
            sout.println(out);
        }
    }

    static float validatorOprnd(String instr) {
        StopCheck(instr);
        float f = 0;
        try {
            f = Float.parseFloat(instr);
            flagOk = false;
        } catch (Exception e) {
            sout.println("Нужно писать только число. Для нецелых чисел разделитель точка. Пример: 3.14");
        }
        return f;
    }

    static byte validatorOpertr(String instr) {
        StopCheck(instr);
        byte o = 0;
        switch (instr) {
            case "+": o = 1; break;
            case "-": o = 2; break;
            case "*": o = 3; break;
            case "/": o = 4; break;
            default: sout.println("Неизвестный оператор. Требуется оператор только +,-,*,/");
        }
        if (o != 0) {
            flagOk = false;
            strtype = instr;
        }
        return o;
    }

    static void StopCheck (String instr) {
        if ("stop".equals(instr.toLowerCase())) {
            System.exit(0);
        }
    }

    static double calculate(float var1, float var2, byte type) {
        double d = 0;
        switch(type) {
            case 1: d = var1 + var2; break;
            case 2: d = var1 - var2; break;
            case 3: d = var1 * var2; break;
            case 4:
                if (var2 != 0) {
                    d = var1 / var2;
                } else {
                    d = 0;
                    zeroErr = true;
                }
                break;
        }
        return d;
    }
}
