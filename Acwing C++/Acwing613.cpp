#include <iostream>
using namespace std;
int main()
{
    float A,B,C,a=3.14159,X1,X2,X3,X4,X5;
    cin>>A>>B>>C;
    X1=A*C*0.5;
    X2=a*C*C;
    X3=(A+B)*C/2.0;
    X4=B*B;
    X5=A*B;
 printf("TRIANGULO: %1.3f\n",A*C*0.5);
 printf("CIRCULO: %1.3f\n",a*C*C);
 printf("TRAPEZIO: %1.3f\n",(A+B)*C/2.0);
 printf("QUADRADO: %1.3f\n",X4);
 printf("RETANGULO %1.3f\n",X5);
 return 0;
}