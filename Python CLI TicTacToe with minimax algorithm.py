import math
import random

class Player:

    def __init__(self, letter):
        self.letter = letter

    def get_move(self, game):
        pass


class RandomComputerPlayer(Player):
    def __init__(self, letter):
        super().__init__(letter)

    #just pick a random empty position returned from game.available moves
    def get_move(self, game):
        square = random.choice(game.available_moves())
        return square


class HumanPlayer(Player):
    def __init__(self, letter):
        super().__init__(letter)

    def get_move(self, game):
        valid_square = False
        val = None

        while not valid_square:
            square = input(self.letter + '\'s turn, input a move (0-8): ')
            try:
                val = int(square)
                if val not in game.available_moves():
                    raise ValueError
                valid_square = True
            except ValueError:
                print('Invalid Square, try again')

        return val


class AIComputerPlayer(Player):
    def __init__(self, letter):
        super().__init__(letter)

    def get_move(self, game):
        if len(game.available_moves()) == 9:
            square = random.choice(game.available_moves())
        else:
            square = self.minimax(game, self.letter)['position']
        return square

    def minimax(self, state, player):
        max_player = self.letter  # yourself
        other_player = 'O' if player == 'X' else 'X'

        # first we want to check if the previous move is a winner
        if state.current_winner == other_player:
            return {'position': None, 'score': 1 * (state.num_empty_squares() + 1) if other_player == max_player else -1 * (
                        state.num_empty_squares() + 1)}
        elif not state.empty_squares():
            return {'position': None, 'score': 0}

        if player == max_player:
            best = {'position': None, 'score': -math.inf}  # each score should maximize
        else:
            best = {'position': None, 'score': math.inf}  # each score should minimize
        for possible_move in state.available_moves():
            state.make_move(possible_move, player)
            sim_score = self.minimax(state, other_player)  # simulate a game after making that move

            # undo move
            state.board[possible_move] = ' '
            state.current_winner = None
            sim_score['position'] = possible_move  # this represents the move optimal next move

            if player == max_player:  # X is max player
                if sim_score['score'] > best['score']:
                    best = sim_score
            else:
                if sim_score['score'] < best['score']:
                    best = sim_score
        return best
        
        ---------------------------------------------------------------------------------------------------------------------------------
        
from Player import Player, HumanPlayer, RandomComputerPlayer, AIComputerPlayer
import time

class TicTacToe:

    def __init__(self):
        #repr board as a single array of 9 elements
        self.board = [' ' for _ in range(9)]
        self.current_winner = None

    def print_board(self):
        #first row [0, 1, 2]
        #second row[3, 4, 5]
        #third row [6, 7, 8]
        for row in [self.board[i*3:(i+1)*3] for i in range(3)]:
            print("|" + " | ".join(row) + " |")

    @staticmethod
    def print_board_numbers():
        number_board = [[str(i) for i in range(j*3, (j+1)*3)] for j in range(3)]
        for row in number_board:
            print('| ' + ' | '.join(row) + ' |')

    def available_moves(self):
        return [i for i, spot in enumerate(self.board) if spot == ' ']

    def empty_squares(self):
        return ' ' in self.board

    def num_empty_squares(self):
        return self.board.count(' ')

    def make_move(self, square, letter):
        if self.board[square] == ' ':
            self.board[square] = letter
            if self.winner(square, letter):
                self.current_winner = letter
            return True
        return False

    def winner(self, square, letter):
        #check rows first
        row_index = square // 3 #e.g 8 // 3 = 2
        row = self.board[row_index*3: (row_index+1)*3]
        #e.g square = 8 row_index = 2, row =[6,7,8]
        if all([spot == letter for spot in row]):
            return True

        #check columns
        col_index = square % 3
        col = [self.board[col_index+i*3] for i in range(3)]

        if all([letter == spot for spot in col]):
            return True

        if square % 2 == 0:
            diagonal1 = [self.board[i] for i in [0, 4, 8]]
            if all([spot == letter for spot in diagonal1]):
                return True
            diagonal2 = [self.board[i] for i in [2, 4, 6]]
            if all([spot == letter for spot in diagonal2]):
                return True
        #all checks failed
        return False

def play(game, x_player, o_player, print_game=True):
    if print_game:
        game.print_board_numbers()

    #starting letter
    letter = 'X'

    #iterate while game still has empty squares
    #break out of loop when a winner is found

    while game.empty_squares():
        if letter == 'O':
            square = o_player.get_move(game)
        else:
            square = x_player.get_move(game)

        if game.make_move(square, letter):
            if print_game:
                print(f"{letter} makes a move to {square}")
                game.print_board()
                print('')

            if game.current_winner:
                if print_game:
                    print(letter + ' wins')
                return letter

            #alternate between players
            letter = 'O' if letter == 'X' else 'X'
            #check if we won after each move....

        #tiny break after each iteration
        time.sleep(.75)

    if print_game:
        print('Its a tie!')

if __name__ == "__main__":
    x_player = HumanPlayer('X')
    o_player = AIComputerPlayer('O')
    t = TicTacToe()
    play(t, x_player, o_player, True)
