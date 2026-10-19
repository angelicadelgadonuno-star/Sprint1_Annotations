package Level2_CustomAnnotations;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Serializer {

    public static void serialize(Object obj) throws IOException {
        Class<?> clazz = obj.getClass();

        if (clazz.isAnnotationPresent(JsonSerializable.class)) {
            JsonSerializable annotation = clazz.getAnnotation(JsonSerializable.class);
            String directoryPath = annotation.directory();

            File directory = new File(directoryPath);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            Person person = (Person) obj;
            String json = String.format("{\n  \"name\": \"%s\",\n  \"age\": %d\n}",
                    person.getName(), person.getAge());

            File file = new File(directory, clazz.getSimpleName() + ".json");
            try (FileWriter writer = new FileWriter(file)) {
                writer.write(json);
            }

            System.out.println("File saved at: " + file.getAbsolutePath());
        } else {
            System.out.println("The class is not annotated with @JsonSerializable");
        }
    }

}







