package machine.utils;

import machine.user.User;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Utils implements Requirements {

    private List<Integer> ingredients;

    public Utils() {}

    public Utils(List<Integer> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Integer> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Integer> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public void fillMachine() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many ml of water you want to add:");
        addWater(scanner.nextInt());
        System.out.println("Write how many ml of milk you want to add:");
        addMilk(scanner.nextInt());
        System.out.println("Write how many grams of coffee beans you want to add:");
        addBeans(scanner.nextInt());
        System.out.println("Write how many disposable cups you want to add:");
        addCups(scanner.nextInt());
    }

    @Override
    public void process(User user) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            user.commandGiven(scanner.nextLine());

            switch (user.getCommand()) {
                case "buy" -> {
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
                    user.commandGiven(scanner.nextLine());

                    switch (user.getCommand()) {
                        case "1" -> {
                            if (checkWater(250) && checkCups(1) && checkBeans(16)) {
                                System.out.println("I have enough resources, making you a coffee");
                                System.out.println();

                                removeWater(250);
                                removeBeans(16);
                                removeCups(1);
                                addMoney(4);
                            }
                        }

                        case "2" -> {
                            if (checkMilk(75) && checkWater(350) && checkBeans(20) && checkCups(1)) {
                                System.out.println("I have enough resources, making you a coffee");
                                System.out.println();

                                removeWater(350);
                                removeMilk(75);
                                removeBeans(20);
                                removeCups(1);
                                addMoney(7);
                            }
                        }

                        case "3" -> {
                            if (checkCups(1) && checkMilk(100) && checkWater(200) && checkBeans(12)) {
                                System.out.println("I have enough resources, making you a coffee");
                                System.out.println();

                                removeWater(200);
                                removeMilk(100);
                                removeCups(1);
                                removeBeans(12);
                                addMoney(6);
                            }
                        }
                    }
                }

                case "fill" -> fillMachine();

                case "take" -> {
                    System.out.println("I gave you $" + ingredients.get(4));
                    System.out.println();

                    removeMoney();
                }

                case "remaining" -> {
                    System.out.println();
                    user.welcome(new Utils(ingredients));
                }

                case "exit" -> System.exit(0);
            }
        }

    }

    @Override
    public void addWater(int amount) {
        this.ingredients.set(0, this.ingredients.get(0) + amount);
    }

    @Override
    public void addMilk(int amount) {
        this.ingredients.set(1, this.ingredients.get(1) + amount);
    }

    @Override
    public void addBeans(int amount) {
        this.ingredients.set(2, this.ingredients.get(2) + amount);
    }

    @Override
    public void addCups(int amount) {
        this.ingredients.set(3, this.ingredients.get(3) + amount);
    }

    @Override
    public void addMoney(int amount) {
        this.ingredients.set(4, this.ingredients.get(4) + amount);
    }

    @Override
    public void removeWater(int amount) {
        this.ingredients.set(0, this.ingredients.get(0) - amount);
    }

    @Override
    public void removeMilk(int amount) {
        this.ingredients.set(1, this.ingredients.get(1) - amount);
    }

    @Override
    public void removeBeans(int amount) {
        this.ingredients.set(2, this.ingredients.get(2) - amount);
    }

    @Override
    public void removeCups(int amount) {
        this.ingredients.set(3, this.ingredients.get(3) - amount);
    }

    @Override
    public void removeMoney() {
        this.ingredients.set(4, 0);
    }

    @Override
    public boolean checkWater(int amount) {
        if (this.ingredients.get(0) - amount < 0) {
            System.out.println("Sorry, not enough water!");
            return false;
        }

        return true;
    }

    @Override
    public boolean checkMilk(int amount) {
        if (this.ingredients.get(1) - amount < 0) {
            System.out.println("Sorry, not enough milk!");
            return false;
        }

        return true;
    }

    @Override
    public boolean checkBeans(int amount) {
        if (this.ingredients.get(2) - amount < 0) {
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        }

        return true;
    }

    @Override
    public boolean checkCups(int amount) {
        if (this.ingredients.get(3) - amount < 0) {
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        }

        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utils utils = (Utils) o;
        return Objects.equals(ingredients, utils.ingredients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingredients);
    }
}
