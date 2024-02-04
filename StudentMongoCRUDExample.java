import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class StudentMongoCRUDExample {
    public static void main(String[] args) {
        // Connect to MongoDB (Make sure MongoDB server is running)
        MongoClientURI connectionString = new MongoClientURI("mongodb://localhost:27017");
        try (MongoClient mongoClient = new MongoClient(connectionString)) {
            // Access the database and collection
            MongoDatabase database = mongoClient.getDatabase("your_database_name");
            MongoCollection<Document> collection = database.getCollection("students");

            // Create
            Document newStudent = new Document("first_name", "John")
                    .append("last_name", "Doe")
                    .append("age", 20)
                    .append("email", "john@example.com");
            collection.insertOne(newStudent);

            // Read
            MongoCursor<Document> cursor = collection.find().iterator();
            while (cursor.hasNext()) {
                Document student = cursor.next();
                System.out.println(student);
            }
            cursor.close();

            // Update
            Document updatedStudent = new Document("$set", new Document("first_name", "Updated First Name"));
            collection.updateOne(new Document("first_name", "John"), updatedStudent);

            // Read again
            cursor = collection.find().iterator();
            while (cursor.hasNext()) {
                Document student = cursor.next();
                System.out.println(student);
            }
            cursor.close();

            // Delete
            collection.deleteOne(new Document("first_name", "John"));
        }
    }
}
