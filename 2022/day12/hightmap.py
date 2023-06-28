import numpy as np

def print_queue(queue):
    for co in queue: 
            if co[0][0] >= heigth or co[0][0] < 0: continue
            if co[0][1] >= length or co[0][1] < 0: continue
            print(f"NEXT: {co[0]} {chr(map[co[0][0]][co[0][1]])}")
    print()

def check(start, next, map):

    x0 = start[0]
    y0 = start[1]
    x1 = next[0]
    y1 = next[1]

    if y1 >= length or y1 < 0: return False
    if x1 >= heigth or x1 < 0: return False

    prev = map[x0][y0]
    curr = map[x1][y1]
    diff = curr - prev

    if curr >= prev: 
        if diff > 1: return False
    
    return True
          
def find_path(start):

    global length
    global heigth
    global map
    global end
    
    queue = [(start, [chr(map[start[0]][start[1]])])]
    visited = []
    visited.append(start)
    
    while(len(queue) != 0):
        
        start, path = queue.pop(0)
        x = start[0]
        y = start[1]

        if map[x, y] == map[end[0]][end[1]]:
            return path + [chr(map[x][y])]
        
        if [x + 1, y] not in visited:
            if check([x, y], [x + 1, y], map):
                visited.append([x + 1, y])
                queue.append(([x + 1, y], path + [chr(map[x + 1][y])]))

        if [x - 1, y] not in visited:
            if check([x, y], [x - 1, y], map):
                visited.append([x - 1, y])
                queue.append(([x - 1, y], path + [chr(map[x - 1][y])]))

        if [x, y + 1] not in visited:
            if check([x, y], [x, y + 1], map):   
                visited.append([x, y + 1])
                queue.append(([x, y + 1], path + [chr(map[x][y + 1])]))

        if [x, y - 1] not in visited:
            if check([x, y], [x, y - 1], map):
                visited.append([x, y - 1])
                queue.append(([x, y - 1], path + [chr(map[x][y - 1])]))

        #print_queue(queue)

# BRANJE IN INICIALIZACIJA PROBLEMA:
file = open('input.txt', 'r')
input = file.readlines()
file.close()

heigth = len(input)
length = len(input[0]) - 1

map = np.zeros(shape=(heigth,length), dtype=int)

for i,line in enumerate(input): 
    for j,ch in enumerate(line):
        if ch == '\n': break
        map[i][j] = ord(ch)

result = np.where(map == ord('S'))
start = list(zip(result[0], result[1]))[0]
start = [start[0], start[1]]
result = np.where(map == ord('E'))
end = list(zip(result[0], result[1]))[0]
end = [end[0], end[1]]

map[start[0]][start[1]] = ord('a')
map[end[0]][end[1]] = ord('z')

# RESEVANJE PROBLEMA:
print(start)
path = find_path(start)
print(len(path) - 1, path)




