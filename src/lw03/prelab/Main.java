package lw03.prelab;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("===== Problem 1 =====");
        problem1();
        System.out.println();
        System.out.println("===== Problem 2 =====");
        problem2();
        System.out.println();
        System.out.println("===== Problem 3 =====");
        problem3();
    }

    static  void problem1(){
        List<String> playlist = new ArrayList<>();
        Scanner input = new Scanner(Main.class.getResourceAsStream("playlist.txt"));
        while(input.hasNext()){
            String todo = input.next();
            if(todo.equals("ADD")) playlist.add(input.nextLine());
            else if(todo.equals("REMOVE")){
                String nama = input.nextLine();
                playlist.remove(playlist.indexOf(nama));
            }
            else if(todo.equals("INSERT")){
                int index = input.nextInt();
                String nama = input.nextLine();
                playlist.add(index,nama);
            }
        }
        System.out.println("Total songs: " + playlist.size());
        for(int i=0;i<playlist.size();i++){
            System.out.println(i +":"+ playlist.get(i));
        }
        input.close();
    }

    static void problem2(){
        Scanner input = new Scanner(Main.class.getResourceAsStream("participants.txt"));
        Set<String> participant = new LinkedHashSet<>();
        int duplicate = 0;
        while(input.hasNext()){
            String nama = input.next();
            if(!participant.contains(nama)) participant.add(nama);
            else duplicate += 1;
        }
        System.out.println("Unique participant "+ participant.size());
        int count = 1;
        for(String participants : participant){
            System.out.println((count++) + ": "+ participants);
        }
        System.out.println("Duplicate registrations: " + duplicate);
        input.close();
    }

    static void problem3(){
        Scanner input = new Scanner(Main.class.getResourceAsStream("inventory.txt"));
        Map<String, Integer> inventory = new LinkedHashMap<>();
        int failCount = 0;
        while(input.hasNext()){
            String type = input.next();
            String product = input.next();
            int quality = input.nextInt();

            if(type.equals("ADD")){
                if(!inventory.containsKey(product)){
                    inventory.put(product, quality);
                    continue;
                }
                else{
                    inventory.put(product, inventory.get(product) + quality);
                    continue;
                }
            }
            else if(type.equals("SELL")){
                if(!inventory.containsKey(product) || inventory.get(product)<quality){
                    failCount++;
                    continue;
                }
                else{
                    inventory.put(product, inventory.get(product)-quality);
                    continue;
                }
            }
        }
        for(String item : inventory.keySet()){
            System.out.println(item + ": " + inventory.get(item));
        }
        System.out.println("Failed sales: " + failCount);
        input.close();
    }
}
