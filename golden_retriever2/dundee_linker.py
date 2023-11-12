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
    if ((body.src is None) or (body.src == "null")) or ((body.dst is None) or (body.dst == "null")):
        return None
    d["src"] = body.src
    d["dst"] = body.dst
    return actual_doing(request.query_params["src"], request.query_params["dst"], [d["src"]], [d["dst"]])

