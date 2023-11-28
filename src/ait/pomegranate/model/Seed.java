package ait.pomegranate.model;

public class Seed {
    private double weight;

    public Seed(double weight) {
        this.weight = weight;
    }

    public Seed() {
        this.weight = 2;
    }

    public double getWeight() {
        return weight;
    }
}
