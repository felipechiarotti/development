#Alteração de String
string = "Alô mundo"
print(string[0])
string[0] = "a" #Não vai funcionar, precisa transformar em lista

#String em lista
lista = list("Alô mundo") #Função list transforma cada caractere da string em um elemento da lista
lista[0] = "a"
print(lista)
s = "".join(lista) #O método Join transforma cada elemento da lista em uma caractere da string
print(s)

#Verificação de Strings
nome = "Felipe Chiarotti Giron"
nome.startswith("Felipe") # Retorna True
nome.startswith("felipe") # Retorna False
nome.endswith("Giron") # Retorna True

#Conversão de Strings
nome.lower()
nome.upper()
s.lower().startswith("felipe") # Retorna True

#Pesquisa de Palavras em uma String
nome = "Felipe Chiarotti Giron"
"Felipe" in nome # Retorna True
"felipe" in nome # Retorna False
"Chiarotti" in nome # Retorna True
"e C" in nome # Retorna True

#Pesquisa de Palavras em String (Inverso)
"Felipe" not in nome #Retorna False
"felipe" not in nome #Retorna True

#Combinação de Manipulação de Strings
nome = "Felipe comprou um carro"
"felipe" in nome.lower() #Retorna True
"CARRO" in nome.upper() #Retorna True
"comprou" not in nome.lower() #Retorna False
"barco" not in nome.lower() #Retorna True

#Contagem em String
nome = "Felipe Chiarotti Giron"
nome.count("Felipe") #Retorna 1
nome.count("e") #Retorna 2

#Pesquisa de Strings
mensagem = "Alô mundo"
mensagem.find("mun") #Retorna a posição que se inicia (No caso 4)
mensagem.find("ok") #Retorna -1
mensagem.rfind("o") #Retorna 8 pois pega da direita pra esquerda o primeiro "o"

mensagem = "um tigre, dois tigres, três tigres"
mensagem.find("tigres") #Retorna 15
mensagem.rfind("tigres") #Retorna 28
mensagem.find("tigres",7) #Começa a busca na posição 7 (Retorna 15)
mensagem.find("tigres",30) #Começa a busca na posição 30 (REtorna -1)
mensagem.find("tigres",0,10) #Começa a busca em 0 e termina em 10 (Retorna -1)

#Pesquisa todas ocorrências de uma String
p = 0
while(p>-1):
    p = mensagem.find("tigre", p)
    if(p>=0):
        print("Posição: %d" % p)
        p+=1

#Posicionamento de Strings
string = "tigre"
print("X"+string.center(10)+"X") #Centraliza a String
print("X"+string.center(10,".")+"X") #Centraliza a String adicionando caracteres nos espaços
print(string.ljust(20)+"X") #Adiciona espaços apenas à direita
print(string.ljust(10,"-")) #Adiciona caracter apenas à direita
print("X"+string.rjust(20)) #Adiciona espaços apenas à esquerda

#Quebra e separação de Strings
mensagem = "um tigre, dois tigres, três tigres"
print(mensagem.split()) #Transforma a String em uma lista de elementos a cada espaço
print(mensagem.split(","))

mensagem = "Uma linha\noutra linha\ne mais uma linha"
mensagem.splitlines()

#Substituição de Strings
mensagem.replace("tigre","gato") #Substitui todas as ocorrencias por outra
mensagem.replace("tigre","gato",1) #Substitui apenas a primeira ocorrencia
mensagem.replace("tigre","gato",2) #Substitui 2 ocorrencias
mensagem.replace("", "-") #Substitui cada lugar entre cada caractere por -

#Remoção de espaçoes em branco
mensagem = "     Olá     "
mensagem.strip() #Remove todos os espaços em branco
mensagem.lstrip() #Remove apenas os espaços em branco da esquerda
mensagem.rstrip() #Remove apenas espaços em branco da direita

mensagem = "...///Olá///..."
mensagem.lstrip(".") #Retira todos . da esquerda (Sobrando ///Olá///...)
mensagem.rstrip(".") #Retira todos . da direita (Sobrando ...///Olá///)
mensagem.strip("./") #Retira todos . e / (Sobrando Olá)

#Validação por tipo de conteúdo
mensagem = "125"
p = "alô mundo"

mensagem.isalnum() #Retorna True se a string não estiver vazia e se todos seus caracteres são letras ou numeros (Se tiver espaço, virgula, exclamação etc, retorna False)
p.isalnum() #Retorna false devido ao espaço

mensagem.isalpha() #Verifica se não está vazia, e só é True se todos os caracteres forem letras
p.isalpha()

mensagem.isdigit() #Retorna true se contiver apenas numeros (Não pode ter nem ponto de decimal) (Nesse caso sim)


mensagem = "ABC"
p = "abc"
e = "aBc"

mensagem.isupper() #Retorna True se for inteiro Maiuscula
mensagem.islower() #Retorna TRue se for inteiro minuscula

mensagem.isprintable() #Verifica se pode ser printado na tela e se não tem algum caractere que não pode ser impresso


#Formatação de Strings
"{0} {1}".format("Alô","Mundo")
"{0} x {1} R${2}".format(5,"maçã","1.20")
"{0} {1} {0}".format("-","x")
"{1} {0}".format("primeiro","segundo")
"{0:10} {1}".format("123","456")
"X{0:10}X".format("123")
"X{0:<10}X".format("123")
"X{0:>10}X".format("123")
"X{0:^10}X".format("123")
"X{0:.<10}X".format("123")
"{0[1]} {0[2]}".format(["123", "456"]) #Com listas
"{0[nome]} {0[telefone]}".format({"telefone":88144325, "nome":"Felipe"})
"{0:05}".format(5)
"{0:*=7}".format(5)#Utiliza-se o = quando não usa-se o 0 pra completar
"{0:*^10}".format(123)
"{0:10,}".format(7532)
"{0:10.5f}".format(1500.31)
"{0:10,.5f}".format(1500.31)
"{0:+10} {1:-10}".format(5,-6)
"{0:b}".format(5678) #Formata para binario
"{0:c}".format(65) #Formata para ASCII
"{0:o}".format(5678) #Formata para Octal
"{0:x}".format(5678) #Formata para Hexadecimal minusculo
"{0:X}".format(5678) #Formata para Hexadecimal maiusculo


import locale
locale.setlocale(locale.LC_ALL,"pt_BR.utf-8")