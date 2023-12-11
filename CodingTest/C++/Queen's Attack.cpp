#include <bits/stdc++.h>
#include <limits>

using namespace std;

string ltrim(const string &);
string rtrim(const string &);
vector<string> split(const string &);

/*
 * Complete the 'queensAttack' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER n
 *  2. INTEGER k
 *  3. INTEGER r_q
 *  4. INTEGER c_q
 *  5. 2D_INTEGER_ARRAY obstacles
 */

int min(int a, int b) {
    if(a < b) {
        return a;
    } else {
        return b;
    }
}

int queensAttack(int n, int k, int r_q, int c_q, vector<vector<int>> obstacles) {
    int RB = n - c_q;
    int LB = c_q - 1;
    int TB = n - r_q;
    int BB = r_q - 1;
    int TRB = min(TB, RB);
    int TLB = min(TB, LB);
    int BRB = min(BB, RB);
    int BLB = min(BB, LB);
    
    
    for(int i = 0; i < k; i++) {
        if(obstacles.at(i).at(0) == r_q) {
            if(c_q > obstacles.at(i).at(1)) {
                LB = min(LB, c_q - obstacles.at(i).at(1) - 1);
            } else {
                RB = min(RB, obstacles.at(i).at(1) - c_q - 1);
            }
        } else if(obstacles.at(i).at(1) == c_q) {
            if(r_q > obstacles.at(i).at(0)) {
                BB = min(BB, r_q - obstacles.at(i).at(0) - 1);
            } else {
                TB = min(TB, obstacles.at(i).at(0) - r_q - 1);
            }
        } else if(obstacles.at(i).at(0) - r_q == obstacles.at(i).at(1) - c_q) {
            if(r_q > obstacles.at(i).at(0)) {
                BLB = min(BLB, r_q - obstacles.at(i).at(0) - 1);
            } else {
                TRB = min(TRB, obstacles.at(i).at(0) - r_q - 1);
            }
        } else if(obstacles.at(i).at(0) - r_q == c_q - obstacles.at(i).at(1)) {
            if(r_q > obstacles.at(i).at(0)) {
                BRB = min(BRB, r_q - obstacles.at(i).at(0) - 1);
            } else {
                TLB = min(TLB, obstacles.at(i).at(0) - r_q - 1);
            }
        }
    }
    return RB + LB + TB + BB + TRB + TLB + BRB + BLB;
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string first_multiple_input_temp;
    getline(cin, first_multiple_input_temp);

    vector<string> first_multiple_input = split(rtrim(first_multiple_input_temp));

    int n = stoi(first_multiple_input[0]);

    int k = stoi(first_multiple_input[1]);

    string second_multiple_input_temp;
    getline(cin, second_multiple_input_temp);

    vector<string> second_multiple_input = split(rtrim(second_multiple_input_temp));

    int r_q = stoi(second_multiple_input[0]);

    int c_q = stoi(second_multiple_input[1]);

    vector<vector<int>> obstacles(k);

    for (int i = 0; i < k; i++) {
        obstacles[i].resize(2);

        string obstacles_row_temp_temp;
        getline(cin, obstacles_row_temp_temp);

        vector<string> obstacles_row_temp = split(rtrim(obstacles_row_temp_temp));

        for (int j = 0; j < 2; j++) {
            int obstacles_row_item = stoi(obstacles_row_temp[j]);

            obstacles[i][j] = obstacles_row_item;
        }
    }

    int result = queensAttack(n, k, r_q, c_q, obstacles);

    fout << result << "\n";

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

vector<string> split(const string &str) {
    vector<string> tokens;

    string::size_type start = 0;
    string::size_type end = 0;

    while ((end = str.find(" ", start)) != string::npos) {
        tokens.push_back(str.substr(start, end - start));

        start = end + 1;
    }

    tokens.push_back(str.substr(start));

    return tokens;
}
