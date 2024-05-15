package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> dishes;    // = new HashMap<>();
    private Random random = new Random();       //Спасибо!!!

    public DinnerConstructor() {
        dishes = new HashMap<>();
    }

    public void addDish(String type, String name) {
        ArrayList<String> arrDishes;
        //1. Такой тип в мапе уже есть -> Получить из мапы список с блюдами и добавить в него новое
        //2. Такого типа в мапе еще пока нет -> Создать список, положить в него новое блюдо и положить в мапу
        if (dishes.containsKey(type)) {
            arrDishes = dishes.get(type);
        } else {
            arrDishes = new ArrayList<>();
            dishes.put(type, arrDishes);
        }
        arrDishes.add(name);
        System.out.println(type + " " + name + " добавили");
    }


    public ArrayList<ArrayList<String>> generateCombinations(int cnt, ArrayList<String> types) {

        ArrayList<ArrayList<String>> combos = new ArrayList<>();


        for (int i = 0; i < cnt; i++) {
            ArrayList<String> combo = new ArrayList<>();
            for (String type : types) {
                ArrayList<String> dishType = dishes.get(type);

                int randType = random.nextInt(dishType.size());

                combo.add(dishType.get(randType));
            }
            combos.add(combo);
        }
        return combos;
        // В цикле for пройти cnt раз и сгенерировать на каждой итерации по комбинации
        // Пройтись по всем типам, из которых нужно сделать комбинацию
        //      Для каждого типа:
        //      1. Посмотреть, сколько есть возможных блю
        //      2. Получить на основе этого из Random число
        //      3. Взять по этому рандомному число блюдо из списка у этого текущего типа и положить его в комбинацию

    }


    public boolean checkType(String type) {
        return dishes.containsKey(type);
    }

}
