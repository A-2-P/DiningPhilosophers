import java.util.HashMap;
import java.util.Map;

public class Monitor {
    //Observer
    private Map<Integer, Zustand> map;

    public Monitor() {
        map = new HashMap<>();
    }

    public void update(int id, Zustand neuerZustand){
        String text = "";
        synchronized (this) {
            map.put(id, neuerZustand);

            //System.out.println(id + ": " + neuerZustand);

            for (int key : map.keySet()) {
                Zustand zustand = map.get(key);
                text += String.format("%d %12s | ", key, zustand); //key + "\tZustand: "+ zustand ;
            }
        }
        System.out.println(text);
    }

}
