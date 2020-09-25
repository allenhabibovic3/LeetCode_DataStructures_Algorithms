#BELOW IS JUST TESTING OF THE VARIABLE METHODS WITHIN THE NUMPY LIBRAY

import numpy as np

#create a 2D matrix array
arr = np.array([[1,2,3], [4,5,6], [7,8,9]])

#print the dimensions of the array
print(arr.ndim)

#print the shape of the array
print(arr.shape)

#print the size of the array(total # of elements)
print(arr.size)

#print the datatype of the elements in the array
print(arr.dtype)

#create an array from a tuple instead of list
arr_from_tuple = np.array((1,2,3,4), dtype='i')
print(arr_from_tuple)

#create a zero array filled with zeros 3x3 matrix
zero_array = np.zeros((3,3))

print(zero_array)

#create a 2x2 matrix with all inf value
inf_matrx = np.full((2,2), np.inf)
print(inf_matrx)

#apply a filter to array,only even numbers
filt = (arr % 2 == 0)

temp_arr = arr[filt]
print(temp_arr)

#random matrix operations
a = np.array([[1,2,3], [3,2,1]])
print(a + 1) #add 1 to each element
print(a * 2) #multiply by a scalar
print(a ** 2) #square each entry
print(a.T) #transpose of an array

#user unaray operators
arr = np.array([[1,4,7], [8, 1, 2], [3, 10, 11]])
print(arr.max()) # print largest element in array
print(arr.min()) # print smallest element in array
print(arr.sum()) #summ all elements
print(arr.cumsum(axis=1)) #print cum sum by axis 1(rows)


a = np.array([[1, 2],
            [3, 4]])
b = np.array([[4, 3],
            [2, 1]])

print(a * b) #matrix multiplication
print(a.dot(b)) #dot product

#useful math functions
print(np.exp(a)) #exponent
print(np.sqrt(a))
print(np.sin(a))
