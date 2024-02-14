package args;


import org.apache.log4j.Logger;

import java.util.HashMap;

public class DefaultMap {
    private static final Logger log = Logger.getLogger(DefaultMap.class);

    public static HashMap<String, String> getDefaultHashMap() {
            HashMap<String, String> map = new HashMap<>();
            map.put("a", "false");
            map.put("o", "./");
            map.put("p", "");
            map.put("s", "not");
            map.put("files","");
            log.info("Default map is created");
            log.info(map);
            return map;
    }
}
