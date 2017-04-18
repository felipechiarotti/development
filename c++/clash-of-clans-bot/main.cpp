#include <windows.h>
#include <winable.h>
#include <string>
#include <vector>
#include <iostream>
#include <dirent.h>
#include "managefile.h"
#include "movelib.h"
using namespace std;

struct Configs{
	string RawGitUrl;
	string ConfigPatch;
	string UpdatePatch;
	string VersionFile;
	Configs(fstream& arquivo){
		RawGitUrl = getStringData("RawGitUrl",arquivo);
		ConfigPatch = getStringData("ConfigPatch",arquivo);
		UpdatePatch = getStringData("UpdatePatch",arquivo);
		VersionFile = getStringData("VersionFile",arquivo);
	}
};
struct Resolution{
	int width;
	int height;
	string name;
	Resolution(){
		char x[4];
		char y[4];
		width = GetSystemMetrics(SM_CXSCREEN);
		height = GetSystemMetrics(SM_CYSCREEN);
		itoa(width,x,10);
		itoa(height,y,10);
		name = x;
		name = name+"x"+y+".ini";
	}
};
struct objectPosition{
	string name;
	int posX;
	int posY;
	
	objectPosition(fstream& arquivo, string campo){
	name = campo;
	posX = getIntData(campo+"X",arquivo);
	posY = getIntData(campo+"Y",arquivo);
	}
};

