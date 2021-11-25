package indra.user;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.client.MongoCollection;

@RestController
public class UserApiController {

	@Autowired
	private MongoCollection<Document> collection;
	
	@GetMapping("/saludar")
	public String saludar() {
		return "Hola Mundo";
	}

	@PostMapping("/user")
	public UserData createUser(@RequestBody UserData user) {
		ObjectId id = new ObjectId();
		user.setId(id.toHexString());
		Document doc = new Document()
				.append("_id", id)
				.append("name", user.getName());
		collection.insertOne(doc);
		return user;
	}
	
	@GetMapping("/user")
	public Stream<UserData> listUser() {
		Stream<Document> s = StreamSupport.stream(collection.find().spliterator(), false);
		Stream<UserData> usuarios = s.map(doc -> {
			String id = doc.getObjectId("_id").toHexString();
			String name = doc.getString("name");
			UserData user = new UserData(id, name);
			return user;
		});
		return usuarios;
	}
}
