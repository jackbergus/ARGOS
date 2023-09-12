from flask import render_template, request, redirect, session, Markup
from . import application
import pandas as pd
from urllib.request import urlopen
import requests
import json
import urllib
import tempfile
import os
import uuid
import nltk
from nltk.tokenize import sent_tokenize
from joblib import load
from app.centrality import Centrality
from app.SentenceSimilarity import SentenceSimilarity
from fuzzywuzzy import fuzz
import spacy
from copy import deepcopy
import glob
import ast
from collections import defaultdict




@application.route('/')
@application.route('/index')
def index():
    return redirect('/home')
@application.route('/home')
def home_render():
    return render_template('home.html')

@application.route('/home', methods=['POST'])
def index_post():
    aif_mode = 'false'
    han_mode = 'false'
    ex_aif_mode = 'false'
    s_date = ''
    external_text = request.form['edata']
    source_text = request.form['sdata']
    aif_mode = request.form['aif_mode']
    ex_aif_mode = request.form['ex_aif_mode']
    han_mode = request.form['han_mode']
    s_date = request.form['date']
    session['s_date'] = s_date
    session['s_text'] = source_text
    session['e_text'] = external_text
    session['aif'] = aif_mode
    session['han'] = han_mode
    session['e_aif'] = ex_aif_mode

    return redirect('/results')


