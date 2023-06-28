class Directory:
    def __init__(self, name, parent):
        self.parent = parent
        self.name = name
        self.folders = []
        self.files = []
        self.size = 0
        
    def __str__(self):
        if self.parent != None:
            return f"Name: {self.name}  Parent: {self.parent.name}"
        else: 
            return f"Name: {self.name}  Parent: {self.parent}"

    def __repr__(self):
        return str(self)
    
    def search(self, name):
        for i in range(len(self.folders)):
            if self.folders[i].name == name:
                return self.folders[i]
        return None

class File:
    def __init__(self, name, size):
        self.name = name
        self.size = size
    
    def __repr__(self):
        return str(self)
    
    def __str__(self):
        return f"Name: {self.name}  Size: {self.size}"

file = open('input.txt', 'r')
input = file.readlines()
sum = 0

root = Directory("root", None)
curr_dir = root

for line in input:
    line = line.strip()
    command = line.split(" ")

    if command[0] == "$":
        if command[1] == "cd":
            name = command[2]
            if name == "/": continue
            if name == "..":
                curr_dir.parent.size += curr_dir.size
                if curr_dir.size <= 100000: sum += curr_dir.size
                curr_dir = curr_dir.parent
            else:
                next_dir = curr_dir.search(name)
                next_dir.parent = curr_dir
                curr_dir = next_dir
        
        elif command[1] == "ls": continue
    elif command[0] == "dir":
        name = command[1]
        curr_dir.folders.append(Directory(name, curr_dir))
    else: 
        size = int(command[0])
        name = command[1]
        curr_dir.files.append(File(name, size))
        curr_dir.size += size
    
print(sum)



