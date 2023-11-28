package ait.pomegranate;

import ait.pomegranate.model.Box;
import ait.pomegranate.model.Pomegranate;

import java.util.*;
import java.util.stream.Collectors;

public class PomegranateAppl {

    private static Random random = new Random();

    public static void main(String[] args) {

        int countOfBoxes = random.nextInt(100, 200);

        List<Box> boxList = new ArrayList<>();

        for (int i = 0; i < countOfBoxes; i++) {
            Box box = new Box("box number " + i);
            boxList.add(box);
        }

        System.out.println("Total boxes = " + boxList.size());

        int totalCountOfPomegranates = boxList.stream()
                .map(box -> box.getCountOfGranates())
                .reduce(0, (a, b) -> a + b);

        System.out.println("Total Pomegranates in all boxes = " + totalCountOfPomegranates);

        // Task 2
        int sum2 = boxList.stream()
                .map(box -> box.getCountOfAllSeedsInBox())
                .reduce(0, (a, b) -> a + b);

        System.out.println("Total seeds in all boxes = " + sum2);

        // Task 3

        Map<String, Integer> boxNamesAndCountOfSeeds = boxList.stream()
                .collect(Collectors.toMap(Box::getName, Box::getCountOfAllSeedsInBox));

        int maxSeedInOneBox = boxNamesAndCountOfSeeds.values().stream()
                .max(Integer::compare)
                .orElse(0);
        System.out.println("Max seed in one box = " + maxSeedInOneBox);


        // Task 4

        Map.Entry<String, Integer> data = boxNamesAndCountOfSeeds.entrySet().stream()
                .filter(p -> p.getValue().equals(maxSeedInOneBox))
                .findFirst()
                .orElse(null);

        if (data != null) {
            System.out.println("Winner Box name is = " + data.getKey());
        }


    }

}
