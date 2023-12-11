#include <bits/stdc++.h>

using namespace std;

/*
 * Complete the 'isValid' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts STRING s as parameter.
 */

string isValid(string s) {
    map<char, int> m1;
    map<int, int> m2;
    string result = "NO";
    
    
    for(int i = 0; i < s.length(); i++) {
        if(m1.find(s.at(i)) == m1.end()) {
            m1.insert(make_pair(s.at(i), 1));
        } else {
            m1[s.at(i)]++;
        }
    }
    
    for(auto it = m1.begin(); it != m1.end(); it++) {
        if(m2.find(it->second) == m2.end()) {
            m2.insert(make_pair(it->second, 1));
        } else {
            m2[it->second]++;
        }
    }
    if(m2.size() <= 1) {
        result = "YES";
    } else if(m2.size() < 3) {
        int k1, v1, k2, v2;
        auto it = m2.begin();
        
        k1 = it->first;
        v1 = it->second;
        it++;
        
        k2 = it->first;
        v2 = it->second;
        
        if(k1 == 1 && v1 == 1) {
            result = "YES";
        } else if(k2 - k1 == 1) {
            if(v2 == 1) {
                result = "YES";
            }
        }
    }
    
    return result;
    
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string s;
    getline(cin, s);

    string result = isValid(s);

    fout << result << "\n";

    fout.close();

    return 0;
}
