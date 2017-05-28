import java.util.Arrays;
import java.util.Scanner;

public class ex6
{
    private static String[] criarArray() {
        System.out.println("Escreva as palavras que quer no array");
        String[] arr;
        int i;
        arr = new String[10];
        Scanner sc = new Scanner(System.in);
        String a=sc.next();
        for(i=0;!(a.equals("fim"));i++){
            arr[i]=a;
            a=sc.next();
        }
        String[] arr1;
        arr1 = new String[i];
        for(i=0;i<arr1.length;i++)
            arr1[i]=arr[i];
        return arr1;
}

    private static void sub(String[] arr) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduza a palavra que queira substituir: ");
        String a = sc.next();
        System.out.println("Introduza a palavra pela qual quer substituir:");
        String b = sc.next();
        int i;
        for(i=0;!(arr[i].equals(a));i++);
        arr[i]=b;
    }
    
    
    private static void rem(String[] arr) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduza a palavra que quer remover: ");
        String a = sc.next();
        int i;
        for(i=0;!(arr[i].equals(a));i++);
        for(;i<arr.length-1;i++)
            arr[i]=arr[i+1];
    }
    
    
    public static void main() {
    String[] a = criarArray();
    int l=0;
    Scanner sc = new Scanner(System.in);
    System.out.println("Introduza o caracter 's' para substituir ou 'r' para remover:");
    String c = sc.next();
    if (c.equals("s")) sub(a);
    else if (c.equals("r")) {rem(a);l=1;}
    
    for (int i = 0; i< a.length-l; i++)
        System.out.print(a[i]+" ");
    System.out.println(".");
    }
    
}