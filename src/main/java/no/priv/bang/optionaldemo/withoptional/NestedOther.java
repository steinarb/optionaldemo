package no.priv.bang.optionaldemo.withoptional;

public class NestedOther {

    private Integer leafnodeValue;

    public Integer someValue() {
        return leafnodeValue;
    }

    public NestedOther withLeafnodeValue(Integer leafnodeValue) {
        this.leafnodeValue = leafnodeValue;
        return this;
    }

}
