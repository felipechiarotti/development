ponto_a = input()
ponto_b = input()

pontos = [ponto_a.split(), ponto_b.split()]

distance = (((float(pontos[0][0])-float(pontos[1][0]))**2) + ((float(pontos[0][1])-float(pontos[1][1]))**2))** (1/2)
print("%.4f" % (distance))