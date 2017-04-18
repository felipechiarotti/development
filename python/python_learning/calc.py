number_one = float(input("Primeiro Número: "))
number_two = float(input("Segundo Número: "))
operation = input("Operação (+ - / *): ")

result = 0

if operation == '+':
	result = number_one + number_two
elif operation == '-':
	result = numer_one - number_two
elif operation == '/':
	result = number_one / number_two
elif operation == '*':
	result = number_one * number_two

print("%.1f %s %.1f = %.1f" % (number_one,operation,number_two,result))
