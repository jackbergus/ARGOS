from tkinter import *
import yaml
from tkinter.ttk import Combobox
import requests
import matplotlib
from matplotlib.figure import Figure
import linker
matplotlib.use('TkAgg')
from matplotlib.backends.backend_tkagg import FigureCanvasTkAgg
import matplotlib.pyplot as plt
import networkx as nx
import numpy as np
# importing networkx
import networkx as nx

# importing matplotlib.pyplot
import matplotlib.pyplot as plt


window=Tk()
cfg = None
with open("config.yaml") as f:
    cfg = yaml.load(f, Loader=yaml.FullLoader)

selectedCorpus = None
selectedDocument = None
lb = None
docs = None

def onselectDocument(evt):
    # Note here that Tkinter passes an event object to onselect()
    try:
        global selectedDocument
        global selectedCorpus
        w = evt.widget
        index = int(w.curselection()[0])
        value = w.get(index)
        selectedDocument = value
        print('You selected document %d: "%s"' % (index, value))
    except:
        pass



Label(window,
		 text="Corpora:",
		 fg = "red").pack()
lb=Listbox(window, height=5)
for num in requests.get(cfg["service"]+"list-corpora").json():
    lb.insert(END,num)

def onselectCorpus(evt):
    # Note here that Tkinter passes an event object to onselect()
    w = evt.widget
    try:
        global selectedDocument
        global selectedCorpus
        index = int(w.curselection()[0])
        value = w.get(index)
        selectedCorpus = value
        print('You selected corpus %d: "%s"' % (index, value))
        selectedDocument = None
        docs.delete(0, END)
        for num in requests.get(cfg["service"] + "list-documents/"+selectedCorpus).json():
            docs.insert(END, num)
    except:
        pass

lb.bind('<<ListboxSelect>>', onselectCorpus)
lb.pack()

Label(window,
		 text="Documents:",
		 fg = "red").pack()
docs=Listbox(window, height=5)
docs.bind('<<ListboxSelect>>', onselectDocument)
docs.pack()

def textCallBack():
    # Create secondary (or popup) window.
    secondary_window = Toplevel()
    global selectedCorpus
    global selectedDocument
    doc = selectedCorpus+":"+selectedDocument
    secondary_window.title(doc)
    secondary_window.config(width=800, height=600)
    T = Text(secondary_window)
    T.insert(END, requests.get(cfg["service"] + "document/"+selectedCorpus+"/"+selectedDocument).text)
    T.pack(fill=BOTH, expand=1)

def storeInDB():
    global selectedCorpus
    global selectedDocument
    doc = selectedCorpus+":"+selectedDocument
    print(doc+" stored: "+ requests.post(cfg["service"] + "load/"+selectedCorpus+"/"+selectedDocument).text)

def callbackGrapp():
    global selectedCorpus
    global selectedDocument
    doc = selectedCorpus+":"+selectedDocument
    secondary_window = generateSubWindow(doc)
    graph_json = requests.get(cfg["service"] + "argument/"+selectedCorpus+"/"+selectedDocument).json()
    graphForPlotting(graph_json, secondary_window)


def graphForPlotting(graph_json, secondary_window):
    G = linker.load_map.CorpusLoader().parse_json(graph_json)
    removed = set(nx.isolates(G))
    G.remove_nodes_from(removed)
    f = plt.figure(figsize=(5, 4))
    plt.axis('off')
    pos = nx.spring_layout(G)  # the layout gives us the nodes position
    node_shapes = dict()
    shape_to_color = {"d": "tab:red", "o": "tab:blue"}
    node_labels = dict()
    for node in graph_json["nodes"]:
        id = int(node["nodeID"])
        if id not in removed:
            shape = "o"
            if ("schemeID" in node and (node["schemeID"] is not None)) or (node["text"] == "YA") or (
                    node["text"] == "TA"):
                shape = "d"
            if shape not in node_shapes:
                node_shapes[shape] = set()
            node_shapes[shape].add(id)
            node_labels[id] = node["text"]
    for shape, nodesDict in node_shapes.items():
        nodes = list(nodesDict)
        nx.draw_networkx_nodes(G, pos, nodes, node_shape=shape, node_color=shape_to_color[shape])
    nx.draw_networkx_labels(G, pos, node_labels)
    nx.draw_networkx_edges(G, pos)
    canvas = FigureCanvasTkAgg(f, master=secondary_window)
    canvas.get_tk_widget().pack(side='bottom', fill='both', expand=1)


def generateSubWindow(doc):
    secondary_window = Toplevel()
    secondary_window.title(doc)
    secondary_window.config(width=800, height=600)
    return secondary_window


stack = []
def pushPair():
    global selectedCorpus
    global selectedDocument
    if (selectedCorpus is not None) and (selectedDocument is not None):
        stack.append(tuple([selectedCorpus, selectedDocument]))

def linkPairs():
    global stack
    start = 0
    end = len(stack)
    step = 2
    ende = 0
    for i in range(start, end, step):
        x = i
        ende = x + step+1
        obj = stack[x:x + step]
        src = obj[0]
        dst = obj[1]
        print(str(src)+"<->"+str(dst) + " stored: " + requests.post(cfg["service"] + "link/" + src[0] + "/" + src[1] + "/" + dst[0]+"/"+dst[1]).text)
    stack = stack[ende:]

def retriveLoaded():
    secondary_window = generateSubWindow("Merged Graphs")
    graph_json = requests.get(cfg["service"] + "joined").json()
    graphForPlotting(graph_json, secondary_window)


B = Button(window, text ="Text", command = textCallBack)
B.pack()
A = Button(window, text ="Argumentation", command = callbackGrapp)
A.pack()
S = Button(window, text ="Store", command = storeInDB)
S.pack()
P = Button(window, text ="Push", command = pushPair)
P.pack()
L = Button(window, text ="Link", command = linkPairs)
L.pack()
R = Button(window, text ="Retrieve", command = retriveLoaded)
R.pack()


window.title('ARGA GUI')
window.geometry("800x600+10+10")
window.mainloop()