lista_vazia = [] #Cria uma Lista Vazia
lista_elementos = [ 15, 8, 9 ] #Cria uma Lista de Inteiros
lista_elementos[0] #Acessa o primeiro elemento
lista_elementos[0] = 7 #Seta o primeiro elemento

lista_copia_referencia = lista_elementos #Copia a lista por referência
lista_copia_real = lista_elementos[:] #Faz uma copia da lista
len(lista_copia_real) #Exibe tamanho da Lista

lista_vazia.append("a") #Adiciona um elemento ao fim da lista
lista_elementos = lista_elementos+[1] #Adiciona o elemento 1 ao fim da lista
lista_elementos += [2] #Adiciona o elemento 2 ao fim da lista
lista_elementos += lista_vazia #Adiciona uma lista em outra

del lista_elementos[1] #Deleta o elemento 1 da lista
del lista_elementos[:3] #Deleta os 4 primeiros elementos da lista

lista_compras = ["maçã","pera","kiwi"] #Cria uma lista de Strings
print(lista_compras[0[2]]) #Vai retornar a terceira letra do elemento 0 (No caso retorna ç)

for element in lista_compras:
    for word in element:
        print(word)

produto_1 = [ "maçã", 10, 0.30 ] #Lista de multiplos tipos
produto_2 = [ "pêra", 20, 0.20 ]
compras = [produto_1, produto_2] #Lista de listas

for product in compras:
    print("Nome: %s" % (product[0]))
    print("Quantidade: %d" % (product[1]))
    print("Preço: %.2f" % (product[2]))
    print("Valor Total: ", product[1]*product[2])