package jcu.cp3407.pancreart.model;

import org.json.*;

public class Event {

    public long userId;

    enum Type {
        GLUCOSE_READING,
        INSULIN_INJECTION,
    }

    public Type type;

    public long time;

    public double amount;

    public Event(long userId, Type type, long time, double amount) {
        this.userId = userId;
        this.type = type;
        this.time = time;
        this.amount = amount;
    }

    public Event(JSONObject buffer) throws JSONException {
        userId = buffer.getLong("userId");
        int typeBuffer = buffer.getInt("type");
        if (typeBuffer == Type.GLUCOSE_READING.ordinal()) {
            type = Type.GLUCOSE_READING;
        } else if (typeBuffer == Type.INSULIN_INJECTION.ordinal()) {
            type = Type.INSULIN_INJECTION;
        }
        time = buffer.getLong("time");
        amount = buffer.getFloat("amount");
    }

    public JSONObject serialize() throws JSONException {
        JSONObject buffer = new JSONObject();
        buffer.put("userId", userId);
        buffer.put("type", type.ordinal());
        buffer.put("time", time);
        buffer.put("amount", amount);
        return buffer;
    }
}
