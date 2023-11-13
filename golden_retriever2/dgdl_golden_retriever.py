from services.service import setup_microservice

def golden_retriever(command:str):
    from corpora.no_server import parse_request
    return parse_request(command)

setup_microservice("/home/giacomo/projects/tweetyPrEAF/golden_retriever2/golden_retriever.yaml", golden_retriever)