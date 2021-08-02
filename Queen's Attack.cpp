#include <bits/stdc++.h>

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

int queensAttack(int n, int k, int r_q, int c_q, vector<vector<int>> obstacles) {
    int answer = 0;
    int R, C;
    r_q--;
    c_q--;
    vector<vector<bool>> board;
    for(int i = 0; i < n; i++) {
        vector<bool> temp;
        for(int j = 0; j < n; j++) {
            temp.emplace_back(true);
        }
        board.emplace_back(temp);
    }
    
    for(int i = 0; i < k; i++) {
        board.at(obstacles.at(i).at(0) - 1).at(obstacles.at(i).at(1) - 1) = false;
    }
    // top
    R = r_q + 1;
    C = c_q;
    
    while(R < n && board.at(R).at(C)) {
        answer++;
        R++;
    }
    
    // bottom
    R = r_q - 1;
    C = c_q;
    
    while(R >= 0 && board.at(R).at(C)) {
        answer++;
        R--;
    }
    
    // left
    R = r_q;
    C = c_q - 1;
    
    while(C >= 0 && board.at(R).at(C)) {
        answer++;
        C--;
    }
    
    // right
    R = r_q;
    C = c_q + 1;
    
    while(C < n && board.at(R).at(C)) {
        answer++;
        C++;
    }
    
    // right top
    R = r_q + 1;
    C = c_q + 1;
    
    while(R < n && C < n && board.at(R).at(C)) {
        answer++;
        C++;
        R++;
    }
    
    // left top
    R = r_q + 1;
    C = c_q - 1;
    
    while(R < n && C >= 0 && board.at(R).at(C)) {
        answer++;
        C--;
        R++;
    }
    
    // left bottom
    R = r_q - 1;
    C = c_q - 1;
    
    while(R >= 0 && C >= 0 && board.at(R).at(C)) {
        answer++;
        C--;
        R--;
    }
    
    
    // right bottom
    R = r_q - 1;
    C = c_q + 1;
    
    while(R >= 0 && C < n && board.at(R).at(C)) {
        answer++;
        C++;
        R--;
    }
    return answer;
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
