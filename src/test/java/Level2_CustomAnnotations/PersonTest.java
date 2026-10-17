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
}