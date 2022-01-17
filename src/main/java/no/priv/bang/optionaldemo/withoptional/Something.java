package no.priv.bang.optionaldemo.withoptional;

import java.util.Optional;

public class Something {

    private Other other;

    public Optional<Other> findOther() {
        return Optional.ofNullable(other);
    }

    public Something withOther(Other other) {
        this.other = other;
        return this;
    }

}
