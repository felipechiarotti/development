tupla = ("a","b","c")
tupla_unica = (1,)
tupla_vazia = ()

lista = [1,2,3]
tupla_da_lista = tuple(lista)

tupla_concatenada = tupla+tupla_da_lista

tupla = ("a",["b","c","d"])
tupla[1].append("e")

a, b = 10, 20
a, b = b, a

print("%d,%d" % (a,b))