#include <lua.hpp>
#include <iostream>

int main(){
  lua_State *lState;
  lState = luaL_newstate();
  luaL_openlibs( lState );

  string script_lua = "arquivo.lua";

  int iStatus = luaL_loadstring( lState, szLua );
  iStatus = lua_pcall( lState, 0, script_lua, 0);

}
