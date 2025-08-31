package com.parmida.common.converter;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;

public class JsonConverter {
    public static <D> String toJsonString(D d) {
        Jsonb jsonb = JsonbBuilder.create();
        return jsonb.toJson(d);
    }

    public static <D> D fromString(String json, Class<D> e) {
        return JsonbBuilder.create().fromJson(json, e);
    }
}
