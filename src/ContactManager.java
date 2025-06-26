import java.util.ArrayList;
import java.util.Scanner;

public class ContactManager {
    private ArrayList<Contact> contactos;
    private Scanner scanner;

    public ContactManager() {
        contactos = new ArrayList<>();
        scanner = new Scanner(System.in);
        contactos.add(new Contact("Mati", "0981000000", "mati@email.com"));}

    public void start() {
        byte opt;
        do {
            menu();
            opt = scanner.nextByte();

            switch (opt){
                case 1 -> contacts();
                case 2 -> agg();
                case 3 -> borrar();
                case 0 -> System.out.println("\n\n✌ Cerrando app contactos.");
                default -> System.out.println("❌ Opción inválida");
            }
        } while (opt != 0);
        scanner.close();
    }


    public void menu(){
        System.out.println("📱 ContactApp");
        System.out.println("\n1. Ver contactos\n2. Agregar\n3. Borrar\n0. Salir\n");
        System.out.print("-> ");
    }

    public void contacts(){
        byte index=0; // Suponiendo que no tenga más de 127 contactos, usemos byte para index
        if(contactos.isEmpty()){
            System.out.println("No hay contactos para mostrar.");
            return;
        }
        do {

            // Imprimimos todos los contactos
            System.out.println("\n\n📒 Contactos");
            System.out.println("==============================\n");
            for (int i = 0; i < contactos.size(); i++) {
                System.out.println(i + ". " + contactos.get(i));
            }
            System.out.println("\n==============================");
            System.out.println("Escribe número de indice para ver detalles. \n-1. Salir");
            index=scanner.nextByte(); // Leemos input de usuario

            // Imprime contacto si está en el rango
            if ( index>=0 && index<contactos.size()){
                System.out.println(contactos.get(index).detalles());
                sleep(3000);
            }
            else if (index==-1) { // Sale del menú
                System.out.println("\n\n");
            }
            // Si no está en rango, error.
            else System.out.println("❌ Contacto inválido (Rango: 0 - "+ contactos.size()+")");

        }while(index!=-1);
    }

    public void agg(){
        String nombre, numero, email;
        do {
            System.out.println("\n\n🟩 Agregar contacto.\nEscriba \"exit\" para salir.\n");

            System.out.print("Ingrese nombre: ");
            nombre = scanner.next();
            if (nombre.equals("exit")) { // Si user ingresa "exit", terminar.
                System.out.println("❌ Agregar cancelado.");
                return;
            }
            System.out.print("Ingrese número: ");
            numero = scanner.next();
            if (numero.equals("exit")) {
                System.out.println("❌ Agregar cancelado.");
                return;
            }

            System.out.print("Ingrese email: ");
            email = scanner.next();
            if (email.equals("exit")) {
                System.out.println("❌ Agregar cancelado.");
                return;
            }

            if (nombre.isEmpty() || numero.isEmpty() || email.isEmpty()) {
                System.out.println("\n❌ Campos incompletos. Favor completar.");
                // Si hay un campo incompleto, volver a ejecutar.
            }else{
                // Crear contacto y agregar a la lista
                Contact nuevo = new Contact(nombre, numero, email);
                contactos.add(nuevo);

                System.out.println("✅ Contacto agregado: " + nuevo);
                return;
            }
        }while(true);
    }

    public void borrar(){
        if(contactos.isEmpty()){
            System.out.println("No hay contactos para mostrar.");
            return;
        }
        byte index=0;
        do {
            System.out.println("❌ Eliminar contacto\nEscriba \"-1\" cancelar");
            System.out.println("==============================\n");
            for (int i = 0; i < contactos.size(); i++) {
                System.out.println(i + ". " + contactos.get(i));
            }
            System.out.println("\n==============================");
            System.out.println("\nEscriba índice de contacto a borrar: ");
            index = scanner.nextByte();
            if (index == -1) {
                System.out.println("❌ Cancelando.");
                sleep(500);
                return;
            }
            else if (index >= 0 && index < contactos.size()) {
                Contact eliminado=contactos.remove(index);
                System.out.println("🗑 Contacto borrado: " + eliminado);
                sleep(2000);
                return;
            } else {
                System.out.println("\n❌ Índice inválido");
                sleep(1000);
            }
        }while(true);
    }

    public void sleep(int tiempo){
        try{
            Thread.sleep((tiempo)); // El tiempo está en ms. (1000ms -> 1s)
        }catch(InterruptedException e){
            e.printStackTrace(); // Manejar errores (obligatorio)
        }
    } // Función para dormir el programa por segundos
}
