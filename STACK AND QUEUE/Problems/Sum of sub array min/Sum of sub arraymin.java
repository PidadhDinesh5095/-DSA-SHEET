//Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.class Solution {

    private int[] getNSE(int[] a){

      Stack<Integer> s=new Stack<>();

      int[] ans=new int[a.length];

      for(int i=a.length-1;i>=0;i--){

        int n=a[i];

        while(!s.isEmpty() && a[s.peek()]>=a[i]){

          s.pop();

        }

        if(!s.isEmpty()){

          ans[i]=s.peek();

        }

        else{

          ans[i]=a.length;

        }

        s.push(i);

      }

      return ans;

   }

      private int[] getPSE(int[] a){

        Stack<Integer> s=new Stack<>();

        int[] ans=new int[a.length];

        for(int i=0 ;i<a.length;i++){

        int n=a[i];

        while(!s.isEmpty() && a[s.peek()]>a[i]){

          s.pop();

        }

        if(!s.isEmpty()){

          ans[i]=s.peek();

        }

        else{

          ans[i]=-1;

        }

        s.push(i);

      }

      return ans;

    }

    public int sumSubarrayMins(int[] arr) {

      int m=(int)Math.pow(10,9)+7;

      int[] nse=getNSE(arr);

      int[] pse=getPSE(arr);

     long t=0;

      for(int i=0;i<arr.length;i++){

        int l=nse[i]-i;

       int r=i-pse[i];

        t=(t+r*l*(long)arr[i])%m;

      }

      return (int)t;

      

    }

}

