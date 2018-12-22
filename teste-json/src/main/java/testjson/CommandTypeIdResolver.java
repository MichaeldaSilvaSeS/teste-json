package testjson;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.type.TypeFactory;

public class CommandTypeIdResolver implements TypeIdResolver
{
    private static final String COMMAND_PACKAGE = 
    		Contatc.class.getPackage().getName() + ".command";
    private JavaType mBaseType;
/*

    @Override
    public String idFromValue(Object obj)
    {
        return idFromValueAndType(obj, obj.getClass());
    }

    @Override
    public String idFromBaseType()
    {
        return idFromValueAndType(null, mBaseType.getRawClass());
    }

    @Override
    public String idFromValueAndType(Object obj, Class<?> clazz)
    {
        String name = clazz.getName();
        if ( name.startsWith(COMMAND_PACKAGE) ) {
            return name.substring(COMMAND_PACKAGE.length() + 1);
        }
        throw new IllegalStateException("class " + clazz + " is not in the package " + COMMAND_PACKAGE);
    }

    */
	public Id getMechanism() {
		return Id.CUSTOM;
	}
	public String idFromBaseType() {
		if(mBaseType.getRawClass().equals(ContatcEmail.class))
			return "Email";

		throw new IllegalStateException("cannot find class ");
	}
	public String idFromValue(Object obj) {
		if(obj instanceof ContatcEmail)
			return "Email";

		throw new IllegalStateException("cannot find class ");
	}
	public String idFromValueAndType(Object obj, Class<?> clazz) {
		if(obj instanceof ContatcEmail)
			return "Email";

		throw new IllegalStateException("cannot find class '" + clazz + "'");
	}
	
	public void init(JavaType baseType) {
		mBaseType = baseType;		
	}
	
	public JavaType typeFromId(String type) {
		Class clazz = null;
		switch(type){
			case "Email":
				clazz = ContatcEmail.class;
				break;
			default:
				throw new IllegalStateException("cannot find class '" + type + "'");
		}
		return TypeFactory.defaultInstance().constructSpecializedType(mBaseType, clazz);
	}
}