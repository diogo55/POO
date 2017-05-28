import java.util.Arrays;
import java.util.Scanner;

public class ex4
{
    
    private static int[] lerArrayInt(int n) {
        System.out.println("Introduza os valores para o array:");
        Scanner sc = new Scanner (System.in);
        int[] arr;
        arr = new int [n];
        
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        return arr;
        }
        
    private static int[] subArray(int[] arr, int i, int f) {
        int[] newarr;
        newarr = new int[f-i+1];
        for(int a=0,b=i;b<=f;a++,b++)
            newarr[a]=arr[b];
        return newarr;
    }
    
    public static void main() {
        System.out.println("Quantos elementos vai ter o array?");
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=lerArrayInt(n);
        System.out.println("Indicie Inicial:");
        int i=sc.nextInt();
        System.out.println("Indice Final:");
        int f=sc.nextInt();
        int[] newarr=subArray(arr,i,f);
        System.out.println(Arrays.toString(newarr));
    }
}
