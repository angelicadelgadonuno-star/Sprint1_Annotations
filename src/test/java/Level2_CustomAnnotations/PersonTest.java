package Level2_CustomAnnotations;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void classIsAnnotatedWithJsonSerializable() {
        assertTrue(Person.class.isAnnotationPresent(JsonSerializable.class));
    }

    @Test
    void annotationHasCorrectDirectory() {
        JsonSerializable annotation = Person.class.getAnnotation(JsonSerializable.class);
        assertNotNull(annotation);
        assertEquals("output/", annotation.directory());
    }

    @Test
    void serializerCreatesJsonFileSuccessfully() throws Exception {
        Person person = new Person("TestName", 30);
        java.io.File expectedFile = new java.io.File("output/Person.json");
        if (expectedFile.exists()) {
            expectedFile.delete();
        }
        Serializer.serialize(person);
        assertTrue(expectedFile.exists(), "The Json file should have been created");
        expectedFile.delete();
    }
}