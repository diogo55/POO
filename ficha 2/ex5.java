import java.util.Arrays;
import java.util.Scanner;

public class ex5
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
        
    
    private static int[] arrayConcat(int[] arr1, int[] arr2){
        int[] arr3;
        arr3 = new int[arr1.length+arr2.length];
        System.arraycopy(arr1,0,arr3,0,arr1.length);
        System.arraycopy(arr2,0,arr3,arr1.length,arr2.length);
        Arrays.sort(arr3);
        return arr3;
    }
    
     public static void main() {
        System.out.println("Quantos elementos vai ter o array?");
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr1=lerArrayInt(n);
        System.out.println("Quantos elementos vai ter o segundo array?");
        n=sc.nextInt();
        int[] arr2=lerArrayInt(n);
        int[] arr3=arrayConcat(arr1,arr2);
        System.out.println(Arrays.toString(arr3));
    }
}
