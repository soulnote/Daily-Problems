class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        int n = asteroids.length;
        int asteroid = 0;
        long newmass = mass;
        while(asteroid<n){
            if(asteroids[asteroid]<=newmass){
                newmass += asteroids[asteroid];
            }
            else{
                return false;
            }
            asteroid++;
        }
        return true;
    }
}