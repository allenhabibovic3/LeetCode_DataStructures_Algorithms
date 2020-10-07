def firstRecurrignChar(s):
    s = s.lower()

    count = {}
    
    for letter in s:
        if letter in count:
            return letter
        count[letter] = 1
        
        
print(firstRecurrignChar("ABCDeE"))