s = """
{
  "nodes": [
    {
      "nodeID": "775927",
      "text": "Tim Stanley : No, that particular term is totally unacceptable",
      "type": "L",
      "timestamp": "2021-11-11 20:57:54"
    },
    {
      "nodeID": "775933",
      "text": "Tim Stanley : The answer is no",
      "type": "L",
      "timestamp": "2021-11-11 20:57:57"
    },
    {
      "nodeID": "775939",
      "text": "AudienceMember 20211111QT22 : Can a racist term ever be defined as banter",
      "type": "L",
      "timestamp": "2021-11-11 20:57:59"
    },
    {
      "nodeID": "798248",
      "text": "Abbie: Fiona Bruce : I'm going to explain what the term is",
      "type": "L",
      "timestamp": "2022-01-06 10:38:45"
    },
    {
      "nodeID": "1027382",
      "text": "If the government look at it holistically",
      "type": "L",
      "timestamp": "2022-07-11 10:09:46"
    },
    {
      "nodeID": "1027383",
      "text": "Xiyuan: Paul Polman : If the government look at it holistically",
      "type": "L",
      "timestamp": "2022-07-11 10:09:47"
    },
    {
      "nodeID": "1027384",
      "text": "Paul Polman : If the government look at it holistically, 90 or 100 percent of these can be solved",
      "type": "L",
      "timestamp": "2022-07-11 10:09:48"
    },
    {
      "nodeID": "1027385",
      "text": "Asserting",
      "type": "YA",
      "timestamp": "2022-07-11 10:09:48",
      "scheme": "Asserting",
      "schemeID": "74"
    },
    {
      "nodeID": "1027386",
      "text": "if the government look at the energy issue holistically, 90 or 100 percent of these can be solved",
      "type": "I",
      "timestamp": "2022-07-11 10:09:49"
    },
    {
      "nodeID": "1027387",
      "text": "Xiyuan: Paul Polman : If the government look at it holistically, 90 or 100 percent of these can be solved",
      "type": "L",
      "timestamp": "2022-07-11 10:09:50"
    },
    {
      "nodeID": "1027388",
      "text": "Paul Polman : It is the same for business",
      "type": "L",
      "timestamp": "2022-07-11 10:09:51"
    },
    {
      "nodeID": "1027389",
      "text": "Asserting",
      "type": "YA",
      "timestamp": "2022-07-11 10:09:51",
      "scheme": "Asserting",
      "schemeID": "74"
    },
    {
      "nodeID": "1027390",
      "text": "it is the same for business",
      "type": "I",
      "timestamp": "2022-07-11 10:09:51"
    },
    {
      "nodeID": "1027391",
      "text": "Xiyuan: Paul Polman : It is the same for business",
      "type": "L",
      "timestamp": "2022-07-11 10:09:52"
    },
    {
      "nodeID": "1027392",
      "text": "Default Transition",
      "type": "TA",
      "timestamp": "2022-07-11 10:09:52",
      "scheme": "Default Transition",
      "schemeID": "82"
    },
    {
      "nodeID": "1027393",
      "text": "Paul Polman : We should stop competing with each other on the future of humanity, include in politics",
      "type": "L",
      "timestamp": "2022-07-11 10:09:53"
    },
    {
      "nodeID": "1027394",
      "text": "Asserting",
      "type": "YA",
      "timestamp": "2022-07-11 10:09:53",
      "scheme": "Asserting",
      "schemeID": "74"
    },
    {
      "nodeID": "1027395",
      "text": "we should stop competing with each other on the future of humanity, including in politics",
      "type": "I",
      "timestamp": "2022-07-11 10:09:53"
    },
    {
      "nodeID": "1027396",
      "text": "Xiyuan: Paul Polman : We should stop competing with each other on the future of humanity, include in politics",
      "type": "L",
      "timestamp": "2022-07-11 10:09:54"
    },
    {
      "nodeID": "1027397",
      "text": "Paul Polman : start working together like adults on these things for the benefit of mankind",
      "type": "L",
      "timestamp": "2022-07-11 10:09:55"
    },
    {
      "nodeID": "1027398",
      "text": "Asserting",
      "type": "YA",
      "timestamp": "2022-07-11 10:09:55",
      "scheme": "Asserting",
      "schemeID": "74"
    },
    {
      "nodeID": "1027399",
      "text": "we should start working together like adults on these things for the benefit of mankind",
      "type": "I",
      "timestamp": "2022-07-11 10:09:56"
    },
    {
      "nodeID": "1027400",
      "text": "Xiyuan: Paul Polman : start working together like adults on these things for the benefit of mankind",
      "type": "L",
      "timestamp": "2022-07-11 10:09:56"
    },
    {
      "nodeID": "1027401",
      "text": "Default Inference",
      "type": "RA",
      "timestamp": "2022-07-11 10:09:56",
      "scheme": "Default Inference",
      "schemeID": "72"
    },
    {
      "nodeID": "1027402",
      "text": "Default Transition",
      "type": "TA",
      "timestamp": "2022-07-11 10:09:56",
      "scheme": "Default Transition",
      "schemeID": "82"
    },
    {
      "nodeID": "1027403",
      "text": "Default Inference",
      "type": "RA",
      "timestamp": "2022-07-11 10:09:56",
      "scheme": "Default Inference",
      "schemeID": "72"
    },
    {
      "nodeID": "1027404",
      "text": "Default Transition",
      "type": "TA",
      "timestamp": "2022-07-11 10:09:56",
      "scheme": "Default Transition",
      "schemeID": "82"
    },
    {
      "nodeID": "1027405",
      "text": "Arguing",
      "type": "YA",
      "timestamp": "2022-07-11 10:09:56",
      "scheme": "Arguing",
      "schemeID": "80"
    },
    {
      "nodeID": "1027406",
      "text": "Default Transition",
      "type": "TA",
      "timestamp": "2022-07-11 10:09:56",
      "scheme": "Default Transition",
      "schemeID": "82"
    },
    {
      "nodeID": "1027407",
      "text": "Default Transition",
      "type": "TA",
      "timestamp": "2022-07-11 10:09:56",
      "scheme": "Default Transition",
      "schemeID": "82"
    },
    {
      "nodeID": "1027408",
      "text": "Arguing",
      "type": "YA",
      "timestamp": "2022-07-11 10:09:56",
      "scheme": "Arguing",
      "schemeID": "80"
    },
    {
      "nodeID": "1027409",
      "text": "Paul Polman : We have the technology",
      "type": "L",
      "timestamp": "2022-07-11 10:09:57"
    },
    {
      "nodeID": "1027410",
      "text": "Asserting",
      "type": "YA",
      "timestamp": "2022-07-11 10:09:57",
      "scheme": "Asserting",
      "schemeID": "74"
    },
    {
      "nodeID": "1027411",
      "text": "we have the technology",
      "type": "I",
      "timestamp": "2022-07-11 10:09:58"
    },
    {
      "nodeID": "1027412",
      "text": "Xiyuan: Paul Polman : We have the technology",
      "type": "L",
      "timestamp": "2022-07-11 10:09:59"
    },
    {
      "nodeID": "1027413",
      "text": "Paul Polman : We know what we have to do, and we don't have time",
      "type": "L",
      "timestamp": "2022-07-11 10:09:59"
    },
    {
      "nodeID": "1027414",
      "text": "Asserting",
      "type": "YA",
      "timestamp": "2022-07-11 10:09:59",
      "scheme": "Asserting",
      "schemeID": "74"
    },
    {
      "nodeID": "1027415",
      "text": "we know what we have to do, and we don't have time",
      "type": "I",
      "timestamp": "2022-07-11 10:10:00"
    },
    {
      "nodeID": "1027416",
      "text": "Xiyuan: Paul Polman : We know what we have to do, and we don't have time",
      "type": "L",
      "timestamp": "2022-07-11 10:10:01"
    },
    {
      "nodeID": "1027417",
      "text": "Fiona Bruce : We could talk about climate change all evening",
      "type": "L",
      "timestamp": "2022-07-11 10:10:02"
    },
    {
      "nodeID": "1027418",
      "text": "Asserting",
      "type": "YA",
      "timestamp": "2022-07-11 10:10:02",
      "scheme": "Asserting",
      "schemeID": "74"
    },
    {
      "nodeID": "1027419",
      "text": "we could talk about climate change all evening",
      "type": "I",
      "timestamp": "2022-07-11 10:10:03"
    },
    {
      "nodeID": "1027420",
      "text": "Xiyuan: Fiona Bruce : We could talk about climate change all evening",
      "type": "L",
      "timestamp": "2022-07-11 10:10:04"
    },
    {
      "nodeID": "1027421",
      "text": "Fiona Bruce : it is a massive topic, hugely important",
      "type": "L",
      "timestamp": "2022-07-11 10:10:04"
    },
    {
      "nodeID": "1027422",
      "text": "Asserting",
      "type": "YA",
      "timestamp": "2022-07-11 10:10:04",
      "scheme": "Asserting",
      "schemeID": "74"
    },
    {
      "nodeID": "1027423",
      "text": "climate change is a massive topic, hugely important",
      "type": "I",
      "timestamp": "2022-07-11 10:10:05"
    },
    {
      "nodeID": "1027424",
      "text": "Xiyuan: Fiona Bruce : it is a massive topic, hugely important",
      "type": "L",
      "timestamp": "2022-07-11 10:10:06"
    },
    {
      "nodeID": "1027425",
      "text": "Default Inference",
      "type": "RA",
      "timestamp": "2022-07-11 10:10:06",
      "scheme": "Default Inference",
      "schemeID": "72"
    },
    {
      "nodeID": "1027426",
      "text": "Default Transition",
      "type": "TA",
      "timestamp": "2022-07-11 10:10:06",
      "scheme": "Default Transition",
      "schemeID": "82"
    },
    {
      "nodeID": "1027427",
      "text": "Arguing",
      "type": "YA",
      "timestamp": "2022-07-11 10:10:06",
      "scheme": "Arguing",
      "schemeID": "80"
    },
    {
      "nodeID": "1027428",
      "text": "Xiyuan: Fiona Bruce : There's another question a lot of you submitted this evening",
      "type": "L",
      "timestamp": "2022-07-11 10:10:07"
    },
    {
      "nodeID": "1027429",
      "text": "Xiyuan: Fiona Bruce : I'm going to move on",
      "type": "L",
      "timestamp": "2022-07-11 10:10:08"
    },
    {
      "nodeID": "1027430",
      "text": "Xiyuan: Fiona Bruce : Can a racist term ever be defined as banter",
      "type": "L",
      "timestamp": "2022-07-11 10:10:08"
    },
    {
      "nodeID": "1027431",
      "text": "Xiyuan: Fiona Bruce : I'm just picking one of them.",
      "type": "L",
      "timestamp": "2022-07-11 10:10:09"
    },
    {
      "nodeID": "1027432",
      "text": "Pure Questioning",
      "type": "YA",
      "timestamp": "2022-07-11 10:10:10",
      "scheme": "PureQuestioning",
      "schemeID": "91"
    },
    {
      "nodeID": "1027433",
      "text": "a racist term can or can not ever be defined as banter",
      "type": "I",
      "timestamp": "2022-07-11 10:10:11"
    },
    {
      "nodeID": "1027434",
      "text": "Xiyuan: AudienceMember 20211111QT22 : Can a racist term ever be defined as banter",
      "type": "L",
      "timestamp": "2022-07-11 10:10:11"
    },
    {
      "nodeID": "1027435",
      "text": "Xiyuan: Fiona Bruce : What you are talking about here is the furore there's been over Azeem Rafiq who claims he was subjected to institutional racism at his club, and he clearly feels that this has not been handled properly and Yorkshire has carried out its own investigation, ruled no disciplinary action would take place, called it banter",
      "type": "L",
      "timestamp": "2022-07-11 10:10:12"
    },
    {
      "nodeID": "1027436",
      "text": "Fiona Bruce : the furore there's been over Azeem Rafiq who claims he was subjected to institutional racism at his club, and he clearly feels that this has not been handled properly",
      "type": "L",
      "timestamp": "2022-07-11 10:10:13"
    },
    {
      "nodeID": "1027437",
      "text": "Asserting",
      "type": "YA",
      "timestamp": "2022-07-11 10:10:13",
      "scheme": "Asserting",
      "schemeID": "74"
    },
    {
      "nodeID": "1027438",
      "text": "Azeem Rafiq who claims he was subjected to institutional racism at his club, and he clearly feels that this has not been handled properly",
      "type": "I",
      "timestamp": "2022-07-11 10:10:14"
    },
    {
      "nodeID": "1027439",
      "text": "Xiyuan: Fiona Bruce : the furore there's been over Azeem Rafiq who claims he was subjected to institutional racism at his club, and he clearly feels that this has not been handled properly",
      "type": "L",
      "timestamp": "2022-07-11 10:10:14"
    },
    {
      "nodeID": "1027440",
      "text": "Fiona Bruce : Yorkshire has carried out its own investigation, ruled no disciplinary action would take place, called it banter",
      "type": "L",
      "timestamp": "2022-07-11 10:10:15"
    },
    {
      "nodeID": "1027441",
      "text": "Asserting",
      "type": "YA",
      "timestamp": "2022-07-11 10:10:15",
      "scheme": "Asserting",
      "schemeID": "74"
    },
    {
      "nodeID": "1027442",
      "text": "Yorkshire has carried out its own investigation, ruled no disciplinary action would take place, called it banter",
      "type": "I",
      "timestamp": "2022-07-11 10:10:16"
    },
    {
      "nodeID": "1027443",
      "text": "Xiyuan: Fiona Bruce : Yorkshire has carried out its own investigation, ruled no disciplinary action would take place, called it banter",
      "type": "L",
      "timestamp": "2022-07-11 10:10:17"
    },
    {
      "nodeID": "1027444",
      "text": "Default Rephrase",
      "type": "MA",
      "timestamp": "2022-07-11 10:10:17",
      "scheme": "Default Rephrase",
      "schemeID": "144"
    },
    {
      "nodeID": "1027445",
      "text": "Default Transition",
      "type": "TA",
      "timestamp": "2022-07-11 10:10:17",
      "scheme": "Default Transition",
      "schemeID": "82"
    },
    {
      "nodeID": "1027446",
      "text": "Default Rephrase",
      "type": "MA",
      "timestamp": "2022-07-11 10:10:17",
      "scheme": "Default Rephrase",
      "schemeID": "144"
    },
    {
      "nodeID": "1027447",
      "text": "Default Transition",
      "type": "TA",
      "timestamp": "2022-07-11 10:10:17",
      "scheme": "Default Transition",
      "schemeID": "82"
    },
    {
      "nodeID": "1027448",
      "text": "Restating",
      "type": "YA",
      "timestamp": "2022-07-11 10:10:17",
      "scheme": "Restating",
      "schemeID": "101"
    },
    {
      "nodeID": "1027449",
      "text": "Restating",
      "type": "YA",
      "timestamp": "2022-07-11 10:10:17",
      "scheme": "Restating",
      "schemeID": "101"
    },
    {
      "nodeID": "1027450",
      "text": "Asserting",
      "type": "YA",
      "timestamp": "2022-07-11 10:10:17",
      "scheme": "Asserting",
      "schemeID": "74"
    },
    {
      "nodeID": "1027451",
      "text": "a racist term can not ever be defined as banter",
      "type": "I",
      "timestamp": "2022-07-11 10:10:18"
    },
    {
      "nodeID": "1027452",
      "text": "Xiyuan: Tim Stanley : The answer is no",
      "type": "L",
      "timestamp": "2022-07-11 10:10:19"
    },
    {
      "nodeID": "1027453",
      "text": "Default Transition",
      "type": "TA",
      "timestamp": "2022-07-11 10:10:19",
      "scheme": "Default Transition",
      "schemeID": "82"
    },
    {
      "nodeID": "1027454",
      "text": "Default Rephrase",
      "type": "MA",
      "timestamp": "2022-07-11 10:10:19",
      "scheme": "Default Rephrase",
      "schemeID": "144"
    },
    {
      "nodeID": "1027455",
      "text": "Default Transition",
      "type": "TA",
      "timestamp": "2022-07-11 10:10:19",
      "scheme": "Default Transition",
      "schemeID": "82"
    },
    {
      "nodeID": "1027456",
      "text": "Default Illocuting",
      "type": "YA",
      "timestamp": "2022-07-11 10:10:19",
      "scheme": "Default Illocuting",
      "schemeID": "168"
    },
    {
      "nodeID": "1027457",
      "text": "Tim Stanley : There's nothing else to say",
      "type": "L",
      "timestamp": "2022-07-11 10:10:20"
    },
    {
      "nodeID": "1027458",
      "text": "Asserting",
      "type": "YA",
      "timestamp": "2022-07-11 10:10:20",
      "scheme": "Asserting",
      "schemeID": "74"
    },
    {
      "nodeID": "1027459",
      "text": "there's nothing else to say",
      "type": "I",
      "timestamp": "2022-07-11 10:10:20"
    },
    {
      "nodeID": "1027460",
      "text": "Xiyuan: Tim Stanley : There's nothing else to say",
      "type": "L",
      "timestamp": "2022-07-11 10:10:21"
    },
    {
      "nodeID": "1027461",
      "text": "Default Transition",
      "type": "TA",
      "timestamp": "2022-07-11 10:10:21",
      "scheme": "Default Transition",
      "schemeID": "82"
    },
    {
      "nodeID": "1027462",
      "text": "Tim Stanley : I don't see how the club can explain its decision to not take further action other than, I suppose, hypothetically, perhaps, there was a reluctance to do something that might damage the career of a star player",
      "type": "L",
      "timestamp": "2022-07-11 10:10:22"
    },
    {
      "nodeID": "1027463",
      "text": "Asserting",
      "type": "YA",
      "timestamp": "2022-07-11 10:10:22",
      "scheme": "Asserting",
      "schemeID": "74"
    },
    {
      "nodeID": "1027464",
      "text": "Tim Stanley does not see how the club can explain its decision to not take further action other than, there was a reluctance to do something that might damage the career of a star player",
      "type": "I",
      "timestamp": "2022-07-11 10:10:22"
    },
    {
      "nodeID": "1027465",
      "text": "Xiyuan: Tim Stanley : I don't see how the club can explain its decision to not take further action other than, I suppose, hypothetically, perhaps, there was a reluctance to do something that might damage the career of a star player",
      "type": "L",
      "timestamp": "2022-07-11 10:10:23"
    },
    {
      "nodeID": "1027466",
      "text": "Default Transition",
      "type": "TA",
      "timestamp": "2022-07-11 10:10:23",
      "scheme": "Default Transition",
      "schemeID": "82"
    },
    {
      "nodeID": "1027467",
      "text": "Tim Stanley : I don't know",
      "type": "L",
      "timestamp": "2022-07-11 10:10:24"
    },
    {
      "nodeID": "1027468",
      "text": "Asserting",
      "type": "YA",
      "timestamp": "2022-07-11 10:10:24",
      "scheme": "Asserting",
      "schemeID": "74"
    },
    {
      "nodeID": "1027469",
      "text": "Tim Stanley does not know if there was a reluctance to do something that might damage the career of a star player",
      "type": "I",
      "timestamp": "2022-07-11 10:10:25"
    },
    {
      "nodeID": "1027470",
      "text": "Xiyuan: Tim Stanley : I don't know",
      "type": "L",
      "timestamp": "2022-07-11 10:10:26"
    },
    {
      "nodeID": "1027471",
      "text": "Default Rephrase",
      "type": "MA",
      "timestamp": "2022-07-11 10:10:26",
      "scheme": "Default Rephrase",
      "schemeID": "144"
    },
    {
      "nodeID": "1027472",
      "text": "Default Transition",
      "type": "TA",
      "timestamp": "2022-07-11 10:10:26",
      "scheme": "Default Transition",
      "schemeID": "82"
    },
    {
      "nodeID": "1027473",
      "text": "Restating",
      "type": "YA",
      "timestamp": "2022-07-11 10:10:26",
      "scheme": "Restating",
      "schemeID": "101"
    },
    {
      "nodeID": "1027474",
      "text": "Tim Stanley : that's purely speculative",
      "type": "L",
      "timestamp": "2022-07-11 10:10:26"
    },
    {
      "nodeID": "1027475",
      "text": "Asserting",
      "type": "YA",
      "timestamp": "2022-07-11 10:10:26",
      "scheme": "Asserting",
      "schemeID": "74"
    },
    {
      "nodeID": "1027476",
      "text": "that's purely speculative that there was a reluctance to do something that might damage the career of a star player",
      "type": "I",
      "timestamp": "2022-07-11 10:10:27"
    },
    {
      "nodeID": "1027477",
      "text": "Xiyuan: Tim Stanley : that's purely speculative",
      "type": "L",
      "timestamp": "2022-07-11 10:10:28"
    },
    {
      "nodeID": "1027478",
      "text": "Default Rephrase",
      "type": "MA",
      "timestamp": "2022-07-11 10:10:28",
      "scheme": "Default Rephrase",
      "schemeID": "144"
    },
    {
      "nodeID": "1027479",
      "text": "Default Transition",
      "type": "TA",
      "timestamp": "2022-07-11 10:10:28",
      "scheme": "Default Transition",
      "schemeID": "82"
    },
    {
      "nodeID": "1027480",
      "text": "Restating",
      "type": "YA",
      "timestamp": "2022-07-11 10:10:28",
      "scheme": "Restating",
      "schemeID": "101"
    },
    {
      "nodeID": "1027481",
      "text": "Asserting",
      "type": "YA",
      "timestamp": "2022-07-11 10:10:29",
      "scheme": "Asserting",
      "schemeID": "74"
    },
    {
      "nodeID": "1027482",
      "text": "no, that particular term is totally unacceptable",
      "type": "I",
      "timestamp": "2022-07-11 10:10:29"
    },
    {
      "nodeID": "1027483",
      "text": "Xiyuan: Tim Stanley : No, that particular term is totally unacceptable",
      "type": "L",
      "timestamp": "2022-07-11 10:10:30"
    },
    {
      "nodeID": "1027484",
      "text": "Default Transition",
      "type": "TA",
      "timestamp": "2022-07-11 10:10:30",
      "scheme": "Default Transition",
      "schemeID": "82"
    },
    {
      "nodeID": "1027485",
      "text": "Default Rephrase",
      "type": "MA",
      "timestamp": "2022-07-11 10:10:30",
      "scheme": "Default Rephrase",
      "schemeID": "144"
    },
    {
      "nodeID": "1027486",
      "text": "Default Transition",
      "type": "TA",
      "timestamp": "2022-07-11 10:10:30",
      "scheme": "Default Transition",
      "schemeID": "82"
    },
    {
      "nodeID": "1027487",
      "text": "Restating",
      "type": "YA",
      "timestamp": "2022-07-11 10:10:30",
      "scheme": "Restating",
      "schemeID": "101"
    },
    {
      "nodeID": "1027488",
      "text": "Default Transition",
      "type": "TA",
      "timestamp": "2022-07-11 10:10:30",
      "scheme": "Default Transition",
      "schemeID": "82"
    },
    {
      "nodeID": "1027489",
      "text": "Default Transition",
      "type": "TA",
      "timestamp": "2022-07-11 10:10:30",
      "scheme": "Default Transition",
      "schemeID": "82"
    },
    {
      "nodeID": "1027490",
      "text": "Default Transition",
      "type": "TA",
      "timestamp": "2022-07-11 10:10:30",
      "scheme": "Default Transition",
      "schemeID": "82"
    },
    {
      "nodeID": "1027491",
      "text": "Default Transition",
      "type": "TA",
      "timestamp": "2022-07-11 10:10:30",
      "scheme": "Default Transition",
      "schemeID": "82"
    }
  ],
  "edges": [
    {
      "edgeID": "1359298",
      "fromID": "1027385",
      "toID": "1027386",
      "formEdgeID": null
    },
    {
      "edgeID": "1359299",
      "fromID": "1027384",
      "toID": "1027385",
      "formEdgeID": null
    },
    {
      "edgeID": "1359300",
      "fromID": "1027389",
      "toID": "1027390",
      "formEdgeID": null
    },
    {
      "edgeID": "1359301",
      "fromID": "1027388",
      "toID": "1027389",
      "formEdgeID": null
    },
    {
      "edgeID": "1359302",
      "fromID": "1027384",
      "toID": "1027392",
      "formEdgeID": null
    },
    {
      "edgeID": "1359303",
      "fromID": "1027392",
      "toID": "1027388",
      "formEdgeID": null
    },
    {
      "edgeID": "1359304",
      "fromID": "1027394",
      "toID": "1027395",
      "formEdgeID": null
    },
    {
      "edgeID": "1359305",
      "fromID": "1027393",
      "toID": "1027394",
      "formEdgeID": null
    },
    {
      "edgeID": "1359306",
      "fromID": "1027398",
      "toID": "1027399",
      "formEdgeID": null
    },
    {
      "edgeID": "1359307",
      "fromID": "1027397",
      "toID": "1027398",
      "formEdgeID": null
    },
    {
      "edgeID": "1359308",
      "fromID": "1027386",
      "toID": "1027401",
      "formEdgeID": null
    },
    {
      "edgeID": "1359309",
      "fromID": "1027401",
      "toID": "1027395",
      "formEdgeID": null
    },
    {
      "edgeID": "1359310",
      "fromID": "1027384",
      "toID": "1027402",
      "formEdgeID": null
    },
    {
      "edgeID": "1359311",
      "fromID": "1027402",
      "toID": "1027393",
      "formEdgeID": null
    },
    {
      "edgeID": "1359312",
      "fromID": "1027386",
      "toID": "1027403",
      "formEdgeID": null
    },
    {
      "edgeID": "1359313",
      "fromID": "1027403",
      "toID": "1027399",
      "formEdgeID": null
    },
    {
      "edgeID": "1359314",
      "fromID": "1027384",
      "toID": "1027404",
      "formEdgeID": null
    },
    {
      "edgeID": "1359315",
      "fromID": "1027404",
      "toID": "1027397",
      "formEdgeID": null
    },
    {
      "edgeID": "1359316",
      "fromID": "1027402",
      "toID": "1027405",
      "formEdgeID": null
    },
    {
      "edgeID": "1359317",
      "fromID": "1027405",
      "toID": "1027401",
      "formEdgeID": null
    },
    {
      "edgeID": "1359318",
      "fromID": "1027390",
      "toID": "1027401",
      "formEdgeID": null
    },
    {
      "edgeID": "1359319",
      "fromID": "1027390",
      "toID": "1027403",
      "formEdgeID": null
    },
    {
      "edgeID": "1359320",
      "fromID": "1027388",
      "toID": "1027406",
      "formEdgeID": null
    },
    {
      "edgeID": "1359321",
      "fromID": "1027406",
      "toID": "1027393",
      "formEdgeID": null
    },
    {
      "edgeID": "1359322",
      "fromID": "1027393",
      "toID": "1027407",
      "formEdgeID": null
    },
    {
      "edgeID": "1359323",
      "fromID": "1027407",
      "toID": "1027397",
      "formEdgeID": null
    },
    {
      "edgeID": "1359324",
      "fromID": "1027404",
      "toID": "1027408",
      "formEdgeID": null
    },
    {
      "edgeID": "1359325",
      "fromID": "1027408",
      "toID": "1027403",
      "formEdgeID": null
    },
    {
      "edgeID": "1359326",
      "fromID": "1027410",
      "toID": "1027411",
      "formEdgeID": null
    },
    {
      "edgeID": "1359327",
      "fromID": "1027409",
      "toID": "1027410",
      "formEdgeID": null
    },
    {
      "edgeID": "1359328",
      "fromID": "1027414",
      "toID": "1027415",
      "formEdgeID": null
    },
    {
      "edgeID": "1359329",
      "fromID": "1027413",
      "toID": "1027414",
      "formEdgeID": null
    },
    {
      "edgeID": "1359330",
      "fromID": "1027418",
      "toID": "1027419",
      "formEdgeID": null
    },
    {
      "edgeID": "1359331",
      "fromID": "1027417",
      "toID": "1027418",
      "formEdgeID": null
    },
    {
      "edgeID": "1359332",
      "fromID": "1027422",
      "toID": "1027423",
      "formEdgeID": null
    },
    {
      "edgeID": "1359333",
      "fromID": "1027421",
      "toID": "1027422",
      "formEdgeID": null
    },
    {
      "edgeID": "1359334",
      "fromID": "1027423",
      "toID": "1027425",
      "formEdgeID": null
    },
    {
      "edgeID": "1359335",
      "fromID": "1027425",
      "toID": "1027419",
      "formEdgeID": null
    },
    {
      "edgeID": "1359336",
      "fromID": "1027417",
      "toID": "1027426",
      "formEdgeID": null
    },
    {
      "edgeID": "1359337",
      "fromID": "1027426",
      "toID": "1027421",
      "formEdgeID": null
    },
    {
      "edgeID": "1359338",
      "fromID": "1027426",
      "toID": "1027427",
      "formEdgeID": null
    },
    {
      "edgeID": "1359339",
      "fromID": "1027427",
      "toID": "1027425",
      "formEdgeID": null
    },
    {
      "edgeID": "1359340",
      "fromID": "1027432",
      "toID": "1027433",
      "formEdgeID": null
    },
    {
      "edgeID": "1359341",
      "fromID": "775939",
      "toID": "1027432",
      "formEdgeID": null
    },
    {
      "edgeID": "1359342",
      "fromID": "1027437",
      "toID": "1027438",
      "formEdgeID": null
    },
    {
      "edgeID": "1359343",
      "fromID": "1027436",
      "toID": "1027437",
      "formEdgeID": null
    },
    {
      "edgeID": "1359344",
      "fromID": "1027441",
      "toID": "1027442",
      "formEdgeID": null
    },
    {
      "edgeID": "1359345",
      "fromID": "1027440",
      "toID": "1027441",
      "formEdgeID": null
    },
    {
      "edgeID": "1359346",
      "fromID": "1027438",
      "toID": "1027444",
      "formEdgeID": null
    },
    {
      "edgeID": "1359347",
      "fromID": "1027444",
      "toID": "1027433",
      "formEdgeID": null
    },
    {
      "edgeID": "1359348",
      "fromID": "775939",
      "toID": "1027445",
      "formEdgeID": null
    },
    {
      "edgeID": "1359349",
      "fromID": "1027445",
      "toID": "1027436",
      "formEdgeID": null
    },
    {
      "edgeID": "1359350",
      "fromID": "1027442",
      "toID": "1027446",
      "formEdgeID": null
    },
    {
      "edgeID": "1359351",
      "fromID": "1027446",
      "toID": "1027433",
      "formEdgeID": null
    },
    {
      "edgeID": "1359352",
      "fromID": "775939",
      "toID": "1027447",
      "formEdgeID": null
    },
    {
      "edgeID": "1359353",
      "fromID": "1027447",
      "toID": "1027440",
      "formEdgeID": null
    },
    {
      "edgeID": "1359354",
      "fromID": "1027447",
      "toID": "1027448",
      "formEdgeID": null
    },
    {
      "edgeID": "1359355",
      "fromID": "1027448",
      "toID": "1027446",
      "formEdgeID": null
    },
    {
      "edgeID": "1359356",
      "fromID": "1027445",
      "toID": "1027449",
      "formEdgeID": null
    },
    {
      "edgeID": "1359357",
      "fromID": "1027449",
      "toID": "1027444",
      "formEdgeID": null
    },
    {
      "edgeID": "1359358",
      "fromID": "1027450",
      "toID": "1027451",
      "formEdgeID": null
    },
    {
      "edgeID": "1359359",
      "fromID": "775933",
      "toID": "1027450",
      "formEdgeID": null
    },
    {
      "edgeID": "1359360",
      "fromID": "1027440",
      "toID": "1027453",
      "formEdgeID": null
    },
    {
      "edgeID": "1359361",
      "fromID": "1027453",
      "toID": "775933",
      "formEdgeID": null
    },
    {
      "edgeID": "1359362",
      "fromID": "1027451",
      "toID": "1027454",
      "formEdgeID": null
    },
    {
      "edgeID": "1359363",
      "fromID": "1027454",
      "toID": "1027433",
      "formEdgeID": null
    },
    {
      "edgeID": "1359364",
      "fromID": "775939",
      "toID": "1027455",
      "formEdgeID": null
    },
    {
      "edgeID": "1359365",
      "fromID": "1027455",
      "toID": "775933",
      "formEdgeID": null
    },
    {
      "edgeID": "1359366",
      "fromID": "1027455",
      "toID": "1027456",
      "formEdgeID": null
    },
    {
      "edgeID": "1359367",
      "fromID": "1027456",
      "toID": "1027454",
      "formEdgeID": null
    },
    {
      "edgeID": "1359368",
      "fromID": "1027458",
      "toID": "1027459",
      "formEdgeID": null
    },
    {
      "edgeID": "1359369",
      "fromID": "1027457",
      "toID": "1027458",
      "formEdgeID": null
    },
    {
      "edgeID": "1359370",
      "fromID": "775933",
      "toID": "1027461",
      "formEdgeID": null
    },
    {
      "edgeID": "1359371",
      "fromID": "1027461",
      "toID": "1027457",
      "formEdgeID": null
    },
    {
      "edgeID": "1359372",
      "fromID": "1027463",
      "toID": "1027464",
      "formEdgeID": null
    },
    {
      "edgeID": "1359373",
      "fromID": "1027462",
      "toID": "1027463",
      "formEdgeID": null
    },
    {
      "edgeID": "1359374",
      "fromID": "1027457",
      "toID": "1027466",
      "formEdgeID": null
    },
    {
      "edgeID": "1359375",
      "fromID": "1027466",
      "toID": "1027462",
      "formEdgeID": null
    },
    {
      "edgeID": "1359376",
      "fromID": "1027468",
      "toID": "1027469",
      "formEdgeID": null
    },
    {
      "edgeID": "1359377",
      "fromID": "1027467",
      "toID": "1027468",
      "formEdgeID": null
    },
    {
      "edgeID": "1359378",
      "fromID": "1027469",
      "toID": "1027471",
      "formEdgeID": null
    },
    {
      "edgeID": "1359379",
      "fromID": "1027471",
      "toID": "1027464",
      "formEdgeID": null
    },
    {
      "edgeID": "1359380",
      "fromID": "1027462",
      "toID": "1027472",
      "formEdgeID": null
    },
    {
      "edgeID": "1359381",
      "fromID": "1027472",
      "toID": "1027467",
      "formEdgeID": null
    },
    {
      "edgeID": "1359382",
      "fromID": "1027472",
      "toID": "1027473",
      "formEdgeID": null
    },
    {
      "edgeID": "1359383",
      "fromID": "1027473",
      "toID": "1027471",
      "formEdgeID": null
    },
    {
      "edgeID": "1359384",
      "fromID": "1027475",
      "toID": "1027476",
      "formEdgeID": null
    },
    {
      "edgeID": "1359385",
      "fromID": "1027474",
      "toID": "1027475",
      "formEdgeID": null
    },
    {
      "edgeID": "1359386",
      "fromID": "1027476",
      "toID": "1027478",
      "formEdgeID": null
    },
    {
      "edgeID": "1359387",
      "fromID": "1027478",
      "toID": "1027469",
      "formEdgeID": null
    },
    {
      "edgeID": "1359388",
      "fromID": "1027467",
      "toID": "1027479",
      "formEdgeID": null
    },
    {
      "edgeID": "1359389",
      "fromID": "1027479",
      "toID": "1027474",
      "formEdgeID": null
    },
    {
      "edgeID": "1359390",
      "fromID": "1027479",
      "toID": "1027480",
      "formEdgeID": null
    },
    {
      "edgeID": "1359391",
      "fromID": "1027480",
      "toID": "1027478",
      "formEdgeID": null
    },
    {
      "edgeID": "1359392",
      "fromID": "1027481",
      "toID": "1027482",
      "formEdgeID": null
    },
    {
      "edgeID": "1359393",
      "fromID": "775927",
      "toID": "1027481",
      "formEdgeID": null
    },
    {
      "edgeID": "1359394",
      "fromID": "1027474",
      "toID": "1027484",
      "formEdgeID": null
    },
    {
      "edgeID": "1359395",
      "fromID": "1027484",
      "toID": "775927",
      "formEdgeID": null
    },
    {
      "edgeID": "1359396",
      "fromID": "1027482",
      "toID": "1027485",
      "formEdgeID": null
    },
    {
      "edgeID": "1359397",
      "fromID": "1027485",
      "toID": "1027451",
      "formEdgeID": null
    },
    {
      "edgeID": "1359398",
      "fromID": "775927",
      "toID": "1027486",
      "formEdgeID": null
    },
    {
      "edgeID": "1359399",
      "fromID": "1027486",
      "toID": "775933",
      "formEdgeID": null
    },
    {
      "edgeID": "1359400",
      "fromID": "1027486",
      "toID": "1027487",
      "formEdgeID": null
    },
    {
      "edgeID": "1359401",
      "fromID": "1027487",
      "toID": "1027485",
      "formEdgeID": null
    },
    {
      "edgeID": "1359402",
      "fromID": "1027397",
      "toID": "1027488",
      "formEdgeID": null
    },
    {
      "edgeID": "1359403",
      "fromID": "1027488",
      "toID": "1027409",
      "formEdgeID": null
    },
    {
      "edgeID": "1359404",
      "fromID": "1027409",
      "toID": "1027489",
      "formEdgeID": null
    },
    {
      "edgeID": "1359405",
      "fromID": "1027489",
      "toID": "1027413",
      "formEdgeID": null
    },
    {
      "edgeID": "1359406",
      "fromID": "1027413",
      "toID": "1027490",
      "formEdgeID": null
    },
    {
      "edgeID": "1359407",
      "fromID": "1027490",
      "toID": "1027417",
      "formEdgeID": null
    },
    {
      "edgeID": "1359408",
      "fromID": "1027421",
      "toID": "1027491",
      "formEdgeID": null
    },
    {
      "edgeID": "1359409",
      "fromID": "1027491",
      "toID": "775939",
      "formEdgeID": null
    }
  ],
  "locutions": [
    {
      "nodeID": "1027384",
      "personID": "5636",
      "timestamp": "2022-07-11 10:10:30",
      "start": "2020-10-15 23:49:22",
      "end": null,
      "source": null
    },
    {
      "nodeID": "1027388",
      "personID": "5636",
      "timestamp": "2022-07-11 10:10:30",
      "start": "2020-10-15 23:49:28",
      "end": null,
      "source": null
    },
    {
      "nodeID": "1027393",
      "personID": "5636",
      "timestamp": "2022-07-11 10:10:30",
      "start": "2020-10-15 23:49:33",
      "end": null,
      "source": null
    },
    {
      "nodeID": "1027397",
      "personID": "5636",
      "timestamp": "2022-07-11 10:10:30",
      "start": "2020-10-15 23:49:41",
      "end": null,
      "source": null
    },
    {
      "nodeID": "1027409",
      "personID": "5636",
      "timestamp": "2022-07-11 10:10:30",
      "start": "2020-10-15 23:49:44",
      "end": null,
      "source": null
    },
    {
      "nodeID": "1027413",
      "personID": "5636",
      "timestamp": "2022-07-11 10:10:30",
      "start": "2020-10-15 23:49:48",
      "end": null,
      "source": null
    },
    {
      "nodeID": "1027417",
      "personID": "3812",
      "timestamp": "2022-07-11 10:10:30",
      "start": "2020-10-15 23:49:53",
      "end": null,
      "source": null
    },
    {
      "nodeID": "1027421",
      "personID": "3812",
      "timestamp": "2022-07-11 10:10:30",
      "start": "2020-10-15 23:49:56",
      "end": null,
      "source": null
    },
    {
      "nodeID": "775939",
      "personID": "5659",
      "timestamp": "2022-07-11 10:10:30",
      "start": "2020-10-15 23:50:06",
      "end": null,
      "source": null
    },
    {
      "nodeID": "1027436",
      "personID": "3812",
      "timestamp": "2022-07-11 10:10:30",
      "start": "2020-10-15 23:50:17",
      "end": null,
      "source": null
    },
    {
      "nodeID": "1027440",
      "personID": "3812",
      "timestamp": "2022-07-11 10:10:30",
      "start": "2020-10-15 23:50:40",
      "end": null,
      "source": null
    },
    {
      "nodeID": "775933",
      "personID": "3721",
      "timestamp": "2022-07-11 10:10:30",
      "start": "2020-10-15 23:50:44",
      "end": null,
      "source": null
    },
    {
      "nodeID": "1027457",
      "personID": "3721",
      "timestamp": "2022-07-11 10:10:30",
      "start": "2020-10-15 23:50:46",
      "end": null,
      "source": null
    },
    {
      "nodeID": "1027462",
      "personID": "3721",
      "timestamp": "2022-07-11 10:10:30",
      "start": "2020-10-15 23:50:48",
      "end": null,
      "source": null
    },
    {
      "nodeID": "1027467",
      "personID": "3721",
      "timestamp": "2022-07-11 10:10:30",
      "start": "2020-10-15 23:51:10",
      "end": null,
      "source": null
    },
    {
      "nodeID": "1027474",
      "personID": "3721",
      "timestamp": "2022-07-11 10:10:30",
      "start": "2020-10-15 23:51:11",
      "end": null,
      "source": null
    },
    {
      "nodeID": "775927",
      "personID": "3721",
      "timestamp": "2022-07-11 10:10:30",
      "start": "2020-10-15 23:51:14",
      "end": null,
      "source": null
    }
  ]
}"""

