public class Main {
    public static void main(String[] args){
        Pet dog = new Pet("woof", "dog", 5);


        System.out.println(dog.getName());
        System.out.println(dog.getAnimal());
        System.out.println(dog.getAge());

        System.out.println();
        System.out.println("changing name to spot...");
        System.out.println("changing animal to cat...");
        System.out.println("changing age to 2...");

        dog.setName("spot");
        dog.setAnimal("cat");
        dog.setAge(2);

        System.out.println();
        System.out.println(dog.getName());
        System.out.println(dog.getAnimal());
        System.out.println(dog.getAge());
    }
}
