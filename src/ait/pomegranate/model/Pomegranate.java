package ait.pomegranate.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Pomegranate implements Iterable<Seed> {
    private List<Seed> seeds;
    private static Random random = new Random();
    private int minCountOfSeeds = 400;
    private int maxCountOfSeeds = 700;

    public Pomegranate(int minCountOfSeeds, int maxCountOfSeeds) {
        this.minCountOfSeeds = minCountOfSeeds;
        this.maxCountOfSeeds = maxCountOfSeeds;
        seeds = new ArrayList<>();
        addSeedsToGranate();
    }

    public Pomegranate() {
        seeds = new ArrayList<>();
        addSeedsToGranate();
    }

    private void addSeedsToGranate() {
        int count = random.nextInt(minCountOfSeeds, maxCountOfSeeds);
        for (int i = 0; i < count; i++) {
            seeds.add(new Seed());
        }
    }

    public int getCountOfSeeds(){
        return seeds.size();
    }



    @Override
    public Iterator<Seed> iterator() {
        return new Iterator<Seed>() {
            int counter = 0;

            @Override
            public boolean hasNext() {
                return seeds.size() > counter;
            }

            @Override
            public Seed next() {
                Seed seed = seeds.get(counter);
                counter++;
                return seed;
            }
        };
    }
}
