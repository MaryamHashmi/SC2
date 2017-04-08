//
//  main.cpp
//  lab2 SC
//
//  Created by misha on 22/02/2017.
//  Copyright © 2017 learn. All rights reserved.
//



#include<iostream>
#include "stressan_mult.h"
using namespace std;





void unit_tests(){
    
    int r1=2; int c1=2; int r2=2; int c2=2;
    int a[10][10], b[10][10];
    //MATRIX X
    a[0][0]=0; a[0][1]=0; a[1][0]=0; a[1][1]=0;
    //Matrix Y
    b[0][0]=0; b[0][1]=0; b[1][0]=0; b[1][1]=0;
    //printing
    cout << "\n\nMatrix X :\n\n";
        for (int i = 0; i < r1; i++)
        {
            for (int j = 0; j < c1; j++)
            {
                cout << "\t" << a[i][j];
            }
            cout << "\n\n";
        }
    
    cout << "\n\nMatrix Y\n\n";
        for (int i = 0; i < r2; i++)
        {
            for (int j = 0; j < c2; j++)
            {
                cout << "\t" << b[i][j];
            }
            cout << "\n\n";
        }
    int z1[10][10]={0,0,0,0};
    if(**z1==multiply(r1, c1, r2, c2, a, b)){
        cout<<"The unit test 1 passed\n";
    }
    else cout<<"Unit test failed.\n";
    
    
    
    
    
    
    
    r1=2; c1=2;  r2=2; c2=2;
    
    //MATRIX X
    a[0][0]=1; a[0][1]=0; a[1][0]=0; a[1][1]=1;
    //Matrix Y
    b[0][0]=1; b[0][1]=0; b[1][0]=0; b[1][1]=1;
    //printing
    cout << "\n\nMatrix X :\n\n";
    for (int i = 0; i < r1; i++)
    {
        for (int j = 0; j < c1; j++)
        {
            cout << "\t" << a[i][j];
        }
        cout << "\n\n";
    }
    
    cout << "\n\nMatrix Y\n\n";
    for (int i = 0; i < r2; i++)
    {
        for (int j = 0; j < c2; j++)
        {
            cout << "\t" << b[i][j];
        }
        cout << "\n\n";
    }
    int z2[10][10]={1,0,0,1};
    if(**z2==multiply(r1, c1, r2, c2, a, b)){
        cout<<"The unit test 2 passed\n";
    }
    else cout<<"Unit test failed.\n";


}

int main()
{
    
    unit_tests();
}
