import os
from services.all_dgdl_plus import Generaliser

if __name__ == "__main__":
    """
    This program takes as an input the Macro-version of DGDL syntax and expands it into the more convenient
    representation
    """
    g = Generaliser()
    print(g.readFile(os.sys.argv[1], False))