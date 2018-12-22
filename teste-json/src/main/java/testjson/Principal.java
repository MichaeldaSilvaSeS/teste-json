package testjson;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Principal {
	private static final String json = "{"+
											"\"nome\":\"Michael\","+
											"\"contatos\":["+
												"{"+
													"\"tipo\":\"Email\","+
													"\"valor\":\"email@email.com\""+
												"}"+
											"]"+
										"}";
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		System.out.println(json);
		ObjectMapper mapper = new ObjectMapper();
		User user = mapper.readValue(json, User.class);
		
		System.out.println(user.getName());
		for (Contatc contatc : user.getContats()) {
			System.out.println(contatc.getValue());
			System.out.println(contatc.getClass().getName());
		}
	}
}
