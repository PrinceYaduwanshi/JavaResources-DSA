import java.util.HashMap;

class Hash_Map{

    public static void main(String[] args) {
        // Create
        HashMap<String , Integer> hm = new HashMap<>();

        // Insert-O(1)
        hm.put("India" , 100);
        hm.put("China" , 150);
        hm.put("US" , 60);

        System.out.println(hm);
        System.out.println(hm.size());

        // Get-O(1)
        int popIndia = hm.get("India");
        System.out.println(popIndia);
        System.out.println(hm.get("Pakistan"));


        // containsKey-O(1)
        boolean res = hm.containsKey("Pakistan");
        System.out.println(res);
        System.out.println(hm.containsKey("India"));

        // Remove-O(1)
        System.out.println(hm.remove("China"));
        System.out.println(hm);
        System.out.println(hm.remove("Pakistan"));
        System.out.println(hm.size());

        System.out.println(hm.isEmpty());


        // CLear fnx
        hm.clear();
        System.out.println(hm.isEmpty());
        System.out.println(hm);



    }
}