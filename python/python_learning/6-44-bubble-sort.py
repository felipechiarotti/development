lista = [5,2,8,3] #Lista Desordenada
fim = len(lista) #Tamanho da Lista
                 #O fim diminui a cada passada de fora
while fim > 1: #Roda os elementos de fora até chegar 
    trocou = False
    x = 0
    while x < (fim-1):
        if lista[x] > lista[x+1]:
            trocou = True
            temp = lista[x]
            lista[x] = lista[x+1]
            lista[x+1] = temp
        x += 1
    if not trocou:
        break
    fim -= 1

for element in lista:
    print(element)