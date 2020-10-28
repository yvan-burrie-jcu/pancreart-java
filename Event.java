package jcu.cp3407.pancreart.model;

import org.json.*;

public class Event {

    protected long userId;

    protected long time;

    protected float amount;

    Event(long userId, long time, float amount) {
        this.userId = userId;
        this.time = time;
        this.amount = amount;
    }

    Event(JSONObject buffer) throws JSONException {
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