t = """
{
  "nodes": [
    {
      "nodeID": "775927",
      "text": "Tim Stanley : No, that particular term is totally unacceptable",
      "type": "L",
      "timestamp": "2021-11-11 20:57:54"
    },
    {
      "nodeID": "775933",
      "text": "Tim Stanley : The answer is no",
      "type": "L",
      "timestamp": "2021-11-11 20:57:57"
    },
    {
      "nodeID": "775939",
      "text": "AudienceMember 20211111QT22 : Can a racist term ever be defined as banter",
      "type": "L",
      "timestamp": "2021-11-11 20:57:59"
    },
    {
      "nodeID": "798248",
      "text": "Abbie: Fiona Bruce : I'm going to explain what the term is",
      "type": "L",
      "timestamp": "2022-01-06 10:38:45"
    },
    {
      "nodeID": "1027382",
      "text": "If the government look at it holistically",
      "type": "L",
      "timestamp": "2022-07-11 10:09:46"
    },
    {
      "nodeID": "1027383",
      "text": "Xiyuan: Paul Polman : If the government look at it holistically",
      "type": "L",
      "timestamp": "2022-07-11 10:09:47"
    },
    {
      "nodeID": "1027384",
      "text": "Paul Polman : If the government look at it holistically, 90 or 100 percent of these can be solved",
      "type": "L",
      "timestamp": "2022-07-11 10:09:48"
    },
    {
      "nodeID": "1027385",
      "text": "Asserting",
      "type": "YA",
      "timestamp": "2022-07-11 10:09:48",
      "scheme": "Asserting",
      "schemeID": "74"
    },
    {
      "nodeID": "1027386",
      "text": "if the government look at the energy issue holistically, 90 or 100 percent of these can be solved",
      "type": "I",
      "timestamp": "2022-07-11 10:09:49"
    },
    {
      "nodeID": "1027387",
      "text": "Xiyuan: Paul Polman : If the government look at it holistically, 90 or 100 percent of these can be solved",
      "type": "L",
      "timestamp": "2022-07-11 10:09:50"
    },
    {
      "nodeID": "1027388",
      "text": "Paul Polman : It is the same for business",
      "type": "L",
      "timestamp": "2022-07-11 10:09:51"
    },
    {
      "nodeID": "1027389",
      "text": "Asserting",
      "type": "YA",
      "timestamp": "2022-07-11 10:09:51",
      "scheme": "Asserting",
      "schemeID": "74"
    },
    {
      "nodeID": "1027390",
      "text": "it is the same for business",
      "type": "I",
      "timestamp": "2022-07-11 10:09:51"
    },
    {
      "nodeID": "1027391",
      "text": "Xiyuan: Paul Polman : It is the same for business",
      "type": "L",
      "timestamp": "2022-07-11 10:09:52"
    },
    {
      "nodeID": "1027392",
      "text": "Default Transition",
      "type": "TA",
      "timestamp": "2022-07-11 10:09:52",
      "scheme": "Default Transition",
      "schemeID": "82"
    },
    {
      "nodeID": "1027393",
      "text": "Paul Polman : We should stop competing with each other on the future of humanity, include in politics",
      "type": "L",
      "timestamp": "2022-07-11 10:09:53"
    },
    {
      "nodeID": "1027394",
      "text": "Asserting",
      "type": "YA",
      "timestamp": "2022-07-11 10:09:53",
      "scheme": "Asserting",
      "schemeID": "74"
    },
    {
      "nodeID": "1027395",
      "text": "we should stop competing with each other on the future of humanity, including in politics",
      "type": "I",
      "timestamp": "2022-07-11 10:09:53"
    },
    {
      "nodeID": "1027396",
      "text": "Xiyuan: Paul Polman : We should stop competing with each other on the future of humanity, include in politics",
      "type": "L",
      "timestamp": "2022-07-11 10:09:54"
    },
    {
      "nodeID": "1027397",
      "text": "Paul Polman : start working together like adults on these things for the benefit of mankind",
      "type": "L",
      "timestamp": "2022-07-11 10:09:55"
    },
    {
      "nodeID": "1027398",
      "text": "Asserting",
      "type": "YA",
      "timestamp": "2022-07-11 10:09:55",
      "scheme": "Asserting",
      "schemeID": "74"
    },
    {
      "nodeID": "1027399",
      "text": "we should start working together like adults on these things for the benefit of mankind",
      "type": "I",
      "timestamp": "2022-07-11 10:09:56"
    },
    {
      "nodeID": "1027400",
      "text": "Xiyuan: Paul Polman : start working together like adults on these things for the benefit of mankind",
      "type": "L",
      "timestamp": "2022-07-11 10:09:56"
    },
    {
      "nodeID": "1027401",
      "text": "Default Inference",
      "type": "RA",
      "timestamp": "2022-07-11 10:09:56",
      "scheme": "Default Inference",
      "schemeID": "72"
    },
    {
      "nodeID": "1027402",
      "text": "Default Transition",
      "type": "TA",
      "timestamp": "2022-07-11 10:09:56",
      "scheme": "Default Transition",
      "schemeID": "82"
    },
    {
      "nodeID": "1027403",
      "text": "Default Inference",
      "type": "RA",
      "timestamp": "2022-07-11 10:09:56",
      "scheme": "Default Inference",
      "schemeID": "72"
    },
    {
      "nodeID": "1027404",
      "text": "Default Transition",
      "type": "TA",
      "timestamp": "2022-07-11 10:09:56",
      "scheme": "Default Transition",
      "schemeID": "82"
    },
    {
      "nodeID": "1027405",
      "text": "Arguing",
      "type": "YA",
      "timestamp": "2022-07-11 10:09:56",
      "scheme": "Arguing",
      "schemeID": "80"
    },
    {
      "nodeID": "1027406",
      "text": "Default Transition",
      "type": "TA",
      "timestamp": "2022-07-11 10:09:56",
      "scheme": "Default Transition",
      "schemeID": "82"
    },
    {
      "nodeID": "1027407",
      "text": "Default Transition",
      "type": "TA",
      "timestamp": "2022-07-11 10:09:56",
      "scheme": "Default Transition",
      "schemeID": "82"
    },
    {
      "nodeID": "1027408",
      "text": "Arguing",
      "type": "YA",
      "timestamp": "2022-07-11 10:09:56",
      "scheme": "Arguing",
      "schemeID": "80"
    },
    {
      "nodeID": "1027409",
      "text": "Paul Polman : We have the technology",
      "type": "L",
      "timestamp": "2022-07-11 10:09:57"
    },
    {
      "nodeID": "1027410",
      "text": "Asserting",
      "type": "YA",
      "timestamp": "2022-07-11 10:09:57",
      "scheme": "Asserting",
      "schemeID": "74"
    },
    {
      "nodeID": "1027411",
      "text": "we have the technology",
      "type": "I",
      "timestamp": "2022-07-11 10:09:58"
    },
    {
      "nodeID": "1027412",
      "text": "Xiyuan: Paul Polman : We have the technology",
      "type": "L",
      "timestamp": "2022-07-11 10:09:59"
    },
    {
      "nodeID": "1027413",
      "text": "Paul Polman : We know what we have to do, and we don't have time",
      "type": "L",
      "timestamp": "2022-07-11 10:09:59"
    },
    {
      "nodeID": "1027414",
      "text": "Asserting",
      "type": "YA",
      "timestamp": "2022-07-11 10:09:59",
      "scheme": "Asserting",
      "schemeID": "74"
    },
    {
      "nodeID": "1027415",
      "text": "we know what we have to do, and we don't have time",
      "type": "I",
      "timestamp": "2022-07-11 10:10:00"
    },
    {
      "nodeID": "1027416",
      "text": "Xiyuan: Paul Polman : We know what we have to do, and we don't have time",
      "type": "L",
      "timestamp": "2022-07-11 10:10:01"
    },
    {
      "nodeID": "1027417",
      "text": "Fiona Bruce : We could talk about climate change all evening",
      "type": "L",
      "timestamp": "2022-07-11 10:10:02"
    },
    {
      "nodeID": "1027418",
      "text": "Asserting",
      "type": "YA",
      "timestamp": "2022-07-11 10:10:02",
      "scheme": "Asserting",
      "schemeID": "74"
    },
    {
      "nodeID": "1027419",
      "text": "we could talk about climate change all evening",
      "type": "I",
      "timestamp": "2022-07-11 10:10:03"
    },
    {
      "nodeID": "1027420",
      "text": "Xiyuan: Fiona Bruce : We could talk about climate change all evening",
      "type": "L",
      "timestamp": "2022-07-11 10:10:04"
    },
    {
      "nodeID": "1027421",
      "text": "Fiona Bruce : it is a massive topic, hugely important",
      "type": "L",
      "timestamp": "2022-07-11 10:10:04"
    },
    {
      "nodeID": "1027422",
      "text": "Asserting",
      "type": "YA",
      "timestamp": "2022-07-11 10:10:04",
      "scheme": "Asserting",
      "schemeID": "74"
    },
    {
      "nodeID": "1027423",
      "text": "climate change is a massive topic, hugely important",
      "type": "I",
      "timestamp": "2022-07-11 10:10:05"
    },
    {
      "nodeID": "1027424",
      "text": "Xiyuan: Fiona Bruce : it is a massive topic, hugely important",
      "type": "L",
      "timestamp": "2022-07-11 10:10:06"
    },
    {
      "nodeID": "1027425",
      "text": "Default Inference",
      "type": "RA",
      "timestamp": "2022-07-11 10:10:06",
      "scheme": "Default Inference",
      "schemeID": "72"
    },
    {
      "nodeID": "1027426",
      "text": "Default Transition",
      "type": "TA",
      "timestamp": "2022-07-11 10:10:06",
      "scheme": "Default Transition",
      "schemeID": "82"
    },
    {
      "nodeID": "1027427",
      "text": "Arguing",
      "type": "YA",
      "timestamp": "2022-07-11 10:10:06",
      "scheme": "Arguing",
      "schemeID": "80"
    },
    {
      "nodeID": "1027428",
      "text": "Xiyuan: Fiona Bruce : There's another question a lot of you submitted this evening",
      "type": "L",
      "timestamp": "2022-07-11 10:10:07"
    },
    {
      "nodeID": "1027429",
      "text": "Xiyuan: Fiona Bruce : I'm going to move on",
      "type": "L",
      "timestamp": "2022-07-11 10:10:08"
    },
    {
      "nodeID": "1027430",
      "text": "Xiyuan: Fiona Bruce : Can a racist term ever be defined as banter",
      "type": "L",
      "timestamp": "2022-07-11 10:10:08"
    },
    {
      "nodeID": "1027431",
      "text": "Xiyuan: Fiona Bruce : I'm just picking one of them.",
      "type": "L",
      "timestamp": "2022-07-11 10:10:09"
    },
    {
      "nodeID": "1027432",
      "text": "Pure Questioning",
      "type": "YA",
      "timestamp": "2022-07-11 10:10:10",
      "scheme": "PureQuestioning",
      "schemeID": "91"
    },
    {
      "nodeID": "1027433",
      "text": "a racist term can or can not ever be defined as banter",
      "type": "I",
      "timestamp": "2022-07-11 10:10:11"
    },
    {
      "nodeID": "1027434",
      "text": "Xiyuan: AudienceMember 20211111QT22 : Can a racist term ever be defined as banter",
      "type": "L",
      "timestamp": "2022-07-11 10:10:11"
    },
    {
      "nodeID": "1027435",
      "text": "Xiyuan: Fiona Bruce : What you are talking about here is the furore there's been over Azeem Rafiq who claims he was subjected to institutional racism at his club, and he clearly feels that this has not been handled properly and Yorkshire has carried out its own investigation, ruled no disciplinary action would take place, called it banter",
      "type": "L",
      "timestamp": "2022-07-11 10:10:12"
    },
    {
      "nodeID": "1027436",
      "text": "Fiona Bruce : the furore there's been over Azeem Rafiq who claims he was subjected to institutional racism at his club, and he clearly feels that this has not been handled properly",
      "type": "L",
      "timestamp": "2022-07-11 10:10:13"
    },
    {
      "nodeID": "1027437",
      "text": "Asserting",
      "type": "YA",
      "timestamp": "2022-07-11 10:10:13",
      "scheme": "Asserting",
      "schemeID": "74"
    },
    {
      "nodeID": "1027438",
      "text": "Azeem Rafiq who claims he was subjected to institutional racism at his club, and he clearly feels that this has not been handled properly",
      "type": "I",
      "timestamp": "2022-07-11 10:10:14"
    },
    {
      "nodeID": "1027439",
      "text": "Xiyuan: Fiona Bruce : the furore there's been over Azeem Rafiq who claims he was subjected to institutional racism at his club, and he clearly feels that this has not been handled properly",
      "type": "L",
      "timestamp": "2022-07-11 10:10:14"
    },
    {
      "nodeID": "1027440",
      "text": "Fiona Bruce : Yorkshire has carried out its own investigation, ruled no disciplinary action would take place, called it banter",
      "type": "L",
      "timestamp": "2022-07-11 10:10:15"
    },
    {
      "nodeID": "1027441",
      "text": "Asserting",
      "type": "YA",
      "timestamp": "2022-07-11 10:10:15",
      "scheme": "Asserting",
      "schemeID": "74"
    },
    {
      "nodeID": "1027442",
      "text": "Yorkshire has carried out its own investigation, ruled no disciplinary action would take place, called it banter",
      "type": "I",
      "timestamp": "2022-07-11 10:10:16"
    },
    {
      "nodeID": "1027443",
      "text": "Xiyuan: Fiona Bruce : Yorkshire has carried out its own investigation, ruled no disciplinary action would take place, called it banter",
      "type": "L",
      "timestamp": "2022-07-11 10:10:17"
    },
    {
      "nodeID": "1027444",
      "text": "Default Rephrase",
      "type": "MA",
      "timestamp": "2022-07-11 10:10:17",
      "scheme": "Default Rephrase",
      "schemeID": "144"
    },
    {
      "nodeID": "1027445",
      "text": "Default Transition",
      "type": "TA",
      "timestamp": "2022-07-11 10:10:17",
      "scheme": "Default Transition",
      "schemeID": "82"
    },
    {
      "nodeID": "1027446",
      "text": "Default Rephrase",
      "type": "MA",
      "timestamp": "2022-07-11 10:10:17",
      "scheme": "Default Rephrase",
      "schemeID": "144"
    },
    {
      "nodeID": "1027447",
      "text": "Default Transition",
      "type": "TA",
      "timestamp": "2022-07-11 10:10:17",
      "scheme": "Default Transition",
      "schemeID": "82"
    },
    {
      "nodeID": "1027448",
      "text": "Restating",
      "type": "YA",
      "timestamp": "2022-07-11 10:10:17",
      "scheme": "Restating",
      "schemeID": "101"
    },
    {
      "nodeID": "1027449",
      "text": "Restating",
      "type": "YA",
      "timestamp": "2022-07-11 10:10:17",
      "scheme": "Restating",
      "schemeID": "101"
    },
    {
      "nodeID": "1027450",
      "text": "Asserting",
      "type": "YA",
      "timestamp": "2022-07-11 10:10:17",
      "scheme": "Asserting",
      "schemeID": "74"
    },
    {
      "nodeID": "1027451",
      "text": "a racist term can not ever be defined as banter",
      "type": "I",
      "timestamp": "2022-07-11 10:10:18"
    },
    {
      "nodeID": "1027452",
      "text": "Xiyuan: Tim Stanley : The answer is no",
      "type": "L",
      "timestamp": "2022-07-11 10:10:19"
    },
    {
      "nodeID": "1027453",
      "text": "Default Transition",
      "type": "TA",
      "timestamp": "2022-07-11 10:10:19",
      "scheme": "Default Transition",
      "schemeID": "82"
    },
    {
      "nodeID": "1027454",
      "text": "Default Rephrase",
      "type": "MA",
      "timestamp": "2022-07-11 10:10:19",
      "scheme": "Default Rephrase",
      "schemeID": "144"
    },
    {
      "nodeID": "1027455",
      "text": "Default Transition",
      "type": "TA",
      "timestamp": "2022-07-11 10:10:19",
      "scheme": "Default Transition",
      "schemeID": "82"
    },
    {
      "nodeID": "1027456",
      "text": "Default Illocuting",
      "type": "YA",
      "timestamp": "2022-07-11 10:10:19",
      "scheme": "Default Illocuting",
      "schemeID": "168"
    },
    {
      "nodeID": "1027457",
      "text": "Tim Stanley : There's nothing else to say",
      "type": "L",
      "timestamp": "2022-07-11 10:10:20"
    },
    {
      "nodeID": "1027458",
      "text": "Asserting",
      "type": "YA",
      "timestamp": "2022-07-11 10:10:20",
      "scheme": "Asserting",
      "schemeID": "74"
    },
    {
      "nodeID": "1027459",
      "text": "there's nothing else to say",
      "type": "I",
      "timestamp": "2022-07-11 10:10:20"
    },
    {
      "nodeID": "1027460",
      "text": "Xiyuan: Tim Stanley : There's nothing else to say",
      "type": "L",
      "timestamp": "2022-07-11 10:10:21"
    },
    {
      "nodeID": "1027461",
      "text": "Default Transition",
      "type": "TA",
      "timestamp": "2022-07-11 10:10:21",
      "scheme": "Default Transition",
      "schemeID": "82"
    },
    {
      "nodeID": "1027462",
      "text": "Tim Stanley : I don't see how the club can explain its decision to not take further action other than, I suppose, hypothetically, perhaps, there was a reluctance to do something that might damage the career of a star player",
      "type": "L",
      "timestamp": "2022-07-11 10:10:22"
    },
    {
      "nodeID": "1027463",
      "text": "Asserting",
      "type": "YA",
      "timestamp": "2022-07-11 10:10:22",
      "scheme": "Asserting",
      "schemeID": "74"
    },
    {
      "nodeID": "1027464",
      "text": "Tim Stanley does not see how the club can explain its decision to not take further action other than, there was a reluctance to do something that might damage the career of a star player",
      "type": "I",
      "timestamp": "2022-07-11 10:10:22"
    },
    {
      "nodeID": "1027465",
      "text": "Xiyuan: Tim Stanley : I don't see how the club can explain its decision to not take further action other than, I suppose, hypothetically, perhaps, there was a reluctance to do something that might damage the career of a star player",
      "type": "L",
      "timestamp": "2022-07-11 10:10:23"
    },
    {
      "nodeID": "1027466",
      "text": "Default Transition",
      "type": "TA",
      "timestamp": "2022-07-11 10:10:23",
      "scheme": "Default Transition",
      "schemeID": "82"
    },
    {
      "nodeID": "1027467",
      "text": "Tim Stanley : I don't know",
      "type": "L",
      "timestamp": "2022-07-11 10:10:24"
    },
    {
      "nodeID": "1027468",
      "text": "Asserting",
      "type": "YA",
      "timestamp": "2022-07-11 10:10:24",
      "scheme": "Asserting",
      "schemeID": "74"
    },
    {
      "nodeID": "1027469",
      "text": "Tim Stanley does not know if there was a reluctance to do something that might damage the career of a star player",
      "type": "I",
      "timestamp": "2022-07-11 10:10:25"
    },
    {
      "nodeID": "1027470",
      "text": "Xiyuan: Tim Stanley : I don't know",
      "type": "L",
      "timestamp": "2022-07-11 10:10:26"
    },
    {
      "nodeID": "1027471",
      "text": "Default Rephrase",
      "type": "MA",
      "timestamp": "2022-07-11 10:10:26",
      "scheme": "Default Rephrase",
      "schemeID": "144"
    },
    {
      "nodeID": "1027472",
      "text": "Default Transition",
      "type": "TA",
      "timestamp": "2022-07-11 10:10:26",
      "scheme": "Default Transition",
      "schemeID": "82"
    },
    {
      "nodeID": "1027473",
      "text": "Restating",
      "type": "YA",
      "timestamp": "2022-07-11 10:10:26",
      "scheme": "Restating",
      "schemeID": "101"
    },
    {
      "nodeID": "1027474",
      "text": "Tim Stanley : that's purely speculative",
      "type": "L",
      "timestamp": "2022-07-11 10:10:26"
    },
    {
      "nodeID": "1027475",
      "text": "Asserting",
      "type": "YA",
      "timestamp": "2022-07-11 10:10:26",
      "scheme": "Asserting",
      "schemeID": "74"
    },
    {
      "nodeID": "1027476",
      "text": "that's purely speculative that there was a reluctance to do something that might damage the career of a star player",
      "type": "I",
      "timestamp": "2022-07-11 10:10:27"
    },
    {
      "nodeID": "1027477",
      "text": "Xiyuan: Tim Stanley : that's purely speculative",
      "type": "L",
      "timestamp": "2022-07-11 10:10:28"
    },
    {
      "nodeID": "1027478",
      "text": "Default Rephrase",
      "type": "MA",
      "timestamp": "2022-07-11 10:10:28",
      "scheme": "Default Rephrase",
      "schemeID": "144"
    },
    {
      "nodeID": "1027479",
      "text": "Default Transition",
      "type": "TA",
      "timestamp": "2022-07-11 10:10:28",
      "scheme": "Default Transition",
      "schemeID": "82"
    },
    {
      "nodeID": "1027480",
      "text": "Restating",
      "type": "YA",
      "timestamp": "2022-07-11 10:10:28",
      "scheme": "Restating",
      "schemeID": "101"
    },
    {
      "nodeID": "1027481",
      "text": "Asserting",
      "type": "YA",
      "timestamp": "2022-07-11 10:10:29",
      "scheme": "Asserting",
      "schemeID": "74"
    },
    {
      "nodeID": "1027482",
      "text": "no, that particular term is totally unacceptable",
      "type": "I",
      "timestamp": "2022-07-11 10:10:29"
    },
    {
      "nodeID": "1027483",
      "text": "Xiyuan: Tim Stanley : No, that particular term is totally unacceptable",
      "type": "L",
      "timestamp": "2022-07-11 10:10:30"
    },
    {
      "nodeID": "1027484",
      "text": "Default Transition",
      "type": "TA",
      "timestamp": "2022-07-11 10:10:30",
      "scheme": "Default Transition",
      "schemeID": "82"
    },
    {
      "nodeID": "1027485",
      "text": "Default Rephrase",
      "type": "MA",
      "timestamp": "2022-07-11 10:10:30",
      "scheme": "Default Rephrase",
      "schemeID": "144"
    },
    {
      "nodeID": "1027486",
      "text": "Default Transition",
      "type": "TA",
      "timestamp": "2022-07-11 10:10:30",
      "scheme": "Default Transition",
      "schemeID": "82"
    },
    {
      "nodeID": "1027487",
      "text": "Restating",
      "type": "YA",
      "timestamp": "2022-07-11 10:10:30",
      "scheme": "Restating",
      "schemeID": "101"
    },
    {
      "nodeID": "1027488",
      "text": "Default Transition",
      "type": "TA",
      "timestamp": "2022-07-11 10:10:30",
      "scheme": "Default Transition",
      "schemeID": "82"
    },
    {
      "nodeID": "1027489",
      "text": "Default Transition",
      "type": "TA",
      "timestamp": "2022-07-11 10:10:30",
      "scheme": "Default Transition",
      "schemeID": "82"
    },
    {
      "nodeID": "1027490",
      "text": "Default Transition",
      "type": "TA",
      "timestamp": "2022-07-11 10:10:30",
      "scheme": "Default Transition",
      "schemeID": "82"
    },
    {
      "nodeID": "1027491",
      "text": "Default Transition",
      "type": "TA",
      "timestamp": "2022-07-11 10:10:30",
      "scheme": "Default Transition",
      "schemeID": "82"
    }
  ],
  "edges": [
    {
      "edgeID": "1359298",
      "fromID": "1027385",
      "toID": "1027386",
      "formEdgeID": null
    },
    {
      "edgeID": "1359299",
      "fromID": "1027384",
      "toID": "1027385",
      "formEdgeID": null
    },
    {
      "edgeID": "1359300",
      "fromID": "1027389",
      "toID": "1027390",
      "formEdgeID": null
    },
    {
      "edgeID": "1359301",
      "fromID": "1027388",
      "toID": "1027389",
      "formEdgeID": null
    },
    {
      "edgeID": "1359302",
      "fromID": "1027384",
      "toID": "1027392",
      "formEdgeID": null
    },
    {
      "edgeID": "1359303",
      "fromID": "1027392",
      "toID": "1027388",
      "formEdgeID": null
    },
    {
      "edgeID": "1359304",
      "fromID": "1027394",
      "toID": "1027395",
      "formEdgeID": null
    },
    {
      "edgeID": "1359305",
      "fromID": "1027393",
      "toID": "1027394",
      "formEdgeID": null
    },
    {
      "edgeID": "1359306",
      "fromID": "1027398",
      "toID": "1027399",
      "formEdgeID": null
    },
    {
      "edgeID": "1359307",
      "fromID": "1027397",
      "toID": "1027398",
      "formEdgeID": null
    },
    {
      "edgeID": "1359308",
      "fromID": "1027386",
      "toID": "1027401",
      "formEdgeID": null
    },
    {
      "edgeID": "1359309",
      "fromID": "1027401",
      "toID": "1027395",
      "formEdgeID": null
    },
    {
      "edgeID": "1359310",
      "fromID": "1027384",
      "toID": "1027402",
      "formEdgeID": null
    },
    {
      "edgeID": "1359311",
      "fromID": "1027402",
      "toID": "1027393",
      "formEdgeID": null
    },
    {
      "edgeID": "1359312",
      "fromID": "1027386",
      "toID": "1027403",
      "formEdgeID": null
    },
    {
      "edgeID": "1359313",
      "fromID": "1027403",
      "toID": "1027399",
      "formEdgeID": null
    },
    {
      "edgeID": "1359314",
      "fromID": "1027384",
      "toID": "1027404",
      "formEdgeID": null
    },
    {
      "edgeID": "1359315",
      "fromID": "1027404",
      "toID": "1027397",
      "formEdgeID": null
    },
    {
      "edgeID": "1359316",
      "fromID": "1027402",
      "toID": "1027405",
      "formEdgeID": null
    },
    {
      "edgeID": "1359317",
      "fromID": "1027405",
      "toID": "1027401",
      "formEdgeID": null
    },
    {
      "edgeID": "1359318",
      "fromID": "1027390",
      "toID": "1027401",
      "formEdgeID": null
    },
    {
      "edgeID": "1359319",
      "fromID": "1027390",
      "toID": "1027403",
      "formEdgeID": null
    },
    {
      "edgeID": "1359320",
      "fromID": "1027388",
      "toID": "1027406",
      "formEdgeID": null
    },
    {
      "edgeID": "1359321",
      "fromID": "1027406",
      "toID": "1027393",
      "formEdgeID": null
    },
    {
      "edgeID": "1359322",
      "fromID": "1027393",
      "toID": "1027407",
      "formEdgeID": null
    },
    {
      "edgeID": "1359323",
      "fromID": "1027407",
      "toID": "1027397",
      "formEdgeID": null
    },
    {
      "edgeID": "1359324",
      "fromID": "1027404",
      "toID": "1027408",
      "formEdgeID": null
    },
    {
      "edgeID": "1359325",
      "fromID": "1027408",
      "toID": "1027403",
      "formEdgeID": null
    },
    {
      "edgeID": "1359326",
      "fromID": "1027410",
      "toID": "1027411",
      "formEdgeID": null
    },
    {
      "edgeID": "1359327",
      "fromID": "1027409",
      "toID": "1027410",
      "formEdgeID": null
    },
    {
      "edgeID": "1359328",
      "fromID": "1027414",
      "toID": "1027415",
      "formEdgeID": null
    },
    {
      "edgeID": "1359329",
      "fromID": "1027413",
      "toID": "1027414",
      "formEdgeID": null
    },
    {
      "edgeID": "1359330",
      "fromID": "1027418",
      "toID": "1027419",
      "formEdgeID": null
    },
    {
      "edgeID": "1359331",
      "fromID": "1027417",
      "toID": "1027418",
      "formEdgeID": null
    },
    {
      "edgeID": "1359332",
      "fromID": "1027422",
      "toID": "1027423",
      "formEdgeID": null
    },
    {
      "edgeID": "1359333",
      "fromID": "1027421",
      "toID": "1027422",
      "formEdgeID": null
    },
    {
      "edgeID": "1359334",
      "fromID": "1027423",
      "toID": "1027425",
      "formEdgeID": null
    },
    {
      "edgeID": "1359335",
      "fromID": "1027425",
      "toID": "1027419",
      "formEdgeID": null
    },
    {
      "edgeID": "1359336",
      "fromID": "1027417",
      "toID": "1027426",
      "formEdgeID": null
    },
    {
      "edgeID": "1359337",
      "fromID": "1027426",
      "toID": "1027421",
      "formEdgeID": null
    },
    {
      "edgeID": "1359338",
      "fromID": "1027426",
      "toID": "1027427",
      "formEdgeID": null
    },
    {
      "edgeID": "1359339",
      "fromID": "1027427",
      "toID": "1027425",
      "formEdgeID": null
    },
    {
      "edgeID": "1359340",
      "fromID": "1027432",
      "toID": "1027433",
      "formEdgeID": null
    },
    {
      "edgeID": "1359341",
      "fromID": "775939",
      "toID": "1027432",
      "formEdgeID": null
    },
    {
      "edgeID": "1359342",
      "fromID": "1027437",
      "toID": "1027438",
      "formEdgeID": null
    },
    {
      "edgeID": "1359343",
      "fromID": "1027436",
      "toID": "1027437",
      "formEdgeID": null
    },
    {
      "edgeID": "1359344",
      "fromID": "1027441",
      "toID": "1027442",
      "formEdgeID": null
    },
    {
      "edgeID": "1359345",
      "fromID": "1027440",
      "toID": "1027441",
      "formEdgeID": null
    },
    {
      "edgeID": "1359346",
      "fromID": "1027438",
      "toID": "1027444",
      "formEdgeID": null
    },
    {
      "edgeID": "1359347",
      "fromID": "1027444",
      "toID": "1027433",
      "formEdgeID": null
    },
    {
      "edgeID": "1359348",
      "fromID": "775939",
      "toID": "1027445",
      "formEdgeID": null
    },
    {
      "edgeID": "1359349",
      "fromID": "1027445",
      "toID": "1027436",
      "formEdgeID": null
    },
    {
      "edgeID": "1359350",
      "fromID": "1027442",
      "toID": "1027446",
      "formEdgeID": null
    },
    {
      "edgeID": "1359351",
      "fromID": "1027446",
      "toID": "1027433",
      "formEdgeID": null
    },
    {
      "edgeID": "1359352",
      "fromID": "775939",
      "toID": "1027447",
      "formEdgeID": null
    },
    {
      "edgeID": "1359353",
      "fromID": "1027447",
      "toID": "1027440",
      "formEdgeID": null
    },
    {
      "edgeID": "1359354",
      "fromID": "1027447",
      "toID": "1027448",
      "formEdgeID": null
    },
    {
      "edgeID": "1359355",
      "fromID": "1027448",
      "toID": "1027446",
      "formEdgeID": null
    },
    {
      "edgeID": "1359356",
      "fromID": "1027445",
      "toID": "1027449",
      "formEdgeID": null
    },
    {
      "edgeID": "1359357",
      "fromID": "1027449",
      "toID": "1027444",
      "formEdgeID": null
    },
    {
      "edgeID": "1359358",
      "fromID": "1027450",
      "toID": "1027451",
      "formEdgeID": null
    },
    {
      "edgeID": "1359359",
      "fromID": "775933",
      "toID": "1027450",
      "formEdgeID": null
    },
    {
      "edgeID": "1359360",
      "fromID": "1027440",
      "toID": "1027453",
      "formEdgeID": null
    },
    {
      "edgeID": "1359361",
      "fromID": "1027453",
      "toID": "775933",
      "formEdgeID": null
    },
    {
      "edgeID": "1359362",
      "fromID": "1027451",
      "toID": "1027454",
      "formEdgeID": null
    },
    {
      "edgeID": "1359363",
      "fromID": "1027454",
      "toID": "1027433",
      "formEdgeID": null
    },
    {
      "edgeID": "1359364",
      "fromID": "775939",
      "toID": "1027455",
      "formEdgeID": null
    },
    {
      "edgeID": "1359365",
      "fromID": "1027455",
      "toID": "775933",
      "formEdgeID": null
    },
    {
      "edgeID": "1359366",
      "fromID": "1027455",
      "toID": "1027456",
      "formEdgeID": null
    },
    {
      "edgeID": "1359367",
      "fromID": "1027456",
      "toID": "1027454",
      "formEdgeID": null
    },
    {
      "edgeID": "1359368",
      "fromID": "1027458",
      "toID": "1027459",
      "formEdgeID": null
    },
    {
      "edgeID": "1359369",
      "fromID": "1027457",
      "toID": "1027458",
      "formEdgeID": null
    },
    {
      "edgeID": "1359370",
      "fromID": "775933",
      "toID": "1027461",
      "formEdgeID": null
    },
    {
      "edgeID": "1359371",
      "fromID": "1027461",
      "toID": "1027457",
      "formEdgeID": null
    },
    {
      "edgeID": "1359372",
      "fromID": "1027463",
      "toID": "1027464",
      "formEdgeID": null
    },
    {
      "edgeID": "1359373",
      "fromID": "1027462",
      "toID": "1027463",
      "formEdgeID": null
    },
    {
      "edgeID": "1359374",
      "fromID": "1027457",
      "toID": "1027466",
      "formEdgeID": null
    },
    {
      "edgeID": "1359375",
      "fromID": "1027466",
      "toID": "1027462",
      "formEdgeID": null
    },
    {
      "edgeID": "1359376",
      "fromID": "1027468",
      "toID": "1027469",
      "formEdgeID": null
    },
    {
      "edgeID": "1359377",
      "fromID": "1027467",
      "toID": "1027468",
      "formEdgeID": null
    },
    {
      "edgeID": "1359378",
      "fromID": "1027469",
      "toID": "1027471",
      "formEdgeID": null
    },
    {
      "edgeID": "1359379",
      "fromID": "1027471",
      "toID": "1027464",
      "formEdgeID": null
    },
    {
      "edgeID": "1359380",
      "fromID": "1027462",
      "toID": "1027472",
      "formEdgeID": null
    },
    {
      "edgeID": "1359381",
      "fromID": "1027472",
      "toID": "1027467",
      "formEdgeID": null
    },
    {
      "edgeID": "1359382",
      "fromID": "1027472",
      "toID": "1027473",
      "formEdgeID": null
    },
    {
      "edgeID": "1359383",
      "fromID": "1027473",
      "toID": "1027471",
      "formEdgeID": null
    },
    {
      "edgeID": "1359384",
      "fromID": "1027475",
      "toID": "1027476",
      "formEdgeID": null
    },
    {
      "edgeID": "1359385",
      "fromID": "1027474",
      "toID": "1027475",
      "formEdgeID": null
    },
    {
      "edgeID": "1359386",
      "fromID": "1027476",
      "toID": "1027478",
      "formEdgeID": null
    },
    {
      "edgeID": "1359387",
      "fromID": "1027478",
      "toID": "1027469",
      "formEdgeID": null
    },
    {
      "edgeID": "1359388",
      "fromID": "1027467",
      "toID": "1027479",
      "formEdgeID": null
    },
    {
      "edgeID": "1359389",
      "fromID": "1027479",
      "toID": "1027474",
      "formEdgeID": null
    },
    {
      "edgeID": "1359390",
      "fromID": "1027479",
      "toID": "1027480",
      "formEdgeID": null
    },
    {
      "edgeID": "1359391",
      "fromID": "1027480",
      "toID": "1027478",
      "formEdgeID": null
    },
    {
      "edgeID": "1359392",
      "fromID": "1027481",
      "toID": "1027482",
      "formEdgeID": null
    },
    {
      "edgeID": "1359393",
      "fromID": "775927",
      "toID": "1027481",
      "formEdgeID": null
    },
    {
      "edgeID": "1359394",
      "fromID": "1027474",
      "toID": "1027484",
      "formEdgeID": null
    },
    {
      "edgeID": "1359395",
      "fromID": "1027484",
      "toID": "775927",
      "formEdgeID": null
    },
    {
      "edgeID": "1359396",
      "fromID": "1027482",
      "toID": "1027485",
      "formEdgeID": null
    },
    {
      "edgeID": "1359397",
      "fromID": "1027485",
      "toID": "1027451",
      "formEdgeID": null
    },
    {
      "edgeID": "1359398",
      "fromID": "775927",
      "toID": "1027486",
      "formEdgeID": null
    },
    {
      "edgeID": "1359399",
      "fromID": "1027486",
      "toID": "775933",
      "formEdgeID": null
    },
    {
      "edgeID": "1359400",
      "fromID": "1027486",
      "toID": "1027487",
      "formEdgeID": null
    },
    {
      "edgeID": "1359401",
      "fromID": "1027487",
      "toID": "1027485",
      "formEdgeID": null
    },
    {
      "edgeID": "1359402",
      "fromID": "1027397",
      "toID": "1027488",
      "formEdgeID": null
    },
    {
      "edgeID": "1359403",
      "fromID": "1027488",
      "toID": "1027409",
      "formEdgeID": null
    },
    {
      "edgeID": "1359404",
      "fromID": "1027409",
      "toID": "1027489",
      "formEdgeID": null
    },
    {
      "edgeID": "1359405",
      "fromID": "1027489",
      "toID": "1027413",
      "formEdgeID": null
    },
    {
      "edgeID": "1359406",
      "fromID": "1027413",
      "toID": "1027490",
      "formEdgeID": null
    },
    {
      "edgeID": "1359407",
      "fromID": "1027490",
      "toID": "1027417",
      "formEdgeID": null
    },
    {
      "edgeID": "1359408",
      "fromID": "1027421",
      "toID": "1027491",
      "formEdgeID": null
    },
    {
      "edgeID": "1359409",
      "fromID": "1027491",
      "toID": "775939",
      "formEdgeID": null
    }
  ],
  "locutions": [
    {
      "nodeID": "1027384",
      "personID": "5636",
      "timestamp": "2022-07-11 10:10:30",
      "start": "2020-10-15 23:49:22",
      "end": null,
      "source": null
    },
    {
      "nodeID": "1027388",
      "personID": "5636",
      "timestamp": "2022-07-11 10:10:30",
      "start": "2020-10-15 23:49:28",
      "end": null,
      "source": null
    },
    {
      "nodeID": "1027393",
      "personID": "5636",
      "timestamp": "2022-07-11 10:10:30",
      "start": "2020-10-15 23:49:33",
      "end": null,
      "source": null
    },
    {
      "nodeID": "1027397",
      "personID": "5636",
      "timestamp": "2022-07-11 10:10:30",
      "start": "2020-10-15 23:49:41",
      "end": null,
      "source": null
    },
    {
      "nodeID": "1027409",
      "personID": "5636",
      "timestamp": "2022-07-11 10:10:30",
      "start": "2020-10-15 23:49:44",
      "end": null,
      "source": null
    },
    {
      "nodeID": "1027413",
      "personID": "5636",
      "timestamp": "2022-07-11 10:10:30",
      "start": "2020-10-15 23:49:48",
      "end": null,
      "source": null
    },
    {
      "nodeID": "1027417",
      "personID": "3812",
      "timestamp": "2022-07-11 10:10:30",
      "start": "2020-10-15 23:49:53",
      "end": null,
      "source": null
    },
    {
      "nodeID": "1027421",
      "personID": "3812",
      "timestamp": "2022-07-11 10:10:30",
      "start": "2020-10-15 23:49:56",
      "end": null,
      "source": null
    },
    {
      "nodeID": "775939",
      "personID": "5659",
      "timestamp": "2022-07-11 10:10:30",
      "start": "2020-10-15 23:50:06",
      "end": null,
      "source": null
    },
    {
      "nodeID": "1027436",
      "personID": "3812",
      "timestamp": "2022-07-11 10:10:30",
      "start": "2020-10-15 23:50:17",
      "end": null,
      "source": null
    },
    {
      "nodeID": "1027440",
      "personID": "3812",
      "timestamp": "2022-07-11 10:10:30",
      "start": "2020-10-15 23:50:40",
      "end": null,
      "source": null
    },
    {
      "nodeID": "775933",
      "personID": "3721",
      "timestamp": "2022-07-11 10:10:30",
      "start": "2020-10-15 23:50:44",
      "end": null,
      "source": null
    },
    {
      "nodeID": "1027457",
      "personID": "3721",
      "timestamp": "2022-07-11 10:10:30",
      "start": "2020-10-15 23:50:46",
      "end": null,
      "source": null
    },
    {
      "nodeID": "1027462",
      "personID": "3721",
      "timestamp": "2022-07-11 10:10:30",
      "start": "2020-10-15 23:50:48",
      "end": null,
      "source": null
    },
    {
      "nodeID": "1027467",
      "personID": "3721",
      "timestamp": "2022-07-11 10:10:30",
      "start": "2020-10-15 23:51:10",
      "end": null,
      "source": null
    },
    {
      "nodeID": "1027474",
      "personID": "3721",
      "timestamp": "2022-07-11 10:10:30",
      "start": "2020-10-15 23:51:11",
      "end": null,
      "source": null
    },
    {
      "nodeID": "775927",
      "personID": "3721",
      "timestamp": "2022-07-11 10:10:30",
      "start": "2020-10-15 23:51:14",
      "end": null,
      "source": null
    }
  ]
}
"""

