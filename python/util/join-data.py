file_statistics = open('statistics-ordened.csv','r')
file_players = open('players')

data_players = []
for line in file_players.readlines():
    line = line.replace(u'\xa0', u' ')
    data_line = line.split('\t')
    data_line[len(data_line)-1] = data_line[len(data_line)-1].replace('\n','')
    
    full_name = data_line[0].split()
    data_line.pop(0)
    data_line.insert(0,full_name[0])
    print(data_line)
    data_line.insert(1,full_name[1])

    data_players.append(data_line)

data_statistics = []
for line in file_statistics.readlines():
    data_line = line.split(';')
    data_statistics.append(data_line)

total_statistic_columns = len(data_statistics[0])
for key,player in enumerate(data_players):
    for statistic in data_statistics:
        if(player[0] == statistic[1] and player[1] == statistic[0]):
            del statistic[0:3]
            data_players[key] = player+statistic
            break
    if(len(player)==8):
        for i in range(total_statistic_columns-3):
            player.append(0)

file_write_join = open('player-statistics.csv','w')
for player in data_players:
    write =    ';'.join(str(column) for column in player)+'\n'
    file_write_join.write(write)