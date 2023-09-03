package machine.utils;

import machine.user.User;

public interface Requirements {
    void fillMachine();
    void process(User user);
    void addWater(int amount);
    void addMilk(int amount);
    void addBeans(int amount);
    void addCups(int amount);
    void addMoney(int amount);
    void removeWater(int amount);
    void removeMilk(int amount);
    void removeBeans(int amount);
    void removeCups(int amount);
    void removeMoney();
    boolean checkWater(int amount);
    boolean checkMilk(int amount);
    boolean checkBeans(int amount);
    boolean checkCups(int amount);

}
