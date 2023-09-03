package machine;

import machine.user.User;
import machine.utils.Utils;
import java.util.Arrays;
import java.util.List;

public class CoffeeMachine extends User {
    private static final List<Integer> initialValues = Arrays.asList(400, 540, 120, 9, 550);

    public static void main(String[] args) {
        User user = new User();
        Utils utils = new Utils();
        utils.setIngredients(initialValues);
        utils.process(user);
    }

}
