import re


priority = 0
file = open('input.txt', 'r')

for line1 in file:
    line2 = next(file).strip()
    line3 = next(file).strip()

    for ch in line1:

        if ch in line2 and ch in line3:
            x = ord(ch)
            if x in range(97,123): x = x - 96
            if x in range(65,91): x = x - 65 + 27
            priority += x
            break

print(priority)
    