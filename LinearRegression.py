#linear regression best fit line
from scipy import stats
import matplotlib.pyplot as plt
import numpy as np


x = [5,7,8,7,2,17,2,9,4,11,12,9,6]
y = [99,86,87,88,111,86,103,87,94,78,77,85,86]

slope, y_intercept, r, p, std_error = stats.linregress(x, y)

def line_func(x):
    return x * slope + y_intercept

model = list(map(line_func, x))

plt.scatter(x, y)
plt.plot(x, model)
plt.show()

print("coeff of correlation: ", r)

