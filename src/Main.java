
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        BST bst = new BST();

        try(BufferedReader br = new BufferedReader(new FileReader("In.txt"))){
            String line;
            while ((line = br.readLine()) != null){
                String[] values = line.split(" ");
                for(String value : values){
                    bst.insert(Integer.parseInt(value));
                }
            }
        } catch(IOException e){
            e.printStackTrace();
        }

        Random rand = new Random();

        try(PrintWriter out = new PrintWriter("Out.txt")){
            for(int i = 0; i < 5; i++){
                int value = rand.nextInt(1000);
                //out.println(value);
                //bst.insert(value);
            }
        }catch (IOException e){
            e.printStackTrace();
        }


        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Wybierz operację:");
            System.out.println("1. Zapisz elementy drzewa BST do pliku OutTest3.txt w kolejności KLP");
            System.out.println("2. Dodaj element do drzewa BST");
            System.out.println("3. Usuń element z drzewa BST");
            System.out.println("4. Zakończ program");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    try (PrintWriter out = new PrintWriter("OutTest3.txt")) {
                        KLP(bst.root, out);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    System.out.println("Podaj element do dodania:");
                    int value = sc.nextInt();
                    bst.insert(value);
                    break;
                case 3:
                    System.out.println("Podaj element do usunięcia:");
                    value = sc.nextInt();
                    bst.deleteKey(value);
                    break;
                case 4:
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Zly wybor");
            }
        }
    }
    static void KLP(Node root, PrintWriter out) { // LPK z wykładu
        if(root != null){
            KLP(root.left, out);
            KLP(root.right, out);
            out.println(root.key + " ");
        }
    }
}