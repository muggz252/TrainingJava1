package homeWork5;

import java.util.ArrayList;
public class Task3 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(40);
        list.add(50);
        System.out.println(list);
        list.remove(new Integer(10));
        System.out.println(list);
        for (int i = 0; i< list.size()-1; i++){
            if (list.get(i) == list.get(i+1)){
                list.remove(i+1);
            }
        }
        System.out.println(list);
        ArrayList<Integer> listUnion = new ArrayList<>();
        listUnion.add(10);
        listUnion.add(40);
        listUnion.add(50);
        listUnion.add(50);
        listUnion.add(110);
        listUnion.add(150);
        System.out.println(listUnion);

        listUnion.removeAll(list);
        list.addAll(listUnion);
        System.out.println(list);
        System.out.println();

        ArrayList<Integer> listIntersection = new ArrayList<>();
        listIntersection.add(20);
        listIntersection.add(30);
        listIntersection.add(40);
        listIntersection.add(50);
        listIntersection.add(100);

        System.out.println(listIntersection);

        listIntersection.removeAll(list);
        System.out.println(listIntersection);

//        ArrayList<Integer> listSubstract = new ArrayList<>();
//        listSubstract.add(30);
//        listSubstract.add(40);
//        listSubstract.add(100);
//        list.removeAll(listSubstract);
//        System.out.println(list);
    }
}
