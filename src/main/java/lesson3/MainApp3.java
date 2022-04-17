package lesson3;

import java.util.*;

public class MainApp3 {
    static class Metal {
        String name;

        Metal(String name) {
            this.name = name;
        }

        public Object getName(){
            return name;
        }

        @Override
        public String toString() {
            return "Metal{" + "name='" + name + '\'' + '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Metal metal = (Metal) o;
            return Objects.equals(name, metal.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

    public static void main (String [] args) {
        Metal[] metals = {new Metal("brass"), new Metal("bronze"), new Metal("silver"),
                new Metal("copper"), new Metal("brass"), new Metal("gold"),
                new Metal("iron"), new Metal("mercury"), new Metal("copper"),
                new Metal("lead"), new Metal("nickel"), new Metal("steel"), new Metal("tin")};

        List<Metal> arrMetal = new ArrayList<>(Arrays.asList(metals));
        System.out.println(arrMetal);

        HashSet<Metal> setMetal = new HashSet<>(Arrays.asList(metals));
        System.out.println(setMetal);

        Map resultMap = new HashMap<>();
        for (int i = 0; i < arrMetal.size(); i++) {
            if (resultMap.containsKey(arrMetal.get(i))) {
                resultMap.put(arrMetal.get(i), resultMap.get(arrMetal.get(i)) + 1);
            } else {
                resultMap.put(arrMetal.get(i), 1);
            }
        }
        System.out.println(resultMap);
        System.out.println("Количество уникальных металлов " + (setMetal.size()));

    }
}


