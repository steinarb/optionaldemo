package no.priv.bang.optionaldemo.withoptional;

public class WithOptionalReturnDefaultInsteadOfThrowOnNotFound {

    private SomeService someService;

    public WithOptionalReturnDefaultInsteadOfThrowOnNotFound(SomeService someService) {
        this.someService = someService;
    }

    public Integer findLeafnodeValue() {
        Something something = someService.findSomething().orElse(new Something());
        Other other = something.findOther().orElse(new Other());
        NestedOther nestedOther = other.findNestedOther().orElse(new NestedOther());
        return nestedOther.someValue();
    }

}
