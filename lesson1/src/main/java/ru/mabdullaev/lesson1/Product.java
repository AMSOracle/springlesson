package ru.mabdullaev.lesson1;

public class Product {
    public int id;
    public String title;
    public int cost;

    public Product(int id, String title, int cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", title='" + title + ", cost=" + cost;
    }
}
