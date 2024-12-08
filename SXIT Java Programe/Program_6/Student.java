package Program_6;
class Student {
    int Id;
    String Name;
    String Banji;
    public void setter() {
        this.Id = 1905000;
        this.Name = "李四";
        this.Banji = "4班";
    }

    public void get() {
        System.out.println("学号: " + Id);
        System.out.println("姓名: " + Name);
        System.out.println("班级: " + Banji);
    }
    public static void main(String[] args) {
        Student s = new Student();
        s.setter();
        s.get(); 
    }
}
