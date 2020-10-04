#!/bin/python3

import math
import os
import random
import re
import sys



if __name__ == '__main__':
    n = int(input())

    s = input()

    key = int(input())

    alpha1 = "abcdefghijklmnopqrstuvwxyz"
    alpha2 = alpha1.upper()
    
    new_str = ""

    for letter in s:
        if letter in alpha1:
            index = alpha1.index(letter)
            if index + key > 25:
                new_str += alpha1[(index + key) % 26]
            else:
                new_str += alpha1[(index) + key]
        elif letter in alpha2:
            index = alpha2.index(letter)
            if index + key > 25:
                new_str += alpha2[(index + key) % 26]
            else:
                new_str += alpha2[index + key]
        else:
            new_str += letter
    print(new_str)
