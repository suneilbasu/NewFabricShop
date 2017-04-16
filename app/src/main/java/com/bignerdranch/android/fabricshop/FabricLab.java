package com.bignerdranch.android.fabricshop;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FabricLab {
    private static FabricLab sFabricLab;

    private List<Fabric> mFabrics;

    public static FabricLab get(Context context) {
        if (sFabricLab == null) {
            sFabricLab = new FabricLab(context);
        }

        return sFabricLab;
    }

    private FabricLab(Context context) {
        mFabrics = Fabric.initialFabrics();
    }

    public void addCrime(Fabric c) {
        mFabrics.add(c);
    }

    public List<Fabric> getFabrics() {
        return mFabrics;
    }

    public Fabric getCrime(UUID id) {
        for (Fabric fabric : mFabrics) {
            if (fabric.getId().equals(id)) {
                return fabric;
            }
        }

        return null;
    }
}
