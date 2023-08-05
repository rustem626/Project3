package HashMsp;

import java.util.HashMap;
import java.util.HashSet;

public class _DersHashmap_Tekrar {
    public static void main (String[] args) {
        HashMap<String,Integer> sinifID=new HashMap<>();
        sinifID.put("Nurjahan", 2005);
        sinifID.put("Meryem",2007);
        sinifID.put("Salih", 2009);
        sinifID.put("Nurmuhammet", 2013);
        System.out.println("\n"+sinifID);
        System.out.println("***************");
        System.out.println(sinifID.values());
        System.out.println("///////////////");
        System.out.println(sinifID.size());
        System.out.println("***************");
        System.out.println(sinifID.containsKey("Salih"));
        System.out.println("***************");
        System.out.println(sinifID.replace("Salih", 2001));

        System.out.println("\n"+sinifID);
        System.out.println("\n"+sinifID.get("Meryem")+" "+sinifID.getClass()+" "+sinifID.get("Nurjahan"));

        System.out.println(sinifID.containsValue(2001));



    }

}
