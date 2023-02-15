package study15_1;

import java.util.HashMap;

enum CoffeeType{Americano, IcedAmericano,CafeLatte}

public class EnumPrac {
    static void printCoffeePrice(CoffeeType type) {
        HashMap<CoffeeType,Integer> priceMap = new HashMap<>();
        priceMap.put(CoffeeType.Americano, 3000);
        priceMap.put(CoffeeType.IcedAmericano, 4000);
        priceMap.put(CoffeeType.CafeLatte, 5000);
        int price = priceMap.get(type);
        System.out.println(type+"가격은 " + price + "원 입니다");
    }
//    static void printCoffeePrice(String type) {
//        HashMap<String,Integer> priceMap = new HashMap<>();
//        priceMap.put("Americano", 3000);
//        priceMap.put("IcedAmericano", 4000);
//        priceMap.put("CafeLatte", 5000);
//        int price = priceMap.get(type);
//        System.out.println(type+"가격은 " + price + "원 입니다");
//    }
//    public static void main(String[] args) {
//        printCoffeePrice("Americano");
//
//    }
    public static void main(String[] args) {
        printCoffeePrice(CoffeeType.Americano);
    }
}
