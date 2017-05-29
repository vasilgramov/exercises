package hackerEarth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class TestClass {
    public static void main(String args[] ) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(in.readLine());
        for (int i = 0; i < t; i++) {
            String[] tokens = in.readLine().split("\\s+");
            // N A B C

            int n = Integer.parseInt(tokens[0]);
            long a = Long.parseLong(tokens[1]);
            long b = Long.parseLong(tokens[2]);
            long c = Long.parseLong(tokens[3]);

            Interval[] intervals = new Interval[n];

            for (int j = 0; j < n; j++) {
                String[] pq = in.readLine().split("\\s+");
                long p = Integer.parseInt(pq[0]);
                long q = Integer.parseInt(pq[1]);

                intervals[j] = new Interval(p, q);
            }

            Interval intervalMax = null;
            long max = -1;
            for (int j = 0; j < intervals.length; j++) {
                long current = 0;
                for (int k = 0; k < intervals.length; k++) {
                    if (intervals[j].isIn(intervals[k])) {
                        current++;
                    }
                }

                if (current > max) {
                    max = current;
                    intervalMax = intervals[j];
                } else if (current == max) {
                    if (c > a) {
                        intervalMax = intervals[j];
                    }
                }
            }


            for (Interval interval : intervals) {
                if (interval.isIn(intervalMax)) {

                }
            }
        }
    }

    public static class Interval {
        private long start;
        private long end;

        public Interval(long start, long end) {
            this.start = start;
            this.end = end;
        }

        public boolean isIn(Interval interval) {
            return this.start <= interval.start ||
                    this.end >= interval.end;
        }
    }
}
