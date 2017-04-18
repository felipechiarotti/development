#include <iostream>
#include <vector>
#include <string>
#include "lib/manageFile.h"
#include <cstdlib>
#include <unistd.h>
using namespace std;

fstream arquivo1;
fstream arquivo2;

struct DadosCandidato {
	int codigo[6];
	int curso;
	int local;
	int lingua;
};

struct Materia{
	int id;
	string nome;
	
	void readMateria(){
		string Id;
		Id = readLineCSV(arquivo1);
		nome = readLineCSV(arquivo1);

		if(Id.size()>1){
			id = ((Id[0]-48) * 10);
			id+= Id[1]-48;
		}else{
			id = Id[0]-48;			
		}
	}
};

struct Curso{
	int id;
	int vagas;
	string nome;
	string turno;
	string campus;


	void readCurso(){
		string linha;
		linha = readLineCSV(arquivo1);

			if(linha.size()<3) id = linha[linha.size()-1]-48;
			else{
				id= (linha[linha.size()-2]-48)*10;
				id+= linha[linha.size()-1]-48;
			}			

		nome = readLineCSV(arquivo1);
		turno = readLineCSV(arquivo1);
		linha = readLineCSV(arquivo1);
		vagas = (linha[0]-48)*10;
		vagas+= linha[1]-48;
		campus = readLineCSV(arquivo1);
	}
};

struct Peso{
	int idCurso;
	int peso[11];

	void readPeso(){
		string linha;
		linha = readLineCSV(arquivo1);
		if(linha.size()==1) idCurso = linha[0]-48;
		else if(linha.size()==2){idCurso = linha[1]-48;}
		else{idCurso = (linha[1]-48)*10;
			 idCurso+= linha[2]-48;}

			 linha = readLineCSV(arquivo1);
		for(int i = 0; i<linha.size(); i++){
			peso[i] = linha[i]-48;
		}
	}
};

struct Desempate{
	int idCurso;
	int materias[11];

	void readDesempate(){
		string linha;
		linha = readLineCSV(arquivo1);
			if(linha.size()==1) idCurso = linha[0]-48;
			else if(linha.size()==2){idCurso = linha[1]-48;}
			else{idCurso = (linha[1]-48)*10;
				 idCurso+= linha[2]-48;}

			for(int i = 0; i<11; i++){
				linha = readLineCSV(arquivo1);
				if(linha.size()>1){
					materias[i] = (linha[0]-48)*10;
					materias[i]+= linha[1]-48;
				}else {materias[i] = (linha[0]-48);}
			}
	}
};
struct Gabarito{
	int nProva;
	string gabarito;

	void readGabarito(){
		string linha;
		linha = readLine(arquivo1);

		nProva = linha[1]-48;
		gabarito = linha.substr(3,linha.size());
	}
};
struct Candidato{
	DadosCandidato dados;

	vector<char> respostaP1;
	vector<char> respostaP2;
	char alternativa;

	bool status;

	int totalAcertos;
	int acertoMat[10];
	int totalPontos;
	int acertoP1;
	int acertoP2;

	Candidato(){
		totalAcertos=totalPontos=acertoP1=acertoP2=0;
		status = false;
		for(int i = 0; i<10; i++){
			acertoMat[i]=0;
		}
	}
	void readCandidato(){
		string linha;
		int aux[2];

		linha = readLine(arquivo1);
		for(int i = 0; i<linha.size(); i++){
			if(i == 0) dados.local = linha[i]-48;
			else if(i>0 && i<3)aux[i-1] = linha[i]-48;
			else if(i>2 && i<9) {dados.codigo[i-3] = linha[i]-48;}
			else if(i==9) dados.lingua = linha[i]-48;
			else if(i>9 && i<linha.size()){
				respostaP1.push_back(alternativa);
				respostaP1[i-10] = linha[i];
			}
		}
			dados.curso = aux[0]*10;
			dados.curso+= aux[1];

		readLine(arquivo2);
		for(int i = 0; i<linha.size(); i++){
			if(i>9 && i<linha.size()){
				respostaP2.push_back(alternativa);
				respostaP2[i-10] = linha[i];
			}
		}
	}
};

