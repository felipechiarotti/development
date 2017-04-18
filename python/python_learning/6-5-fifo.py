fifo = []
read = input("Adicionar à Fila (A)\nRemover da Fila(D)\nDigite a opção: ")
while read != '#':
    if read == 'A':
        read_element = input("Digite o nome do elemento: ")
        fifo.append(read_element)
        print("%s foi adicionado à posição %d da fila." %(read_element,len(fifo)))
    elif read == 'D':
        if len(fifo) > 0:
            fifo.pop(0)
        else:
            print("Lista vazia, impossível fazer a remoção!")
    else:
        print("Comando Desconhecido!")
    print("Fila: %s" % (fifo))
    read = input("Adicionar à Fila (A)\nRemover da Fila(D)\nDigite a opção: ")
