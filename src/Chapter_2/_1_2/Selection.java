package Chapter_2._1_2;

import Chapter_2._1_1.Example;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Scanner;

/**
 * 选择排序
 */

public class Selection {
    public static void sort(Comparable[] a){
        int N=a.length;
        for (int i = 0; i < N; i++) {
            int min=i;
            for(int j=i+1;j<N;j++){
                if(less(a[j],a[min])) min=j;
                exch(a,i,min);
            }
        }
    }

    private static boolean less(Comparable v,Comparable w)
    { return v.compareTo(w)<0;}

    private static void exch(Comparable[] a,int i,int j)
    { Comparable t=a[i];a[i]=a[j];a[j]=t; }

    private static void show(Comparable[] a){
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i]+" ");
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a){//检查数组是否有序
        for(int i=1;i<a.length;i++)
            if(less(a[i],a[i-1])) return false;
        return true;
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        Integer a[]=new Integer[100];int len=0;
        while (sc.next()!=null){
            a[len++]=Integer.parseInt(sc.next());
        }
        sort(a);
        assert isSorted(a);//若数组被成功排序，则继续执行
        show(a);
    }
}