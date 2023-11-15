#!/usr/local/bin/python
# -*- coding: utf-8 -*-
__author__ = "Giacomo Bergami"
__copyright__ = "Copyright 2023"
__credits__ = ["Giacomo Bergami"]
__license__ = "GPL"
__version__ = "3.0"
__maintainer__ = "Giacomo Bergami"
__email__ = "bergamigiacomo@gmail.com"
__status__ = "Production"

import os
import sys
from contextlib import asynccontextmanager
from typing import List

import uvicorn
import yaml
from fastapi import FastAPI
from fastapi import Request

from linker.routes import actual_doing


def extract_nodes_keys(obj):
    d = dict()
    for item in obj["src"]["locutions"]:
        for k, v in item.items():
            if k not in d:
                d[k] = set()
            d[k].add(type(v).__name__)
    for item in obj["dst"]["locutions"]:
        for k, v in item.items():
            if k not in d:
                d[k] = set()
            d[k].add(type(v).__name__)
    return d


@asynccontextmanager
async def app_lifespan(app: FastAPI):
    print("init lifespan")
    # Generates a file to determine that the service is successfully up and running
    with open("dundee_linker.ready", "w") as f:
        f.write("READY")
    print("Please open your browser at http://127.0.0.1:8001/redoc for a live documentation")
    yield
    # Deletes the readiness file when the server goes down
    os.unlink("dundee_linker.ready")
    print("clean up lifespan")


app = FastAPI(lifespan=app_lifespan,
              title="dundee_linker",
              summary="This uses University of Dundee's code for linking documents being expressed in AIF",
              contact={
                  "name": "Giacomo Bergami",
                  "url": "https://jackbergus.github.io",
                  "email": "bergamigiacomo@gmail.com",
              },
              license_info={
                  "name": "GPL 3.0",
                  "url": "https://www.gnu.org/licenses/gpl-3.0.txt",
              },
              )

from pydantic import BaseModel


class Item(BaseModel):
    src: str
    dst: str


# @app.on_event("startup")
# async def startup_event():
#     """
#     Generates a file to determine that the service is successfully up and running
#
#     :return:
#     """
#     with open("dundee_linker.ready", "w") as f:
#         f.write("READY")
#
# @app.on_event("shutdown")
# async def shutdown_event():
#     """
#     Deletes the readiness file when the server goes down
#
#     :return:
#     """
#     os.unlink("dundee_linker.ready")

@app.post('/extract_links')
def extract_links(body: Item, request: Request = None):
    """
    Uses Dundee's code for linking two documents expressed in AIF
    :param files:   Files being uploaded
    :param src:     Name of the source file
    :param dst:     Name of the destination file
    :return:        Returns the linking object
    """
    d = dict()
    if ((body.src is None) or (body.src == "null")) or ((body.dst is None) or (body.dst == "null")):
        return None
    d["src"] = body.src
    d["dst"] = body.dst
    return actual_doing(request.query_params["src"], request.query_params["dst"], [d["src"]], [d["dst"]])


if __name__ == "__main__":
    conf = dict()
    try:
        with open("service_linker.yaml", 'r') as stream:
            conf = yaml.safe_load(stream)
    except:
        print("ERROR: unable to correctly parse the configuration file: 'service_miner.yaml'")
        sys.exit(1)
    uvicorn.run("rest_dundee_linker:app", host=conf["serviceIP"], port=int(conf["servicePort"]), workers=1)
