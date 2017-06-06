def soma(a,b):
    return(a+b)

soma(3,5)

def par(x):
    return(x%2==0)

def maximo(a,b):
    if (a>b):
        return a;
    else:
        return b;
    #return (a if a>b else return b)

def multiplo(a,b):
    return (a%b==0)

def area_quadrado(lado):
    return (lado**2)

def area_triangulo(base,altura):
    return ((base*altura) / 2)

def pesquisa(lista, valor):
    for key, value in enumerate(lista):
        if value == valor:
            return key;
    return None;

def fatorial(n):
    if n==0 or n == 1:
        return 1;
    else:
        return n*fatorial(n-1);

def fibonacci(n):
    if(n <= 1):
        return n
    else:
        return fibonacci(n-1)+fibonacci(n-2)


def soma(a,b):
    return a+b

def subtracao(a,b):
    return a-b

def imprime(a,b, function_op):
    print(function_op(a,b))

############################################

def imprime_lista(lista, func_impressao, func_condicao):
    for element in lista:
        if func_condicao(element):
            func_impressao(element)

def imprime_elemento(element):
    print("Valor: %d" % element)

lista = [3,5,8,12,4]
imprime_lista(lista, imprime_elemento, par)

###############################################

soma(*lista)

#############################################

def soma(*args):
    soma = 0
    for value in args:
        soma = soma + value
    return soma

soma(1,2)
soma(2)
soma(5,6,7,8)
soma(9,10,20,30,40)

##############################################

a = lambda x: x*2
print(a(3))

aumento = lambda a,b: (a*b/100)
aumento(100,5)