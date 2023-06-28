
first_calorie = 0
second_calorie = 0
third_calorie = 0

curr_calorie = 0
file = open('input.txt', 'r')

for line in file:
    if line == "\n": 

        if curr_calorie > first_calorie: 
            third_calorie = second_calorie
            second_calorie = first_calorie
            first_calorie = curr_calorie

        elif curr_calorie > second_calorie: 
            third_calorie = second_calorie
            second_calorie = curr_calorie

        elif curr_calorie > third_calorie: 
            third_calorie = curr_calorie

        curr_calorie = 0
    else: 
        curr_calorie = curr_calorie + int(line)
    #print(curr_calorie)

print(first_calorie, second_calorie, third_calorie)
sum = first_calorie + second_calorie + third_calorie
print(sum)