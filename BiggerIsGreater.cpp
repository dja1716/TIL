#include <bits/stdc++.h>

using namespace std;

string ltrim(const string &);
string rtrim(const string &);

/*
 * Complete the 'biggerIsGreater' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts STRING w as parameter.
 */

string biggerIsGreater(string w) {
    string answer = "no answer";
    int index = w.length() - 1;
    map<char, int> data;
    data.insert(make_pair(w.at(index), 1));
    index--;
    
    while(index >= 0) {
        auto jt = data.end();
        jt--;
        if(w.at(index) < jt->first) {
            
            if(data.find(w.at(index)) == data.end()) {
                data.insert(make_pair(w.at(index), 1));
            } else {
                data.at(w.at(index))++;
            }
            
            for(auto it = data.begin(); it != data.end(); it++) {
                if(it->first > w.at(index)) {
                    it->second--;
                    w.at(index) = it->first;
                    break;
                }
            }
            
            for(auto it = data.begin(); it != data.end(); it++) {
                for(int i = 0; i < it->second; i++) {
                    index++;
                    w.at(index) = it->first;
                }
            }
            answer = w;
            break;
        }
        
        if(data.find(w.at(index)) == data.end()) {
            data.insert(make_pair(w.at(index), 1));
        } else {
            data.at(w.at(index))++;
        }
        
        index--;
    }
    
    return answer;
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string T_temp;
    getline(cin, T_temp);

    int T = stoi(ltrim(rtrim(T_temp)));

    for (int T_itr = 0; T_itr < T; T_itr++) {
        string w;
        getline(cin, w);

        string result = biggerIsGreater(w);

        fout << result << "\n";
    }

    fout.close();

    return 0;
}

string ltrim(const string &str) {
    string s(str);

    s.erase(
        s.begin(),
        find_if(s.begin(), s.end(), not1(ptr_fun<int, int>(isspace)))
    );

    return s;
}

string rtrim(const string &str) {
    string s(str);

    s.erase(
        find_if(s.rbegin(), s.rend(), not1(ptr_fun<int, int>(isspace))).base(),
        s.end()
    );

    return s;
}
