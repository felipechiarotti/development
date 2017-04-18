first_string = ""+input()
second_string = ""+input()
result = []
for character in first_string:
    if(character not in second_string):
        result.append(character)

print("".join(result))