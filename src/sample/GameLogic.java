package sample;

public class GameLogic {
    int str[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    int str1[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    int flag = 0;
    int fail = 0;
//    int score = 0;
//    int scoreTemp = 0;
    boolean isVictory = false;
    boolean isDefeat = false;
    String wasd = "";//移动方向

    //
    public int scoreNow() {
        int score = 0;
        for (int i = 0; i < 16; i++) {
            score += str[i];
        }
        return score;
    }

    //游戏继续运行逻辑
    public void run() {
        if (isVictory()) {
            //System.out.println("恭喜你，成功啦！");
            isVictory = true;
        }
        if (isDefeat()) {
            //System.out.println("很遗憾，游戏失败！");
            isDefeat = true;
        } else {
            create24WhenMove();
            //showState();
            //run();
        }
    }

    //随机将一个为0的项改成2或4
    public void randomChange() {

        MyRandom myRandom = new MyRandom();
        int n = myRandom.suijinum();//随机生成2或4
        int m = myRandom.suijixy();//随机生成坐标
        if (str[m] == 0) {
            str[m] = n;
        } else {
            randomChange();
        }
    }

    //执行上下左右移动操作时数组的变化方式
    public void create24WhenMove() {
//        Scanner sc =new Scanner(System.in);
//        wasd=sc.nextLine();
        if (canMove(wasd)) {
            randomChange();
        }
    }

    /**
     * 判断是否可以移动
     *
     * @return
     */
    public boolean canMove(String wasd) {
//        scoreTemp = score;
        for (int i = 0; i < 16; i++) {
            str1[i] = str[i];
        }
        switch (wasd) {
            case "w":
                upMove(4);
                upMerge(0);
                upMove(8);
                upMerge(4);
                upMove(12);
                upMerge(8);
                break;
            case "s":
                downMove(11);
                downMerge(15);
                downMove(7);
                downMerge(11);
                downMove(3);
                downMerge(7);
                break;
            case "a":
                leftMove(4);
                leftMerge(0);
                leftMove(8);
                leftMerge(4);
                leftMove(12);
                leftMerge(8);
                break;
            case "d":
                rightMove(11);
                rightMerge(15);
                rightMove(7);
                rightMerge(11);
                rightMove(3);
                rightMerge(7);
                break;
        }
        flag = 0;
        for (int i = 0; i < 16; i++) {
            if (str[i] != str1[i]) {
                flag = 1;
            }
        }
        if (flag == 0) {
//            score = scoreTemp;
            return false;
        }
        return true;
    }

    //显示目前数组的状态
    public void showState() {
        System.out.println(str[0] + "      " + str[1] + "      " + str[2] + "      " + str[3] + "\n");
        System.out.println(str[4] + "      " + str[5] + "      " + str[6] + "      " + str[7] + "\n");
        System.out.println(str[8] + "      " + str[9] + "      " + str[10] + "      " + str[11] + "\n");
        System.out.println(str[12] + "      " + str[13] + "      " + str[14] + "      " + str[15] + "\n");
    }

    //判断失败条件
    public boolean isDefeat() {
//        scoreTemp = score;
        for (int i = 0; i < 16; i++) {
            str1[i] = str[i];
        }
        fail = 0;
        //w
        flag = 0;
        upMove(4);
        upMerge(0);
        upMove(8);
        upMerge(4);
        upMove(12);
        upMerge(8);
        for (int i = 0; i < 16; i++) {
            if (str[i] != str1[i]) {
                flag = 1;
            }
        }
        for (int i = 0; i < 16; i++) {
            str[i] = str1[i];
        }
        if (flag == 1) {
            fail++;
        }
        //s
        flag = 0;
        downMove(11);
        downMerge(15);
        downMove(7);
        downMerge(11);
        downMove(3);
        downMerge(7);
        for (int i = 0; i < 16; i++) {
            if (str[i] != str1[i]) {
                flag = 1;
            }
        }
        for (int i = 0; i < 16; i++) {
            str[i] = str1[i];
        }
        if (flag == 1) {
            fail++;
        }
        //a
        flag = 0;
        leftMove(4);
        leftMerge(0);
        leftMove(8);
        leftMerge(4);
        leftMove(12);
        leftMerge(8);
        for (int i = 0; i < 16; i++) {
            if (str[i] != str1[i]) {
                flag = 1;
            }
        }
        for (int i = 0; i < 16; i++) {
            str[i] = str1[i];
        }
        if (flag == 1) {
            fail++;
        }
        //d
        flag = 0;
        rightMove(11);
        rightMerge(15);
        rightMove(7);
        rightMerge(11);
        rightMove(3);
        rightMerge(7);
        for (int i = 0; i < 16; i++) {
            if (str[i] != str1[i]) {
                flag = 1;
            }
        }
        for (int i = 0; i < 16; i++) {
            str[i] = str1[i];
        }
        if (flag == 1) {
            fail++;
        }
        //
//        score = scoreTemp;
        if (fail == 0) {
            return true;
        }
        return false;
    }

    //判断胜利条件
    public boolean isVictory() {
        for (int i = 0; i < 16; i++) {
            if (str[i] == 2048) {
                return true;
            }
        }
        return false;
    }

    public void upMove(int n) {
        for (int i = n; i < 16; i++) {
            if (str[i] != 0 && str[i - 4] == 0) {
                str[i - 4] = str[i];
                str[i] = 0;
                i = n - 1;
            }
        }
    }

    public void upMerge(int n) {
        for (int i = n; i < n + 4; i++) {
            if (str[i] == str[i + 4]) {
                str[i] = str[i] + str[i + 4];
                str[i + 4] = 0;
//                score += str[i];
            }
        }
    }

    public void downMove(int n) {
        for (int i = n; i > -1; i--) {
            if (str[i] != 0 && str[i + 4] == 0) {
                str[i + 4] = str[i];
                str[i] = 0;
                i = n + 1;
            }
        }
    }

    public void downMerge(int n) {
        for (int i = n; i > n - 4; i--) {
            if (str[i] == str[i - 4]) {
                str[i] = str[i] + str[i - 4];
                str[i - 4] = 0;
//                score += str[i];
            }
        }
    }

    public void leftMove(int n) {
        int left[] = {str[12], str[8], str[4], str[0], str[13], str[9], str[5], str[1], str[14], str[10], str[6], str[2], str[15], str[11], str[7], str[3]};
        for (int i = n; i < 16; i++) {
            if (left[i] != 0 && left[i - 4] == 0) {
                left[i - 4] = left[i];
                left[i] = 0;
                i = n - 1;
            }
        }
        str[0] = left[3];
        str[1] = left[7];
        str[2] = left[11];
        str[3] = left[15];
        str[4] = left[2];
        str[5] = left[6];
        str[6] = left[10];
        str[7] = left[14];
        str[8] = left[1];
        str[9] = left[5];
        str[10] = left[9];
        str[11] = left[13];
        str[12] = left[0];
        str[13] = left[4];
        str[14] = left[8];
        str[15] = left[12];
    }

    public void leftMerge(int n) {
        int left[] = {str[12], str[8], str[4], str[0], str[13], str[9], str[5], str[1], str[14], str[10], str[6], str[2], str[15], str[11], str[7], str[3]};
        for (int i = n; i < n + 4; i++) {
            if (left[i] == left[i + 4]) {
                left[i] = left[i] + left[i + 4];
                left[i + 4] = 0;
//                score += str[i];
            }
        }
        str[0] = left[3];
        str[1] = left[7];
        str[2] = left[11];
        str[3] = left[15];
        str[4] = left[2];
        str[5] = left[6];
        str[6] = left[10];
        str[7] = left[14];
        str[8] = left[1];
        str[9] = left[5];
        str[10] = left[9];
        str[11] = left[13];
        str[12] = left[0];
        str[13] = left[4];
        str[14] = left[8];
        str[15] = left[12];
    }

    public void rightMove(int n) {
        int left[] = {str[12], str[8], str[4], str[0], str[13], str[9], str[5], str[1], str[14], str[10], str[6], str[2], str[15], str[11], str[7], str[3]};
        for (int i = n; i > -1; i--) {
            if (left[i] != 0 && left[i + 4] == 0) {
                left[i + 4] = left[i];
                left[i] = 0;
                i = n + 1;
            }
        }
        str[0] = left[3];
        str[1] = left[7];
        str[2] = left[11];
        str[3] = left[15];
        str[4] = left[2];
        str[5] = left[6];
        str[6] = left[10];
        str[7] = left[14];
        str[8] = left[1];
        str[9] = left[5];
        str[10] = left[9];
        str[11] = left[13];
        str[12] = left[0];
        str[13] = left[4];
        str[14] = left[8];
        str[15] = left[12];
    }

    public void rightMerge(int n) {
        int left[] = {str[12], str[8], str[4], str[0], str[13], str[9], str[5], str[1], str[14], str[10], str[6], str[2], str[15], str[11], str[7], str[3]};
        for (int i = n; i > n - 4; i--) {
            if (left[i] == left[i - 4]) {
                left[i] = left[i] + left[i - 4];
                left[i - 4] = 0;
//                score += str[i];
            }
        }
        str[0] = left[3];
        str[1] = left[7];
        str[2] = left[11];
        str[3] = left[15];
        str[4] = left[2];
        str[5] = left[6];
        str[6] = left[10];
        str[7] = left[14];
        str[8] = left[1];
        str[9] = left[5];
        str[10] = left[9];
        str[11] = left[13];
        str[12] = left[0];
        str[13] = left[4];
        str[14] = left[8];
        str[15] = left[12];
    }
}
