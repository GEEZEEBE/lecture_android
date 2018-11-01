package com.example.ohsanghun.androidappwithoutevening;

import java.util.UUID;

public class CommonUtil {
    public String getUniqueSequence() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replaceAll("-", "");
    }
}
