/**
 * Created by 乐成 on 2016/3/14.
 */
public class WhileLoop {
    public static void main(String[] args) {
        int i = 1;
        while (i <= 10) {
            int doubled = i * 2;
            System.out.println(i + " times two equals " + doubled);
            i++;
        }
        System.out.println("End of program");
    }
}
