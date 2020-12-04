board = [
    [7, 8, 0, 4, 0, 0, 1, 2, 0],
    [6, 0, 0, 0, 7, 5, 0, 0, 9],
    [0, 0, 0, 6, 0, 1, 0, 7, 8],
    [0, 0, 7, 0, 4, 0, 2, 6, 0],
    [0, 0, 1, 0, 5, 0, 9, 3, 0],
    [9, 0, 4, 0, 6, 0, 0, 0, 5],
    [0, 7, 0, 3, 0, 0, 0, 1, 2],
    [1, 2, 0, 0, 0, 7, 4, 0, 0],
    [0, 4, 9, 2, 0, 6, 0, 0, 7]
]


def print_board(board):
    for i in range(len(board)):
        if i % 3 == 0 and i != 0:
            print("- - - - - - - - - - - - ")
        for j in range(len(board[0])):
            if j % 3 == 0 and j != 0:
                print(" | ", end='')
            if j == 8:
                print(board[i][j])
            else:
                print(str(board[i][j]) + " ", end='')


def find_empty(board):
    #loop through grid, return the first empty cell as tuple object (row, col)

    for i in range(len(board)):
        for j in range(len(board[0])):
            if board[i][j] == 0:
                return (i, j)
    return None


def is_promising(board, row, col, numb):
    #check the current row of board to see if numb is present here, if so non-promising node: leads
    #to no solution, backtrack to current nodes parent and continue DFS, "pre-order" traversal of tree
    for j in range(len(board[0])):
        if board[row][j] == numb and col != j:
            return False

    #check current col of board to see if numb is present here, if so non promising node
    for i in range(len(board)):
        if board[i][col] == numb and row != i:
            return False

    #check the sub 9x9 grid to see if numb is present here
    box_x = col // 3
    box_y = row // 3

    for i in range(box_y*3, box_y*3 + 3):
        for j in range(box_x*3, box_x*3 + 3):
            if board[i][j] == numb and i != row and j != col:
                return False
    return True


def solve(board):
    location = find_empty(board)
    if not location:
        return True
    else:
        row, col = location

    for i in range(1, 10):
        if(is_promising(board, row, col, i)):
            board[row][col] = i
            if solve(board):
                return True
            board[row][col] = 0

    return False

if __name__ == "__main__":
    solve(board)
    print("_______________________")
    print_board(board)
