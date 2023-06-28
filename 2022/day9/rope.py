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

H = Tocka(0,0)
T = Tocka(0,0)

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

        H.premakni(direction)
        dx = H.x - T.x
        dy = H.y - T.y

        if abs(dx) + abs(dy) > 1:
            
            if (dx != 0 and dy != 0) and abs(dx) + abs(dy) == 2: continue
            if dx > 0: T.premakni('R')
            if dx < 0: T.premakni('L')
            
            if dy > 0: T.premakni('U')
            if dy < 0: T.premakni('D')
        
        if str(T) not in visited: 
            visited.append(str(T))
            no_visited += 1

print(H, T, no_visited)
        
        
