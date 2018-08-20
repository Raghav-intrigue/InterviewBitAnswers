import java.util.ArrayList;
import java.util.List;

public class Greedy {
    //highest-product
    public int maxp3(ArrayList<Integer> A) {
        A.sort(null);
        int n = A.size();
        int x = A.get(n - 1) * A.get(n - 2) * A.get(n - 3);
        int y = A.get(n - 1) * A.get(0) * A.get(1);
        return Math.max(x, y);
    }

    //gas-station
    public int canCompleteCircuit(final List<Integer> A, final List<Integer> B) {

        if (A.size() == 0)
            return 0;

        if (A.size() == 1) {
            if (A.get(0) >= B.get(0))
                return 0;
            else
                return -1;
        }

        int sum = 0;
        Integer start = null;
        int s2 = 0;

        for (int i = 0; i < A.size(); i++) {
            int t = A.get(i) - B.get(i);
            if (t >= 0) {
                if (start != null)
                    s2 += t;
                else {
                    start = i;
                    s2 = t;
                }
            } else {
                if (start != null) {
                    if (s2 + t < 0) {
                        start = null;
                        s2 = 0;
                    } else {
                        s2 += t;
                    }
                }
            }

            sum += t;
        }

        if (sum < 0)
            return -1;
        else {

            if (start != null) {
                if (s2 >= (A.get(0) - B.get(0)))
                    return start;
            }

        }

        return -1;
    }


    public int majorityElement(final List<Integer> A) {
        A.sort(null);
        int c = 1;
        Integer n = A.get(0);
        for (int i = 1; i < A.size(); ) {
            while (i < A.size() && n.equals(A.get(i))) {
                i++;
                c++;
            }
            if (c > A.size() / 2) {
                return n;
            }
            c = 1;
            n = A.get(i);
            i++;
        }
        return n;
    }

    //seats
    public int seats(String A) {

        ArrayList<Integer> pos = new ArrayList<>();
        double a = 0d;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == 'x') {
                pos.add(i);
            }
        }

        if(pos.size()<2)
            return 0;

        int center = 0;
        for(int i = 0; i < A.length(); i++){
            if(A.charAt(i) == 'x'){
                center++;
                if(center == (pos.size()/2)+1){
                    center = i;
                    break;
                }
            }
        }

        int k = 0;
        while (center > pos.get(k)) {
            k++;
        }

        long ans = 0;
        int cr = center;
        for (int i = k; i < pos.size(); i++) {
            ans += pos.get(i) - cr;
            cr++;
            ans = ans % 10000003;
        }

        int cl = center-1;
        for (int i = k-1; i >= 0; i--) {
            ans += cl - pos.get(i);
            cl--;
            ans = ans % 10000003;
        }

        return (int) ans;
    }

    public int bulbs(ArrayList<Integer> A) {

    }
}