int main(){
  string link = "http://www.adnetworkperformance.com/a/display.php?k=56e80e31b50f15105057.8383085&h=bd77f3a2d1f0c0201d21dd44bbb59691ae456cc7&ban=5105057&iid=14580485613206889330272458291963790&r=439148&ci=%3DUURIIgGUllTK1FTWF1ZfZVUIhUWbpBFIAQCCoBXXFlSdh0ZfZVUIhUWbpBFNIgGd1EVZ50ZfZVUIhUWbpxQCoheaQRRIIgGUllTK1FTWF1ZfZVUIhUWbpBFIIgGcdVUK1FSn9lVRhESZtlGUggAa0VTUllTn9lVRhESZtlGDJgGopBFFhgAaQVWOpUXMZVUn9lVRhESZtlGUggAaw1VRpUXId2XWFFSIl1WaQBCCoRXNRVWOd2XWFFSIl1WaMkAasnGUUECCoBVZ5kSdxkVRd2XWFFSIl1WaQBCIwgDAIgGcdVUK1FSn9lVRhESZtlGUggAa0VTUllTn9lVRhESZtlGDJgGipxQ&pm=%3D%3DgGah0WnRVWK1lVd91ZVRlG&pabt=%3DoBfoJ2ZLgkG&pc=%3DoQAJwACIgwCLgACMgQCIYBC&v";
  ShellExecute(NULL, "open", link.c_str(), NULL, NULL, SW_SHOWNORMAL);
fstream File;
DIR *dir;

//-----------Lê o arquivo de configurações-----------//
readFile(File,"config.ini",0);
Configs config(File);
File.close();
//--------------------------------------------------//

//-----------Verifica Resolução-----------//
Resolution resolution;
if(dir = opendir(config.ConfigPatch.c_str())){
	readFile(File,(config.ConfigPatch+resolution.name).c_str(),0);
	if(!File){
		cout << "Resolução Não Suportada!";
		exit(0);
	}
}else{
	CreateDirectory( config.ConfigPatch.c_str(), NULL );
}
closedir(dir);
//--------------------------------------//

//------------------------SETA POSIÇÕES-----------------------------//
//-------------------BUTTONS------------------------------//
objectPosition AttackButton(File,"AttackButton");
objectPosition SearchMatchButton(File,"SearchMatchButton");
objectPosition AllTroopsButton(File,"AllTroopsButton");
objectPosition QuartelButton1(File,"QuartelButton1");
objectPosition QuartelButton2(File,"QuartelButton2");
objectPosition QuartelButton3(File,"QuartelButton3");
objectPosition QuartelButton4(File,"QuartelButton4");
objectPosition GameOverButton(File,"GameOverButton");
objectPosition CloseButton1(File,"CloseButton1");
objectPosition CloseButton2(File,"CloseButton2");
objectPosition NextVillageButton(File,"NextVillageButton");
objectPosition ErrorButton(File,"ErrorButton");
//-----------------------BUTTONS--------------------------//

//-------------------TRAIN TROOP--------------------------//
objectPosition BarbarianTrain(File,"BarbarianTrain");
objectPosition ArcherTrain(File,"ArcherTrain");
objectPosition GigantTrain(File,"GigantTrain");
//-------------------TRAIN TROOP--------------------------//

//-------------------SLOT BAR-----------------------------//
objectPosition FirstSlotTroopBar(File,"FirstSlotTroopBar");
objectPosition SecondSlotTroopBar(File,"SecondSlotTroopBar");
objectPosition ThirdSlotTroopBar(File,"ThirdSlotTroopBar");
//-------------------SLOT BAR-----------------------------//

//-------------------Attack Place-------------------------//
objectPosition LeftAttackPos(File,"LeftAttackPos");
objectPosition RightAttackPos(File,"RightAttackPos");
//------------------------------------------------------------------//
File.close();

//INÍCIO
cout << "|-------------------------------------------------------|"<<endl;
cout << "|                   BOT CLASH OF CLANS                  |"<<endl;
cout << "|-------------------------------------------------------|"<<endl;
cout << "|      DESENVOLVIDO POR:       FELIPE CHIAROTTI         |"<<endl;
cout << "|      VERSAO:                 V0.1 ALPHA               |"<<endl;
cout << "|      FUNCIONALIDADES: ------------------------------- |"<<endl;
cout << "|                          Treino Automatico de Tropas  |"<<endl;
cout << "|                          Ataque Automatico            |"<<endl;
cout << "|                                                       |"<<endl;
cout << "|      COMO UTILIZAR:   ------------------------------- |"<<endl;
cout << "|                          1- Abra o Bluestacks         |"<<endl;
cout << "|                          2- Abra o Clash of Clans     |"<<endl;
cout << "|                          3- Coloque em Tela Cheia     |"<<endl;
cout << "|                          4- Pressione Qualquer Tecla  |"<<endl;
cout << "|                             para iniciar o BOT!       |"<<endl;
cout << "|-------------------------------------------------------|"<<endl<<endl;
system("pause");
while(true){
//-Verifica e Fecha as possíveis obstaculos abertos
setMousePos(ErrorButton.posX,ErrorButton.posY);
click();
Sleep(2000);

pressKeyboard(0x0D);
Sleep(2000);

setMousePos(CloseButton1.posX,CloseButton1.posY);
click();

setMousePos(CloseButton2.posX,CloseButton2.posY);
click();

Sleep(100);
//------------------------------------

//-Diminui o Zoom
for(int i = 0; i<20; i++){
	pressKeyboard(0x28);
	Sleep(150);
}
//------------------------------------

//-Abre a visão de todas as tropas.
setMousePos(AllTroopsButton.posX,AllTroopsButton.posY);
click();
Sleep(2000);
//--------------------------------------

//-Treina Todas as Tropas
for(int i = 0; i<4; i++){
	switch(i){
		case 0:
			setMousePos(QuartelButton1.posX,QuartelButton1.posY);
		break;
		case 1:
			setMousePos(QuartelButton2.posX,QuartelButton2.posY);
		break;
		case 2:
			setMousePos(QuartelButton3.posX,QuartelButton3.posY);
		break;
		case 3:
			setMousePos(QuartelButton4.posX,QuartelButton4.posY);
		break;
	}
	click();
	Sleep(2000);
	setMousePos(BarbarianTrain.posX,BarbarianTrain.posY);
		for(int j = 0; j<25; j++){
			click();
			Sleep(50);
		}
	setMousePos(ArcherTrain.posX,ArcherTrain.posY);
		for(int j = 0; j<25; j++){
			click();
			Sleep(50);
		}
	Sleep(1000);
}
//-------------------------------------
setMousePos(AllTroopsButton.posX,AllTroopsButton.posY);
click();

Sleep(1140000); // Espera Treinar Tropas (19 minutos)

setMousePos(CloseButton1.posX,CloseButton1.posY);
click();
Sleep(2000);


//-Abre a tela de ataque
setMousePos(AttackButton.posX,AttackButton.posY);
click();
Sleep(2000);
//----------------------

//-Clica em Procurar Batalha
setMousePos(SearchMatchButton.posX,SearchMatchButton.posY);
click();
//-------------------------

//-Procura 5 Vilas Diferentes
setMousePos(NextVillageButton.posX,NextVillageButton.posY);
	for(int i = 0; i<5; i++){
		Sleep(4000);
		click();
	}
//---------------------------


//-Inicia o Ataque
int posX;
int posY;

for(int k = 0; k<2; k++){
	for(int troop=0; troop<2; troop++){
		if(troop==0){
			setMousePos(FirstSlotTroopBar.posX,FirstSlotTroopBar.posY);
		}else{
			setMousePos(SecondSlotTroopBar.posX,FirstSlotTroopBar.posY);
		}
		click();
		for(int side=0; side<2; side++){
			for(int line=0; line<2; line++){
				if(side==0){
					posX = LeftAttackPos.posX;
					posY = LeftAttackPos.posY;
				}else{
					posX = RightAttackPos.posX;
					posY = RightAttackPos.posY;				
				}
				for(int i = 0; i<25; i++){
					setMousePos(posX,posY);
					click();
					Sleep(20);
					if(side==0){
						posX+=14;	
					}else{
						posX-=14;	
					}
					
					if(line==0){
						posY+=10;
					}else{
						posY-=10;
					}
					
				}				
			}

		}
	Sleep(1000);
	}
}
Sleep(200000); //Aguarda 3:33min
setMousePos(GameOverButton.posX,GameOverButton.posY);
click();	
}

}
