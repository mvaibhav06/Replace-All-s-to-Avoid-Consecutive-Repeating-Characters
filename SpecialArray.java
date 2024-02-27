import java.util.Arrays;
import java.util.HashMap;

public class SpecialArray {
    public static int specialArray(int[] nums){
        Arrays.sort(nums);
        HashMap<Integer, Integer> temp = new HashMap<>();

        for (int i=0; i<nums.length; i++){
            if (!temp.containsKey(nums[i])){
                temp.put(nums[i], nums.length-i);
            }if (i>0 && nums[i] == nums[i-1]){
                continue;
            }
            if (nums[i] == nums.length-i){
                return nums[i];
            }
        }
        int out = -1;
        for (int key : temp.keySet()){
            if (out < temp.get(key) && temp.get(key)<key && !temp.containsKey(temp.get(key))){
                int counter = 0;
                for (int i=0; i<nums.length; i++){
                    if (nums[i] >= temp.get(key)){
                        counter++;
                        if (counter == temp.get(key)){
                            out = temp.get(key);
                        }
                        if (counter > temp.get(key)){
                            out = -1;
                            break;
                        }
                    }
                }

            }
        }
        return out;
    }
    public static void main(String[] args) {
        int[] nums = {2,3,0,2};
        System.out.println(specialArray(nums));
    }
}
