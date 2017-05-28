import java.util.Arrays;
import java.util.Scanner;

public class Ex3 {
    
    private static void ordenaArr(int arr[],int a) {
    int tmp;
    for(int i=a;i>0 && arr[i]>arr[i-1];i--) {
        tmp=arr[i];
        arr[i]=arr[i-1];
        arr[i-1]=tmp;
    }
}
    
    private static int[] lerArrayInt(int n) {
        System.out.println("Introduza os valores para o array:");
        Scanner sc = new Scanner (System.in);
        int[] arr;
        arr = new int [n];
        
        for(int i=0;i<n;i++) {
            arr[i]=sc.nextInt();
            ordenaArr(arr,i);
            System.out.println(Arrays.toString( arr));
        }
        return arr;
        }
        
        public static void main() {
        System.out.println("Quantos elementos vai ter o array?");
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=lerArrayInt(n);
        System.out.println("Array final:"+Arrays.toString( arr));
        }
}


