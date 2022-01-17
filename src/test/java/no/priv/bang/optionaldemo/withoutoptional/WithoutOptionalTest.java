package no.priv.bang.optionaldemo.withoutoptional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

import no.priv.bang.optionaldemo.OptionaldemoException;

class WithoutOptionalTest {

    @Test
    void testSuccessfullyFindLeafnodeValue() {
        Integer leafnodeValue = 42;
        SomeService someService = mock(SomeService.class);
        when(someService.findSomething()).thenReturn(
            new Something().withOther(
                new Other().withNestedOther(
                    new NestedOther().withLeafnodeValue(leafnodeValue))));
        var demo = new WithoutOptional(someService);

        assertEquals(leafnodeValue, demo.findLeafnodeValue());
    }

    @Test
    void testFindLeafnodeValueWhenValueNotSet() {
        SomeService someService = mock(SomeService.class);
        when(someService.findSomething()).thenReturn(
            new Something().withOther(
                new Other().withNestedOther(new NestedOther())));
        var demo = new WithoutOptional(someService);

        assertNull(demo.findLeafnodeValue());
    }

    @Test
    void testFindLeafnodeValueFailsFindingNestedOther() {
        SomeService someService = mock(SomeService.class);
        when(someService.findSomething()).thenReturn(
            new Something().withOther(new Other()));
        var demo = new WithoutOptional(someService);

        var e = assertThrows(OptionaldemoException.class, () -> demo.findLeafnodeValue());
        assertThat(e.getMessage()).startsWith("Unable to find NestedOther when looking for leafnodeValue");
    }

    @Test
    void testFindLeafnodeValueFailsFindingOther() {
        SomeService someService = mock(SomeService.class);
        when(someService.findSomething()).thenReturn(new Something());
        var demo = new WithoutOptional(someService);

        var e = assertThrows(OptionaldemoException.class, () -> demo.findLeafnodeValue());
        assertThat(e.getMessage()).startsWith("Unable to find Other when looking for leafnodeValue");
    }

    @Test
    void testFindLeafnodeValueFailsFindingSomething() {
        SomeService someService = mock(SomeService.class);
        var demo = new WithoutOptional(someService);

        var e = assertThrows(OptionaldemoException.class, () -> demo.findLeafnodeValue());
        assertThat(e.getMessage()).startsWith("Unable to find Something when looking for leafnodeValue");
    }

}
