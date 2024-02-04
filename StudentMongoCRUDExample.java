import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class StudentMongoCRUDExample {
    public static void main(String[] args) {
        // Create a MongoClient using the factory method
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            // Access the database and collection
            MongoDatabase database = mongoClient.getDatabase("your_database_name");
            MongoCollection<Document> collection = database.getCollection("students");

            // Perform CRUD operations here
            // Example: Insert a document
            Document newStudent = new Document("first_name", "John")
                    .append("last_name", "Doe")
                    .append("age", 20)
                    .append("email", "john@example.com");
            collection.insertOne(newStudent);

            // Continue with other CRUD operations...
        }
    }
}
