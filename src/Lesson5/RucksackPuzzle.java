package Lesson5;

import java.util.*;

public class RucksackPuzzle {
    private float weightCapacity;
    private Set<List<Thing>> set;
    private List<Thing> singleThingArray;
    private List<Summa> listOfSumms;

    public RucksackPuzzle(float weightCapacity) {
        if (weightCapacity <= 0)
            throw new IllegalArgumentException("Illegal weight capacity of rucksack: " + weightCapacity);
        this.weightCapacity = weightCapacity;
        this.set = new HashSet<>();
        this.singleThingArray = new ArrayList<>(1);
        this.listOfSumms = new ArrayList<>();
    }

    private class Summa {
        float cost;
        List<Thing> list;

        Summa(float cost, List<Thing> list) {
            this.cost = cost;
            this.list = list;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Summa summa = (Summa) o;
            return Float.compare(summa.cost, cost) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(cost);
        }

        float getCost() {
            return cost;
        }

        List<Thing> getList() {
            return list;
        }
    }

    /*for 2 elements
    Example: for value = 1 2 result = 1, result = 2, result = 1 2*/
    private void collectTwoThings(List<Thing> array) {
        for (int i = 0; i < array.size(); i++) {
            Thing thing = array.get(i);
            singleThingArray.clear();
            singleThingArray.add(thing);
            set.add(singleThingArray);
        }
        set.add(array);
    }

    /*for 3 elements & more
    Example: for value = 1 2 3: collectTwoThings(1 2) collectTwoThings(1 3) collectTwoThings(2 3)*/
    private void collect(List<Thing> array) {
        for (int outIndex = 0; outIndex < array.size(); outIndex++) {
            List<Thing> list = new ArrayList<>(array.size() - 1);
            for (int innerIndex = 0; innerIndex < array.size(); innerIndex++) {
                if (outIndex != innerIndex) {
                    list.add(array.get(innerIndex));
                }
            }
            if (list.size() == 2)
                collectTwoThings(list);
            else collect(list);
        }
        set.add(array);
    }

    public void pack(ArrayList<Thing> list) {
        selectThings(list);
        collect(list);
        calculateTotalWeight();
        List<List<Thing>> resultLists = findListsWithMaxWeight();
        outputResult(resultLists);
    }

    private List<List<Thing>> findListsWithMaxWeight() {
        float maxWeight = 0;
        List<List<Thing>> resultLists = new ArrayList<>();
        for (Summa summ : listOfSumms) {
            float weight = summ.getCost();
            if (Float.compare(weight, maxWeight) < 0)
                continue;

            List<Thing> list = summ.getList();

            if (Float.compare(weight, maxWeight) > 0) {
                maxWeight = weight;
                resultLists.clear();
            }
            resultLists.add(list);
        }
        return resultLists;
    }

    private void calculateTotalWeight() {
        for (List<Thing> list : set) {
            calculateListWeightAndPutResultInListOfSumms(list);
        }
    }

    private void calculateListWeightAndPutResultInListOfSumms(List<Thing> list) {
        float totalWeight = 0;
        float totalCost = 0;
        for (Thing thing : list) {
            totalWeight += thing.getWeight();
            if (Float.compare(totalWeight, weightCapacity) > 0)
                return;
            totalCost += thing.getCost();
        }
        Summa totalSumm = new Summa(totalCost, list);
        listOfSumms.add(totalSumm);
    }

    /**
     * remove things from list, if its weight more than rucksack capacity or cost equals 0
     */
    private void selectThings(ArrayList<Thing> list) {
        Iterator<Thing> iterator = list.iterator();
        while (iterator.hasNext()) {
            Thing thing = iterator.next();
            if (thing.getWeight() > weightCapacity
                    || thing.getCost() == 0)
                iterator.remove();
        }
    }

    public static void main(String[] args) {
        RucksackPuzzle puzzle = new RucksackPuzzle(800f);
        ArrayList<Thing> list = new ArrayList<>(Arrays.asList(new Thing("бинокль", 300f, 5000f),
                new Thing("котелок", 1000f, 1_500f),
                new Thing("учебник по Java", 1000f, 1_500f),
                new Thing("кружка", 200f, 90f),
                new Thing("тарелка", 230f, 110f),
                new Thing("аптечка", 230f, 2_000f),
                new Thing("фумигатор", 50f, 100f),
                new Thing("туалетная бумага", 60f, 100f),
                new Thing("компас", 50f, 2_000f),
                new Thing("телефон", 150f, 60_000f),
                new Thing("картошка", 5000f, 300f),
                new Thing("кольцо с бриллиантом", 10f, 3_000_000f),
                new Thing("палатка", 10_000f, 15_000f),
                new Thing("крупа", 500f, 40f)

        ));
        puzzle.pack(list);
    }

    private void outputResult(List<List<Thing>> lists) {
        System.out.println("Rucksack with total capacity "+weightCapacity+" can contain the following sets of things with maximum total cost:");
        int numberOfSet = 1;
        for (List<Thing> list : lists) {
            printList(list,numberOfSet);
            numberOfSet++;
        }
    }

    private void printList(List<Thing> list, int numberOfSet) {
        System.out.println("------------------------------");
        float totalWeight = 0;
        float totalCost = 0;
        for (Thing th : list) {
            totalWeight+=th.getWeight();
            totalCost+=th.getCost();
            System.out.println(th.toString());
        }
        System.out.println("Set № "+numberOfSet+": total cost = "+totalCost+", total weight = "+totalWeight);
    }
}
