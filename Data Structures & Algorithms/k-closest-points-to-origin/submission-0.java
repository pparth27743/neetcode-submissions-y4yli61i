class Solution {

    public class Point {
        Double dist;
        int x;
        int y;

        public Point(double dist, int x, int y) {
            this.dist = dist;
            this.x = x;
            this.y = y;
        }
    }

    public int[][] kClosest(int[][] points, int k) {

        int[][] ans = new int[k][2];

        Queue<Point> pq = new PriorityQueue<>((p1, p2) -> (p2.dist.compareTo(p1.dist)));
    
        int x,y;
        for(int i=0; i<points.length; i++) {
            x = points[i][0];
            y = points[i][1];
            Point p = new Point(getDistance(x,y), x, y);
            pq.add(p);

            if(pq.size() > k)
                pq.poll();
        }

        int i=0;
        while(pq.size() != 0) {
            Point p = pq.poll();
            ans[i][0] = p.x;
            ans[i][1] = p.y;
            i++;
        }
        
        return ans;

    }

    public double getDistance(int x, int y) {
        return Math.sqrt((x*x) + (y*y));
    }
}
