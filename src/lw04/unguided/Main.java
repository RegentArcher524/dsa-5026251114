package unguided;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(Main.class.getResourceAsStream("cards.txt"));
        int batas = 2;

        int n = input.nextInt();
        int[] kartu = new int[n];
        for(int i=0;i<n;i++){
            kartu[i] = input.nextInt();
        }

        int m = input.nextInt();
        int[] cari = new int[n];
        for(int i=0;i<m;i++){
            cari[i] = input.nextInt();
        }
        input.close();

        sort(kartu, batas);

        for(int i=0;i<n;i++){
            System.out.print(kartu[i] + " ");
        }

        System.out.println();

        for(int i=0;i<m;i++){
            int hasil = linearsearch(kartu, cari[i]);
            if(hasil != -1){
                System.out.println(cari[i] + " : FOUND at Index " + hasil);
            }
            else{
                System.out.println(cari[i] + " : NOT FOUND");
            }
        }
    }

    static void sort(int[] kartu, int batas){
        for(int i=0;i<batas;i++){
            int kecil = kartu[i];
            int index = i;
            for(int j=i+1;j<kartu.length;j++){
                if(kecil > kartu[j]){
                    kecil = kartu[j];
                    index = j;
                }
            }
            kartu[index] = kartu[i];
            kartu[i] = kecil;
        }
    }

    static int linearsearch(int[] kartu, int cari){
        for(int i=0;i<kartu.length;i++){
            if(kartu[i] == cari){
                return i;
            }
        }
        return -1;
    }
}
