import socket

target_host = "www.uenp.edu.br"
target_port = 80

client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

client.connect((target_host,target_port))

client.send("GET / HTTP/1.1\r\nHost: uenp.edu.br\r\n\r\n")

response = client.recv(8192)

print (response)
