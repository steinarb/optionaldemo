package no.priv.bang.optionaldemo.withoptional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;

class WithOptionalReturnDefaultInsteadOfThrowOnNotFoundTest {

    @Test
    void testSuccessfullyFindLeafnodeValue() {
        Integer leafnodeValue = 42;
        SomeService someService = mock(SomeService.class);
        when(someService.findSomething()).thenReturn(
            Optional.ofNullable(
                new Something().withOther(
                    new Other().withNestedOther(
                        new NestedOther().withLeafnodeValue(leafnodeValue)))));
        var demo = new WithOptionalReturnDefaultInsteadOfThrowOnNotFound(someService);

        assertEquals(leafnodeValue, demo.findLeafnodeValue());
    }

    @Test
    void testFindLeafnodeValueWhenValueNotSet() {
        SomeService someService = mock(SomeService.class);
        when(someService.findSomething()).thenReturn(
            Optional.ofNullable(
                new Something().withOther(
                    new Other().withNestedOther(new NestedOther()))));
        var demo = new WithOptionalReturnDefaultInsteadOfThrowOnNotFound(someService);

        assertNull(demo.findLeafnodeValue());
    }

    @Test
    void testFindLeafnodeValueFailsFindingNestedOther() {
        SomeService someService = mock(SomeService.class);
        when(someService.findSomething()).thenReturn(
            Optional.ofNullable(new Something().withOther(new Other())));
        var demo = new WithOptionalReturnDefaultInsteadOfThrowOnNotFound(someService);

        assertNull(demo.findLeafnodeValue());
    }

    @Test
    void testFindLeafnodeValueFailsFindingOther() {
        SomeService someService = mock(SomeService.class);
        when(someService.findSomething()).thenReturn(Optional.ofNullable(new Something()));
        var demo = new WithOptionalReturnDefaultInsteadOfThrowOnNotFound(someService);

        assertNull(demo.findLeafnodeValue());
    }

    @Test
    void testFindLeafnodeValueFailsFindingSomething() {
        SomeService someService = mock(SomeService.class);
        var demo = new WithOptionalReturnDefaultInsteadOfThrowOnNotFound(someService);

        assertNull(demo.findLeafnodeValue());
    }

}
