//
//  mult.h
//  lab2 SC
//
//  Created by misha on 22/02/2017.
//  Copyright © 2017 learn. All rights reserved.
//

#ifndef mult_h
#define mult_h

#include <stdio.h>
#include<iostream>
using namespace std;


int mult(int r1, int c1, int r2, int c2, int a[10][10], int b[10][10]){
    
    int c[10][10];
    if (c1 == r2)
    {
        for (int i = 0; i < r1; i++)
        {
            for (int j = 0; j < c2; j++)
            {
                c[i][j] = 0;
                for (int k = 0; k < r2; k++)
                {
                    c[i][j] = c[i][j] + a[i][k] * b[k][j];
                }
            }
        }
        cout
        << "\n-----------------------------------------------------------\n";
        cout << "\n\nMultiplication of Matrix X and Matrix Y :\n\n";
        for (int i = 0; i < r1; i++)
        {
            for (int j = 0; j < c2; j++)
            {
                cout << "\t" << c[i][j];
            }
            cout << "\n\n";
        }
    }
    else
    {
        cout << "\n\nMultiplication is not possible";
    }
    return **c;
}

#endif /* mult_h */
