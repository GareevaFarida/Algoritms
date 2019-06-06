package Lesson6;

import java.util.Random;

public class CheckOfBalanceTrees {
    public static final int NUMBER_OF_TREES = 20;
    public static final int MIN_NUMBER = -20;
    public static final int MAX_NUMBER = 20;
    public static final int COUNT_OF_LEVELS = 4;
    public static final int COUNT_OF_NODES = (int) Math.pow(2, COUNT_OF_LEVELS) - 1;

    Tree<Integer>[] trees = new Tree[NUMBER_OF_TREES];

    public void InitTrees() {
        int balancedTrees = 0;
        for (int i = 0; i < NUMBER_OF_TREES; i++) {
            TreeImpl<Integer> tree = new TreeImpl<>();
            InitNewTree(tree);
           // tree.display();
            trees[i] = tree;
            if(tree.isBalanced())balancedTrees++;
        }
        System.out.println("Percent of balanced trees is "+(int)(100*balancedTrees/NUMBER_OF_TREES)+"%");
    }

    private void InitNewTree(TreeImpl<Integer> tree) {
        for (int i = 0; i < COUNT_OF_NODES; i++) {
            int value = RandomGenerator.getIntValueInRange(MIN_NUMBER, MAX_NUMBER);
            tree.add(value);
            int deepOfValue = tree.deepOfValue(value);
            if ((deepOfValue) > COUNT_OF_LEVELS-1)
                tree.remove(value);
        }
    }

    public static void main(String[] args) {
        CheckOfBalanceTrees check = new CheckOfBalanceTrees();
        check.InitTrees();
    }
}
