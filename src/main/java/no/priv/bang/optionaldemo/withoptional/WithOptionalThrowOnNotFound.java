package no.priv.bang.optionaldemo.withoptional;

import no.priv.bang.optionaldemo.OptionaldemoException;

public class WithOptionalThrowOnNotFound {

    private SomeService someService;

    public WithOptionalThrowOnNotFound(SomeService someService) {
        this.someService = someService;
    }

    public Integer findLeafnodeValue() {
        Something something = someService.findSomething()
            .orElseThrow(() -> new OptionaldemoException("Unable to find Something when looking for leafnodeValue"));

        Other other = something.findOther()
            .orElseThrow(() -> new OptionaldemoException("Unable to find Other when looking for leafnodeValue"));

        NestedOther nestedOther = other.findNestedOther()
            .orElseThrow(() -> new OptionaldemoException("Unable to find NestedOther when looking for leafnodeValue"));

        return nestedOther.someValue();
    }

}
