package testjson;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

	@JsonProperty("nome")
	private String name;
	
	@JsonProperty("contatos")
	private List<Contatc> contats;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Contatc> getContats() {
		return contats;
	}

	public void setContats(List<Contatc> contats) {
		this.contats = contats;
	}
}
