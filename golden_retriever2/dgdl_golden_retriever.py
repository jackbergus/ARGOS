import json

from linker.routes import actual_doing
from services.service import setup_microservice


def golden_retriever(command:str):
    from corpora.no_server import parse_request
    return parse_request(command)

setup_microservice("service_linker.yaml", golden_retriever)