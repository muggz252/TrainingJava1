package homeWork5;

import java.util.ArrayList;
import java.util.Objects;

public class Task1 {
    public static void main(String[] args) {
        ArrayList<Gun> list = new ArrayList<>();
        list.add(new Gun("pistol", 20,75));
        list.add(new Gun("automat", 50,100));
        list.add(new Gun("mashineGun", 75,125));
        list.add(new Gun("cannon", 100,150));
        //System.out.println("0. Добавить оружие");
        System.out.println("1. Вывести все оружия на консоль");
        System.out.println("2. Найти самое мощное по урону оружие");
        System.out.println("3. Вывести урон и цену по названию");
        System.out.println("4. Удалить любое оружие по названию");
        int input = 0;
        while (input != 5) {
            input = Input.nextInt();
            if (input == 0) {
                System.out.println("Добавляем");
                Gun gun = new Gun(Input.next("Enter name: "), Input.nextInt("Enter damage: "),
                        Input.nextInt("Enter price: "));
                list.add(gun);
            } else if (input == 1) {
                for (int i = 0; i < list.size(); i++) {
                    System.out.println(list.get(i).getName() + " " + list.get(i).getDamage() + " " + list.get(i).getPrice());
                }
            } else if (input == 2) {
                int maxDamage = 0;
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getDamage() > maxDamage) {
                        maxDamage = list.get(i).getDamage();
                    }
                }
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getDamage() == maxDamage) {
                        System.out.println("Самое мощное " + list.get(i).getName());
                    }
                }
            } else if (input == 3) {
                String name = Input.next("Enter name: ");
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getName().equalsIgnoreCase(name)) {
                        System.out.println(list.get(i).getDamage() + " " + list.get(i).getPrice());
                    }
                }
            } else if (input == 4) {
                String name = Input.next("Enter name: ");
                if(list.remove(new Gun(name, 0,0))){
                    System.out.println("Оружие удалено");
                }else{
                    System.out.println("Оружие не найдено");
                }
            }
        }


    }
}

class Gun {
    private String name;
    private int damage;
    private int price;

    public Gun(String name, int damage, int price) {
        this.name = name;
        this.damage = damage;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gun gun = (Gun) o;
        return Objects.equals(name, gun.name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getPrice() {
        return price;
    }
}