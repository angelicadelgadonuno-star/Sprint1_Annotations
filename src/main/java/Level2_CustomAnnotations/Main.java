package Level2_CustomAnnotations;


public class Main {
    public static void main(String[] args) throws Exception {


        Person serialPerson = new Person("Ana", 45);

        Serializer.serialize(serialPerson);

        System.out.println(serialPerson);
    }
}
