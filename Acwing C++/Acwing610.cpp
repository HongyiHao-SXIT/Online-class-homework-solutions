#include <iostream>
using namespace std;
int main(){
    float A,B,C;//底薪 
    string NAME;//
    cin>>NAME;
    cin>>A>>B;
    C=A+B*0.15;
    printf("TOTAL = R$ %1.2f",C);
    return 0;
}