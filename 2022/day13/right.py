import json
import itertools

def correct(left, right):

    for left_element, right_element in itertools.zip_longest(left, right):
      
        if isinstance(left_element, list) and isinstance(right_element, int): right_element = [right_element]
        if isinstance(right_element, list) and isinstance(left_element, int): left_element = [left_element]
      
        if left_element is None: return True
        if right_element is None: return False

        if isinstance(left_element, int):
            if left_element < right_element: return True
            if right_element < left_element: return False
        
        if isinstance(left_element, list): 
            result = correct(left_element, right_element)
            if result != None: return result

def sort_input(input):
    changed = False
    for i in range(len(input) - 1):

        left = input[i]
        right = input[i + 1]
        result = correct(left, right)
    
        if not result: 
            changed = True
            input.append(left)
            input.remove(left)

    return changed

file = open('input.txt', 'r')
input = []

for line in file:
    if line == "\n": continue
    tmp = next(file)
    if tmp == "\n": continue

    left = json.loads(line)
    right = json.loads(tmp)
    input.append(left)
    input.append(right)

input.append([[2]])
input.append([[6]])
changed = True
mul = 1

while(changed):
    changed = False
    changed = sort_input(input)


for i,packet in enumerate(input,1):
   if packet == [[2]]: mul *= i
   if packet == [[6]]: mul *= i

print(mul)