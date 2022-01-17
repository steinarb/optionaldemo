package no.priv.bang.optionaldemo.withoutoptional;

public class Other {

    private NestedOther nestedOther;

    public NestedOther findNestedOther() {
        return nestedOther;
    }

    public Other withNestedOther(NestedOther nestedOther) {
        this.nestedOther = nestedOther;
        return this;
    }

}
