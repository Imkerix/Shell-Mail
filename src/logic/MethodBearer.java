package logic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class MethodBearer 
{
	public <T extends ToItterate> Object contains(ArrayList<T> arrayList, String[] args, String searchfor,int isSupposedToEqualThisPlace)
	{
		for (T t : arrayList) 
		{
			if(t.get(searchfor).equals(args[isSupposedToEqualThisPlace]))
			{
				return t;
			}
		}
		return null;
	}
	
	public <T extends ToItterate> Object returnStuff(Map map) 
	{
		Iterator<Entry<T, String>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) 
		{
			Map.Entry<T, String> pair = (Entry<T, String>)iterator.next();
			
			return pair.getKey().get("mailid");
		}
		return null;
	}
}
