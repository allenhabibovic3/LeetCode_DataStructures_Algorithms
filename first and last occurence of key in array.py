def firstAndLast(arr, key):
    indices = []

    for i in range(len(arr)):
        if(arr[i] == key):
            indices.append(i)

    print(min(indices), max(indices))

firstAndLast([2,3,6,7,8, 8, 8, 9], 8)
