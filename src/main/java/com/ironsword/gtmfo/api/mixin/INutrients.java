package com.ironsword.gtmfo.api.mixin;

import it.unimi.dsi.fastutil.objects.Object2FloatMap;

public interface INutrients {
    void addNutrients(float dairy, float fruit, float grain, float protein, float vegetable);

    Object2FloatMap<String> getNutrients();
}
