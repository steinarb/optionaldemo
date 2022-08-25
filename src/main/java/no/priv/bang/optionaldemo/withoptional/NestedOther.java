package no.priv.bang.optionaldemo.withoptional;

import java.util.Optional;

public class NestedOther {

    private Integer leafnodeValue;

    public Integer someValue() {
        return leafnodeValue;
    }

    public void incrementSomeValue() {
        Optional.ofNullable(leafnodeValue)
            .ifPresent(leafnode -> this.leafnodeValue = ++leafnode);
    }

    public NestedOther withLeafnodeValue(Integer leafnodeValue) {
        this.leafnodeValue = leafnodeValue;
        return this;
    }

}
