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


int multiply(int r1, int c1, int r2, int c2, int a[10][10], int b[10][10]){
    int s1, s2, s3, s4, s5, s6, s7, s8, s9, s10;
    int p1, p2, p3, p4, p5, p6, p7;
    
    int c[10][10];
    if (c1 == r2)
    {
        
        s1=b[1][2]-b[2][2];
        s2 = a[1][1] + a[1][2];
        s3 = a[2][1] + a[2][2];
        s4 = b[2][1] - b[1][1];
        s5 = a[1][1] + a[2][2];
        s6 = b[1][1] + b[2][2];
        s7 = a[1][2] - a[2][2];
        s8 = b[2][1] + b[2][2];
        s9 = a[1][1] - a[2][1];
        s10 = b[1][1] + b[1][2];
        
        
        
        p1 = a[1][1] * s1;
        p2 = s2 * b[2][2];
        p3 = s3 * b[1][1];
        p4 = a[2][2] * s4;
        p5 = s5 * s6;
        p6 = s7 * s8;
        p7 = s9 * s10;
        
        c[0][0] = p5 + p4 - p2 + p6;
        c[0][1] = p1 + p2;
        c[1][0] = p3 + p4;
        c[1][1] = p5 + p1 - p3 - p7;
        
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
