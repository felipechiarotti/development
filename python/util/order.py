file = open("statistics","r")
statistics = []

for line in file.readlines():
    name = ""
    line = line.split()
    var = ''
            
    for key,field in enumerate(line):
        if(isalpha(field)):
            del line[key]
        else if(len(field) > 4){
            pos = 0
            while(pos != len(field)):
                if(field[pos] == ','):
                    pos = pos + 1
                    var = var + '.' + field[pos] + ' '
                else:
                    var = var + field[pos]
                    pos = pos + 1
                
        else:
            var = var + field
    
    statistics.append(var)