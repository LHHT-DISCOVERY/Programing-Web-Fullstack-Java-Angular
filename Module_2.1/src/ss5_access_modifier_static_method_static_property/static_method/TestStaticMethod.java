package ss5_access_modifier_static_method_static_property.static_method;

public class TestStaticMethod {
    public static void main(String[] args) {
        Student.change();
        //or
        Student a = new Student();
        a.change();

        Student s1 = new Student(111, "Hoang");
        Student s2 = new Student(222, "Khanh");
        Student s3 = new Student(333, "Nam");

        s1.display();
        s2.display();
        s3.display();
    }
}
