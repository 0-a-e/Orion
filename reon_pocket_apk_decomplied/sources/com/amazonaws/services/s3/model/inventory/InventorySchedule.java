package com.amazonaws.services.s3.model.inventory;

import java.io.Serializable;

public class InventorySchedule implements Serializable {
    private String frequency;

    public String getFrequency() {
        return this.frequency;
    }

    public void setFrequency(String str) {
        this.frequency = str;
    }

    public void setFrequency(InventoryFrequency inventoryFrequency) {
        String str;
        if (inventoryFrequency == null) {
            str = null;
            String str2 = null;
        } else {
            str = inventoryFrequency.toString();
        }
        setFrequency(str);
    }

    public InventorySchedule withFrequency(String str) {
        setFrequency(str);
        return this;
    }

    public InventorySchedule withFrequency(InventoryFrequency inventoryFrequency) {
        setFrequency(inventoryFrequency);
        return this;
    }
}
