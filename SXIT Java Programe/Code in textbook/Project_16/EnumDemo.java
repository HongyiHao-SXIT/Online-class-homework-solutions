package Project_16;

public class EnumDemo {
    public static void main(String[] args) {
        var left = Direction.WEST;
        System.out.println(left);
        for(var d: Direction.values()){
            System.out.println(d.name() + "，序号" + d.ordinal());
        }
    }
}
