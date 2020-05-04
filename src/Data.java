import java.util.Random;

/**
 * 产生随机数据
 */
class Data {
    int length;
    int[] data;

    public Data(int length) {
        this.length = length;
        data = new int[length];
    }

    public int[] getData() {

        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < length; i++) {
            data[i] = random.nextInt(2 * length);
        }
        return data;
    }


}