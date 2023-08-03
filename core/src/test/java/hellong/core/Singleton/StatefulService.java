package hellong.core.Singleton;

public class StatefulService {
    private int price;

    public void order(String name, int price){
        System.out.println("name = " + name + "price = " + price);
        this.price=price;// 문제 발생지점
    }
    public int getPrice(){
        return price;
    }

}
