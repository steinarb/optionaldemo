package no.priv.bang.optionaldemo.withoptional;

import java.util.Optional;

import no.priv.bang.optionaldemo.OptionaldemoException;

public class ClumsyWithOptional {

    private SomeService someService;

    public ClumsyWithOptional(SomeService someService) {
        this.someService = someService;
    }

    public Integer findLeafnodeValue() {
        Optional<Something> something = someService.findSomething();
        if (something.isEmpty()) {
            throw new OptionaldemoException("Unable to find Something when looking for leafnodeValue");
        }

        Optional<Other> other = something.get().findOther();
        if (other.isEmpty()) {
            throw new OptionaldemoException("Unable to find Other when looking for leafnodeValue");
        }

        Optional<NestedOther> nestedOther = other.get().findNestedOther();
        if (nestedOther.isEmpty()) {
            throw new OptionaldemoException("Unable to find NestedOther when looking for leafnodeValue");
        }

        return nestedOther.get().someValue();
    }

}
