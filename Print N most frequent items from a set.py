#printing the N most frequent items in a list
from collections import Counter

words = [
 'look', 'into', 'my', 'eyes', 'look', 'into', 'my', 'eyes',
 'the', 'eyes', 'the', 'eyes', 'the', 'eyes', 'not', 'around', 'the',
 'eyes', "don't", 'look', 'around', 'the', 'eyes', 'look', 'into',
 'my', 'eyes', "you're", 'under'
]

c = Counter()
c.update(words)
most_common_3 = c.most_common(3)

print(most_common_3)
