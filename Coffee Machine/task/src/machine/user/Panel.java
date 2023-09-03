package machine.user;

import machine.utils.Utils;

public interface Panel {
    void commandGiven(String command);
    void welcome(Utils utils);
}
