import numpy

class Tocka:
    def __init__(self, x, y):
        self.x = x
        self.y = y
    
    def __str__(self):
        return f"({self.x},{self.y})"
    
    def premakni(self, direction):
        if direction == 'U': self.y += 1
        if direction == 'D': self.y -= 1
        if direction == 'L': self.x -= 1
        if direction == 'R': self.x += 1

def premik(U, V):
    dx = U.x - V.x
    dy = U.y - V.y

    if abs(dx) + abs(dy) > 1:
        
        if (dx != 0 and dy != 0) and abs(dx) + abs(dy) == 2: return
        if dx > 0: V.premakni('R')
        if dx < 0: V.premakni('L')
        
        if dy > 0: V.premakni('U')
        if dy < 0: V.premakni('D')

tocke = [Tocka(0,0) for i in range(10)]


file = open('input.txt', 'r')
input = file.readlines()
visited = []
no_visited = 0

for line in input:

    line = line.strip()
    instructions = line.split(" ")
    direction = instructions[0]
    length = int(instructions[1])

    for i in range(length):

        tocke[0].premakni(direction)
        for k in range(len(tocke) - 1):
            A = tocke[k]
            B = tocke[k + 1]
            premik(A,B)
            
            if k == len(tocke) - 2:
                if str(B) not in visited: 
                    visited.append(str(B))
                    no_visited += 1
print(tocke[0], tocke[len(tocke) - 1], no_visited)
        
        
