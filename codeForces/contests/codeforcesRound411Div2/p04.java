package codeForces.contests.codeforcesRound411Div2;

/**
 * Created by vladix on 5/4/17.
 */
public class p04 {
    /*
    using namespace std;

    ull PowMod(ull n, unordered_map<ull, ull> &dp)
    {
        auto it = dp.find(n);
        ull orig = n;
        if (it != dp.end()) {
            return it->second;
        }
        ull ret = 1;
        ull a = 2;
        while (n > 0) {
            if (n & 1) ret = ret * a % MODULO;
            a = a * a % MODULO;
            n >>= 1;
        }
        dp.insert(make_pair(orig, ret));
        return ret;
    }

    int main() {
        unordered_map<ull, ull> dp;

        string ip;
        cin >> ip;
        ull a_len = 0;
        ull answer = 0;
        for (int i = 0; i < ip.length(); ++i) {
            if (ip[i] == 'a'){
                a_len++;
            } else if (ip[i] == 'b') {
                answer = ((answer %  MODULO ) + ((PowMod(a_len, dp) - 1) % MODULO)) % MODULO;
            }
        }

        std::cout << answer << std::endl;
        return 0;
    }
     */
}
