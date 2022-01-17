package no.priv.bang.optionaldemo.withoutoptional;

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
