def is_balanced(expression):
    #create a list that resembles a stack data structure
    #push open parenthesis in the list,
    #pop close parenthesis from the stack
    #if mismatch, then return false
    #after check if stack is not empty

    stack = []
    open_set = ['(', '[', '{']
    close_set = [')', ']', '}']

    for letter in expression:
        if letter in open_set:
            stack.append(letter)
        elif letter in close_set:
            pos = close_set.index(letter)
            if len(stack) > 0 and open_set[pos] == stack[len(stack) - 1]:
                stack.pop()
            else:
                return False

    if len(stack) == 0:
        return True
    else:
        return False

if __name__ == "__main__":
    my_expression = "{{}}()[[]]"
    #the above expression is considered balanced, the parenthesis are nested properly

    result = is_balanced(my_expression)
    print(my_expression, " is balanced? ", result)