def actual_doing(source_text=None,
                 external_text=None,
                 aif_mode="true",
                 han_mode="false",
                 ex_aif_mode="true",
                 source_date='2019-05-01',
                 ma_thresh = 0.85,
                 ra_thresh = 0.55):
    centra = Centrality()
    if source_text is None:
        source_text = [s]
    if external_text is None:
        external_text = [t]
    # s_map_numbers = []
    # ex_map_numbers = []
    # ma_thresh = 0.85
    # ra_thresh = 0.55
    s_l_i_nodes = []
    ex_l_i_nodes = []
    s_l_nodes = []
    ex_l_nodes = []
    h_l_i_nodes = []
    h_l_nodes = []

    if aif_mode == "true" and han_mode == "true" and ex_aif_mode == "false":
        raise Exception("ERROR: the online propositionaliser is not available. Cannot invoke this")
        # # Source Map and Hansard
        # # sources = source_text.split(',')
        # # s_map_numbers = [int(i) for i in sources]
        # central_nodes, s_l_i_nodes, s_l_nodes = centra.get_top_nodes_combined(source_text)
        # source_topic_text = get_topic_text(central_nodes)
        # txt_df = sent_to_df(source_topic_text)
        # result = predict_topic(txt_df)
        # hansard_fp = get_hansard_file_path(source_date, result, 'HansardDataAMF')
        # hansard_map_num = check_hansard_path(hansard_fp)
        # if hansard_map_num[0] == '':
        #     hansard_text = get_hansard_text(hansard_fp)
        #     hansard_text = hansard_text.decode("utf-8")
        #     ex_map_numbers = do_amf_calls(hansard_text, True)
        #     write_to_csv(ex_map_numbers, hansard_fp)
        # else:
        #     ex_map_numbers = hansard_map_num
        #     ex_map_numbers = ast.literal_eval(ex_map_numbers)
        # h_i_nodes, h_l_i_nodes, h_l_nodes = centra.get_top_nodes_combined(ex_map_numbers)
        # relations = itc_matrix(central_nodes, h_i_nodes, ma_thresh, ra_thresh)
        # if len(relations) > 0:
        #     # Build itc map
        #     map_id = build_itc_map(relations, s_l_i_nodes, h_l_i_nodes, s_l_nodes, h_l_nodes)



    elif aif_mode == "true" and han_mode == "false" and ex_aif_mode == "true":
        # Source Map and External Maps
        # sources = source_text.split(',')
        # s_map_numbers = [int(i) for i in sources]
        #
        # external = external_text.split(',')
        # ex_map_numbers = [int(i) for i in external]

        central_nodes, s_l_i_nodes, s_l_nodes = centra.get_top_nodes_combined(source_text)
        ex_i_nodes, ex_l_i_nodes, ex_l_nodes = centra.get_all_nodes_combined(external_text)

        relations = itc_matrix(central_nodes, ex_i_nodes, ma_thresh, ra_thresh)
        if len(relations) > 0:
            # Build itc map
            map_id = build_itc_map(relations, s_l_i_nodes, ex_l_i_nodes, s_l_nodes, ex_l_nodes)


    elif aif_mode == "false" and han_mode == "true" and ex_aif_mode == "false":
        raise Exception("ERROR: the online propositionaliser is not available. Cannot invoke this")
        # # Source Text and Hansard
        # s_map_numbers = do_amf_calls(source_text, False)
        # central_nodes, s_l_i_nodes, s_l_nodes = centra.get_top_nodes_combined(s_map_numbers)
        #
        # source_topic_text = get_topic_text(central_nodes)
        # txt_df = sent_to_df(source_topic_text)
        # result = predict_topic(txt_df)
        # hansard_fp = get_hansard_file_path(source_date, result, 'HansardDataAMF')
        # hansard_map_num = check_hansard_path(hansard_fp)
        #
        # if hansard_map_num[0] == '':
        #     hansard_text = get_hansard_text(hansard_fp)
        #     hansard_text = hansard_text.decode("utf-8")
        #
        #     ex_map_numbers = do_amf_calls(hansard_text, True)
        #     write_to_csv(ex_map_numbers, hansard_fp)
        # else:
        #
        #     ex_map_numbers = hansard_map_num
        #
        #     ex_map_numbers = ast.literal_eval(ex_map_numbers)
        #
        # h_i_nodes, h_l_i_nodes, h_l_nodes = centra.get_top_nodes_combined(ex_map_numbers)
        #
        # # print(central_nodes, h_i_nodes)
        #
        # relations = itc_matrix(central_nodes, h_i_nodes, ma_thresh, ra_thresh)
        # if len(relations) > 0:
        #     # Build itc map
        #     map_id = build_itc_map(relations, s_l_i_nodes, h_l_i_nodes, s_l_nodes, h_l_nodes)

    elif aif_mode == "false" and han_mode == "false" and ex_aif_mode == "false":
        # Source Text and External Text
        s_map_numbers = do_amf_calls(source_text, False)
        central_nodes, s_l_i_nodes, s_l_nodes = centra.get_top_nodes_combined(s_map_numbers)

        ex_map_numbers = do_amf_calls(external_text, False)
        ex_i_nodes, ex_l_i_nodes, ex_l_nodes = centra.get_all_nodes_combined(ex_map_numbers)

        relations = itc_matrix(central_nodes, ex_i_nodes, ma_thresh, ra_thresh)
        if len(relations) > 0:
            # Build itc map
            map_id = build_itc_map(relations, s_l_i_nodes, ex_l_i_nodes, s_l_nodes, ex_l_nodes)

    elif aif_mode == "true" and han_mode == "false" and ex_aif_mode == "false":
        raise Exception("ERROR: the online propositionaliser is not available. Cannot invoke this")
        # # Source Text and External Text
        # # sources = source_text.split(',')
        # # s_map_numbers = [int(i) for i in sources]
        #
        # central_nodes, s_l_i_nodes, s_l_nodes = centra.get_top_nodes_combined(s_map_numbers)
        #
        # ex_map_numbers = do_amf_calls(external_text, False)
        # ex_i_nodes, ex_l_i_nodes, ex_l_nodes = centra.get_all_nodes_combined(ex_map_numbers)
        #
        # relations = itc_matrix(central_nodes, ex_i_nodes, ma_thresh, ra_thresh)
        # if len(relations) > 0:
        #     # Build itc map
        #     map_id = build_itc_map(relations, s_l_i_nodes, ex_l_i_nodes, s_l_nodes, ex_l_nodes)


    elif aif_mode == "false" and han_mode == "false" and ex_aif_mode == "true":
        raise Exception("ERROR: the online propositionaliser is not available. Cannot invoke this")
        # # Source Text and External Map
        #
        # s_map_numbers = do_amf_calls(source_text, False)
        # central_nodes, s_l_i_nodes, s_l_nodes = centra.get_top_nodes_combined(s_map_numbers)
        #
        # external = external_text.split(',')
        # ex_map_numbers = [int(i) for i in external]
        # ex_i_nodes, ex_l_i_nodes, ex_l_nodes = centra.get_all_nodes_combined(ex_map_numbers)
        #
        # relations = itc_matrix(central_nodes, ex_i_nodes, ma_thresh, ra_thresh)
        # if len(relations) > 0:
        #     # Build itc map
        #     map_id = build_itc_map(relations, s_l_i_nodes, ex_l_i_nodes, s_l_nodes, ex_l_nodes)

    # new_map_numbers = get_new_map_nums(source_text)
    # if (relations is not None) and (len(relations) > 0):
    #     itc_map_number = get_new_itc_map(map_id)
    #     itc_map_list = [itc_map_number]
    #     itc_map_view_list = create_argview_links(itc_map_list)
    #     itc_number = str(itc_map_view_list[0])
    #     itc_relations = [(rels[1], rels[3], rels[4]) for rels in relations]
    # else:
    #     itc_number = 'No ITC relations found'
    #     itc_relations = ['No ITC relations found']

    # source_map_numbers_links = create_argview_links(new_map_numbers)
    # ex_map_number_links = create_argview_links(external_text)

    return (None, None, None, None, None)

