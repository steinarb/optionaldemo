package no.priv.bang.optionaldemo.withoptional;

import java.util.Optional;

public class Other {

    private NestedOther nestedOther;

    public Optional<NestedOther> findNestedOther() {
        return Optional.ofNullable(nestedOther);
    }

    public Other withNestedOther(NestedOther nestedOther) {
        this.nestedOther = nestedOther;
        return this;
    }

}
