import os

from flask import Flask, jsonify, Response


app = Flask(__name__)
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

@app.route('/corpora', methods=['GET'])
def get_corpora():
    c = list(corpora())
    return Response(jsonify(c), mimetype='text/json'), 200

@app.route('/corpora/<name>', methods=['GET'])
def get_corpora_files(name):
    c = list_corpora_files(name)
    return  Response(jsonify(list(c)), mimetype='text/json'), 200


@app.route('/get/<corpora>/<document>')
def get_corpora_Document(corpora, document):
    """
    Retrieving a document from a given corpus
    :param corpora:     Corpus containing the document
    :param document:    Document to be retrieved from the corpus
    :return:            Plain-Text Document
    """
    with open(os.path.join(dataset_path, corpora, document+".txt")) as f:
        return Response(f.read(), mimetype='text'), 200

@app.route('/mine/<corpora>/<document>')
def mine_corpora_Document(corpora, document):
    """
    Mimicked mining outcome for the documents being provided
    :param corpora:     Corpus containing the mined data
    :param document:    Mimicked mining outcome from the corpus document
    :return:            per-line json file (not an actual json file)
    """
    with open(os.path.join(dataset_path, corpora, document+".json")) as f:
        return Response(f.read(), mimetype='text/json'), 200


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

if __name__ == "__main__":
    print(retriever)
    print("GOLDEN RETRIEVER (c) 2023 (Giacomo Bergami)")
    print("This simulates an ArgMine by returning json AIF for each document of interest.")
    print("Starting the retriever server...")
    app.run()