@application.route('/results')
def render_text():
    source_text = session.get('s_text', None)
    external_text = session.get('e_text', None)
    aif_mode = session.get('aif', None)
    han_mode = session.get('han', None)
    ex_aif_mode = session.get('e_aif', None)
    source_date = session.get('s_date', None)
    (source_map_numbers_links, ex_map_number_links, ex_map_number_links, itc_number, itc_relations) = actual_doing(source_text, external_text, aif_mode, han_mode, ex_aif_mode, source_date)
    return render_template('results.html', source_text=source_text, source_maps_links = source_map_numbers_links, ex_map_links = ex_map_number_links, itc_number=itc_number, itc_relations=itc_relations)

def create_argview_links(map_numbers):
    link_list = []
    for nodeset in map_numbers:
        link = 'http://www.aifdb.org/argview/' + str(nodeset)

        link_list.append(link)

    return link_list
def get_new_itc_map(nodeset_id):
    new_map_id = get_arg_schemes(nodeset_id)

    if new_map_id == '':
        return nodeset_id
    else:
        return new_map_id


def get_new_map_nums(s_map_numbers):
    new_maps = []
    for nodeset in s_map_numbers:
        new_map_id = get_arg_schemes(nodeset)
        if new_map_id == '':
            new_maps.append(nodeset)
        else:
            new_maps.append(new_map_id)
    return new_maps

