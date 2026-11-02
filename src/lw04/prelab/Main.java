import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(Main.class.getResourceAsStream("branches.txt"));
        int n = input.nextInt();
        int[] list = new int[n];
        for(int i=0;i<n;i++){
            list[i] = input.nextInt();
        }
        int m = input.nextInt();
        int[] cari = new int[m];
        for(int i=0;i<m;i++){
            cari[i] = input.nextInt();
        }
        for(int i=1;i<=3;i++){
            int j = i;
            while(j != 0){
                int save = list[j];
                if(list[j] > list[j-1]){
                    list[j] = list[j-1];
                    list[j-1] = save;
                }
                j--;
            }
        }
        for(int i=0;i<n;i++){
            System.out.print(list[i] + " ");
        }
        System.out.println();
        for(int i=0;i<m;i++){
            boolean kondisi = false;
            for(int j=0;j<n;j++){
                if(cari[i] == list[j]){
                    System.out.println(cari[i] + " : FOUND at Index " + j);
                    kondisi = true;
                    break;
                }
            }
            if(!kondisi){
                System.out.println(cari[i] + " : NOT FOUND");
            }
        }
        input.close();
    }
}