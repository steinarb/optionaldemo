package no.priv.bang.optionaldemo.withoptional;

public class WithOptionalAndFlatmapChainingWithMethodReferences {

    private SomeService someService;

    public WithOptionalAndFlatmapChainingWithMethodReferences(SomeService someService) {
        this.someService = someService;
    }

    public Integer findLeafnodeValue() {
        return someService.findSomething()
            .flatMap(Something::findOther)
            .flatMap(Other::findNestedOther)
            .map(NestedOther::someValue)
            .orElse(null);
    }

}