int main(){
	int eof;
	string linha;
	string nomeArq;
	string url;
	//BAIXA ARQUIVOS
	cout << "Baixando arquivos de configurações: ";
	if(downloadFile("https://dl.dropboxusercontent.com/s/1uubgmia7qvojr2/config.csv?dl=0","config/config.csv")) cout << "Concluido."<<endl;

	eof = readCSVFile(arquivo1,"config/config.csv");
	for(int i = 0; i<eof; i++){
		nomeArq = "files/"+readLineCSV(arquivo1);
		url = readLineCSV(arquivo1);
		string aux;
		for(int j = 0; j<nomeArq.size();j++){
			if((int)nomeArq[j]==10){
				aux = nomeArq.substr(0,j);
				nomeArq = nomeArq.substr(j+1);
				nomeArq = aux+nomeArq;
				break;
			}		
		}
		readFile(arquivo2,nomeArq);
		if(arquivo2.is_open()==0){
			cout << "Baixando arquivo de dado: " << i+1 << " de " << eof << endl;
			downloadFile(url,nomeArq);
		}
		arquivo2.close();
	}
	arquivo1.close();


	cout << "--------------------------------------" << endl << endl;
	cout << "Iniciando Análise de Dados..." << endl;
	usleep(3000);
	/*		--- ARMAZENA CURSOS		  ---	*/
	vector<Curso> cursos;
	Curso structCurso;
	eof = readCSVFile(arquivo1,"files/curso.csv");
	for(int i = 0; i<eof; i++){
		cursos.push_back(structCurso);
		cursos[i].readCurso();
	}
	cout << "Cursos Lidos: " << cursos.size() << endl;
	arquivo1.close();


	/* 		--- ARMAZENA OS GABARITOS ---	*/
	vector<Gabarito> gabaritos;
	Gabarito structGabarito;
	eof = readFileCheck(arquivo1,"files/gabarito.txt")-12;
	for(int i = 0; i<eof; i++){
		gabaritos.push_back(structGabarito);
		gabaritos[i].readGabarito();
	}
	cout << "Gabaritos Lidos: " << gabaritos.size() << endl;
	arquivo1.close();


	vector<Desempate> desempates;
	Desempate structDesempate;
	eof = readCSVFile(arquivo1,"files/desempate.csv");

	for(int i = 0; i<eof; i++){
		desempates.push_back(structDesempate);
		desempates[i].readDesempate();
	}
	arquivo1.close();
	cout << "Critérios para Desempate Lidos: " << desempates.size() << endl;

	/*		--- ARMAZENA OS PESOS X CURSO --- */
	vector<Peso> pesos;
	Peso structPeso;
	eof = readCSVFile(arquivo1,"files/pesos.csv");
	for(int i = 0; i<eof; i++){
		pesos.push_back(structPeso);
		pesos[i].readPeso();
	}
	cout << "Pesos Lidos: " << pesos.size() << endl;
	arquivo1.close();



	/* 		--- ARMAZENA AS MATERIAS ---	*/
	vector<Materia> materias;
	Materia structMateria;

	eof = readCSVFile(arquivo1,"files/materias.csv");

	for(int i = 0; i<eof; i++){
		materias.push_back(structMateria);
		materias[i].readMateria();
	}
	cout << "Matérias Lidas: " << materias.size() << endl;
	arquivo1.close();


	/* 		--- ARMAZENA OS CANDIDATOS ---	*/
	eof = readFileCheck(arquivo1,"files/prova1.txt");
	 	  readFile(arquivo2,"files/prova2.txt");

	vector<Candidato> candidatos;
	Candidato structCandidato;

	for(int i = 0; i<eof; i++){
		candidatos.push_back(structCandidato);
		candidatos[i].readCandidato();
			/*		--- CONTABILIZA ACERTOS --- */
			for(int j = 0; j<gabaritos[0].gabarito.size(); j++){
				if(j<30){
					if(candidatos[i].respostaP1[j] == gabaritos[0].gabarito[j]){
							candidatos[i].acertoMat[0]++;					
					}
				}else{
					if(candidatos[i].dados.lingua == 1){
						if(candidatos[i].respostaP1[j] == gabaritos[0].gabarito[j]){
							candidatos[i].acertoMat[1]++;
						}						
					}else{
						if(candidatos[i].respostaP1[j] == gabaritos[1].gabarito[j]){
							candidatos[i].acertoMat[1]++;
						}						
					}
				}
			}

			for(int j = 0; j<gabaritos[1].gabarito.size(); j++){
				if (candidatos[i].respostaP2[j] == gabaritos[2].gabarito[j])
				{
					if(j<8) candidatos[i].acertoMat[2]++;
					else if(j<15) candidatos[i].acertoMat[3]++;
					else if(j<22) candidatos[i].acertoMat[4]++;
					else if(j<30) candidatos[i].acertoMat[5]++;
					else if(j<38) candidatos[i].acertoMat[6]++;
					else if(j<46) candidatos[i].acertoMat[7]++;
					else if(j<53) candidatos[i].acertoMat[8]++;
					else if(j<60) candidatos[i].acertoMat[9]++;
				}
			}
			for(int j = 0; j<10; j++){
				candidatos[i].totalAcertos+= candidatos[i].acertoMat[j];	
				if(j<2){candidatos[i].acertoP1+= candidatos[i].acertoMat[j];}
				else{candidatos[i].acertoP2+= candidatos[i].acertoMat[j];}		
			}
	}
				cout << "Candidatos Lidos: " << candidatos.size() << endl;
	arquivo1.close();
	arquivo2.close();

	/*		--- VERIFICA ACEITOS ---		*/
	vector<Candidato> aceitos;
	int totalAceitos = 0;
	for(int i = 0; i<eof; i++){
		if( (candidatos[i].acertoP1 >= gabaritos[0].gabarito.size()*0.3) && (candidatos[i].acertoP2 >= gabaritos[2].gabarito.size()*0.3)){
			aceitos.push_back(structCandidato);
			aceitos[totalAceitos] = candidatos[i];
			aceitos[totalAceitos].status = true;
			totalAceitos++;
		}
	}
	cout << "Candidatos Aceitos: " << aceitos.size() << endl;
	candidatos.clear();


	/*		---	CALCULA PESO ---		*/	
	for(int i = 0; i<aceitos.size(); i++){
		for(int j = 0; j<pesos.size(); j++){ 
			if(aceitos[i].dados.curso == pesos[j].idCurso){ 
				for(int z = 0; z<10; z++){ 
					aceitos[i].totalPontos+= aceitos[i].acertoMat[z] * pesos[j].peso[z+1];
				}
			}
		}
	}
	cout << endl <<"---------------------------------" << endl;
	cout << "Pontuação de candidatos calculada."<<endl;
	cout << "---------------------------------" << endl << endl;

	cout << "Gerando arquivos: " << endl;
	/*		--- SEPARA POR CURSO ---	*/	
	int vagasTotaisUENP=0;
	for(int i = 0; i<cursos.size(); i++){
		vagasTotaisUENP+= cursos[i].vagas;
	}

	vector<Candidato> ordenaCurso;
	string cabecalho = "inscrição;língua estrangeira;curso;acertos prova 1;acertos prova 2;pontuação;classificação;situação;\n";

	for(int i = 0; i<cursos.size(); i++){
	int total = 0;
		for(int j=0; j<aceitos.size(); j++){
			if(aceitos[j].dados.curso == i+1){
				ordenaCurso.push_back(structCandidato);
				ordenaCurso[total]=aceitos[j];
				total++;		
			}
		}
		for(int z = 0; z<ordenaCurso.size(); z++){
			for(int j = 0; j<ordenaCurso.size(); j++){
				if(ordenaCurso[j].totalPontos < ordenaCurso[j+1].totalPontos && j!=ordenaCurso.size()-1){
					structCandidato = ordenaCurso[j];
					ordenaCurso[j] = ordenaCurso[j+1];
					ordenaCurso[j+1] = structCandidato;
				}else if(ordenaCurso[j].totalPontos == ordenaCurso[j+1].totalPontos && j!=ordenaCurso.size()-1){
					for(int h = 0; h<desempates.size(); h++){
						if(desempates[h].idCurso == cursos[i].id){
							for(int x = 0; x<materias.size(); x++){
								if(desempates[h].materias[x]!=0){
									if(ordenaCurso[j].acertoMat[desempates[h].materias[x]-1] < ordenaCurso[j+1].acertoMat[desempates[h].materias[x]-1]){
										structCandidato = ordenaCurso[j];
										ordenaCurso[j] = ordenaCurso[j+1];
										ordenaCurso[j+1] = structCandidato;		
										break;																
									}
								}
							}
						break;
						}
					}
				}
			}
		}
		string nomeCurso = "listasAprovados/"+cursos[i].nome+"("+cursos[i].campus+")("+cursos[i].turno+").csv";
		for(int z = 17; z<nomeCurso.size(); z++){
			if(nomeCurso[z]=='/'){nomeCurso[z]='-';}
		}
		DIR* dir = opendir("listasAprovados");
		if(dir == NULL) mkdir("listasAprovados",S_IRWXU | S_IRWXG | S_IROTH | S_IXOTH);
		writeFileCSV(arquivo1,nomeCurso,cabecalho);
			for(int j = 0; j<100+cursos[i].vagas; j++){
				if(j==ordenaCurso.size()){break;}
				for(int z = 0; z<6; z++) {arquivo1 << ordenaCurso[j].dados.codigo[z];}
				arquivo1 << ';';
				arquivo1 << ordenaCurso[j].dados.lingua << ';';
				arquivo1 << ordenaCurso[j].dados.curso << ';';
				arquivo1 << ordenaCurso[j].acertoP1 << ';';
				arquivo1 << ordenaCurso[j].acertoP2 << ';';
				arquivo1 << ordenaCurso[j].totalPontos << ';';
				arquivo1 << j+1 << ';';
				if(j>=cursos[i].vagas){ordenaCurso[j].status = false;}
					if(ordenaCurso[j].status)  arquivo1 << "aprovado";
					else { arquivo1 << "em espera";}
				arquivo1 << '\n';
			}
		cout << "Lista Gerada: " << cursos[i].nome << endl;
		ordenaCurso.clear();
		arquivo1.close();
	}	
}