import re


priority = 0
file = open('input.txt', 'r')

for line in file:
    n = len(line)
    velikost = int(n/2)
    first = line[0:velikost]
    second = line[velikost:n]

    for ch in first:
        result = re.search(ch, second)
        if result != None:
            x = ord(result.group())
            if 96 < x < 123: x = x - 96
            if 64 < x < 91: x = x - 65 + 27
            priority += x
            break

print(priority)
    