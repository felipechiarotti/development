line = input()
line = line.split()

triangulo = (float(line[0])*float(line[2]))/2
circulo = 3.14159*float(line[2])**2
trapezio = ((float(line[0])+float(line[1]))*float(line[2]))/2
quadrado = float(line[1])**2
retangulo = float(line[1])*float(line[0])

print("TRIANGULO: %.3f\nCIRCULO: %.3f\nTRAPEZIO: %.3f\nQUADRADO: %.3f\nRETANGULO: %.3f" % (triangulo,circulo,trapezio,quadrado,retangulo))