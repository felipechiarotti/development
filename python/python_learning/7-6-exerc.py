first_string = ""+input()
second_string = ""+input()
third_string = ""+input()
result = []
for character in first_string:
    if(character in second_string):
        result.append(third_string[second_string.find(character)])
    else:
        result.append(character)

print("".join(result))