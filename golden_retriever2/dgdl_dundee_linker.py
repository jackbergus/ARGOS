import json

from linker.routes import actual_doing
from services.service import setup_microservice

def golden_linker(command:str):
    d = json.loads(command)
    if ((("src_id" not in d) or (d["src_id"] is None) or (d["src_id"] == "null")) or
            (("dst_id" not in d) or (d["dst_id"] is None) or (d["dst_id"] == "null"))):
        return None
    return json.dumps(actual_doing(d["src_id"], d["dst_id"], [d["src"]], [d["dst"]]), indent=2)

setup_microservice("service_miner.yaml", golden_linker)