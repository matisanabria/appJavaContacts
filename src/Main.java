import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Contact> contactos = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new ContactManager().start();
        System.out.println("\n\n✌ Cerrando app contactos."); // Mensaje al terminar programa
        scanner.close();

    }


}