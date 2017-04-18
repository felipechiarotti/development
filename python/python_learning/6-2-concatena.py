list_one = []
list_two = []

aux_list = input("Digite a primeira lista: ")
i = 0
while i < len(aux_list):
    list_one.append(int(aux_list[i]))
    i = i + 2

aux_list = input("Digite a segunda lista: ")
i = 0
while i < len(aux_list):
    list_two.append(int(aux_list[i]))
    i = i + 2

list_three = []
list_three.extend(list_one)
list_three.extend(list_two)
print (list_three)
