package no.priv.bang.optionaldemo.withoptional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;

class WithOptionalAndFlatmapChainingWithMethodReferencesTest {

    @Test
    void testSuccessfullyFindLeafnodeValue() {
        Integer leafnodeValue = 42;
        SomeService someService = mock(SomeService.class);
        when(someService.findSomething()).thenReturn(
            Optional.ofNullable(
                new Something().withOther(
                    new Other().withNestedOther(
                        new NestedOther().withLeafnodeValue(leafnodeValue)))));
        var demo = new WithOptionalAndFlatmapChainingWithMethodReferences(someService);

        assertEquals(leafnodeValue, demo.findLeafnodeValue());
    }

    @Test
    void testFindLeafnodeValueWhenValueNotSet() {
        SomeService someService = mock(SomeService.class);
        when(someService.findSomething()).thenReturn(
            Optional.ofNullable(
                new Something().withOther(
                    new Other().withNestedOther(new NestedOther()))));
        var demo = new WithOptionalAndFlatmapChainingWithMethodReferences(someService);

        assertNull(demo.findLeafnodeValue());
    }

    @Test
    void testFindLeafnodeValueFailsFindingNestedOther() {
        SomeService someService = mock(SomeService.class);
        when(someService.findSomething()).thenReturn(
            Optional.ofNullable(new Something().withOther(new Other())));
        var demo = new WithOptionalAndFlatmapChainingWithMethodReferences(someService);

        assertNull(demo.findLeafnodeValue());
    }

    @Test
    void testFindLeafnodeValueFailsFindingOther() {
        SomeService someService = mock(SomeService.class);
        when(someService.findSomething()).thenReturn(Optional.ofNullable(new Something()));
        var demo = new WithOptionalAndFlatmapChainingWithMethodReferences(someService);

        assertNull(demo.findLeafnodeValue());
    }

    @Test
    void testFindLeafnodeValueFailsFindingSomething() {
        SomeService someService = mock(SomeService.class);
        var demo = new WithOptionalAndFlatmapChainingWithMethodReferences(someService);

        assertNull(demo.findLeafnodeValue());
    }

    @Test
    void testSuccessfullyIncrementLeafnodeValue() {
        Integer leafnodeValue = 42;
        SomeService someService = mock(SomeService.class);
        when(someService.findSomething()).thenReturn(
            Optional.ofNullable(
                new Something().withOther(
                    new Other().withNestedOther(
                        new NestedOther().withLeafnodeValue(leafnodeValue)))));
        var demo = new WithOptionalAndFlatmapChainingWithMethodReferences(someService);

        assertEquals(leafnodeValue, demo.findLeafnodeValue());
        someService.findSomething()
            .flatMap(Something::findOther)
            .flatMap(Other::findNestedOther)
            .ifPresent(NestedOther::incrementSomeValue);
        assertThat(demo.findLeafnodeValue()).isGreaterThan(leafnodeValue);
    }

    @Test
    void testIncrementLeafnodeValueWhenValueNotSet() {
        SomeService someService = mock(SomeService.class);
        when(someService.findSomething()).thenReturn(
            Optional.ofNullable(
                new Something().withOther(
                    new Other().withNestedOther(new NestedOther()))));
        var demo = new WithOptionalAndFlatmapChainingWithMethodReferences(someService);

        assertNull(demo.findLeafnodeValue());
        someService.findSomething()
            .flatMap(Something::findOther)
            .flatMap(Other::findNestedOther)
            .ifPresent(NestedOther::incrementSomeValue);
        assertNull(demo.findLeafnodeValue());
    }

}
