import flask
from corpora.funcs import *
def parse_request(url_req):
    ls = []
    if isinstance(url_req, str):
        ls = url_req.split("/")
    else:
        ls = url_req.path.split("/")
    if len(ls[0])==0:
        ls.pop(0)
    if len(ls[-1])==0:
        ls.pop(len(ls)-1)
    if ls[0] == "corpora":
        if len(ls) == 1:
            return (list(corpora()))
        elif len(ls) > 1:
            return (list(list_corpora_files(ls[1])))
        else:
            return ""
    elif ls[0] == "get":
        if len(ls) == 3:
            return read_txt(ls[1], ls[2])
        else:
            return ""
    elif ls[0] == "mine":
        if len(ls) == 3:
            return read_json(ls[1], ls[2])
        else:
            return ""
    else:
        return ""

