import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner f = new Scanner(System.in);
        
        StringTokenizer st = new StringTokenizer(f.nextLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(f.nextLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            pq.add(new Edge(u, v, w));
        }

        UnionFind uf = new UnionFind(N+1);

        int cost = 0;

        while(!pq.isEmpty()) {
            //there should be three sets at the end
            if(uf.numSets == 3) break;
            Edge e = pq.poll();
            if(!uf.isSameSet(e.u, e.v)) {
                uf.unionSet(e.u, e.v);
                cost+=e.w;
            }
        }

        if(uf.numSets != 3) cost = -1;
        System.out.println(cost);
    }

    static class Edge implements Comparable<Edge> {
        int u, v, w;
        public Edge (int _u, int _v, int _w) {
            u = _u;
            v = _v;
            w = _w;
        }

        public int compareTo(Edge e) {
            return this.w - e.w;
        }
    }

    //from cp3
    static class UnionFind {
        private ArrayList<Integer> p, rank, setSize;
        private int numSets;

        public UnionFind(int N) {
            p = new ArrayList<Integer>(N);
            rank = new ArrayList<Integer>(N);
            setSize = new ArrayList<Integer>(N);
            numSets = N;
            for (int i = 0; i < N; i++) {
                p.add(i);
                rank.add(0);
                setSize.add(1);
            }
        }

        public int findSet(int i) {
            if (p.get(i) == i) return i;
            else {
                int ret = findSet(p.get(i));
                p.set(i, ret);
                return ret;
            }
        }

        public Boolean isSameSet(int i, int j) {
            return findSet(i) == findSet(j);
        }

        public void unionSet(int i, int j) {
            if (!isSameSet(i, j)) {
                numSets--;
                int x = findSet(i), y = findSet(j);
                // rank is used to keep the tree short
                if (rank.get(x) > rank.get(y)) {
                    p.set(y, x);
                    setSize.set(x, setSize.get(x) + setSize.get(y));
                } else {
                    p.set(x, y);
                    setSize.set(y, setSize.get(y) + setSize.get(x));
                    if (rank.get(x) == rank.get(y)) rank.set(y, rank.get(y) + 1);
                }
            }
        }

        public int numDisjointSets() {
            return numSets;
        }

        public int sizeOfSet(int i) {
            return setSize.get(findSet(i));
        }
    }
}