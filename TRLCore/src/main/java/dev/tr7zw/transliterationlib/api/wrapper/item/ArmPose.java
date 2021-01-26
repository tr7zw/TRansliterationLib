package dev.tr7zw.transliterationlib.api.wrapper.item;

public enum ArmPose {
    EMPTY(false),
    ITEM(false),
    BLOCK(false),
    BOW_AND_ARROW(true),
    THROW_SPEAR(false),
    CROSSBOW_CHARGE(true),
    CROSSBOW_HOLD(true);

    private final boolean twoHanded;

    private ArmPose(boolean twoHanded) {
       this.twoHanded = twoHanded;
    }

    public boolean isTwoHanded() {
       return this.twoHanded;
    }
}
