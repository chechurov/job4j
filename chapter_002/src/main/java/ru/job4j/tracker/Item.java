package ru.job4j.tracker;

import java.util.Objects;

/**
 * Класс описывают бизнес модель заявки.
 */
public class Item {
    private String id;
    private String name;
    private String desc;
    private long time;

    public Item(String name, String decs, long time) {
        this.name = name;
        this.desc = decs;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String decs) {
        this.desc = decs;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return time == item.time && Objects.equals(id, item.id) && Objects.equals(name, item.name) && Objects.equals(desc, item.desc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, desc, time);
    }

    @Override
    public String toString() {
        return "Name: " + this.name
                + " | Description: " + this.desc
                + " | Id: " + this.id
                + " | Creation time: " + this.time;
    }
}