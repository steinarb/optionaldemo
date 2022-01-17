package no.priv.bang.optionaldemo.withoutoptional;

public class Something {

    private Other other;

    public Other findOther() {
        return other;
    }

    public Something withOther(Other other) {
        this.other = other;
        return this;
    }

}
