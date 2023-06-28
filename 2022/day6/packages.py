
file = open('input.txt', 'r')
indeks = 0

line = file.readline()

for i in range(len(line) - 13):
    for k in range(i,i + 14):

        ch = line[k]
        if ch in line[k + 1: i + 14]: 
            indeks = 0
            break
        else: indeks += 1
    
    if indeks == 14: print(i + 14)