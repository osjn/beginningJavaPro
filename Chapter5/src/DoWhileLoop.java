/**
 * Created by 乐成 on 2016/3/14.
 */
public class DoWhileLoop {
    public static void main(String[] args) {
        int i = 1;
        do {
            int doubled = i * 2;
            System.out.println(i + " times two equals " + doubled);
            i++;
        } while (i <= 10);
        System.out.println("End of program");
    }
}
