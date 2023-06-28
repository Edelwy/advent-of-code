import re


fully_included = 0
file = open('input.txt', 'r')

for line in file:
    line.strip() # da se znebimo newlina
    assigment = line.split(",")
    pair1 = assigment[0]
    pair2 = assigment[1]

    start1 = int(pair1.split("-")[0])
    start2 = int(pair2.split("-")[0])
    end1 = int(pair1.split("-")[1])
    end2 = int(pair2.split("-")[1])

    if start1 <= start2 and end1 >= end2: 
        fully_included += 1
        continue

    if start2 <= start1 and end2 >= end1: 
        fully_included += 1


print(fully_included)
    