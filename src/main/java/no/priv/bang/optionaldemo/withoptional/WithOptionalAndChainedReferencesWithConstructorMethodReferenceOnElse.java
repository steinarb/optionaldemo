package no.priv.bang.optionaldemo.withoptional;

public class WithOptionalAndChainedReferencesWithConstructorMethodReferenceOnElse {

    private SomeService someService;

    public WithOptionalAndChainedReferencesWithConstructorMethodReferenceOnElse(SomeService someService) {
        this.someService = someService;
    }

    public Integer findLeafnodeValue() {
        return someService.findSomething().orElseGet(Something::new)
            .findOther().orElseGet(Other::new)
            .findNestedOther().orElseGet(NestedOther::new)
            .someValue();
    }

}
