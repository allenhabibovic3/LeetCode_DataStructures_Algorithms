#create a subset of a dictionary based on a filter

prices = {
 'ACME': 45.23,
 'AAPL': 612.78,
 'IBM': 205.55,
 'HPQ': 37.20,
 'FB': 10.75
}

#create a subset dictionary for stocks greater than 40

subset_prices = {key: value for key, value in prices.items() if value >= 40}

print(subset_prices)

#uses a dictionary comprehension which is clearer and executes faster 
