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

pattern = '\d'

for line in instructions:
    line = line.strip()
    info = line.split(" ")
    many = int(info[1])
    origin = int(info[3])
    new = int(info[5])

    tmp = crates[origin - 1][-many:]
    for element in tmp:
        crates[new - 1].append(element)
        crates[origin - 1].pop()
    #print(info, tmp)
    #print(crates)

str = ""
for column in crates: str = str + column[-1]
print(str)
