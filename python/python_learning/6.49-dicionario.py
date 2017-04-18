tabela = {"Alface": 0.45, "Batata": 0.32, "Tomate": 2.30}
print(tabela.keys())
print(tabela.values())

while True:
    option = input("Deseja Visualizar(v), Adicionar(a) ou Remover(r)?: ")
    produto = input("Digite o nome do produto: ")

    if option == "fim":
        break
    elif option == "v":
        if produto in tabela:
            print("%s custa R$%.2f" % (produto,tabela[produto]))
        else:
            print("Produto inexistente!")
    elif option == "a":
        if produto not in tabela:            
            tabela[produto] = float(input("Digite o valor: R$"))
        else:
            print("Produto já existente!")
    elif option == "r":
        if produto in tabela:
            del tabela[produto]
        else:
            print("Produto inexistente!")