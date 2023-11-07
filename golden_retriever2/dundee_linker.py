import json
import os
from typing import List, Annotated

from fastapi import FastAPI, Response, Request, UploadFile
from fastapi import FastAPI, Form
from linker.routes import actual_doing

def extract_nodes_keys(obj):
    d = dict()
    for item in obj["src"]["locutions"]:
        for k,v in item.items():
            if k not in d:
                d[k] = set()
            d[k].add(type(v).__name__)
    for item in obj["dst"]["locutions"]:
        for k,v in item.items():
            if k not in d:
                d[k] = set()
            d[k].add(type(v).__name__)
    return d

app = FastAPI()

from pydantic import BaseModel


class Item(BaseModel):
    src: str
    dst: str

@app.on_event("startup")
async def startup_event():
    with open("dundee_linker.ready", "w") as f:
        f.write("READY")

@app.on_event("shutdown")
async def shutdown_event():
    os.unlink("dundee_linker.ready")

@app.post('/extract_links')
def extract_links(body:Item, request:Request=None):
    """
    Expresses the link across documents
    :param files:   Files being uploaded
    :param src:     Name of the source file
    :param dst:     Name of the destination file
    :return:        Returns the linking object
    """
    d = dict()
    conv = dict()
    d["src"] = body.src
    d["dst"] = body.dst
    return actual_doing(request.query_params["src"], request.query_params["dst"], [d["src"]], [d["dst"]])


# def link_corpus(corpus, documents = None, debug=False):
#     d = dict()
#     if documents is None:
#         documents = set()
#     else:
#         documents = set(documents)
#     if len(documents) == 0:
#         for x in requests.get(url="http://127.0.0.1:8000/corpora/"+corpus).json():
#             d[x] = [requests.get(url="http://127.0.0.1:8000/mine/"+corpus+"/"+x).text]
#     else:
#         for x in documents:
#             d[x] =[requests.get(url="http://127.0.0.1:8000/mine/"+corpus+"/"+x).text]
#     s = set()
#     L = dict()
#     Final = dict()
#     for x in d:
#         for y in d:
#             if (x != y) and (((x not in L) or (y not in L[x])) or ((y not in L) or (x not in L[x]))) :
#                 obj = actual_doing(x, y, d[x], d[y])
#                 if obj["found"]:
#                     if debug:
#                         print("x,y="+x+","+y+" (found)")
#                     s.add(x)
#                     s.add(y)
#                     if x not in L:
#                         L[x] = dict()
#                     assert y not in L[x]
#                     L[x][y] = obj
#                     print(extract_nodes_keys(obj))
#                     #print(json.dumps(obj, indent=4))
#                     exit(1)
#     Final["relevant"] = s
#     Final["links"] = L
#     if debug:
#         print("\n\n\n~~~~~~~~~~~~~~~~~~~~~")
#     return json.dumps(Final)
#
# if __name__ == '__main__':
#     corpus = "US2016"
#     documents = ["nodeset10032","nodeset10042","nodeset10050","nodeset10056","nodeset10057","nodeset10058","nodeset10063","nodeset10229","nodeset10239","nodeset10240","nodeset10241","nodeset10243","nodeset10244","nodeset10247","nodeset10248","nodeset10250","nodeset10253","nodeset10273","nodeset10281","nodeset10285","nodeset10299","nodeset10300","nodeset10306","nodeset10310","nodeset10312","nodeset10314","nodeset10317","nodeset10320","nodeset10322","nodeset10324","nodeset10337","nodeset10363","nodeset10365","nodeset10367","nodeset10370","nodeset10371","nodeset10375","nodeset10376","nodeset10384","nodeset10385","nodeset10388","nodeset10389","nodeset10391","nodeset10393","nodeset10395","nodeset10400","nodeset10402","nodeset10405","nodeset10406","nodeset10407","nodeset10409","nodeset10410","nodeset10411","nodeset10412","nodeset10413","nodeset10414","nodeset10416","nodeset10419","nodeset10436","nodeset10443","nodeset10444","nodeset10445","nodeset10450","nodeset10453","nodeset10454","nodeset10457","nodeset10459","nodeset10462","nodeset10465","nodeset10474","nodeset10477","nodeset10482","nodeset10484","nodeset10488","nodeset10489","nodeset10492","nodeset10493","nodeset10494","nodeset10495","nodeset10498","nodeset10499","nodeset10506","nodeset10508","nodeset10510","nodeset10513","nodeset10514","nodeset10540","nodeset10546","nodeset10547","nodeset10549","nodeset10556","nodeset10557","nodeset10558","nodeset10559","nodeset10561","nodeset10562","nodeset10563","nodeset10566","nodeset10567","nodeset10569","nodeset10570","nodeset10573","nodeset10574","nodeset10576","nodeset10579","nodeset10581","nodeset10586","nodeset10588","nodeset10589","nodeset10590","nodeset10591","nodeset10593","nodeset10594","nodeset10595","nodeset10607","nodeset10608","nodeset10610","nodeset10621","nodeset10622","nodeset10627","nodeset10631","nodeset10632","nodeset10634","nodeset10660","nodeset10664","nodeset10665","nodeset10670","nodeset10700","nodeset10701","nodeset10810","nodeset10811","nodeset10814","nodeset10815","nodeset10820","nodeset10825","nodeset10827","nodeset10832","nodeset10834","nodeset10836","nodeset10837","nodeset10840","nodeset10842","nodeset10848","nodeset10849","nodeset10854","nodeset10857","nodeset10860","nodeset10862","nodeset10864","nodeset10867","nodeset11321","nodeset9675","nodeset9679","nodeset9706","nodeset9751","nodeset9801","nodeset9812","nodeset9839","nodeset9840","nodeset9842","nodeset9845","nodeset9846","nodeset9851","nodeset9854","nodeset9877"]
#     link_corpus(corpus, documents)