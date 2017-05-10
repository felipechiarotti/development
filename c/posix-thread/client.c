#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netdb.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <sys/ioctl.h>
#include <ctype.h>
#include <string.h>
 
int connect_client(char* ip, int port){
    /*Descritor do cliente*/
    int clienteSockfd;
    /*Estrutura do Cliente*/
    struct sockaddr_in serv_addr;
    /*Tamanho da estrutura*/
    socklen_t addrlen = sizeof (serv_addr);
 
    /*Socket familia TCP declarado SOCK_STREAM e criado*/
    clienteSockfd = socket(PF_INET, SOCK_STREAM, IPPROTO_TCP);
    if (clienteSockfd < 0)
    {
        printf("Erro no Socket\n");
        exit(1);
    }
    /*Zera a estrutura*/
    bzero((char *) & serv_addr, sizeof (serv_addr));
    /*Seta a familia*/
    serv_addr.sin_family = AF_INET;
    /*Define o IP nesse caso o localhost*/
    serv_addr.sin_addr.s_addr = inet_addr(ip);
    /*Define a porta de conexao*/
    serv_addr.sin_port = htons(port);
   /*Faz a conexao com o servidor*/
   if(connect(clienteSockfd,(struct sockaddr *)&serv_addr, addrlen) < 0)
     {
        printf("Erro ao conectar-se ao servidor\n");
        exit(1);
    }
        return clienteSockfd;
}

void run_client(int clienteSockfd)
{
  /*Buffer de dados a ser mandado para o servidor*/
  char buffer_para_servidor[256];
  printf("Digite uma mensagem para o servidor: ");
   do {
 
        scanf("%s",buffer_para_servidor);
        fflush(stdin);
        /*Escreve para o servidor*/
 
        write(clienteSockfd, buffer_para_servidor, sizeof (buffer_para_servidor));
 
      /*Mensagem para sair*/
    } while (strcmp(buffer_para_servidor, "sair") != 0);
    /**Encerra o descritor*/
    close(clienteSockfd);
}

int main(int argc, char* argv[]){
    struct sockaddr_in serv_addr;
    socklen_t addr_len = sizeof(serv_addr);
    int client_data = connect_client(argv[1],atoi(argv[2]));
    run_client(client_data);
}