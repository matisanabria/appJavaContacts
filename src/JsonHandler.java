import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class JsonHandler {
    private static final String FILE_NAME = "contactos.json"; // Nombre del archivo
    private static final Gson gson = new Gson(); // Instancia de libreria gson

    public static void saveToJson(ArrayList<Contact> contactos){
        try (FileWriter writer = new FileWriter(FILE_NAME)) { // Abre, o crea, el archivo JSON, y luego lo escribe
            gson.toJson(contactos, writer);
            System.out.println("✅ Contactos guardados en " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("❌ Error al guardar contactos: " + e.getMessage());
        }
    }

    public static ArrayList<Contact> loadFromJson(){
        try (FileReader reader = new FileReader(FILE_NAME)) {
            Type listType = new TypeToken<ArrayList<Contact>>() {}.getType();
            return gson.fromJson(reader, listType); // Convierte JSON a lista
        } catch (IOException e) {
            System.out.println("⚠️ No se pudo cargar el archivo (¿existe?): " + e.getMessage());
            return new ArrayList<>(); // Si falla, devolvemos lista vacía
        }
    }
}
