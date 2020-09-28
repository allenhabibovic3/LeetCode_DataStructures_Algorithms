#simple operations/calculations on a dictionary

prices = {
 'ACME': 45.23,
 'AAPL': 612.78,
 'IBM': 205.55,
 'HPQ': 37.20,
 'FB': 10.75
}

#using the zip functionality, swap the values/keys of the dictionary mapping
min_value = min(zip(prices.values(), prices.keys()))
max_value = max(zip(prices.values(), prices.keys()))
prices_sorted = sorted(zip(prices.values(), prices.keys()))

print(min_value)
print(max_value)
print(prices_sorted)
