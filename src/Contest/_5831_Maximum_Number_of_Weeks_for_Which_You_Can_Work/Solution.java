package Contest._5831_Maximum_Number_of_Weeks_for_Which_You_Can_Work;

public class Solution {
    public long numberOfWeeks(int[] milestones) {
        long max = 0, sum = 0;
        for (int i = 0; i < milestones.length; i++) {
            sum += milestones[i];
            max = Math.max(max, milestones[i]);
        }
        long rest = sum - max;
        if (max <= rest + 1)
            return sum;
        return rest * 2 + 1;
    }
}
