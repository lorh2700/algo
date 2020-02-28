package HakerRank.FraudulentActivityNotifications;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
public class Solution {
    static double CalMedian(int[] tmpArr, int d) {
        int countSum = 0;
        double median = 0;
        int medianIdx = 0;
        
        
        /* 표본이 홀수 인 경우 */
        if( d % 2 == 1 ) {
            medianIdx =  d / 2 + 1;
            for(int i=0; i<tmpArr.length; i++) {
                countSum += tmpArr[i];
                if(countSum >= medianIdx) {
                    median = i;
                    break;
                }
            }
        }else {
            // 표본이 짝수인 경우 median은 두 값의 평균으로 한다.
            medianIdx =  d / 2;
            double median1=0, median2=0;
            
            for(int i=0; i<tmpArr.length; i++) {
                countSum += tmpArr[i];
                if(countSum >= medianIdx) {
                    median1 = i;
                    
                    if(countSum > medianIdx) {
                        median2 = i;
                        break;
                    }else {
                        for(int j=i+1; j<tmpArr.length; j++) {
                            if(tmpArr[j] != 0) {
                                median2 = j;
                                break;
                            }
                        }
                        
                        break;
                    }
                }
            }
            
            median = (median1 + median2)/2.0;
        }
        
        return median;
    }
    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
       int count = 0;
        int[] tmpArr = new int[201];
        for(int i = 0 ; i < d ; i++) {
            tmpArr[expenditure[i]]++;
        }
        
        //System.out.println(">> 초기상태");
        //print(tmpArr, expenditure.length);
        
        double median = 0;
        for(int i = d ; i < expenditure.length ; i++) {
            //System.out.println("i:"+i);
            
            median = CalMedian(tmpArr, d); 
            //System.out.println("Median: "+median);
            if(median*2 <= expenditure[i]) {
                count++;
            }
            tmpArr[expenditure[i-d]]--;
            tmpArr[expenditure[i]]++;
            
            //print(tmpArr, expenditure.length);
        }
        return count;
    }
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String[] nd = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nd[0]);
        int d = Integer.parseInt(nd[1]);
        int[] expenditure = new int[n];
        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }
        int result = activityNotifications(expenditure, d);
        
        System.out.println(result);
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//        bufferedWriter.close();
        scanner.close();
    }
}