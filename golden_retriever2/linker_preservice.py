from linker.routes import actual_doing

src = ""
dst = ""
with open("dataset/US2016/nodeset10032.json","r") as f:
    src = f.read()
with open("dataset/US2016/nodeset10042.json","r") as f:
    dst = f.read()

actual_doing(None, None, [src], [dst])