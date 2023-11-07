import os

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

def read_txt(corpora,document):
    doc:str = ""
    with open(os.path.join(dataset_path, corpora, document+".txt"), encoding="cp1252") as f:
        doc = (f.read())
    return doc

def read_json(corpora,document):
    doc:str = ""
    with open(os.path.join(dataset_path, corpora, document+".json")) as f:
        doc = (f.read())
    return doc