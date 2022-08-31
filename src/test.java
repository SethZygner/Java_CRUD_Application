
public class test {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 3};


        int[] temp = new int[nums.length];

        System.arraycopy(nums, 0, temp, 0, nums.length);

        for (int num : nums) {

            for (int i : temp) {
                if (num == i) {
                    System.out.println("Not Unique");
                    return;
                }
            }
        }


    }
}
