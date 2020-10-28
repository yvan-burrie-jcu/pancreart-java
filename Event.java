package jcu.cp3407.pancreart.model;

import org.json.*;

public class Event {

    public long userId;

    public long time;

    public float amount;

    public Event(long userId, long time, float amount) {
        this.userId = userId;
        this.time = time;
        this.amount = amount;
    }

    public Event(JSONObject buffer) throws JSONException {
        userId = buffer.getLong("userId");
        time = buffer.getLong("time");
        amount = buffer.getFloat("amount");
    }

    public JSONObject serialize() throws JSONException {
        JSONObject buffer = new JSONObject();
        buffer.put("userId", userId);
        buffer.put("time", time);
        buffer.put("amount", amount);
        return buffer;
    }
}
