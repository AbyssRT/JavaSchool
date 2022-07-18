import java.io.PrintStream;

public class Main1000to1 {


    public static void main(String[] args) {
        PrintStream sout = System.out;
        for(int i=1000; i>0; i = i-2) {
            sout.println(i);
        }
    }
}