def sent_to_df(txt):
    txt_pred = {'text': [txt]}
    df = pd.DataFrame(data=txt_pred)
    return df

def predict_topic(df):
    model_path = 'static/model/final_final_hansard_topic_model_seed.joblib'
    with application.open_resource(model_path) as load_m:
        loaded_m = load(load_m)
    pred = loaded_m.predict(df['text'])
    result = pred[0]
    return result

def get_hansard_file_path(input_date, topic, han_directory):
    files_list = []
    for subdir, dirs, files in os.walk(os.path.join(application.static_folder, han_directory)):
        for file_name in files:
            if 'txt' in file_name:
                full_path = subdir + '/' + file_name
                date = subdir.split(os.path.sep)[1]
                date = date.replace("-","")
                file = str(file_name).lower()
                file_tup = (full_path, date, file)
                files_list.append(file_tup)

    sorted_files = sorted(files_list, key=lambda tup: tup[1], reverse=True)
    input_date = input_date.replace('-', '')
    selected_file = ''
    for tup in sorted_files:
        date = tup[1]
        file_name = tup[2]
        file_path = tup[0]
        if input_date < date:
            continue
        else:
            if topic in file_name:
                selected_file = file_path

    if selected_file == '':
        for tup in sorted_files:
            date = tup[1]
            file_name = tup[2]
            file_path = tup[0]
            if topic in file_name:
                selected_file = file_path

    if not selected_file == '':
        selected_file = selected_file.split('/app/')[1]
    return selected_file

