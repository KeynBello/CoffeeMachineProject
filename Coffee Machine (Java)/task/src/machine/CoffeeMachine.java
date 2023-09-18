package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static final Scanner SCANNER = new Scanner(System.in);
    public static final int WATER_ESPRESSO = 250;
    public static final int WATER_LATTE = 350;
    public static final int WATER_CAPPUCCINO = 200;
    public static final int MILK_LATTE = 75;
    public static final int MILK_CAPPUCCINO = 100;
    public static final int COFFEE_ESPRESSO = 16;
    public static final int COFFEE_LATTE = 20;
    public static final int COFFEE_CAPPUCCINO = 12;

    public static final int CUP_FOR_PORTION = 1;
    public static final int PRICE_ESPRESSO = 4;
    public static final int PRICE_LATTE = 7;
    public static final int PRICE_CAPPUCCINO = 6;
    private int cupsInMachine = 9;
    private int waterInMachine = 400;
    private int milkInMachine = 540;
    private int coffeeBeansInMachine = 120;
    private int cupsToMake;
    private int moneyBalance = 550;

    public CoffeeMachine() {
    }

    public CoffeeMachine(int waterInMachine, int milkInMachine, int coffeeBeansInMachine) {
        this.waterInMachine = waterInMachine;
        this.milkInMachine = milkInMachine;
        this.coffeeBeansInMachine = coffeeBeansInMachine;
    }

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();

        coffeeMachine.coffeeShopOffer();

    }

    public int getMoneyBalance() {
        return moneyBalance;
    }

    public void setMoneyBalance(int moneyBalance) {
        this.moneyBalance = moneyBalance;
    }

    public int getCupsToMake() {
        return cupsToMake;
    }

    public void setCupsToMake(int cupsToMake) {
        this.cupsToMake = cupsToMake;
    }

    public int getCupsInMachine() {
        return cupsInMachine;
    }

    public void setCupsInMachine(int cupsInMachine) {
        this.cupsInMachine = cupsInMachine;
    }

    public int getWaterInMachine() {
        return waterInMachine;
    }

    public void setWaterInMachine(int waterInMachine) {
        this.waterInMachine = waterInMachine;
    }

    public int getMilkInMachine() {
        return milkInMachine;
    }

    public void setMilkInMachine(int milkInMachine) {
        this.milkInMachine = milkInMachine;
    }

    public int getCoffeeBeansInMachine() {
        return coffeeBeansInMachine;
    }

    public void setCoffeeBeansInMachine(int coffeeBeansInMachine) {
        this.coffeeBeansInMachine = coffeeBeansInMachine;
    }

    public void coffeeMachineStatus() {
        System.out.format("%nThe coffee machine has:%n" + "%d ml of water%n" + "%d ml of milk%n" + "%d g of coffee beans%n" + "%d disposable cups%n" + "$%d of money%n" + "%n", getWaterInMachine(), getMilkInMachine(), getCoffeeBeansInMachine(), getCupsInMachine(), getMoneyBalance());
    }

    public boolean canMakeEspresso() {
        if (isEnoughWater(WATER_ESPRESSO)) {
            if (isEnoughCoffeeBeans(COFFEE_ESPRESSO)) {
                System.out.format("%nI have enough resources, making you a coffee!%n");
                return true;
            } else {
                System.out.format("%nSorry, not enough coffee beans!%n");
                return false;
            }
        } else {
            System.out.format("%nSorry, not enough water!%n");
            return false;
        }
    }

    public boolean canMakeLatte() {
        if (isEnoughWater(WATER_LATTE)) {
            if (isEnoughCoffeeBeans(COFFEE_LATTE)) {
                if (isEnoughMilk(MILK_LATTE)) {
                    System.out.format("%nI have enough resources, making you a coffee!%n");
                    return true;
                } else {
                    System.out.format("%nSorry, not enough milk!%n");
                    return false;
                }
            } else {
                System.out.format("%nSorry, not enough coffee beans!%n");
                return false;
            }
        } else {
            System.out.format("%nSorry, not enough water!%n");
            return false;
        }
    }

    public boolean canMakeCappuccino() {
        if (isEnoughWater(WATER_CAPPUCCINO)) {
            if (isEnoughCoffeeBeans(COFFEE_CAPPUCCINO)) {
                if (isEnoughMilk(MILK_CAPPUCCINO)) {
                    System.out.format("%nI have enough resources, making you a coffee!%n");
                    return true;
                } else {
                    System.out.format("%nSorry, not enough milk!%n");
                    return false;
                }
            } else {
                System.out.format("%nSorry, not enough coffee beans!%n");
                return false;
            }
        } else {
            System.out.format("%nSorry, not enough water!%n");
            return false;
        }
    }

    public boolean isEnoughWater(int water) {
        return getWaterInMachine() >= water;
    }

    public boolean isEnoughMilk(int milk) {
        return getMilkInMachine() >= milk;
    }

    public boolean isEnoughCoffeeBeans(int coffee) {
        return getCoffeeBeansInMachine() >= coffee;
    }

    public void sellEspresso() {
        if (canMakeEspresso()) {
            setWaterInMachine(getWaterInMachine() - WATER_ESPRESSO);
            setCoffeeBeansInMachine(getCoffeeBeansInMachine() - COFFEE_ESPRESSO);
            setCupsInMachine(getCupsInMachine() - CUP_FOR_PORTION);
            setMoneyBalance(getMoneyBalance() + PRICE_ESPRESSO);
        }
    }

    public void sellLatte() {
        if (canMakeLatte()) {
            setWaterInMachine(getWaterInMachine() - WATER_LATTE);
            setMilkInMachine(getMilkInMachine() - MILK_LATTE);
            setCoffeeBeansInMachine(getCoffeeBeansInMachine() - COFFEE_LATTE);
            setCupsInMachine(getCupsInMachine() - CUP_FOR_PORTION);
            setMoneyBalance(getMoneyBalance() + PRICE_LATTE);
        }
    }

    public void sellCappuccino() {
        if (canMakeCappuccino()) {
            setWaterInMachine(getWaterInMachine() - WATER_CAPPUCCINO);
            setMilkInMachine(getMilkInMachine() - MILK_CAPPUCCINO);
            setCoffeeBeansInMachine(getCoffeeBeansInMachine() - COFFEE_CAPPUCCINO);
            setCupsInMachine(getCupsInMachine() - CUP_FOR_PORTION);
            setMoneyBalance(getMoneyBalance() + PRICE_CAPPUCCINO);
        }
    }

    public void fillWater() {
        System.out.println("Write how many ml of water you want to add:");
        int amountOfWater = SCANNER.nextInt();
        SCANNER.nextLine();
        setWaterInMachine(getWaterInMachine() + amountOfWater);
    }

    public void fillMilk() {
        System.out.println("Write how many ml of you want to add:");
        int amountOfMilk = SCANNER.nextInt();
        SCANNER.nextLine();
        setMilkInMachine(getMilkInMachine() + amountOfMilk);
    }

    public void fillCoffeeBeans() {
        System.out.println("Write how many grams of coffee beans you want to add:");
        int amountOfCoffeeBeans = SCANNER.nextInt();
        SCANNER.nextLine();
        setCoffeeBeansInMachine(getCoffeeBeansInMachine() + amountOfCoffeeBeans);
    }

    public void fillCups() {
        System.out.println("Write how many ml of water you want to add:");
        int amountOfCups = SCANNER.nextInt();
        SCANNER.nextLine();
        setCupsInMachine(getCupsInMachine() + amountOfCups);
    }

    public void buyOption() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back:");
        String buyOption = SCANNER.nextLine();
        switch (buyOption) {
            case "1" -> sellEspresso();
            case "2" -> sellLatte();
            case "3" -> sellCappuccino();
            case "back" -> coffeeShopOffer();
            default -> throw new IllegalStateException("Unexpected value: " + buyOption);
        }
    }

    public void fillOption() {
        fillWater();
        fillMilk();
        fillCoffeeBeans();
        fillCups();
    }

    private void takeOption() {
        System.out.format("I gave you $%d%n", getMoneyBalance());
        setMoneyBalance(0);
    }

    public void coffeeShopOffer() {
        boolean menuloop = false;
        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String option = SCANNER.nextLine();
            System.out.println();

            switch (option) {
                case "buy" -> buyOption();
                case "fill" -> fillOption();
                case "take" -> takeOption();
                case "remaining" -> coffeeMachineStatus();
                case "exit" -> System.exit(0);
                default -> throw new IllegalStateException("Unexpected value: " + option);
            }
        }
    }
}
