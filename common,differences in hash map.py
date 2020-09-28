#find common keys, or (key,value) tuples between dictionaries using set operations &, |, - 

a = {
 'x' : 1,
 'y' : 2,
 'z' : 3
}

b = {
    'w': 4,
    'x': 3,
    'y': 2
}

#print common keys between a and b, using set operators
print(a.keys() & b.keys())

#print common (key,value) pairs between a and b
print(a.items() & b.items())

#print difference a - b
print(a.keys() - b.keys())
