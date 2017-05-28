import java.util.Arrays;
import java.util.Scanner;

public class Ex2 {
    
     private static int[] lerArrayInt(int n) {
        System.out.println("Introduza os valores para o array:");
        Scanner sc = new Scanner (System.in);
        int[] arr;
        arr = new int [n];
        
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        return arr;
        }
        
        private static int minPos(int[] arr) {
        int min=arr[0];
        int pos=0;
        for(int i=1;i<arr.length;i++)
            if (arr[i]<min) {min=arr[i];pos=i;}
        return pos;
        }
        
        public static void main() {
        System.out.println("Quantos elementos vai ter o array?");
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=lerArrayInt(n);
        int i=minPos(arr);
        System.out.println("O menor elemento do array é "+arr[i]+" e encontra-se na posição "+i);
        }
}
