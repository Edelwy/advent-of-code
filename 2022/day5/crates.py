import re
kolicina = 9
visina = 8

file = open('input.txt', 'r')
content = file.readlines()

picture = content[0:visina]
instructions = content[visina + 2:]  
crates = [[] for column in range(kolicina)]

pattern = '[A-Z]|\s\s\s\s'

for line in reversed(picture):
    all = re.findall(pattern, line)
    
    for i,column in enumerate(crates):
        list = all[i]
        if all[i] != "    ": column.append(list)

print(crates)
pattern = '\d'

for line in instructions:
    line = line.strip()
    info = line.split(" ")
    many = int(info[1])
    before = int(info[3])
    after = int(info[5])

    for i in range(many):
        tmp = crates[before - 1].pop()
        crates[after - 1].append(tmp)
    print(info)

str = ""
for column in crates: str = str + column[-1]
print(str)
