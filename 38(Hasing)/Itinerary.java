
import java.util.HashMap;

public class Itinerary {

    public static String getStart(HashMap<String, String> tickets){
        //to -> from map
        HashMap<String, String> reverseMap = new HashMap<>();
        for (String key: tickets.keySet()) {
            reverseMap.put(tickets.get(key), key);
        }

        //check if the starting point of tickets is actually present in reversemap or not
        for(String key : tickets.keySet()){
            if(!reverseMap.containsKey(key)){
                return key;
            }
        }

        return null;

    }

    public static void main(String[] args) {
        HashMap<String, String> tickets= new HashMap<>();
        tickets.put("Chennai", "Bengaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        //find starting point
        String start= getStart(tickets);
        System.out.print(start);
        for(String key: tickets.keySet()){
            System.out.print(" -> " + tickets.get(key));
            //the value becomes the next start point
            start= tickets.get(start);
        }

        System.out.println();
    }
}
