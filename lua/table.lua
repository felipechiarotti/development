a = {}
b = {1,3,8,"Teste"}
c = {c1 = "v1", c2 = "v2", {3} = "v3"}

a.campo3 = 13
a.campo321 = print()
a.campo321("Exibe")

////////////////////////////////


a = {}    -- new array
for i=1, 1000 do
  a[i] = 0
end
/////////////////////////////////
-- creates an array with indices from -5 to 5
a = {}
for i=-5, 5 do
  a[i] = 0
end

/////////////////////////////////
reserved = {
  ["while"] = true,     ["end"] = true,
  ["function"] = true,  ["local"] = true,
}

for w in allwords() do
  if reserved[w] then
