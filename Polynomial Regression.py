#Polynomial Regression example

#import numpy, pyplot, and r2_score
import numpy as np
import matplotlib.pyplot as plt
from sklearn.metrics import r2_score

#below are the data points corresponding to the x axis and y axis
x = [1,2,3,5,6,7,8,9,10,12,13,14,15,16,18,19,21,22]
y = [100,90,80,60,60,55,60,65,70,70,75,76,78,79,90,99,99,100]

#create the model for polynomial regression
poly_model = np.poly1d(np.polyfit(x, y, 3))

#set the line space appropriately
line = np.linspace(1, 22, 100)

#create a scatter plot with the data points
plt.scatter(x, y)
#plot the polynomial best fit function
plt.plot(line, poly_model(line))
plt.xlabel("Hour of the day")
plt.ylabel("Speed MPH")
plt.show()

#determine the coefficient of correlation r 0 => no correlation, 1 => 100% data sets correlate
print(r2_score(y, poly_model(x)))
