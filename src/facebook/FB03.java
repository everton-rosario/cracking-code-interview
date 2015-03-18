package facebook;

public class FB03 {

/*	# Given a list of arrays of time intervals, write a function that calculates the total number of time covered by the intervals. For example:

		# input = ( [1,4], [2,5]) 
		# > 3

		----
		 -----
		XXXXXX = 6

		# input = ( [1,4], [6,8], [2,4], [7,9], [10, 15] )
		# > 13

		0123456789012345
		 ---- 
		  ---
		      ---
		       ---
		          ------
		10
		15

		3+3

		_XXXX____
		total: 1
		N arrays
		M size
		O(N*M)
*/
    public static void main (String []args) {
        int amount = getAmount(new int[] {1, 4}, new int [] {6,8}, new int[]{2,4}, new int[]{7,9}, new int[] {10, 15});
        System.out.println(amount);
    }		    
    
    private static int getAmount(int[] ... periods) {
        int[] p = periods[0];
        int total = p[1] - p[0];
        
        periods = reorder(periods);
        
        for (int i = 1; i < periods.length; i++) {
            int[] current = periods[i];
            
            if (p[0] <= current[0] && p[1] >= current[1] && current[1] > p[1]) {  // 
                p[1] = current[1];
               
            
            } else if (p[1] < current[0]) {
                total += p[1] - p[0];
                p[0] = current[0];
                p[1] = current[1];
            }
            
        }
        
        
        
        return total + p[1]- p[0];
        
    }

	private static int[][] reorder(int[][] periods) {
		for (int i = 0; i< periods.length - 2; i++) {
			for (int j = i+1; j < periods.length -1; j++) {
				if (periods[j][0] < periods[i][0]) {
					periods[i] = periods[j];
				}
			}
		}
		return periods;
	}
}
