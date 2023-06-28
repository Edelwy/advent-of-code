import re


priority = 0
file = open('input.txt', 'r')

for line1 in file:
    line2 = next(file).strip()
    line3 = next(file).strip()

    for ch in line1:
        result1 = re.search(ch, line2)
        result2 = re.search(ch, line3)

        if result1 != None and result2 != None:
            x = ord(result1.group())
            if 96 < x < 123: x = x - 96
            if 64 < x < 91: x = x - 65 + 27
            priority += x
            break

print(priority)
    