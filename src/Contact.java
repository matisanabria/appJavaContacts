public class Contact {
    private String nombre, telefono, email; // Creamos atributos privados

    // Metodo constructor, lo usaremos al crear un contacto.
    public Contact(String nombre, String telefono, String email){
        this.nombre = nombre; this.telefono = telefono;
        this.email = email;
    }

    @Override
    public String toString(){ // Usaremos esto para imprimir el contacto
        return nombre + " - " + telefono;
    }

    // Función para retornar el contacto con detalles
    public String detalles(){
        return "\n\nNombre:  " + nombre + "\nTeléfono: " + telefono + "\nE-mail: "+email;
    }
}
