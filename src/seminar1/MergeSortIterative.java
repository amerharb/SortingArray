/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seminar1;

/**
 *
 * @author Amer
 */
public class MergeSortIterative
{
    public static void iterativeMergeSort(int[] a)
    {
        //create 2 dimention array from a array that have only 1 element each
        int[][] m = new int[a.length][1];
        for (int i = 0; i < a.length; i++) {
            m[i] = new int[]{a[i]};
        }
        
        while (m.length > 1) {
            int[][] t = new int[m.length / 2 + m.length % 2][];
            int x = 0;
            //for better proformance this loop will be like this
            if (m.length % 2 == 0) //even number
            {
                for (int i = 0; i < m.length; i++) {
                    t[x++] = merge(m[i], m[++i]);
                }

            } else { // odd number
                for (int i = 0; i < m.length - 1; i++) {
                    t[x++] = merge(m[i], m[++i]);
                }
                t[x] = m[m.length - 1];

            }
//            for (int i = 0; i < m.length; i = i + 2) {
//                if (i < m.length - 1) {
//                    t[x++] = merge(m[i], m[i + 1]);
//                } else {
//                    t[x++] = m[i];
//                }
//            }
            m = t;
        }

        for (int i = 0; i < a.length; i++) {
            a[i] = m[0][i];
        }
        
    }

    private static int[] merge(int[] a, int[] b)
    {
        int[] c = new int[a.length + b.length];
        int posA = 0, posB = 0, posC = 0;

        while (posA < a.length && posB < b.length) {
            if (a[posA] <= b[posB]) {
                c[posC++] = a[posA++];
            } else {
                c[posC++] = b[posB++];
            }
        }

        while (posA < a.length) {
            c[posC++] = a[posA++];
        }

        while (posB < b.length) // Copy rest of right half
        {
            c[posC++] = b[posB++];
        }

        return c;
    }

}
