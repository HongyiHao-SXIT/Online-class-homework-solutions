#include <iostream>
using namespace std;
int main(){
   double a [2][3];
    cin>>a[0][0]>>a[0][1]>>a[0][2];
    cin>>a[1][0]>>a[1][1]>>a[1][2];
    printf("VALOR A PAGAR: R$ %1.2f",(a[0][1]*a[0][2])+(a[1][1]*a[1][2]));
    return 0;
}