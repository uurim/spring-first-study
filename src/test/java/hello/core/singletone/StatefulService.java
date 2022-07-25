package hello.core.singletone;

public class StatefulService {

    private int price; // 상태 유지 필드

    public int order(String name, int price){
        System.out.println("name = " + name + " price = " + price);
//        this.price = price; //여기가 문제!
        return price;
    }
    public int getPrice(){
        // return price;
    }
}
