package Level1_BasicAnnotations.Override;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeprecatedCallerTest {

    @Test
    @SuppressWarnings("deprecation")
    void callDeprecatedMethodsRunsWithoutException() {
        DeprecatedCaller caller = new DeprecatedCaller();
        assertDoesNotThrow(()-> caller.callDeprecatedMethods());
    }
}