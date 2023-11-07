import os
from typing import List

from fastapi import FastAPI,Response,Request
from corpora.no_server import parse_request

app = FastAPI()


dataset_path = "./dataset/"


def corpora():
    """
    Listing all the corpora containing at least one textual file being associated to a json AIF

    :return: Iterator of all the folders containing at least one association between textual file and mining result
    """
    for x in next(os.walk(dataset_path))[1]:
        for y in list_corpora_files(x):
            yield x
            break

def list_corpora_files(corpus):
    """
    Listing all the documents in the corpora being associated to a mining outcome in AIF

    :param corpus:  Corpus from which retrieve the associated document
    :return:        Mined documents within the corpus
    """
    mypath = os.path.join(dataset_path, corpus)
    onlyfiles = [f for f in os.listdir(mypath) if os.path.isfile(os.path.join(mypath, f))]
    d = dict()
    for x in onlyfiles:
        if (x.endswith(".json")):
            key = x[:-5]
            if key not in d:
                d[key] = set()
            d[key].add(x)
        elif (x.endswith(".txt")):
            key = x[:-4]
            if key not in d:
                d[key] = set()
            d[key].add(x)
    for k,v in d.items():
        if len(v) == 2:
            yield k

@app.get('/corpora',response_model=List[str],
    responses={
        200: {
            "description": "List of corpora containing at least one document associated to an AIF mining outcome",
            "content": {
                "application/json": {
                    "example": ["US2016"]
                }
            },
        },
    })
async def get_corpora(request:Request) -> List[str]:
    # c = list(corpora())
    return (parse_request(request.url))

def generic_url_parse_to_be_handled_universally(request):
    if request is None:
        return []
    return (parse_request(request.url))

@app.get('/corpora/{name}',response_model=List[str],
    responses={
        200: {
            "description": "Listing all the documents in the corpora being associated to a mining outcome in AIF",
            "content": {
                "application/json": {
                    "example": ["nodeset9675","nodeset9678","nodeset9679"]
                }
            },
        }
    })
async def get_corpora_files(name="US2016",request:Request=None):
    return generic_url_parse_to_be_handled_universally(request)

@app.get('/get/{corpora}/{document}')
async def get_corpora_Document(corpora="US2016", document="nodeset9675",request:Request=None):
    """
    Retrieving a document from a given corpus
    :param corpora:     Corpus containing the document
    :param document:    Document to be retrieved from the corpus
    :return:            Plain-Text Document
    """
    return Response(content=generic_url_parse_to_be_handled_universally(request), media_type="text")

@app.get('/mine/{corpora}/{document}')
async def mine_corpora_Document(corpora="US2016", document="nodeset9675",request:Request=None):
    """
    Mimicked mining outcome for the documents being provided
    :param corpora:     Corpus containing the mined data
    :param document:    Mimicked mining outcome from the corpus document
    :return:            per-line json file (not an actual json file)
    """
    return Response(content=generic_url_parse_to_be_handled_universally(request), media_type="text")


retriever = """
           ____,'`-, 
      _,--'   ,/::.; 
   ,-'       ,/::,' `---.___        ___,_ 
   |       ,:';:/        ;'"`;"`--./ ,-^.;--. 
   |:     ,:';,'         '         `.   ;`   `-. 
    \:.,:::/;/ -:.                   `  | `     `-. 
     \:::,'//__.;  ,;  ,  ,  :.`-.   :. |  ;       :. 
      \,',';/O)^. :'  ;  :   '__` `  :::`.       .:' ) 
      |,'  |\__,: ;      ;  '/O)`.   :::`;       ' ,' 
           |`--''            \__,' , ::::(       ,' 
           `    ,            `--' ,: :::,'\   ,-' 
            | ,;         ,    ,::'  ,:::   |,' 
            |,:        .(          ,:::|   ` 
            ::'_   _   ::         ,::/:| 
           ,',' `-' \   `.      ,:::/,:| 
          | : _  _   |   '     ,::,' ::: 
          | \ O`'O  ,',   ,    :,'   ;:: 
           \ `-'`--',:' ,' , ,,'      :: 
            ``:.:.__   ',-','        ::' 
    -hrr-      `--.__, ,::.         ::' 
                   |:  ::::.       ::' 
                   |:  ::::::    ,::' 
"""

# if __name__ == "__main__":
#     print(retriever)
#     print("GOLDEN RETRIEVER (c) 2023 (Giacomo Bergami)")
#     print("This simulates an ArgMine by returning json AIF for each document of interest.")
#     print("Starting the retriever server...")
#     #app.run()
