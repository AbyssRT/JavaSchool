import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class MainFruitGift {
    static ArrayList<int[]> res = new ArrayList<>(); //результаты вариантов подарка
    static int orng_total = 0; //для удобства что бы не передавать переменные в checker. переменная веса * кол-во
    static int appl_total = 0; //для удобства что бы не передавать переменные в checker. переменная веса * кол-во
    static int pear_total = 0; //для удобства что бы не передавать переменные в checker. переменная веса * кол-во
    static int cnt_orng;    //переменная кол-во апельсинов
    static int cnt_appl;   //переменная кол-во яблок
    static int cnt_pear;   //переменная кол-во груш
    static int gift; //вес подарка

    public static void main(String[] args) {
        PrintStream sout = System.out;
        Scanner scn = new Scanner(System.in);
        sout.print("Мануал. Через пробел надо последовательно указать вес подарка и " +
                "веса апельсина, яблока и груши. Например: 40 25 15 10 \n ");
        gift = 0;
        int weight_orange = 0;
        int weight_apple = 0;
        int weight_pear = 0;

        do {
            res = new ArrayList<>();
            sout.print("Вход программы: ");
            String instr = scn.nextLine();
            String[] params;
            try {
                params = instr.split(" ");
                gift = Integer.parseInt(params[0]);
                weight_orange = Integer.parseInt(params[1]);
                weight_apple = Integer.parseInt(params[2]);
                weight_pear = Integer.parseInt(params[3]);
            } catch (NumberFormatException e) {
                System.out.println(e.toString());
                sout.println("Нужно вводить только целые числа через пробел");
                continue;
            } catch (ArrayIndexOutOfBoundsException e2) {
                System.out.println(e2.toString());
                sout.println("Недостаточно аргументов");
                continue;
            }
            calculate(weight_orange, weight_apple, weight_pear);
            sout.format("Ответ: %d \n", res.size());
            int c = 0;
            for (int[] r : res) {
                c++;
                sout.format("%d вариант - %d orange, %d apple, %d pear \n",
                        c, r[0], r[1], r[2]);
            }
        } while (true);
    }

    static void calculate(int w_orng, int w_apl, int w_pear) {
        for (cnt_orng = 0; cnt_orng <= gift/ w_orng; cnt_orng++) {
            orng_total = w_orng * cnt_orng;
            checker();
            for (cnt_appl = 0; cnt_appl <= gift/ w_apl; cnt_appl++) {
                appl_total = w_apl * cnt_appl;
                checker();
                for (cnt_pear = 0; cnt_pear <= gift/ w_pear; cnt_pear++){
                    pear_total = w_pear * cnt_pear;
                    checker();
                }
            }
        }
    }

    static void checker() {
        if ( (orng_total + appl_total + pear_total) == gift) {
            int[] e = {cnt_orng, cnt_appl, cnt_pear};
            res.add(e);
        }
    }


}
