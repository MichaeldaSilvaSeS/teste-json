package testjson;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonTypeIdResolver;

@JsonTypeInfo(use = JsonTypeInfo.Id.CUSTOM,include=JsonTypeInfo.As.PROPERTY,property = "tipo")
@JsonTypeIdResolver(CommandTypeIdResolver.class)
public abstract class Contatc {
	
	@JsonProperty("valor")
	private String value;

	public String getValue() {
		return "customizado:"+value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
