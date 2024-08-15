package 贪心;

public class 柠檬水找零 {
    public boolean lemonadeChange(int[] bills) {
        int[] money = new int[3];
        int ten = 0;
        int five = 0;
        for (int bill : bills) {
            switch (bill) {
                case 5:
                    five++;
                    break;
                case 10:
                    if (five > 0) {
                        ten++;
                        five--;
                    } else {
                        return false;
                    }
                    break;
                case 20:
                    if (five < 3 && !(five >= 1 && ten >= 1)){
                        // 没有三张5块且没有一张五块一张十块
                        return false;
                    }
                    // 要么有三张5块，要么有一张五块一张十块, 肯定有一张5块
                    // 先找一张十块的一张五块的
                    if (ten >=1){
                        // 先找一张五块一张十块的
                        five--;
                        ten--;
                        break;
                    }
                    // 找三张五块的
                    five -= 3;
                    break;
            }
        }
        return true;
    }
}
