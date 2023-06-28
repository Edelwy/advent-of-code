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

file = open('test.txt', 'r')
index =  1
sum = 0

for line in file:
    if line == "\n": continue

    left = json.loads(line)
    right = json.loads(next(file))

    result = correct(left, right)
    if result: sum += index
    index += 1
    print(result)

print(sum)