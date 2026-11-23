package lw06.unguided;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(Main.class.getResourceAsStream("treenumbers.txt"));
        String baris = input.nextLine();
        String[] data = baris.split(" ");

        BinarySearchTree root = new BinarySearchTree();
        for (String a : data) {
            root.insert(Integer.parseInt(a));
        }

        System.out.print("Preorder : ");
        root.preOrder();

        System.out.print("Inorder : ");
        root.inOrder();

        System.out.print("Postorder : ");
        root.postOrder();

        int tujuan = input.nextInt();
        boolean kondisi = root.search(tujuan);
        System.out.println("Search " + tujuan + " : " + kondisi);

        int min = root.findMin();
        System.out.println("Minimum : " + min);

        int max = root.findMax();
        System.out.println("Maximum : " + max);
        input.close();
    }
}
