import tensorflow as tf
import numpy as np
import matplotlib.pyplot as plt

#load in the MNIST dataset
fashion_mnist = tf.keras.datasets.fashion_mnist

#split data into training/testing data
#training data includes 60,000 images w/ labels
#test data is 10,000 images w/ labels
(train_images, train_labels), (test_images, test_labels) = fashion_mnist.load_data()

#our target label values: image -> class_name
class_names = ['T-shirt/top', 'Trouser', 'Pullover', 'Dress', 'Coat',
               'Sandal', 'Shirt', 'Sneaker', 'Bag', 'Ankle boot']

#display the shape of our datasets
#print(train_images.shape)
#print(len(training_labels)) 60,000
#Each label is an integer between 0 and 9:

#view an image
"""
plt.figure()
plt.imshow(train_images[0])
plt.colorbar()
plt.grid(False)
plt.show()
"""

#squish input data range to [0,1]
train_images = train_images / 255.0
test_images = test_images / 255.0

#building our neural network
#structure our layers

model = tf.keras.Sequential([
	tf.keras.layers.Flatten(input_shape=(28, 28)),
	tf.keras.layers.Dense(128, activation="relu"),
	tf.keras.layers.Dense(10)
])

#compile model first
model.compile(optimizer="adam", loss=tf.keras.losses.SparseCategoricalCrossentropy(from_logits=True), metrics=["accuracy"])

#fit training data to model(training)
model.fit(train_images, train_labels, epochs=10)

#evaluate accuracy
test_loss, test_acc = model.evaluate(test_images, test_labels, verbose=2)
print("Test Accuracy:", test_acc)

#for an instance of the test images, construct a probability array
probability_model = tf.keras.Sequential([model, tf.keras.layers.Softmax()])
predictions = probability_model.predict(test_images)
print(np.argmax(predictions[0]))
