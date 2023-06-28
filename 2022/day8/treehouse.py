import numpy as np

def top(grid,i,j):
    tree1 = grid[i][j]
    column = grid.T[j]
    if i == 0: return True

    for tree2 in column[:i]: 
        if tree2 >= tree1: return False
    return True

def bottom(grid,i,j):
    tree1 = grid[i][j]
    column = grid.T[j]
    if i == len(column) - 1: return True

    for tree2 in column[i + 1:]: 
        if tree2 >= tree1: return False
    return True

def right(grid,i,j):
    tree1 = grid[i][j]
    line = grid[i]
    if j == len(line) - 1: return True

    for tree2 in line[j + 1:]: 
        if tree2 >= tree1: return False
    return True

def left(grid,i,j):
    tree1 = grid[i][j]
    line = grid[i]
    if j == 0: return True

    for tree2 in line[:j]: 
        if tree2 >= tree1: return False
    return True

file = open('input.txt', 'r')
input = file.readlines()

height = len(input)
lenght = len(input[0]) - 1

grid = np.zeros(shape=(height,lenght), dtype=int)
sum = 0

for i,line in enumerate(input): 
    for j,number in enumerate(line):
        if number == '\n': break
        grid[i][j] = int(number)

for i,line in enumerate(grid):
    for j,tree in enumerate(line):
        if right(grid,i,j) or left(grid,i,j) or top(grid,i,j) or bottom(grid,i,j): sum += 1

print(sum)

