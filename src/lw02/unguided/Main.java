package lw02.unguided;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(Main.class.getResourceAsStream("borrowing.txt"));

        LinkedList<String[]> borrowing = new LinkedList<>();
        LinkedList<String[]> member = new LinkedList<>();
        LinkedList<String[]> book = new LinkedList<>();

        String[] buku = {"Kalkulus","2"};
        book.add(buku);
        String[] buku1 = {"Fisika","1"};
        book.add(buku1);
        String[] buku2 = {"Statistika","2"};
        book.add(buku2);
        

        while(input.hasNextLine()){
            String[] borrow = {input.next(),input.next()};
            borrowing.add(borrow);
        }

        for(String[] b : borrowing){
            boolean status = false;

            for(String[] m : member){
                if(m[0].equals(b[0])){
                    status = true;
                }
            }

            if(!status){
                String[] detail = {b[0],"0"};
                member.add(detail);
            }
        }

        Queue<String[]> queue = new LinkedList<>(borrowing);
        Stack<String[]> stack = new Stack<>();

        while(!queue.isEmpty()){
            String[] data = queue.poll();
            String name = data[0];
            String bookName = data[1];

            for(String[] m : member){
                if(m[0].equals(name)){
                    int borrowed = Integer.parseInt(m[1]);
                    if(borrowed >= 2){
                        stack.push(data);
                    }
                    else{
                        for(String[] bk : book){
                            if(bk[0].equals(bookName)){
                                int stock = Integer.parseInt(bk[1]);
                                if(stock <= 0){
                                    stack.push(data);
                                }
                                else{
                                    stock--;
                                    String newStock = Integer.toString(stock);
                                    bk[1] = newStock;
                                    borrowed++;
                                    String newBorrowed = Integer.toString(borrowed);
                                    m[1] = newBorrowed;
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println("=== Successfully Processed Requests ===");
        for(String[] b : borrowing){
            boolean isFailed = false;
            for(String[] f : stack){
                if(b[0].equals(f[0]) && b[1].equals(f[1])){
                    isFailed = true;
                    break;
                }
            }
            if(!isFailed){
                System.out.println(b[0] + " " + b[1]);
            }
        }
        System.out.println("=== Remaining Book Stock ===");
        for(String[] bk : book){
            System.out.println(bk[0] + " " + bk[1]);
        }
        System.out.println("=== Failed Requests ===");
        for(int i = stack.size() - 1; i >= 0; i--){
            String[] f = stack.get(i);
            System.out.println(f[0] + " " + f[1]);
        }
        input.close();
    }
}