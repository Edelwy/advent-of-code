
max_calorie = 0
curr_calorie = 0
file = open('input.txt', 'r')

for line in file:
    if line == "\n": 
        if curr_calorie > max_calorie: max_calorie = curr_calorie
        curr_calorie = 0
    else: 
        curr_calorie = curr_calorie + int(line)
    #print(curr_calorie)

print(max_calorie)