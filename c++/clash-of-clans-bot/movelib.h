#ifndef MOVELIB_H
#define MOVELIB_H

using namespace std;

void setMousePos(int posX, int posY){
	INPUT Input = {0};
	Input.type = INPUT_MOUSE;
	Input.mi.dwFlags = MOUSEEVENTF_ABSOLUTE | MOUSEEVENTF_MOVE;
	Input.mi.dx = posX*(65535.0f/GetSystemMetrics(SM_CXSCREEN));
	Input.mi.dy = posY*(65535.0f/GetSystemMetrics(SM_CYSCREEN));
	SendInput(true,&Input, sizeof(Input));
}

void click(){
	INPUT Input={0};
    Input.mi.dwFlags = MOUSEEVENTF_LEFTDOWN;
    SendInput(true, &Input, sizeof(Input));
    Input.mi.dwFlags = MOUSEEVENTF_LEFTUP;
    SendInput(true, &Input, sizeof(Input));
}

void pressKeyboard(int key){
	INPUT Input={0};
	Input.type = INPUT_KEYBOARD;
	Input.ki.wVk = key;
	Input.ki.dwFlags = KEYEVENTF_EXTENDEDKEY;
	SendInput(true, &Input, sizeof(Input));
	Input.ki.dwFlags = KEYEVENTF_KEYUP;
	SendInput(true, &Input, sizeof(Input)); 	
}
#endif
