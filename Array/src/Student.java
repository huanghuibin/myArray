public class Student {
    public String name;

    public int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString(){
        return String.format("Student(name:%s, age: %d)",name,age);
    }

    public static void main(String[] args) {
        Array<Student> studentArray = new Array<>();
        studentArray.addLast(new Student("辣鸡",23));
        studentArray.addLast(new Student("豪哥",23));
        studentArray.addLast(new Student("陈斌",23));
        System.out.println(studentArray);
    }
}
