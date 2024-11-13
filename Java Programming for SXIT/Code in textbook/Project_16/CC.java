package Project_16;

interface AA {
    int STATUS = 100;
    public abstract void display();
}
interface BB {
    public abstract void show();
    public default void print(){
        System.out.println("这是BB接口的默认方式");
    }
}
public interface CC extends AA,BB{
    int NUM = 3;
}