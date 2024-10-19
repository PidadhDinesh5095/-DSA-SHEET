/**We are given an array asteroids of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.**/class Solution {
    public int[] asteroidCollision(int[] a) {
   List<Integer> l=new ArrayList<>();
   for(int i:a){
      if(i>0){
         l.add(i);
      }
      else{
        
       while(!l.isEmpty() && l.get(l.size()-1)>0 && l.get(l.size()-1)<-1*i){
           l.remove(l.size()-1);
      }
      
       if(!l.isEmpty() && l.get(l.size()-1)==-1*i){
          l.remove(l.size()-1);
      }
        else if(l.isEmpty() || l.get(l.size()-1)<0){
          l.add(i);
        }
     }
    }
      int[] ans=new int[l.size()];
      int i=0;
      while(i<l.size()){
        ans[i]=l.get(i);
        i++;
      }
      return ans;
    }
}
