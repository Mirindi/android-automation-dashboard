package com.cristi8.automationdashboard;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Set;

public class ScriptFactory {
	static HashMap<String, Class<?>> mAvailableScriptTypes;
	
	static
	{
		mAvailableScriptTypes = new HashMap<String, Class<?>>();
		mAvailableScriptTypes.put("SSH", SshScript.class);
		mAvailableScriptTypes.put("HTTP", HttpScript.class);
	}
	
	public static String[] getAvailableScriptTypes()
	{
		Set<String> keySet = mAvailableScriptTypes.keySet(); 
		return keySet.toArray(new String[keySet.size()]);
	}

	public static IScript createScript(String type)
	{
		if (!mAvailableScriptTypes.containsKey(type))
			return null;
		
		try {
			Class<?> scriptClass = mAvailableScriptTypes.get(type);
			Constructor<?> ctor = scriptClass.getConstructor();
			Object script = ctor.newInstance();
			return (IScript)script;
		} catch (Exception e) {
			return null;
		}
	}
}
