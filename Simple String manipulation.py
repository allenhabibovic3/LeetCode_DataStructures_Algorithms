sentence = "aWESOME is cODING"

sentence_list = sentence.split()
reverse_list = []
for i in range(len(sentence_list)-1, -1, -1):
    reverse_list.append(sentence_list[i])
reversed_str = ' '.join(reverse_list)

result = ""

for letter in reversed_str:
    if letter.isupper():
        result += letter.lower()
    elif letter.islower():
        result += letter.upper()
    else:
        result += letter

print(result)
