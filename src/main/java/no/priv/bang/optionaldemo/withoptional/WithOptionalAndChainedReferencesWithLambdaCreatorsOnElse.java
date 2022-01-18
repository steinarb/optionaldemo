package no.priv.bang.optionaldemo.withoptional;

public class WithOptionalAndChainedReferencesWithLambdaCreatorsOnElse {

    private SomeService someService;

    public WithOptionalAndChainedReferencesWithLambdaCreatorsOnElse(SomeService someService) {
        this.someService = someService;
    }

    public Integer findLeafnodeValue() {
        return someService.findSomething().orElseGet(() -> new Something())
            .findOther().orElseGet(() -> new Other())
            .findNestedOther().orElseGet(() -> new NestedOther())
            .someValue();
    }

}
