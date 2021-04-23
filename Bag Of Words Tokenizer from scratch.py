import numpy as np
documents = [
	'This is my first sentence',
	'This is my second sentence',
	'Where am i going with this',
	'Im about to find that out'
]

unique_tokens = np.array([])

for document in documents:
	document = document.lower()
	tokens = document.split()

	unique_tokens = np.append(unique_tokens, tokens)

vocabulary = np.unique(unique_tokens)

bag_of_words = np.zeros((4, len(vocabulary)))

print(vocabulary)

for idx, document in enumerate(documents):
	for word in document.split():
		word = word.lower()
		if word in vocabulary:
			bag_of_words[idx, list(vocabulary).index(word)] = 1

print(bag_of_words)



