package Project_16;

public class DD implements CC {
    @Override
    public void display(){
        System.out.println("实现AA接口的diaplay方法");
    }
    @Override
    public void show(){
        System.out.println("实现BB接口的show方法");
    }
    public static void main(String[] args){
        DD dd = new DD();
        System.out.println(DD.STATUS);
        dd.show();
        dd.print();
        AA aa = new DD();
        aa.display();
    }
}
