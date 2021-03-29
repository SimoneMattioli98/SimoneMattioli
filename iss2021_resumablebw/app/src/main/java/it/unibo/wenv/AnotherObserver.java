package it.unibo.wenv;

import it.unibo.interaction.IssObserver;
import org.json.JSONObject;

import java.util.Observer;

public class AnotherObserver implements IssObserver {
    @Override
    public void handleInfo(String info) {
        System.out.println("AnotherObserver | " + info);
    }

    @Override
    public void handleInfo(JSONObject info) {
        handleInfo(info.toString());
    }
}
