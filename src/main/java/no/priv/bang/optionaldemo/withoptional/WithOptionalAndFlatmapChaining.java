package no.priv.bang.optionaldemo.withoptional;

public class WithOptionalAndFlatmapChaining {

    private SomeService someService;

    public WithOptionalAndFlatmapChaining(SomeService someService) {
        this.someService = someService;
    }

    public Integer findLeafnodeValue() {
        return someService.findSomething()
            .flatMap(s -> s.findOther())
            .flatMap(o -> o.findNestedOther())
            .map(n -> n.someValue())
            .orElse(null);
    }

}
