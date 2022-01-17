package no.priv.bang.optionaldemo.withoutoptional;

import no.priv.bang.optionaldemo.OptionaldemoException;

public class WithoutOptional {

    private SomeService someService;

    public WithoutOptional(SomeService someService) {
        this.someService = someService;
    }

    public Integer findLeafnodeValue() {
        Something something = someService.findSomething();
        if (something == null) {
            throw new OptionaldemoException("Unable to find Something when looking for leafnodeValue");
        }

        Other other = something.findOther();
        if (other == null) {
            throw new OptionaldemoException("Unable to find Other when looking for leafnodeValue");
        }

        NestedOther nestedOther = other.findNestedOther();
        if (nestedOther == null) {
            throw new OptionaldemoException("Unable to find NestedOther when looking for leafnodeValue");
        }

        return nestedOther.someValue();
    }

}
