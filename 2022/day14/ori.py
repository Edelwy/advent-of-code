import numpy as np
import copy as cp

class Path:
    def __init__(self, x0, x1, y0, y1):
        self.x0 = x0
        self.y0 = y0
        self.x1 = x1
        self.y1 = y1
    
    def __str__(self):
        return f"FROM: ({self.x0},{self.y0}) TO: ({self.x1},{self.y1})"
    
    def __repr__(self):
        return str(self)

class Tocka:
    def __init__(self, x, y):
        self.x = x
        self.y = y
    
    def __str__(self):
        return f"({self.x},{self.y})"
    
    def __repr__(self):
        return str(self)
    
def grid_size(paths):
    max_x = 0
    max_y = 0
    min_x = 10000
    min_y = 0

    for path in paths:
        if path.x0 < min_x: min_x = path.x0
        if path.x1 < min_x: min_x = path.x1

        if path.x0 > max_x: max_x = path.x0
        if path.x1 > max_x: max_x = path.x1
        
        if path.y0 < min_y: min_y = path.y0
        if path.y1 < min_y: min_y = path.y1

        if path.y0 > max_y: max_y = path.y0
        if path.y1 > max_y: max_y = path.y1
    
    return max_x, min_x, max_y, min_y

def fix_x(paths, min_x, max_x):

    for path in paths:
        path.x0 -= min_x
        path.x1 -= min_x
    
    max_x -= min_x
    return max_x

def create_map(paths, map):

    for path in paths:
        if path.y0 == path.y1:
            start = min(path.x0, path.x1)
            end = max(path.x0, path.x1)
            map[path.y0, start:end + 1] = True

        elif path.x0 == path.x1:
            start = min(path.y0, path.y1)
            end = max(path.y0, path.y1)
            map[start:end + 1, path.x0] = True
        
def sand_falling(map, start):
    
    point = cp.copy(start)
    stopped = False

    while(not stopped):
        if map[start.y, start.x] == True: return False
        elif map[point.y + 1, point.x] == False:
            point.y += 1
        elif map[point.y + 1, point.x - 1] == False:
            point.x -= 1
            point.y += 1
        elif map[point.y + 1, point.x + 1] == False:
            point.x += 1
            point.y += 1
        else:
            map[point.y, point.x] = True
            stopped = True
    
    return True

file = open('input.txt', 'r')
paths = []

for line in file:
    line = line.strip()
    points = line.split(" -> ")
    
    for i in range(len(points) - 1):
        x0 = int(points[i].split(",")[0])
        x1 = int(points[i + 1].split(",")[0])
        y0 = int(points[i].split(",")[1])
        y1 = int(points[i + 1].split(",")[1])
        paths.append(Path(x0, x1, y0, y1))
  
file.close()

max_x, min_x, max_y, min_y = grid_size(paths)
start = Tocka(500 - min_x, 0)
max_x = fix_x(paths, min_x, max_x)
map = np.zeros(shape=(max_y + 3, 10000), dtype=bool)
create_map(paths, map)
map[max_y + 2] = [True for i in map[max_y + 2]]

#reševanje:
units = 0
while(sand_falling(map, start)):
    units += 1

print(units)

#proba it down, then left and down, then right and down
#basically testiramo kdaj bo sand se hotu ustavit of map: na min_x - 1
