package google;

import java.util.*;

public class SupervisorCount {

    static Map<String, List<String>> populateSupervisorCount() {

        Map<String, List<String>> orgStructure = new HashMap<>();
        orgStructure.put("CEO", List.of("VP1", "VP2"));
        orgStructure.put("VP1", List.of("Manager1", "Manager2"));
        orgStructure.put("VP2", List.of("Manager3"));
        orgStructure.put("Manager1", List.of("Engineer1", "Engineer2"));
        orgStructure.put("Manager3", List.of("Engineer3"));

        return orgStructure;

    }

    public static int calculateScore(Map<String, List<String>> orgStructure, String name) {
        int count = 1;
        if (null != orgStructure.get(name)) {
            for (String word: orgStructure.get(name)) {
                count += calculateScore(orgStructure, word);
            }
        }

        return count;
    }


    public static void main(String []args) {

        System.out.println("The count is " + calculateScore(populateSupervisorCount(), "VP2"));
    }


}


