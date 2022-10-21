import java.util.HashMap;
import java.util.Map;

public class MemStore {

    private static Map<String,String> db = new HashMap<String, String>();

    public static String get( String key )
    {
        synchronized (MemStore.class)
        {
            return db.containsKey(key) ? db.get(key) : "No suck key";
        }

    }

    public static String put( String key, String value )
    {
        synchronized (MemStore.class)
        {
            db.put(key,value);
        }
        return "Ok ~ "+key+" -> "+value;
    }

    public static String del( String key )
    {
        synchronized (MemStore.class)
        {
            if(db.containsKey(key))
            {
                db.remove(key);
                return "Ok ~ Deleted " + key;
            }
        }
        return "Error";
    }

}
