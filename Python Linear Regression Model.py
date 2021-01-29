import pandas as pd
import numpy as np
import sklearn
from sklearn import linear_model
from sklearn.utils import shuffle
import matplotlib.pyplot as plt
import pickle  # save our linear regression model

# load in the data from CSV files into a pandas
# dataframe object
data = pd.read_csv('student-mat.csv', sep=';')

# dataset had 33 attributes or features
# trim down dataset by getting only specific features
data = data[['G1', 'G2', 'G3', 'studytime', 'failures', 'absences']]

# GOAL: predict final grade 'G3' using selected features
predict = "G3"

# training data, remove G3, as G3 will be what we
# try to predict or 'label'
# X(independent) variables=>features,attributes, predictors
X = np.array(data.drop(columns=['G3'], axis=1))

# y(dependent) variable=> label, what we want our machine to be able
# to predict after inferring rules from training data
y = np.array(data['G3'])

# split data into training/testing set
X_train, X_test, y_train, y_test = sklearn.model_selection.train_test_split(X, y, test_size=0.1)

# using a linear regression algorithm or model to predict g3

# create linear regression model
linear = linear_model.LinearRegression()

# fit our training data to our linear regression model
linear.fit(X_train, y_train)

# to view accuracy of the model we made on training data
# use linear.score() on test set

accuracy = linear.score(X_test, y_test)

# save the model to avoid compute time/resources
with open("student_model.pickle", "wb") as f:
	pickle.dump(linear, f)
# save 'linear' model into file f in wb mode

# load in a model from a .pickle file
pickle_in = open("student_model.pickle", "rb")
# load model into a variable
loaded_linear_model = pickle.load(pickle_in)

# model information, coefficients(slopes) of feautres
# and intercept
# print('Coefficients: \n', linear.coef_)
# print("Intercept: ", linear.intercept_)

# use model to make a prediction
predictions = linear.predict(X_test)

# looping through each of our predictions made
# on X_test and comparing to actual label in y_test
# for x in range(len(predictions)):
# print(predictions[x], X_test[x], y_test[x])

#using matplotlib.pyplot for graphing
selected_feature = "G2"
plt.style.use("ggplot")
plt.scatter(data[selected_feature], data['G3'])
plt.xlabel(selected_feature)
plt.ylabel("Final Grade")
plt.show()

"""
how can we get the best model?
iterate many times, selecting model with highest score

best_score = 0
X_train, X_test, y_train, y_test = sklearn.model_selection.train_test_split(X, Y, test_size=0.1)
for _ in range(n):
	X_train, X_test, y_train, y_test = sklearn.model_selection.train_test_split(X, Y, test_size=0.1)
	linear = linear_model.LinearRegression()
	linear.fit(X_train, y_train)
	
	score = linear.score(X_test, y_test)
	
	if score > best_score:
		best_score = score
		with open("best_linear_model.pickle", "wb") as f:
			pickle.dump(linear, f)
"""
