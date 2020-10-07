def isHoppable(towers):

    for i in range(len(towers)):
        if towers[i] + i >= len(towers):
            return True

    return False


tower = [4, 2, 0, 2, 0]

print(isHoppable(tower))
