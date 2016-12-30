package DBConnector;

import java.lang.reflect.Field;
import java.sql.Types;

public interface IFieldTypeMapping {

	Boolean validateType(Field entityField, Types columnType) throws Exception;
	
}

