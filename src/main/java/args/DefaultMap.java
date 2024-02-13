package args;


import java.util.HashMap;

public class DefaultMap {
        public static HashMap<String, String> getDefaultHashMap() {
            HashMap<String, String> map = new HashMap<>();
            map.put("a", "false");
            map.put("o", "./");
            map.put("p", "");
            map.put("s", "not");
            map.put("files","");
            return map;
    }
}
