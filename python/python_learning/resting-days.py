cigarros = int(input("Cigarros fumados por dia: "))
years = int(input("Quantidade de anos fumando: "))

result = (((cigarros)*(360*years))*10)/(60*24)

print("Você já perdeu %d dias de vida" % (result))
