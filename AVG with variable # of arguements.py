def avg_func(*args):
    #variable number of arguements, non keyword
    sum = 0
    count = 0

    for num in args:
        sum += num
        count += 1

    return (num/count)

print(avg_func(5, 3, 4, 5))
