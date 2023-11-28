package ait.pomegranate.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Box implements Iterable<Pomegranate> {
    private String name;
    private List<Pomegranate> granates;
    private static Random random = new Random();
    private int minCountOfGranates = 10;
    private int maxCountOfGranates = 20;

    public Box(String name) {
        this.name = name;
        granates = new ArrayList<>();
        addGranatesToBox();
    }

    public Box(String name, int minCountOfGranates, int maxCountOfGranates) {
        this.name = name;
        granates = new ArrayList<>();
        this.minCountOfGranates = minCountOfGranates;
        this.maxCountOfGranates = maxCountOfGranates;
        addGranatesToBox();
    }

    private void addGranatesToBox() {
        int count = random.nextInt(minCountOfGranates, maxCountOfGranates);
        for (int i = 0; i < count; i++) {
            granates.add(new Pomegranate());
        }
    }

    public String getName() {
        return name;
    }

    public int getCountOfGranates() {
        return granates.size();
    }

    public int getCountOfAllSeedsInBox() {
        return granates.stream()
                .map(p -> p.getCountOfSeeds())
                .reduce(0, (a, b) -> a + b);
    }

    @Override
    public Iterator<Pomegranate> iterator() {
        return new Iterator<Pomegranate>() {

            int counter = 0;

            @Override
            public boolean hasNext() {
                return granates.size() > counter;
            }

            @Override
            public Pomegranate next() {
                Pomegranate pomegranate = granates.get(counter);
                counter++;
                return pomegranate;
            }
        };
    }
}
