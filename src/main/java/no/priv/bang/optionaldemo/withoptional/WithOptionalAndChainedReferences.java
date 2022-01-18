package no.priv.bang.optionaldemo.withoptional;

public class WithOptionalAndChainedReferences {

    private SomeService someService;

    public WithOptionalAndChainedReferences(SomeService someService) {
        this.someService = someService;
    }

    public Integer findLeafnodeValue() {
        return someService.findSomething().orElse(new Something())
            .findOther().orElse(new Other())
            .findNestedOther().orElse(new NestedOther())
            .someValue();
    }

}
