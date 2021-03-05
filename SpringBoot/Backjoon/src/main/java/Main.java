import java.util.Scanner;

public class Main {
    static int finaln =0;


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        finaln= s.nextInt();
        System.out.println(Factorial(finaln));


    }

    public static int Factorial(int temp){
        if(temp == 1) {
            return temp;
        }else if(finaln ==temp) {
            temp= finaln ;
            finaln = temp*(temp-1);
            return Factorial(temp-1);
        }else {
            finaln = temp * (temp - 1);
            return Factorial(temp-1);
        }


    }
}
