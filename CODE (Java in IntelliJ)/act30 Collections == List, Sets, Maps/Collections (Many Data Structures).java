import java.util.*;

/** DATA STRUCTURES:   HashMap, LinkedHashMap, TreeMap, LinkedList, HashSet, LinkedHashSet, TreeSet          */

public class CollectionsDriverSol {

/** ORDERS of Keys Or Insertion && Duplicates?  ->
     * Hashmap == NOT Preserved (Or Insertion)
     * LinkedHashMap == Preserved (Insertion)
     * TreeMap == Preserved (Keys)
     * LinkedList == Duplicates
     * HashSet == NO Duplicates && Order NOT Preserved
     * LinkedHashSet == NO Duplicates && Insertion Order IS Preserved
     * TreeSet == NO Duplicates &&  Elements == sorted after Insertion!                                              */

    public static void main(String[] args) {
        /** NOTE that the order/insertion (or of the keys) is not preserved                                   */
        Map hm = new HashMap<Integer, String>();    // Create a HashMap with the following associations:
        hm.put(511, "Joe");         hm.put(923, "Carla");    // 511:Joe, 923:Carla, 728:Paula, 298:Zion
        hm.put(728, "Paula");       hm.put(298, "Zion");
        System.out.println(hm);                     // print the HashMap using its toString implementation
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        /** NOTE than now the order of insertion is preserved                                                 */
        Map lhm = new LinkedHashMap<Integer, String>(); // Create a LinkedHashMap with the same associations
        lhm.put(511, "Joe");            lhm.put(923, "Carla");
        lhm.put(728, "Paula");          lhm.put(298, "Zion");
        System.out.println(lhm);
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        /** NOTE order of the keys is now preserved                                                           */
        Map tm = new TreeMap<Integer, String>();    // Create a TreeMap with the same associations
        tm.put(511, "Joe");         tm.put(923, "Carla");
        tm.put(728, "Paula");       tm.put(298, "Zion");
        System.out.println(tm);
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        /** NOTE Duplicates are allowed in LinkedList                                                         */
        List ll = new LinkedList<String>(); // LinkedList<String> of:  Joe, Carla, Paula, Zion, Paula
        String joe = "Joe";         String carla = "Carla";
        String paula = "Paula";     String zion = "Zion";
        ll.add(joe);            ll.add(carla);
        ll.add(paula);          ll.add(zion);
        ll.add(paula);      // duplicates allowed
        System.out.println(ll); // print the LinkedList using its toString implementation
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
/**    HashSet ==  NOTE duplicates are NOT allowed  &&
    Order/Insertion (or of keys) is NOT preserved                                                             */
        Set hs = new HashSet<String>(); // HashSet with the same elements
        hs.add(joe);            hs.add(carla);
        hs.add(paula);          hs.add(zion);
        hs.add(paula); // duplicates not allowed!!!
        System.out.println(hs);
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
/**     LinkedHashSet == Duplicates are NOT allowed
    order of insertion is preserved                                                                           */
        Set lhs = new LinkedHashSet<String>();
        lhs.add(joe);           lhs.add(carla);
        lhs.add(paula);         lhs.add(zion);
        lhs.add(paula); // duplicates not allowed!!!
        System.out.println(lhs);
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
/**     TreeSet == Duplicates are NOT allowed
    && elements are sorted after Insertion!                                                                   */
        Set ts = new TreeSet<String>();
        ts.add(joe);            ts.add(carla);
        ts.add(paula);          ts.add(zion);
        ts.add(paula); // duplicates not allowed!!!
        System.out.println(ts);
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    }
}
