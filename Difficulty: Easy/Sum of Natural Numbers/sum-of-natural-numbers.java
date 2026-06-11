import java.util.Scanner;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
       int a = sum(n);
       System.out.print(a);
        
    }
    
 public static int  sum (int n){
        if (n == 0){
            return 0 ;
        }
        return n + sum (n-1);
    }
}