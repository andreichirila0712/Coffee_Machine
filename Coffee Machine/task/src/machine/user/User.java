package machine.user;

import machine.utils.Utils;

public class User implements Panel {

    String command;
    @Override
    public void commandGiven(String command) {
        this.command = command;
    }

    @Override
    public void welcome(Utils utils) {
        System.out.println("The coffee machine has:");
        System.out.println(utils.getIngredients().get(0) + " ml of water");
        System.out.println(utils.getIngredients().get(1) + " ml of milk");
        System.out.println(utils.getIngredients().get(2) + " g of coffee beans");
        System.out.println(utils.getIngredients().get(3) + " disposable cups");
        System.out.println("$" + utils.getIngredients().get(4) + " of money");
        System.out.println();
    }

    public String getCommand() {
        return command;
    }

}
