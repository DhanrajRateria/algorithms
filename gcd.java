import java.util.*;
public class gcd{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b;
        long startTime, endTime;
        a = sc.nextInt();
        b = sc.nextInt();
        sc.close();

        startTime = System.nanoTime();
        int gcdRec = gcdRec(a, b);
        endTime = System.nanoTime();
        double timeRec = (endTime - startTime) / 1e9;

        startTime = System.nanoTime();
        int gcdConsInt = consInt(a, b);
        endTime = System.nanoTime();
        double timeConsInt = (endTime - startTime) / 1e9;

        startTime = System.nanoTime();
        int gcdMSP = msp(a, b);
        endTime = System.nanoTime();
        double timeMSP = (endTime - startTime) / 1e9;
        
        System.out.println("GCD of " + a + " and " + b + ":");
        System.out.println("Euclidean Recursive: " + gcdRec + ", Time: " + timeRec + " seconds");
        System.out.println("Common Factors: " + gcdConsInt + ", Time: " + timeConsInt + " seconds");
        System.out.println("Middle School: " + gcdMSP + ", Time: " + timeMSP + " seconds");
    }

    public static int gcdRec(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcdRec(b, a % b);
    }

    public static int msp(int a, int b) {
        int gcd = 1;
        for (int i = 2; i <= Math.min(a, b); i++) {
            if (isPrime(i)) {
                while (a % i == 0 && b % i == 0) {
                    gcd = gcd * i;
                    a = a / i;
                    b = b / i;
                }
            }
        }
        return gcd;
    }

    public static int consInt(int a, int b) {
        int gcd = 1;
        for (int i = 1; i <= Math.min(a, b); i++) {
            if (a % i == 0 && b % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }

    public static boolean isPrime(int a){
        int count = 0;
        for(int i = 2; i<a;i++){
            if(a%i==0){
                count++;
            }
        }
        if(count==0){
            return true;
        }
        return false;
    }
}