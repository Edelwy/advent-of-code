import numpy as np

def top(grid,i,j):
    tree1 = grid[i][j]
    column = grid.T[j]
    if i == 0: return 0

    for k,tree2 in enumerate(reversed(column[:i]),1): 
        if tree2 >= tree1: return k
    return len(column[:i])

def bottom(grid,i,j):
    tree1 = grid[i][j]
    column = grid.T[j]
    if i == len(column) - 1: return 0

    for k,tree2 in enumerate(column[i + 1:],1): 
        if tree2 >= tree1: return k
    return len(column[i + 1:])

def right(grid,i,j):
    tree1 = grid[i][j]
    line = grid[i]
    if j == len(line) - 1: return 0

    for k,tree2 in enumerate(line[j + 1:],1): 
        if tree2 >= tree1: return k
    return len(line[j + 1:])

def left(grid,i,j):
    tree1 = grid[i][j]
    line = grid[i]
    if j == 0: return 0

    for k,tree2 in enumerate(reversed(line[:j]),1): 
        if tree2 >= tree1: return k
    return len(line[:j])

file = open('input.txt', 'r')
input = file.readlines()

height = len(input)
lenght = len(input[0]) - 1

grid = np.zeros(shape=(height,lenght), dtype=int)
max = 0

for i,line in enumerate(input): 
    for j,number in enumerate(line):
        if number == '\n': break
        grid[i][j] = int(number)

for i,line in enumerate(grid):
    for j,tree in enumerate(line):
        result = right(grid,i,j) * left(grid,i,j) * top(grid,i,j) * bottom(grid,i,j)
        if result > max: max = result

print(max)

