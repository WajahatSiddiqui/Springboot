package com.wajahat.learn.spring.amqp.rabbitmqmessaging.domain;

import java.io.Serializable;

/**
 * Created by wajahat on 17/5/17.
 */
public class CustomMessage implements Serializable {

    private String text;
    private int priority;
    private boolean secret;

    public CustomMessage() {}

    public CustomMessage(String text, int priority, boolean secret) {
        this.text = text;
        this.priority = priority;
        this.secret = secret;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean isSecret() {
        return secret;
    }

    public void setSecret(boolean secret) {
        this.secret = secret;
    }

    @Override
    public String toString() {
        return "CustomMessage{" +
                "text='" + text + '\'' +
                ", priority=" + priority +
                ", secret=" + secret +
                '}';
    }
}
