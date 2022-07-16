import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class MainFriutGift {
    static final PrintStream sout = System.out;
    static final Scanner scn = new Scanner(System.in);
    static ArrayList<int[]> res = new ArrayList<>();
    static int ot = 0;
    static int at = 0;
    static int pt = 0;
    static int i;
    static int j;
    static int h;
    static int gift;

    public static void main(String[] args) {
        sout.print("Мануал. Через пробел надо последовательно указать вес подарка и " +
                "веса апельсина, яблока и груши. Например: 40 25 15 10 \n ");
        gift = 0;
        int orange = 0;
        int apple = 0;
        int pear = 0;

        do {
            res = new ArrayList<>();
            sout.print("Вход программы: ");
            String instr = scn.nextLine();
            String[] s;
            try {
                s = instr.split(" ");
                gift = Integer.parseInt(s[0]);
                orange = Integer.parseInt(s[1]);
                apple = Integer.parseInt(s[2]);
                pear = Integer.parseInt(s[3]);
            } catch (Exception e) {
                sout.println("Неправильный ввод! Попробуй снова! Тут нет защиты от дурака");
                continue;
            }
            calculate(orange, apple, pear);
            sout.format("Ответ: %d \n", res.size());
            int c = 0;
            for (int[] f: res) {
                c++;
                sout.format("%d вариант - %d orange, %d apple, %d pear \n",
                        c, f[0], f[1], f[2]);
            }
        } while (true);
    }

    static void calculate(int o, int a, int p) {
        for (i = 0; i <= gift/o; i++) {
            ot = o * i;
            checker();
            for (j = 0; j<= gift/a; j++) {
                at = a * j;
                checker();
                for (h = 0; h <= gift/p ; h++){
                    pt = p * h;
                    checker();
                }
            }
        }
    }

    static void checker() {
        if ( (ot + at + pt) == gift) {
            int[] e = {i, j, h};
            res.add(e);
        }
    }


}
