package Program_6;

public class Clock {
    
    int hour;
    int minute;
    int second;

   
    public Clock(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }
    public void printTime() {
        System.out.println("时间: " + hour + ":" + minute + ":" + second);
    }
    public static void main(String[] args) {
        Clock p1 = new Clock(2, 30, 40);
        Clock p2 = new Clock(4, 50, 10);
        Clock p3 = new Clock(8, 30, 0);
        p1.printTime();
        p2.printTime();
        p3.printTime();
    }
    
}
