import javax.naming.Context;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainCalc {
    static boolean flagOk;

    public static void main(String[] args) {
        PrintStream sout = System.out;
        float var1;
        float var2;
        String oper;
        String out;
        Scanner scn = new Scanner(System.in);

        while (true) {
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
            out =  String.format( "Результат: %s %s %s = %s",
                    var1, oper, var2, res);
            sout.println(out);
        }
    }

    static float validatorOprnd(String instr) {
        StopCheck(instr);
        float f = 0;
        try {
            f = Float.parseFloat(instr);
            flagOk = false;
        } catch (NumberFormatException e) {
            System.out.println(e.toString());
            System.out.println("Нужно писать только число. Для нецелых чисел разделитель точка. Пример: 3.14");
        }
        return f;
    }

    static String validatorOpertr(String instr) {
        StopCheck(instr);
        String[] opers = new String[] { "+", "-", "*", "/" };
        String out = "";
        for (String oper: opers) {
            if (instr.equals(oper)) {
                out = instr;
                break;
            }
        }
        if (!"".equals(out)) {
            flagOk = false;
        }
        return out;
    }

    static void StopCheck (String instr) {
        if ("stop".equals(instr.toLowerCase())) {
            System.exit(0);
        }
    }

    static double calculate(float var1, float var2, String type) {
        double out = 0;
        switch(type) {
            case "+": out = var1 + var2; break;
            case "-": out = var1 - var2; break;
            case "*": out = var1 * var2; break;
            case "/": out = var1 / var2; break;
        }
        return out;
    }
}