def get_hansard_text(file_path):

    with application.open_resource(file_path) as text_file:
        text = text_file.read()
    #text = text.encode('utf-8')
    return text

def text_to_lines(textData):
    fin_list = []
    lines_speakers = textData.splitlines(keepends=True)
    for line in lines_speakers:
        sentence_list = sent_tokenize(line)
        if len(sentence_list) > 0 and len(sentence_list) < 2:
            sent = sentence_list[0]
            if len(sent) > 0:
                fin_list.append(line)
        elif len(sentence_list) > 0:
            fin_list.append(line)

    return fin_list

def chunk_words(text_list):
    word_counter = 0
    chunks = []
    temp_list = []
    word_count_flag = False
    for line in text_list:
        words = line.split()
        word_counter += len(words)
        if word_counter > 700:
            word_counter = len(words)
            chunks.append(deepcopy(temp_list))
            temp_list = []
            word_count_flag = True
        temp_list.append(line)
    if word_counter < 700:
        chunks.append(deepcopy(temp_list))
    return chunks

def aif_upload(url, aif_data):
    aif_data = str(aif_data)
    filename = uuid.uuid4().hex
    filename = filename + '.json'
    with open(filename,"w") as fo:
        fo.write(aif_data)
    files = {
        'file': (filename, open(filename, 'rb')),
    }
    #get corpus ID

    aif_response = requests.post(url, files=files, auth=('test', 'pass'))
    #change this to pass the response back as text rather than as the full JSON output, this way we either pass back that a corpus was added to or a map uplaoded with map ID. Might be worth passing MAPID and Corpus name back in that situation.

    os.remove(filename)
    return aif_response.text

def post_turns(url,text_str):
    text_str = str(text_str)
    filename = uuid.uuid4().hex
    filename = filename + '.txt'
    with open(filename,"w") as fo:
        fo.write(text_str)
    files = {
        'file': (filename, open(filename, 'rb')),
    }
    #get corpus ID
    response = requests.post(url, files=files)
    os.remove(filename)
    return response

def post(url,text_str):
    #print(text_str)
    #text_str = str(text_str)
    filename = uuid.uuid4().hex
    filename = filename + '.txt'
    with open(filename,"w") as fo:
        fo.write(text_str)
    files = {
        'file': (filename, open(filename, 'rb')),
    }
    #get corpus ID

    response = requests.post(url, files=files)
    os.remove(filename)
    return response

def call_amf(chunks, test_flag):
    map_nums = []
    url_turn = 'http://turninator.arg.tech/turninator'
    url_props = 'http://propositionalizer.arg.tech/propositionalizer'
    url_aif = 'http://www.aifdb.org/json/'
    #URL for hosting outwith ARG-Tech Infrastrucutre
    url_inf = 'http://dam-02.arg.tech/dam-02'
    #url_inf = 'http://cicero.arg.tech:8092/dam-02'
    for i, chunk in enumerate(chunks):
        #print('######################################################')
        #print('Processing chunk ' + str(i) + ' of ' + str(len(chunks)))
        out_str = " ".join(chunk)
        out_str = out_str.replace('’', '')
        out_str = out_str.replace('‘', '')
        out_str = out_str.replace(',', '')
        out_str = out_str.replace('–', '')
        out_str = out_str.replace(')', '')
        out_str = out_str.replace('(', '')
        out_str = out_str.replace("/", '')
    #out_str = repr(out_str)
        word_count = len(out_str.split())
        #print(word_count)
    #print(out_str)
        #print('Getting Turns from AMF')
        prop_text_resp = post_turns(url_turn, out_str)
        prop_text = prop_text_resp.text
    #print(prop_text)
    #print(prop_text_resp)
        if prop_text == '':
        #print(prop_text)
            print('EMPTY return TURNS')
    #print(prop_text)
        #print('Getting Propositions from AMF')
        inf_text_resp = post(url_props, prop_text)
        inf_text = inf_text_resp.text
    #print(inf_text)
        if inf_text == '':
            print('EMPTY return PROPS')
        #break
        #print('Getting Inference relations from AMF')
        aif_json_resp = post(url_inf, inf_text)
        aif_json = aif_json_resp.text
    #print(aif_json)
        if aif_json == '':
            print('EMPTY return INF')
        #break
        #print('Uploading AIF to AIFdb')
    #print(aif_json)


    #Commented out so as to not ruin AIFdb

        map_response = aif_upload(url_aif, aif_json)
        map_data = json.loads(map_response)
        map_id = map_data['nodeSetID']
        map_nums.append(map_id)
        #print('Got nodeset ' + str(map_id) )
    #if test_flag:
    #    map_nums = [10670, 10671]
    #else:
    #    map_nums = [10672]
    return map_nums


