package Controller;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class Conexion {

    private static MongoClient mongoClient = null;
    private static MongoDatabase database = null;

    public static void Conectar() {
        try {
            // Crear el cliente de MongoDB usando la URL de conexión
            mongoClient = MongoClients.create("mongodb://localhost:27017");

            // Seleccionar la base de datos
            database = mongoClient.getDatabase("encuestas");

            System.out.println("Conexión satisfactoria a la base de datos 'encuestas'");
            
        } catch (Exception e) {
            System.err.println("Error en la conexión: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static MongoDatabase getDatabase() {
        return database;
    }

    public static void close() {
        if (mongoClient != null) {
            mongoClient.close();
            System.out.println("Conexión cerrada");
        }
    }
}
