
public class Pet {
    private static String className;
    private static String classAnimal;
    private static int classAge;

    public Pet(String name, String animal, int age){
        className = name ;
        classAnimal = animal;
        classAge = age;
    }
    public static String getName(){
        return className;
    }
    public static String getAnimal(){
        return classAnimal;
    }
    public static int getAge(){
        return classAge;
    }
    public static void setName(String name){
        className = name;
    }
    public static void setAnimal(String animal){
        classAnimal = animal;
    }
    public static void setAge(int age){
        classAge = age;
    }
    public static void main(String[] args){
    }
}