def get_similarity(sent1, sent2):
    sent_sim = SentenceSimilarity()
    similarity = sent_sim.main(sent1, sent2)
    return similarity

def get_fuzzy_similarity(sent1, sent2):
    sim = fuzz.token_set_ratio(sent1,sent2)
    if sim == 0:
        return 0
    else:
        return sim/100
def get_alternate_wn_similarity(sent1, sent2):
    sent_sim = SentenceSimilarity()
    similarity = sent_sim.symmetric_sentence_similarity(sent1, sent2)
    return similarity

def check_sim_thresholds(similarity, premise, conclusion, ma_thresh, ra_thresh):
    negation_list = ['no', 'not', 'none', 'no one', 'nobody', 'nothing', 'neither', 'nowhere', 'never', 'hardly', 'scarcely', 'barely', 'doesnt', 'isnt', 'wasnt', 'shouldnt', 'wouldnt', 'couldnt', 'wont', 'cant', 'dont']
    if similarity > ma_thresh:
        return 'MA'
    if similarity > ra_thresh:
        negation_flag = False
        for neg in negation_list:
            premise = premise.lower()
            premise = premise.replace("'","")
            if neg in premise:
                negation_flag = True

        node_t = conclusion.lower()
        if 'xxx' in node_t or '/' in node_t:
            return ''
        node_p = premise.lower()
        if 'xxx' in node_p or '/' in node_p:
            return ''

        if negation_flag:
            return 'CA'
        else:
            return 'RA'
    else:
        return ''
def get_parsed_text(txt):
    pos_tok_list = ['SYM', 'DET', 'ADP', 'PUNCT', 'AUX', 'PART', 'SCONJ', 'X', 'CONJ']
    txt = process_text(txt)
    nlp = spacy.load("en")
    orig_doc = nlp(txt)
    sent = []
    sent_remove = []
    for token in orig_doc:
        pos_tok = token.pos_
        if 'PROPN' in pos_tok:
            sent.append('it')
        else:
            sent.append(token.text)
        if pos_tok in pos_tok_list:
            sent_remove.append(token.text)

    new_txt = ' '.join(sent)
    words = []
    doc = nlp(new_txt)
    for chunk in doc.noun_chunks:
        if 'nsubj' in chunk.root.dep_ or 'dobj' in chunk.root.dep_ or 'pobj' in chunk.root.dep_ or 'nmod' in chunk.root.dep_ or 'obl' in chunk.root.dep_:
            words.append(chunk.text)
            words.append(chunk.root.head.text)
    words = [i.strip() for i in words]
    res = list(set(words)^set(sent_remove))
    a = set(res)
    new_res = list(a)
    parsed_text = ' '.join(new_res)
    parsed_text = parsed_text.replace(".", "")
    parsed_text = parsed_text.replace(",", "")
    return parsed_text

def process_text(txt):
    txt = txt.lower()

    if 'but' in txt:
        txt = txt.split('but')[0]
    if 'because' in txt:
        txt = txt.split('because')[0]
    # and? .? ,? because?
    return txt

def get_topic_text(central_nodes_tup_list):
    overall_text = ''
    for tup in central_nodes_tup_list:
        txt = tup[1]
        parsed_text = get_parsed_text(txt)
        overall_text = overall_text + parsed_text + ' '
    return overall_text

def do_amf_calls(s_txt, test_flag):
    s_txt_lst = text_to_lines(s_txt)
    removetable = str.maketrans('', '', '@#%-;')
    out_list = [s.translate(removetable) for s in s_txt_lst]
    chunks = chunk_words(out_list)
    s_map_numbers = call_amf(chunks, test_flag)
    return s_map_numbers

def itc_matrix(source_nodes, other_nodes, ma_thresh, ra_thresh):
    relations = []
    for node in source_nodes:
        node_id = node[0]
        node_text = node[1]


        for ex_nodes in other_nodes:
            ex_id = ex_nodes[0]
            ex_text = ex_nodes[1]

            #node_parsed_text = get_parsed_text(node_text)
            #ex_parsed_text = get_parsed_text(ex_text)
            if ex_text == '' or node_text == '':
                continue
            else:
                similarity = get_similarity(node_text, ex_text)
                if similarity > 1 or similarity == 0:
                    #similarity = get_fuzzy_similarity(node_parsed_text, ex_parsed_text)
                    similarity = get_alternate_wn_similarity(node_text, ex_text)


                relation = check_sim_thresholds(similarity, ex_text, node_text, ma_thresh, ra_thresh)
                if relation == '':
                    continue
                else:
                    relation_tup = (node_id, node_text, ex_id, ex_text, relation)
                    relations.append(relation_tup)

    return relations


def check_hansard_path(hansard_fp):
    file_name = 'hansard_maps.csv'

    files_present = glob.glob(file_name)

    if not files_present:
        return ['']
    else:
        hansard_df = pd.read_csv(file_name)

        sel_df = hansard_df[hansard_df['filename'] == hansard_fp]
        if len(sel_df) < 1:
            return ['']
        else:
            sel_df.reset_index(inplace=True)
            return sel_df['map_id'][0]
def write_to_csv(map_numbers, hansard_fp):
    file_name = 'hansard_maps.csv'

    files_present = glob.glob(file_name)

    if not files_present:
        #create df and write
        df = pd.DataFrame({'filename': hansard_fp, 'map_id': [map_numbers]})
        df.to_csv(file_name)
    else:
        df = pd.DataFrame({'filename': hansard_fp, 'map_id': [map_numbers]})
        df.to_csv(file_name, mode='a', header=False)

def get_l_node_text(i_node_id, lnode_inode_list, l_node_list):
    for rel_tup in lnode_inode_list:
        lnode_id = rel_tup[0]
        inode_id = rel_tup[1]

        if i_node_id == inode_id:
            for tups in l_node_list:
                l_id = tups[0]
                if l_id == lnode_id:
                    ltext = tups[1]
                    return l_id, ltext
def build_itc_json(relations, aif_flags):
    node_list = []
    edge_list = []
    loc_list = []

    json_aif_dict = defaultdict(list)

    for i,rel in enumerate(relations):
        node_id = i + 1
        if not aif_flags:
            source_i_n = {"nodeID": "si" + str(node_id), "text": rel[0], "type": "I"}
            source_l_n = {"nodeID": "sl" + str(node_id), "text": rel[1], "type": "L"}
            ex_i_n = {"nodeID": "ei" + str(node_id), "text": rel[2], "type": "I"}
            ex_l_n = {"nodeID": "el" + str(node_id), "text": rel[3], "type": "L"}
            s_n = {"nodeID": "s" + str(node_id), "text": rel[5], "type": rel[4]}
            ya_n = {"nodeID": "ya" + str(node_id), "text": rel[6], "type": "YA"}
            ta_n = {"nodeID": "ta" + str(node_id), "text": "Default Transition", "type": "TA"}

            node_list.append(source_i_n)
            node_list.append(source_l_n)
            node_list.append(ex_i_n)
            node_list.append(ex_l_n)
            node_list.append(s_n)
            node_list.append(ya_n)
            node_list.append(ta_n)


            edge_1 = {"edgeID":"e" + str(node_id), "fromID":"el" + str(node_id), "toID":"ta" + str(node_id)}
            edge_2 = {"edgeID":"ee" + str(node_id), "fromID":"ta" + str(node_id), "toID":"sl" + str(node_id)}
            edge_3 = {"edgeID":"eee" + str(node_id), "fromID":"ta" + str(node_id), "toID":"ya" + str(node_id)}
            edge_4 = {"edgeID":"eeee" + str(node_id), "fromID":"ya" + str(node_id), "toID":"s" + str(node_id)}
            edge_5 = {"edgeID":"eeeee" + str(node_id), "fromID":"ei" + str(node_id), "toID":"s" + str(node_id)}
            edge_6 = {"edgeID":"eeeeee" + str(node_id), "fromID":"s" + str(node_id), "toID":"si" + str(node_id)}

            edge_list.append(edge_1)
            edge_list.append(edge_2)
            edge_list.append(edge_3)
            edge_list.append(edge_4)
            edge_list.append(edge_5)
            edge_list.append(edge_6)
        else:
            source_i_n = {"nodeID": "si" + str(node_id), "text": rel[0], "type": "I"}
            ex_i_n = {"nodeID": "ei" + str(node_id), "text": rel[1], "type": "I"}
            s_n = {"nodeID": "s" + str(node_id), "text": rel[3], "type": rel[2]}

            node_list.append(source_i_n)
            node_list.append(ex_i_n)
            node_list.append(s_n)


            edge_5 = {"edgeID":"eeeee" + str(node_id), "fromID":"ei" + str(node_id), "toID":"s" + str(node_id)}
            edge_6 = {"edgeID":"eeeeee" + str(node_id), "fromID":"s" + str(node_id), "toID":"si" + str(node_id)}

            edge_list.append(edge_5)
            edge_list.append(edge_6)




    json_aif_dict["nodes"].extend(node_list)
    json_aif_dict["edges"].extend(edge_list)
    json_aif_dict["locutions"].extend(loc_list)


    aif_json = json.dumps(json_aif_dict)
    return aif_json

def build_itc_map(relations, source_l_i_list, ex_l_i_list, source_l_list, ex_l_list):
    map_rels = []
    aif_flags = False
    if not source_l_i_list or not ex_l_i_list or not source_l_list or not ex_l_list:
        aif_flags = True
    for rel_tups in relations:
        s_i_id = rel_tups[0]
        s_i_text = rel_tups[1]
        ex_i_id = rel_tups[2]
        ex_i_text = rel_tups[3]
        rel = rel_tups[4]
        ya = ''
        scheme_text = ''
        # call get_l_node_text for each i_id to get L

        if not aif_flags:
            source_l = get_l_node_text(s_i_id, source_l_i_list, source_l_list)
            ex_l = get_l_node_text(ex_i_id, ex_l_i_list, ex_l_list)


            s_l_id = source_l[0]
            s_l_text = source_l[1]

            ex_l_id = ex_l[0]
            ex_l_text = ex_l[1]


        if rel == 'MA':
            ya = 'Restating'
            scheme_text = 'Default Rephrase'
        elif rel == 'RA':
            ya = 'Arguing'
            scheme_text = 'Default Inference'
        elif rel == 'CA':
            ya = 'Disagreeing'
            scheme_text = 'Default Conflict'

        if not aif_flags:

            rel_tuple = (s_i_text, s_l_text, ex_i_text, ex_l_text, rel, scheme_text, ya)
            map_rels.append(rel_tuple)
        else:
            rel_tuple = (s_i_text, ex_i_text, rel, scheme_text)
            map_rels.append(rel_tuple)

    aif_json = build_itc_json(map_rels, aif_flags)
    url_aif = 'http://www.aifdb.org/json/'
    map_response = aif_upload(url_aif, aif_json)
    map_data = json.loads(map_response)
    map_id = map_data['nodeSetID']

    return map_id


def get_arg_schemes(json_data):
    cent = Centrality()

    # j_url = cent.create_json_url(str(nodeset),True)
    # graph = cent.get_graph_url(j_url)
    # json_data = get_json_string(j_url)

    ras = cent.get_ras(graph)
    ras_i_list = cent.get_ra_i_nodes(graph, ras)

    ra_changes = []
    for ns in ras_i_list:
        ra_id = ns[0]
        s_id = ns[1]
        e_id = ns[2]

        schemes = identifyScheme(e_id, s_id)

        if len(schemes) < 1:
            continue
        else:
            ra_tup = (ra_id, schemes[0])
            ra_changes.append(ra_tup)
            #get json string and replace text at ID then upload

    print(ra_changes)
    if len(ra_changes) < 1:
        return ''
    else:
        n_json_data = replace_node(json_data, ra_changes)
        url_aif = 'http://www.aifdb.org/json/'
        jsn_data = json.dumps(n_json_data)
        map_response = aif_upload(url_aif, jsn_data)
        map_data = json.loads(map_response)
        fin_map_id = map_data['nodeSetID']


    return fin_map_id


def get_json_string(node_path):
    try:
        jsn_string = requests.get(node_path).text
        strng_ind = jsn_string.index('{')
        n_string = jsn_string[strng_ind:]
        dta = json.loads(n_string)
    except(IOError):
        print('File was not found:')
        print(node_path)

    return dta
def replace_node(json_data, node_list):
    #json_data_dict = json.loads(json_data)

    for ns in node_list:
        n_id = ns[0]
        new_text = ns[1]
        for nodes in json_data['nodes']:
            json_n_id = nodes['nodeID']
            if str(n_id) == str(json_n_id):
                nodes['text'] = new_text

    return json_data

def identifyScheme(premise, conclusion):
    identifiedSchemes = []

    if (("similar" in premise or "generally" in premise) and ("be" in conclusion or "to be" in conclusion)):
        identifiedSchemes.append("Analogy")

    elif ("generally" in premise or "occur" in premise) or ("occur" in conclusion) :
        identifiedSchemes.append("CauseToEffect")

    elif("goal" in premise or "action" in premise) or ("ought" in conclusion or "perform" in conclusion) :
        identifiedSchemes.append("PracticalReasoning")

    elif(("all" in premise or "if" in premise) and ("be" in conclusion or "to be" in conclusion)) :
        identifiedSchemes.append("VerbalClassification")

    elif((("expert" in premise or "experience" in premise or "skill" in premise) and "said" in premise) and ("be" in conclusion or "to be" in conclusion)) :
        identifiedSchemes.append("ExpertOpinion")

    elif(("occur" in premise or "happen" in premise) and ("should" in conclusion or "must" in conclusion)) :
        identifiedSchemes.append("PositiveConsequences")

    return identifiedSchemes

