import java.io.PrintStream;

public class Main1000to1 {
    static final PrintStream sout = System.out;

    public static void main(String[] args) {
        for(int i=1000; i>0; i = i-2) {
            sout.println(i);
        }
    }
}
