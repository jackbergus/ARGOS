import json
import sys

import math as python_lib_Math
import math as Math
import inspect as python_lib_Inspect
import sys as python_lib_Sys
import functools as python_lib_Functools
import json as python_lib_Json
import random as python_lib_Random
import re as python_lib_Re
import socket as python_lib_Socket
import ssl as python_lib_Ssl
import time as python_lib_Time
import traceback as python_lib_Traceback
from datetime import datetime as python_lib_datetime_Datetime
from datetime import timezone as python_lib_datetime_Timezone
from io import StringIO as python_lib_io_StringIO
from socket import socket as python_lib_socket_Socket
from ssl import SSLContext as python_lib_ssl_SSLContext
import urllib.parse as python_lib_urllib_Parse

from services.all_dgdl_plus import Generaliser


class _hx_AnonObject:
    _hx_disable_getattr = False
    def __init__(self, fields):
        self.__dict__ = fields
    def __repr__(self):
        return repr(self.__dict__)
    def __contains__(self, item):
        return item in self.__dict__
    def __getitem__(self, item):
        return self.__dict__[item]
    def __getattr__(self, name):
        if (self._hx_disable_getattr):
            raise AttributeError('field does not exist')
        else:
            return None
    def _hx_hasattr(self,field):
        self._hx_disable_getattr = True
        try:
            getattr(self, field)
            self._hx_disable_getattr = False
            return True
        except AttributeError:
            self._hx_disable_getattr = False
            return False



class Enum:
    _hx_class_name = "Enum"
    __slots__ = ("tag", "index", "params")
    _hx_fields = ["tag", "index", "params"]
    _hx_methods = ["__str__"]

    def __init__(self,tag,index,params):
        self.tag = tag
        self.index = index
        self.params = params

    def __str__(self):
        if (self.params is None):
            return self.tag
        else:
            return self.tag + '(' + (', '.join(str(v) for v in self.params)) + ')'

    @staticmethod
    def _hx_empty_init(_hx_o):
        _hx_o.tag = None
        _hx_o.index = None
        _hx_o.params = None
Enum._hx_class = Enum


class Class: pass


class Date:
    _hx_class_name = "Date"
    __slots__ = ("date", "dateUTC")
    _hx_fields = ["date", "dateUTC"]
    _hx_methods = ["toString"]
    _hx_statics = ["makeLocal"]

    def __init__(self,year,month,day,hour,_hx_min,sec):
        self.dateUTC = None
        if (year < python_lib_datetime_Datetime.min.year):
            year = python_lib_datetime_Datetime.min.year
        if (day == 0):
            day = 1
        self.date = Date.makeLocal(python_lib_datetime_Datetime(year,(month + 1),day,hour,_hx_min,sec,0))
        self.dateUTC = self.date.astimezone(python_lib_datetime_Timezone.utc)

    def toString(self):
        return self.date.strftime("%Y-%m-%d %H:%M:%S")

    @staticmethod
    def makeLocal(date):
        try:
            return date.astimezone()
        except BaseException as _g:
            None
            tzinfo = python_lib_datetime_Datetime.now(python_lib_datetime_Timezone.utc).astimezone().tzinfo
            return date.replace(**python__KwArgs_KwArgs_Impl_.fromT(_hx_AnonObject({'tzinfo': tzinfo})))

    @staticmethod
    def _hx_empty_init(_hx_o):
        _hx_o.date = None
        _hx_o.dateUTC = None
Date._hx_class = Date


class EReg:
    _hx_class_name = "EReg"
    __slots__ = ("pattern", "matchObj", "_hx_global")
    _hx_fields = ["pattern", "matchObj", "global"]

    def __init__(self,r,opt):
        self.matchObj = None
        self._hx_global = False
        options = 0
        _g = 0
        _g1 = len(opt)
        while (_g < _g1):
            i = _g
            _g = (_g + 1)
            c = (-1 if ((i >= len(opt))) else ord(opt[i]))
            if (c == 109):
                options = (options | python_lib_Re.M)
            if (c == 105):
                options = (options | python_lib_Re.I)
            if (c == 115):
                options = (options | python_lib_Re.S)
            if (c == 117):
                options = (options | python_lib_Re.U)
            if (c == 103):
                self._hx_global = True
        self.pattern = python_lib_Re.compile(r,options)

    @staticmethod
    def _hx_empty_init(_hx_o):
        _hx_o.pattern = None
        _hx_o.matchObj = None
        _hx_o._hx_global = None
EReg._hx_class = EReg


class json2object_reader_BaseParser:
    _hx_class_name = "json2object.reader.BaseParser"
    __slots__ = ("value", "errors", "errorType", "putils")
    _hx_fields = ["value", "errors", "errorType", "putils"]
    _hx_methods = ["fromJson", "loadJson", "loadJsonNull", "loadJsonString", "loadString", "loadJsonNumber", "loadJsonUInt", "loadJsonInt", "loadJsonFloat", "loadJsonBool", "loadJsonArray", "loadJsonArrayValue", "loadJsonObject", "loadObjectField", "loadObjectFieldReflect", "objectSetupAssign", "objectErrors", "onIncorrectType", "parsingThrow", "objectThrow", "mapSet"]

    def __init__(self,errors,putils,errorType):
        self.value = None
        self.errors = errors
        self.putils = putils
        self.errorType = errorType

    def fromJson(self,jsonString,filename = None):
        if (filename is None):
            filename = ""
        self.putils = json2object_PositionUtils(jsonString)
        self.errors = []
        try:
            json = hxjsonast_Parser(jsonString,filename).doParse()
            self.loadJson(json)
        except BaseException as _g:
            None
            _g1 = haxe_Exception.caught(_g).unwrap()
            if Std.isOfType(_g1,hxjsonast_Error):
                e = _g1
                _this = self.errors
                x = json2object_Error.ParserError(e.message,self.putils.convertPosition(e.pos))
                _this.append(x)
            else:
                raise _g
        return self.value

    def loadJson(self,json,variable = None):
        if (variable is None):
            variable = ""
        pos = self.putils.convertPosition(json.pos)
        _g = json.value
        tmp = _g.index
        if (tmp == 0):
            s = _g.params[0]
            self.loadJsonString(s,pos,variable)
        elif (tmp == 1):
            n = _g.params[0]
            self.loadJsonNumber(n,pos,variable)
        elif (tmp == 2):
            o = _g.params[0]
            self.loadJsonObject(o,pos,variable)
        elif (tmp == 3):
            a = _g.params[0]
            self.loadJsonArray(a,pos,variable)
        elif (tmp == 4):
            b = _g.params[0]
            self.loadJsonBool(b,pos,variable)
        elif (tmp == 5):
            self.loadJsonNull(pos,variable)
        else:
            pass
        return self.value

    def loadJsonNull(self,pos,variable):
        self.onIncorrectType(pos,variable)

    def loadJsonString(self,s,pos,variable):
        self.onIncorrectType(pos,variable)

    def loadString(self,s,pos,variable,validValues,defaultValue):
        if (python_internal_ArrayImpl.indexOf(validValues,s,None) != -1):
            return s
        self.onIncorrectType(pos,variable)
        return defaultValue

    def loadJsonNumber(self,f,pos,variable):
        self.onIncorrectType(pos,variable)

    def loadJsonUInt(self,f,pos,variable,value):
        uint = 0
        f = StringTools.trim(f)
        neg = ((("" if ((0 >= len(f))) else f[0])) == "-")
        if neg:
            f = HxString.substr(f,1,None)
        hex = f.startswith("0x")
        if hex:
            f = HxString.substr(f,2,None)
        base = (16 if hex else 10)
        pow = 1
        i = (len(f) - 1)
        while (i >= 0):
            cur = (Std.parseInt(("0x" + HxOverrides.stringOrNull((("" if (((i < 0) or ((i >= len(f))))) else f[i]))))) if hex else Std.parseInt(("" if (((i < 0) or ((i >= len(f))))) else f[i])))
            if (cur is None):
                self.onIncorrectType(pos,variable)
                return value
            uint = (uint + ((pow * cur)))
            pow = (pow * base)
            i = (i - 1)
        return uint

    def loadJsonInt(self,f,pos,variable,value):
        if ((Std.parseInt(f) is not None) and ((Std.parseInt(f) == Std.parseFloat(f)))):
            return Std.parseInt(f)
        self.onIncorrectType(pos,variable)
        return value

    def loadJsonFloat(self,f,pos,variable,value):
        if (Std.parseInt(f) is not None):
            return Std.parseFloat(f)
        self.onIncorrectType(pos,variable)
        return value

    def loadJsonBool(self,b,pos,variable):
        self.onIncorrectType(pos,variable)

    def loadJsonArray(self,a,pos,variable):
        self.onIncorrectType(pos,variable)

    def loadJsonArrayValue(self,a,loadJsonFn,variable):
        _g = []
        _g1 = 0
        while (_g1 < len(a)):
            j = (a[_g1] if _g1 >= 0 and _g1 < len(a) else None)
            _g1 = (_g1 + 1)
            x = None
            try:
                x = loadJsonFn(j,variable)
            except BaseException as _g2:
                None
                _g3 = haxe_Exception.caught(_g2).unwrap()
                if Std.isOfType(_g3,json2object_InternalError):
                    e = _g3
                    if (e != json2object_InternalError.ParsingThrow):
                        raise haxe_Exception.thrown(e)
                    continue
                else:
                    raise _g2
            _g.append(x)
        return _g

    def loadJsonObject(self,o,pos,variable):
        self.onIncorrectType(pos,variable)

    def loadObjectField(self,loadJsonFn,field,name,assigned,defaultValue,pos):
        try:
            ret = loadJsonFn(field.value,field.name)
            assigned.h[name] = True
            return ret
        except BaseException as _g:
            None
            _g1 = haxe_Exception.caught(_g).unwrap()
            if Std.isOfType(_g1,json2object_InternalError):
                e = _g1
                if (e != json2object_InternalError.ParsingThrow):
                    raise haxe_Exception.thrown(e)
            else:
                e = _g1
                _this = self.errors
                _this.append(json2object_Error.CustomFunctionException(e,pos))
        return defaultValue

    def loadObjectFieldReflect(self,loadJsonFn,field,name,assigned,pos):
        try:
            o = self.value
            value = loadJsonFn(field.value,field.name)
            setattr(o,(("_hx_" + name) if ((name in python_Boot.keywords)) else (("_hx_" + name) if (((((len(name) > 2) and ((ord(name[0]) == 95))) and ((ord(name[1]) == 95))) and ((ord(name[(len(name) - 1)]) != 95)))) else name)),value)
            assigned.h[name] = True
        except BaseException as _g:
            None
            _g1 = haxe_Exception.caught(_g).unwrap()
            if Std.isOfType(_g1,json2object_InternalError):
                e = _g1
                if (e != json2object_InternalError.ParsingThrow):
                    raise haxe_Exception.thrown(e)
            else:
                e = _g1
                _this = self.errors
                _this.append(json2object_Error.CustomFunctionException(e,pos))

    def objectSetupAssign(self,assigned,keys,values):
        _g = 0
        _g1 = len(keys)
        while (_g < _g1):
            i = _g
            _g = (_g + 1)
            assigned.h[(keys[i] if i >= 0 and i < len(keys) else None)] = (values[i] if i >= 0 and i < len(values) else None)

    def objectErrors(self,assigned,pos):
        lastPos = self.putils.convertPosition(hxjsonast_Position(pos.file,(pos.max - 1),(pos.max - 1)))
        s = assigned.keys()
        while s.hasNext():
            s1 = s.next()
            if (not assigned.h.get(s1,None)):
                _this = self.errors
                _this.append(json2object_Error.UninitializedVariable(s1,lastPos))

    def onIncorrectType(self,pos,variable):
        self.parsingThrow()

    def parsingThrow(self):
        if (self.errorType != 0):
            raise haxe_Exception.thrown(json2object_InternalError.ParsingThrow)

    def objectThrow(self,pos,variable):
        if (self.errorType == 2):
            raise haxe_Exception.thrown(json2object_InternalError.ParsingThrow)
        if (self.errorType == 1):
            _this = self.errors
            _this.append(json2object_Error.UninitializedVariable(variable,pos))

    def mapSet(self,_hx_map,key,value):
        _hx_map.h[key] = value

    @staticmethod
    def _hx_empty_init(_hx_o):
        _hx_o.value = None
        _hx_o.errors = None
        _hx_o.errorType = None
        _hx_o.putils = None
json2object_reader_BaseParser._hx_class = json2object_reader_BaseParser


class JsonParser_1(json2object_reader_BaseParser):
    _hx_class_name = "JsonParser_1"
    __slots__ = ()
    _hx_fields = []
    _hx_methods = ["onIncorrectType", "loadJsonNull", "loadJsonArray", "getAuto"]
    _hx_statics = []
    _hx_interfaces = []
    _hx_super = json2object_reader_BaseParser


    def __init__(self,errors = None,putils = None,errorType = None):
        if (errorType is None):
            errorType = 0
        super().__init__(errors,putils,errorType)

    def onIncorrectType(self,pos,variable):
        _this = self.errors
        _this.append(json2object_Error.IncorrectType(variable,"haxe.ds.List<jackbergus.dgep.internals.Move>",pos))
        super().onIncorrectType(pos,variable)

    def loadJsonNull(self,pos,variable):
        self.value = None

    def loadJsonArray(self,a,pos,variable):
        parser = JsonParser_2(self.errors,self.putils,2)
        res = haxe_ds_List()
        _g = 0
        while (_g < len(a)):
            j = (a[_g] if _g >= 0 and _g < len(a) else None)
            _g = (_g + 1)
            try:
                res.add(parser.loadJson(j,variable))
            except BaseException as _g1:
                None
                _g2 = haxe_Exception.caught(_g1).unwrap()
                if Std.isOfType(_g2,json2object_InternalError):
                    e = _g2
                    if (e != json2object_InternalError.ParsingThrow):
                        raise haxe_Exception.thrown(e)
                else:
                    raise _g1
        self.value = res

    def getAuto(self):
        return JsonParser_1([],self.putils,0).loadJson(hxjsonast_Json(hxjsonast_JsonValue.JNull,hxjsonast_Position("",0,1)))

    @staticmethod
    def _hx_empty_init(_hx_o):        pass
JsonParser_1._hx_class = JsonParser_1


class JsonParser_11(json2object_reader_BaseParser):
    _hx_class_name = "JsonParser_11"
    __slots__ = ()
    _hx_fields = []
    _hx_methods = ["onIncorrectType", "loadJsonNull", "loadJsonObject", "getAuto"]
    _hx_statics = []
    _hx_interfaces = []
    _hx_super = json2object_reader_BaseParser


    def __init__(self,errors = None,putils = None,errorType = None):
        if (errorType is None):
            errorType = 0
        super().__init__(errors,putils,errorType)

    def onIncorrectType(self,pos,variable):
        _this = self.errors
        _this.append(json2object_Error.IncorrectType(variable,"haxe.ds.Map<String, jackbergus.dgep.messages.ProtocolList>",pos))
        super().onIncorrectType(pos,variable)

    def loadJsonNull(self,pos,variable):
        self.value = None

    def loadJsonObject(self,o,pos,variable):
        self.value = haxe_ds_StringMap()
        _g = 0
        while (_g < len(o)):
            field = (o[_g] if _g >= 0 and _g < len(o) else None)
            _g = (_g + 1)
            this1 = self.value
            key = None
            try:
                key1 = JsonParser_5(self.errors,self.putils,2)
                _this = self.putils
                key = key1.loadJson(hxjsonast_Json(hxjsonast_JsonValue.JString(field.name),hxjsonast_Position(pos.file,(pos.min - 1),(pos.max - 1))),variable)
            except BaseException as _g1:
                None
                _g2 = haxe_Exception.caught(_g1).unwrap()
                if Std.isOfType(_g2,json2object_InternalError):
                    e = _g2
                    if (e != json2object_InternalError.ParsingThrow):
                        raise haxe_Exception.thrown(e)
                    continue
                else:
                    raise _g1
            value = None
            try:
                value = JsonParser_13(self.errors,self.putils,2).loadJson(field.value,field.name)
            except BaseException as _g3:
                None
                _g4 = haxe_Exception.caught(_g3).unwrap()
                if Std.isOfType(_g4,json2object_InternalError):
                    e1 = _g4
                    if (e1 != json2object_InternalError.ParsingThrow):
                        raise haxe_Exception.thrown(e1)
                    continue
                else:
                    raise _g3
            this1.h[key] = value

    def getAuto(self):
        return JsonParser_11([],self.putils,0).loadJson(hxjsonast_Json(hxjsonast_JsonValue.JNull,hxjsonast_Position("",0,1)))

    @staticmethod
    def _hx_empty_init(_hx_o):        pass
JsonParser_11._hx_class = JsonParser_11


class JsonParser_13(json2object_reader_BaseParser):
    _hx_class_name = "JsonParser_13"
    __slots__ = ()
    _hx_fields = []
    _hx_methods = ["onIncorrectType", "loadJsonNull", "loadJsonObject", "getAuto"]
    _hx_statics = []
    _hx_interfaces = []
    _hx_super = json2object_reader_BaseParser


    def __init__(self,errors = None,putils = None,errorType = None):
        if (errorType is None):
            errorType = 0
        super().__init__(errors,putils,errorType)

    def onIncorrectType(self,pos,variable):
        _this = self.errors
        _this.append(json2object_Error.IncorrectType(variable,"{ players : List<String>, description : String }",pos))
        super().onIncorrectType(pos,variable)

    def loadJsonNull(self,pos,variable):
        self.value = None

    def loadJsonObject(self,o,pos,variable):
        assigned = haxe_ds_StringMap()
        self.objectSetupAssign(assigned,["description", "players"],[False, False])
        self.value = self.getAuto()
        _g = 0
        while (_g < len(o)):
            field = (o[_g] if _g >= 0 and _g < len(o) else None)
            _g = (_g + 1)
            _g1 = field.name
            _hx_local_1 = len(_g1)
            if (_hx_local_1 == 11):
                if (_g1 == "description"):
                    self.value.description = self.loadObjectField(JsonParser_5(self.errors,self.putils,1).loadJson,field,"description",assigned,self.value.description,pos)
                else:
                    _this = self.errors
                    x = json2object_Error.UnknownVariable(field.name,self.putils.convertPosition(field.namePos))
                    _this.append(x)
            elif (_hx_local_1 == 7):
                if (_g1 == "players"):
                    self.value.players = self.loadObjectField(JsonParser_15(self.errors,self.putils,1).loadJson,field,"players",assigned,self.value.players,pos)
                else:
                    _this = self.errors
                    x = json2object_Error.UnknownVariable(field.name,self.putils.convertPosition(field.namePos))
                    _this.append(x)
            else:
                _this = self.errors
                x = json2object_Error.UnknownVariable(field.name,self.putils.convertPosition(field.namePos))
                _this.append(x)
        self.objectErrors(assigned,pos)

    def getAuto(self):
        return _hx_AnonObject({'description': "", 'players': haxe_ds_List()})

    @staticmethod
    def _hx_empty_init(_hx_o):        pass
JsonParser_13._hx_class = JsonParser_13


class JsonParser_15(json2object_reader_BaseParser):
    _hx_class_name = "JsonParser_15"
    __slots__ = ()
    _hx_fields = []
    _hx_methods = ["onIncorrectType", "loadJsonNull", "loadJsonArray", "getAuto"]
    _hx_statics = []
    _hx_interfaces = []
    _hx_super = json2object_reader_BaseParser


    def __init__(self,errors = None,putils = None,errorType = None):
        if (errorType is None):
            errorType = 0
        super().__init__(errors,putils,errorType)

    def onIncorrectType(self,pos,variable):
        _this = self.errors
        _this.append(json2object_Error.IncorrectType(variable,"haxe.ds.List<String>",pos))
        super().onIncorrectType(pos,variable)

    def loadJsonNull(self,pos,variable):
        self.value = None

    def loadJsonArray(self,a,pos,variable):
        parser = JsonParser_5(self.errors,self.putils,2)
        res = haxe_ds_List()
        _g = 0
        while (_g < len(a)):
            j = (a[_g] if _g >= 0 and _g < len(a) else None)
            _g = (_g + 1)
            try:
                res.add(parser.loadJson(j,variable))
            except BaseException as _g1:
                None
                _g2 = haxe_Exception.caught(_g1).unwrap()
                if Std.isOfType(_g2,json2object_InternalError):
                    e = _g2
                    if (e != json2object_InternalError.ParsingThrow):
                        raise haxe_Exception.thrown(e)
                else:
                    raise _g1
        self.value = res

    def getAuto(self):
        return JsonParser_15([],self.putils,0).loadJson(hxjsonast_Json(hxjsonast_JsonValue.JNull,hxjsonast_Position("",0,1)))

    @staticmethod
    def _hx_empty_init(_hx_o):        pass
JsonParser_15._hx_class = JsonParser_15


class JsonParser_16(json2object_reader_BaseParser):
    _hx_class_name = "JsonParser_16"
    __slots__ = ()
    _hx_fields = []
    _hx_methods = ["onIncorrectType", "loadJsonNull", "loadJsonObject", "getAuto"]
    _hx_statics = []
    _hx_interfaces = []
    _hx_super = json2object_reader_BaseParser


    def __init__(self,errors = None,putils = None,errorType = None):
        if (errorType is None):
            errorType = 0
        super().__init__(errors,putils,errorType)

    def onIncorrectType(self,pos,variable):
        _this = self.errors
        _this.append(json2object_Error.IncorrectType(variable,"jackbergus.dgep.messages.ProtocolMessage",pos))
        super().onIncorrectType(pos,variable)

    def loadJsonNull(self,pos,variable):
        self.value = None

    def loadJsonObject(self,o,pos,variable):
        assigned = haxe_ds_StringMap()
        self.objectSetupAssign(assigned,["message", "protocol"],[False, False])
        self.value = self.getAuto()
        _g = 0
        while (_g < len(o)):
            field = (o[_g] if _g >= 0 and _g < len(o) else None)
            _g = (_g + 1)
            _g1 = field.name
            _hx_local_1 = len(_g1)
            if (_hx_local_1 == 7):
                if (_g1 == "message"):
                    self.value.message = self.loadObjectField(JsonParser_5(self.errors,self.putils,1).loadJson,field,"message",assigned,self.value.message,pos)
                else:
                    _this = self.errors
                    x = json2object_Error.UnknownVariable(field.name,self.putils.convertPosition(field.namePos))
                    _this.append(x)
            elif (_hx_local_1 == 8):
                if (_g1 == "protocol"):
                    self.value.protocol = self.loadObjectField(JsonParser_5(self.errors,self.putils,1).loadJson,field,"protocol",assigned,self.value.protocol,pos)
                else:
                    _this = self.errors
                    x = json2object_Error.UnknownVariable(field.name,self.putils.convertPosition(field.namePos))
                    _this.append(x)
            else:
                _this = self.errors
                x = json2object_Error.UnknownVariable(field.name,self.putils.convertPosition(field.namePos))
                _this.append(x)
        self.objectErrors(assigned,pos)

    def getAuto(self):
        value = Type.createEmptyInstance(jackbergus_dgep_messages_ProtocolMessage)
        value.message = JsonParser_5([],self.putils,0).loadJson(hxjsonast_Json(hxjsonast_JsonValue.JNull,hxjsonast_Position("",0,1)))
        value.protocol = JsonParser_5([],self.putils,0).loadJson(hxjsonast_Json(hxjsonast_JsonValue.JNull,hxjsonast_Position("",0,1)))
        return value

    @staticmethod
    def _hx_empty_init(_hx_o):        pass
JsonParser_16._hx_class = JsonParser_16


class JsonParser_2(json2object_reader_BaseParser):
    _hx_class_name = "JsonParser_2"
    __slots__ = ()
    _hx_fields = []
    _hx_methods = ["onIncorrectType", "loadJsonNull", "loadJsonObject", "getAuto"]
    _hx_statics = []
    _hx_interfaces = []
    _hx_super = json2object_reader_BaseParser


    def __init__(self,errors = None,putils = None,errorType = None):
        if (errorType is None):
            errorType = 0
        super().__init__(errors,putils,errorType)

    def onIncorrectType(self,pos,variable):
        _this = self.errors
        _this.append(json2object_Error.IncorrectType(variable,"jackbergus.dgep.internals.Move",pos))
        super().onIncorrectType(pos,variable)

    def loadJsonNull(self,pos,variable):
        self.value = None

    def loadJsonObject(self,o,pos,variable):
        assigned = haxe_ds_StringMap()
        self.objectSetupAssign(assigned,["reply", "opener", "moveID", "target"],[False, False, False, False])
        self.value = self.getAuto()
        _g = 0
        while (_g < len(o)):
            field = (o[_g] if _g >= 0 and _g < len(o) else None)
            _g = (_g + 1)
            _g1 = field.name
            _hx_local_1 = len(_g1)
            if (_hx_local_1 == 5):
                if (_g1 == "reply"):
                    self.value.reply = self.loadObjectField(JsonParser_4(self.errors,self.putils,1).loadJson,field,"reply",assigned,self.value.reply,pos)
                else:
                    _this = self.errors
                    x = json2object_Error.UnknownVariable(field.name,self.putils.convertPosition(field.namePos))
                    _this.append(x)
            elif (_hx_local_1 == 6):
                if (_g1 == "moveID"):
                    self.value.moveID = self.loadObjectField(JsonParser_5(self.errors,self.putils,1).loadJson,field,"moveID",assigned,self.value.moveID,pos)
                elif (_g1 == "opener"):
                    self.value.opener = self.loadObjectField(JsonParser_5(self.errors,self.putils,1).loadJson,field,"opener",assigned,self.value.opener,pos)
                elif (_g1 == "target"):
                    self.value.target = self.loadObjectField(JsonParser_5(self.errors,self.putils,1).loadJson,field,"target",assigned,self.value.target,pos)
                else:
                    _this = self.errors
                    x = json2object_Error.UnknownVariable(field.name,self.putils.convertPosition(field.namePos))
                    _this.append(x)
            else:
                _this = self.errors
                x = json2object_Error.UnknownVariable(field.name,self.putils.convertPosition(field.namePos))
                _this.append(x)
        self.objectErrors(assigned,pos)

    def getAuto(self):
        value = Type.createEmptyInstance(jackbergus_dgep_internals_Move)
        value.reply = haxe_ds_StringMap()
        value.opener = ""
        value.moveID = ""
        value.target = ""
        return value

    @staticmethod
    def _hx_empty_init(_hx_o):        pass
JsonParser_2._hx_class = JsonParser_2


class JsonParser_4(json2object_reader_BaseParser):
    _hx_class_name = "JsonParser_4"
    __slots__ = ()
    _hx_fields = []
    _hx_methods = ["onIncorrectType", "loadJsonNull", "loadJsonObject", "getAuto"]
    _hx_statics = []
    _hx_interfaces = []
    _hx_super = json2object_reader_BaseParser


    def __init__(self,errors = None,putils = None,errorType = None):
        if (errorType is None):
            errorType = 0
        super().__init__(errors,putils,errorType)

    def onIncorrectType(self,pos,variable):
        _this = self.errors
        _this.append(json2object_Error.IncorrectType(variable,"haxe.ds.Map<String, String>",pos))
        super().onIncorrectType(pos,variable)

    def loadJsonNull(self,pos,variable):
        self.value = None

    def loadJsonObject(self,o,pos,variable):
        self.value = haxe_ds_StringMap()
        _g = 0
        while (_g < len(o)):
            field = (o[_g] if _g >= 0 and _g < len(o) else None)
            _g = (_g + 1)
            this1 = self.value
            key = None
            try:
                key1 = JsonParser_5(self.errors,self.putils,2)
                _this = self.putils
                key = key1.loadJson(hxjsonast_Json(hxjsonast_JsonValue.JString(field.name),hxjsonast_Position(pos.file,(pos.min - 1),(pos.max - 1))),variable)
            except BaseException as _g1:
                None
                _g2 = haxe_Exception.caught(_g1).unwrap()
                if Std.isOfType(_g2,json2object_InternalError):
                    e = _g2
                    if (e != json2object_InternalError.ParsingThrow):
                        raise haxe_Exception.thrown(e)
                    continue
                else:
                    raise _g1
            value = None
            try:
                value = JsonParser_5(self.errors,self.putils,2).loadJson(field.value,field.name)
            except BaseException as _g3:
                None
                _g4 = haxe_Exception.caught(_g3).unwrap()
                if Std.isOfType(_g4,json2object_InternalError):
                    e1 = _g4
                    if (e1 != json2object_InternalError.ParsingThrow):
                        raise haxe_Exception.thrown(e1)
                    continue
                else:
                    raise _g3
            this1.h[key] = value

    def getAuto(self):
        return JsonParser_4([],self.putils,0).loadJson(hxjsonast_Json(hxjsonast_JsonValue.JNull,hxjsonast_Position("",0,1)))

    @staticmethod
    def _hx_empty_init(_hx_o):        pass
JsonParser_4._hx_class = JsonParser_4


class JsonParser_5(json2object_reader_BaseParser):
    _hx_class_name = "JsonParser_5"
    __slots__ = ()
    _hx_fields = []
    _hx_methods = ["onIncorrectType", "loadJsonNull", "loadJsonString", "getAuto"]
    _hx_statics = []
    _hx_interfaces = []
    _hx_super = json2object_reader_BaseParser


    def __init__(self,errors = None,putils = None,errorType = None):
        if (errorType is None):
            errorType = 0
        super().__init__(errors,putils,errorType)

    def onIncorrectType(self,pos,variable):
        _this = self.errors
        _this.append(json2object_Error.IncorrectType(variable,"String",pos))
        super().onIncorrectType(pos,variable)

    def loadJsonNull(self,pos,variable):
        self.value = None

    def loadJsonString(self,s,pos,variable):
        self.value = s

    def getAuto(self):
        return JsonParser_5([],self.putils,0).loadJson(hxjsonast_Json(hxjsonast_JsonValue.JNull,hxjsonast_Position("",0,1)))

    @staticmethod
    def _hx_empty_init(_hx_o):        pass
JsonParser_5._hx_class = JsonParser_5


class JsonParser_6(json2object_reader_BaseParser):
    _hx_class_name = "JsonParser_6"
    __slots__ = ()
    _hx_fields = []
    _hx_methods = ["onIncorrectType", "loadJsonNull", "loadJsonObject", "getAuto"]
    _hx_statics = []
    _hx_interfaces = []
    _hx_super = json2object_reader_BaseParser


    def __init__(self,errors = None,putils = None,errorType = None):
        if (errorType is None):
            errorType = 0
        super().__init__(errors,putils,errorType)

    def onIncorrectType(self,pos,variable):
        _this = self.errors
        _this.append(json2object_Error.IncorrectType(variable,"jackbergus.dgep.internals.ResponseAndData",pos))
        super().onIncorrectType(pos,variable)

    def loadJsonNull(self,pos,variable):
        self.value = None

    def loadJsonObject(self,o,pos,variable):
        assigned = haxe_ds_StringMap()
        self.objectSetupAssign(assigned,["response", "data"],[False, False])
        self.value = self.getAuto()
        _g = 0
        while (_g < len(o)):
            field = (o[_g] if _g >= 0 and _g < len(o) else None)
            _g = (_g + 1)
            _g1 = field.name
            _hx_local_1 = len(_g1)
            if (_hx_local_1 == 4):
                if (_g1 == "data"):
                    self.value.data = self.loadObjectField(JsonParser_4(self.errors,self.putils,1).loadJson,field,"data",assigned,self.value.data,pos)
                else:
                    _this = self.errors
                    x = json2object_Error.UnknownVariable(field.name,self.putils.convertPosition(field.namePos))
                    _this.append(x)
            elif (_hx_local_1 == 8):
                if (_g1 == "response"):
                    self.value.response = self.loadObjectField(JsonParser_8(self.errors,self.putils,1).loadJson,field,"response",assigned,self.value.response,pos)
                else:
                    _this = self.errors
                    x = json2object_Error.UnknownVariable(field.name,self.putils.convertPosition(field.namePos))
                    _this.append(x)
            else:
                _this = self.errors
                x = json2object_Error.UnknownVariable(field.name,self.putils.convertPosition(field.namePos))
                _this.append(x)
        self.objectErrors(assigned,pos)

    def getAuto(self):
        value = Type.createEmptyInstance(jackbergus_dgep_internals_ResponseAndData)
        value.response = JsonParser_8([],self.putils,0).loadJson(hxjsonast_Json(hxjsonast_JsonValue.JNull,hxjsonast_Position("",0,1)))
        value.data = haxe_ds_StringMap()
        return value

    @staticmethod
    def _hx_empty_init(_hx_o):        pass
JsonParser_6._hx_class = JsonParser_6


class JsonParser_8(json2object_reader_BaseParser):
    _hx_class_name = "JsonParser_8"
    __slots__ = ()
    _hx_fields = []
    _hx_methods = ["onIncorrectType", "loadJsonNull", "loadJsonObject", "getAuto"]
    _hx_statics = []
    _hx_interfaces = []
    _hx_super = json2object_reader_BaseParser


    def __init__(self,errors = None,putils = None,errorType = None):
        if (errorType is None):
            errorType = 0
        super().__init__(errors,putils,errorType)

    def onIncorrectType(self,pos,variable):
        _this = self.errors
        _this.append(json2object_Error.IncorrectType(variable,"haxe.ds.Map<String, List<jackbergus.dgep.internals.Move>>",pos))
        super().onIncorrectType(pos,variable)

    def loadJsonNull(self,pos,variable):
        self.value = None

    def loadJsonObject(self,o,pos,variable):
        self.value = haxe_ds_StringMap()
        _g = 0
        while (_g < len(o)):
            field = (o[_g] if _g >= 0 and _g < len(o) else None)
            _g = (_g + 1)
            this1 = self.value
            key = None
            try:
                key1 = JsonParser_5(self.errors,self.putils,2)
                _this = self.putils
                key = key1.loadJson(hxjsonast_Json(hxjsonast_JsonValue.JString(field.name),hxjsonast_Position(pos.file,(pos.min - 1),(pos.max - 1))),variable)
            except BaseException as _g1:
                None
                _g2 = haxe_Exception.caught(_g1).unwrap()
                if Std.isOfType(_g2,json2object_InternalError):
                    e = _g2
                    if (e != json2object_InternalError.ParsingThrow):
                        raise haxe_Exception.thrown(e)
                    continue
                else:
                    raise _g1
            value = None
            try:
                value = JsonParser_1(self.errors,self.putils,2).loadJson(field.value,field.name)
            except BaseException as _g3:
                None
                _g4 = haxe_Exception.caught(_g3).unwrap()
                if Std.isOfType(_g4,json2object_InternalError):
                    e1 = _g4
                    if (e1 != json2object_InternalError.ParsingThrow):
                        raise haxe_Exception.thrown(e1)
                    continue
                else:
                    raise _g3
            this1.h[key] = value

    def getAuto(self):
        return JsonParser_8([],self.putils,0).loadJson(hxjsonast_Json(hxjsonast_JsonValue.JNull,hxjsonast_Position("",0,1)))

    @staticmethod
    def _hx_empty_init(_hx_o):        pass
JsonParser_8._hx_class = JsonParser_8


class JsonParser_9(json2object_reader_BaseParser):
    _hx_class_name = "JsonParser_9"
    __slots__ = ()
    _hx_fields = []
    _hx_methods = ["onIncorrectType", "loadJsonNull", "loadJsonObject", "getAuto"]
    _hx_statics = []
    _hx_interfaces = []
    _hx_super = json2object_reader_BaseParser


    def __init__(self,errors = None,putils = None,errorType = None):
        if (errorType is None):
            errorType = 0
        super().__init__(errors,putils,errorType)

    def onIncorrectType(self,pos,variable):
        _this = self.errors
        _this.append(json2object_Error.IncorrectType(variable,"jackbergus.dgep.messages.DialogueMessage",pos))
        super().onIncorrectType(pos,variable)

    def loadJsonNull(self,pos,variable):
        self.value = None

    def loadJsonObject(self,o,pos,variable):
        assigned = haxe_ds_StringMap()
        self.objectSetupAssign(assigned,["moves", "dialogueID"],[False, False])
        self.value = self.getAuto()
        _g = 0
        while (_g < len(o)):
            field = (o[_g] if _g >= 0 and _g < len(o) else None)
            _g = (_g + 1)
            _g1 = field.name
            _hx_local_1 = len(_g1)
            if (_hx_local_1 == 10):
                if (_g1 == "dialogueID"):
                    self.value.dialogueID = self.loadObjectField(JsonParser_5(self.errors,self.putils,1).loadJson,field,"dialogueID",assigned,self.value.dialogueID,pos)
                else:
                    _this = self.errors
                    x = json2object_Error.UnknownVariable(field.name,self.putils.convertPosition(field.namePos))
                    _this.append(x)
            elif (_hx_local_1 == 5):
                if (_g1 == "moves"):
                    self.value.moves = self.loadObjectField(JsonParser_6(self.errors,self.putils,1).loadJson,field,"moves",assigned,self.value.moves,pos)
                else:
                    _this = self.errors
                    x = json2object_Error.UnknownVariable(field.name,self.putils.convertPosition(field.namePos))
                    _this.append(x)
            else:
                _this = self.errors
                x = json2object_Error.UnknownVariable(field.name,self.putils.convertPosition(field.namePos))
                _this.append(x)
        self.objectErrors(assigned,pos)

    def getAuto(self):
        value = Type.createEmptyInstance(jackbergus_dgep_messages_DialogueMessage)
        value.moves = JsonParser_6([],self.putils,0).loadJson(hxjsonast_Json(hxjsonast_JsonValue.JNull,hxjsonast_Position("",0,1)))
        value.dialogueID = ""
        return value

    @staticmethod
    def _hx_empty_init(_hx_o):        pass
JsonParser_9._hx_class = JsonParser_9


class JsonWriter_0:
    _hx_class_name = "JsonWriter_0"
    __slots__ = ("ignoreNullOptionals", "shouldQuote")
    _hx_fields = ["ignoreNullOptionals", "shouldQuote"]
    _hx_methods = ["quote", "dontQuote", "buildIndent", "_write", "write"]

    def __init__(self,ignoreNullOptionals = None):
        if (ignoreNullOptionals is None):
            ignoreNullOptionals = False
        self.shouldQuote = True
        self.ignoreNullOptionals = ignoreNullOptionals

    def quote(self,_hx_str):
        if self.shouldQuote:
            return json2object_writer_StringUtils.quote(_hx_str)
        else:
            return _hx_str

    def dontQuote(self):
        self.shouldQuote = False
        return self

    def buildIndent(self,space,level):
        if (level == 0):
            return ""
        buff_b = python_lib_io_StringIO()
        _g = 0
        _g1 = level
        while (_g < _g1):
            i = _g
            _g = (_g + 1)
            buff_b.write(Std.string(space))
        return buff_b.getvalue()

    def _write(self,o,space = None,level = None,indentFirst = None,onAllOptionalNull = None):
        if (space is None):
            space = ""
        if (level is None):
            level = 0
        if (indentFirst is None):
            indentFirst = False
        indent = self.buildIndent(space,level)
        firstIndent = (indent if indentFirst else "")
        if (o is None):
            return (("null" if firstIndent is None else firstIndent) + "null")
        decl = [(((("null" if indent is None else indent) + ("null" if space is None else space)) + "\"participants\": ") + HxOverrides.stringOrNull(JsonWriter_2(self.ignoreNullOptionals)._write(o.participants,space,(level + 1),False,onAllOptionalNull)))]
        if self.ignoreNullOptionals:
            skips = [False]
            if (python_internal_ArrayImpl.indexOf(skips,False,None) == -1):
                decl = ([onAllOptionalNull()] if ((onAllOptionalNull is not None)) else [])
            else:
                _g = []
                _g1 = 0
                _g2 = len(decl)
                while (_g1 < _g2):
                    i = _g1
                    _g1 = (_g1 + 1)
                    x = None
                    if (skips[i] if i >= 0 and i < len(skips) else None):
                        continue
                    else:
                        x = (decl[i] if i >= 0 and i < len(decl) else None)
                    _g.append(x)
                decl = _g
        newLine = ("\n" if (((space != "") and ((len(decl) > 0)))) else "")
        json = ((("null" if firstIndent is None else firstIndent) + "{") + ("null" if newLine is None else newLine))
        json = (("null" if json is None else json) + HxOverrides.stringOrNull(((HxOverrides.stringOrNull(("," + ("null" if newLine is None else newLine)).join([python_Boot.toString1(x1,'') for x1 in decl])) + ("null" if newLine is None else newLine)))))
        json = (("null" if json is None else json) + HxOverrides.stringOrNull(((("null" if indent is None else indent) + "}"))))
        return json

    def write(self,o,space = None):
        if (space is None):
            space = ""
        return self._write(o,space,0,False)

    @staticmethod
    def _hx_empty_init(_hx_o):
        _hx_o.ignoreNullOptionals = None
        _hx_o.shouldQuote = None
JsonWriter_0._hx_class = JsonWriter_0


class JsonWriter_2:
    _hx_class_name = "JsonWriter_2"
    __slots__ = ("ignoreNullOptionals", "shouldQuote")
    _hx_fields = ["ignoreNullOptionals", "shouldQuote"]
    _hx_methods = ["quote", "dontQuote", "buildIndent", "_write", "write"]

    def __init__(self,ignoreNullOptionals = None):
        if (ignoreNullOptionals is None):
            ignoreNullOptionals = False
        self.shouldQuote = True
        self.ignoreNullOptionals = ignoreNullOptionals

    def quote(self,_hx_str):
        if self.shouldQuote:
            return json2object_writer_StringUtils.quote(_hx_str)
        else:
            return _hx_str

    def dontQuote(self):
        self.shouldQuote = False
        return self

    def buildIndent(self,space,level):
        if (level == 0):
            return ""
        buff_b = python_lib_io_StringIO()
        _g = 0
        _g1 = level
        while (_g < _g1):
            i = _g
            _g = (_g + 1)
            buff_b.write(Std.string(space))
        return buff_b.getvalue()

    def _write(self,o,space = None,level = None,indentFirst = None,onAllOptionalNull = None):
        if (space is None):
            space = ""
        if (level is None):
            level = 0
        if (indentFirst is None):
            indentFirst = False
        indent = self.buildIndent(space,level)
        firstIndent = (indent if indentFirst else "")
        if (o is None):
            return (("null" if firstIndent is None else firstIndent) + "null")
        valueWriter = JsonWriter_3(self.ignoreNullOptionals)
        _g = []
        _g1_head = o.h
        while (_g1_head is not None):
            val = _g1_head.item
            _g1_head = _g1_head.next
            element = val
            x = valueWriter._write(element,space,(level + 1),True,onAllOptionalNull)
            _g.append(x)
        values = _g
        newLine = ("\n" if (((space != "") and ((o.length > 0)))) else "")
        json = ((("null" if firstIndent is None else firstIndent) + "[") + ("null" if newLine is None else newLine))
        json = (("null" if json is None else json) + HxOverrides.stringOrNull(((HxOverrides.stringOrNull(("," + ("null" if newLine is None else newLine)).join([python_Boot.toString1(x1,'') for x1 in values])) + ("null" if newLine is None else newLine)))))
        json = (("null" if json is None else json) + HxOverrides.stringOrNull(((("null" if indent is None else indent) + "]"))))
        return json

    def write(self,o,space = None):
        if (space is None):
            space = ""
        return self._write(o,space,0,False)

    @staticmethod
    def _hx_empty_init(_hx_o):
        _hx_o.ignoreNullOptionals = None
        _hx_o.shouldQuote = None
JsonWriter_2._hx_class = JsonWriter_2


class JsonWriter_3:
    _hx_class_name = "JsonWriter_3"
    __slots__ = ("ignoreNullOptionals", "shouldQuote")
    _hx_fields = ["ignoreNullOptionals", "shouldQuote"]
    _hx_methods = ["quote", "dontQuote", "buildIndent", "_write", "write"]

    def __init__(self,ignoreNullOptionals = None):
        if (ignoreNullOptionals is None):
            ignoreNullOptionals = False
        self.shouldQuote = True
        self.ignoreNullOptionals = ignoreNullOptionals

    def quote(self,_hx_str):
        if self.shouldQuote:
            return json2object_writer_StringUtils.quote(_hx_str)
        else:
            return _hx_str

    def dontQuote(self):
        self.shouldQuote = False
        return self

    def buildIndent(self,space,level):
        if (level == 0):
            return ""
        buff_b = python_lib_io_StringIO()
        _g = 0
        _g1 = level
        while (_g < _g1):
            i = _g
            _g = (_g + 1)
            buff_b.write(Std.string(space))
        return buff_b.getvalue()

    def _write(self,o,space = None,level = None,indentFirst = None,onAllOptionalNull = None):
        if (space is None):
            space = ""
        if (level is None):
            level = 0
        if (indentFirst is None):
            indentFirst = False
        indent = self.buildIndent(space,level)
        firstIndent = (indent if indentFirst else "")
        if (o is None):
            return (("null" if firstIndent is None else firstIndent) + "null")
        decl = [(((("null" if indent is None else indent) + ("null" if space is None else space)) + "\"name\": ") + HxOverrides.stringOrNull(JsonWriter_4(self.ignoreNullOptionals)._write(o.name,space,(level + 1),False,onAllOptionalNull))), (((("null" if indent is None else indent) + ("null" if space is None else space)) + "\"player\": ") + HxOverrides.stringOrNull(JsonWriter_4(self.ignoreNullOptionals)._write(o.player,space,(level + 1),False,onAllOptionalNull)))]
        if self.ignoreNullOptionals:
            skips = [False, False]
            if (python_internal_ArrayImpl.indexOf(skips,False,None) == -1):
                decl = ([onAllOptionalNull()] if ((onAllOptionalNull is not None)) else [])
            else:
                _g = []
                _g1 = 0
                _g2 = len(decl)
                while (_g1 < _g2):
                    i = _g1
                    _g1 = (_g1 + 1)
                    x = None
                    if (skips[i] if i >= 0 and i < len(skips) else None):
                        continue
                    else:
                        x = (decl[i] if i >= 0 and i < len(decl) else None)
                    _g.append(x)
                decl = _g
        newLine = ("\n" if (((space != "") and ((len(decl) > 0)))) else "")
        json = ((("null" if firstIndent is None else firstIndent) + "{") + ("null" if newLine is None else newLine))
        json = (("null" if json is None else json) + HxOverrides.stringOrNull(((HxOverrides.stringOrNull(("," + ("null" if newLine is None else newLine)).join([python_Boot.toString1(x1,'') for x1 in decl])) + ("null" if newLine is None else newLine)))))
        json = (("null" if json is None else json) + HxOverrides.stringOrNull(((("null" if indent is None else indent) + "}"))))
        return json

    def write(self,o,space = None):
        if (space is None):
            space = ""
        return self._write(o,space,0,False)

    @staticmethod
    def _hx_empty_init(_hx_o):
        _hx_o.ignoreNullOptionals = None
        _hx_o.shouldQuote = None
JsonWriter_3._hx_class = JsonWriter_3


class JsonWriter_4:
    _hx_class_name = "JsonWriter_4"
    __slots__ = ("ignoreNullOptionals", "shouldQuote")
    _hx_fields = ["ignoreNullOptionals", "shouldQuote"]
    _hx_methods = ["quote", "dontQuote", "buildIndent", "_write", "write"]

    def __init__(self,ignoreNullOptionals = None):
        if (ignoreNullOptionals is None):
            ignoreNullOptionals = False
        self.shouldQuote = True
        self.ignoreNullOptionals = ignoreNullOptionals

    def quote(self,_hx_str):
        if self.shouldQuote:
            return json2object_writer_StringUtils.quote(_hx_str)
        else:
            return _hx_str

    def dontQuote(self):
        self.shouldQuote = False
        return self

    def buildIndent(self,space,level):
        if (level == 0):
            return ""
        buff_b = python_lib_io_StringIO()
        _g = 0
        _g1 = level
        while (_g < _g1):
            i = _g
            _g = (_g + 1)
            buff_b.write(Std.string(space))
        return buff_b.getvalue()

    def _write(self,o,space = None,level = None,indentFirst = None,onAllOptionalNull = None):
        if (space is None):
            space = ""
        if (level is None):
            level = 0
        if (indentFirst is None):
            indentFirst = False
        return (HxOverrides.stringOrNull(((self.buildIndent(space,level) if indentFirst else ""))) + HxOverrides.stringOrNull((("null" if ((o is None)) else (json2object_writer_StringUtils.quote(o) if (self.shouldQuote) else o)))))

    def write(self,o,space = None):
        if (space is None):
            space = ""
        return self._write(o,space,0,False)

    @staticmethod
    def _hx_empty_init(_hx_o):
        _hx_o.ignoreNullOptionals = None
        _hx_o.shouldQuote = None
JsonWriter_4._hx_class = JsonWriter_4


class Lambda:
    _hx_class_name = "Lambda"
    __slots__ = ()
    _hx_statics = ["exists"]

    @staticmethod
    def exists(it,f):
        x = HxOverrides.iterator(it)
        while x.hasNext():
            x1 = x.next()
            if f(x1):
                return True
        return False
Lambda._hx_class = Lambda


class Reflect:
    _hx_class_name = "Reflect"
    __slots__ = ()
    _hx_statics = ["field", "isFunction", "compareMethods"]

    @staticmethod
    def field(o,field):
        return python_Boot.field(o,field)

    @staticmethod
    def isFunction(f):
        if (not ((python_lib_Inspect.isfunction(f) or python_lib_Inspect.ismethod(f)))):
            return python_Boot.hasField(f,"func_code")
        else:
            return True

    @staticmethod
    def compareMethods(f1,f2):
        if HxOverrides.eq(f1,f2):
            return True
        if (isinstance(f1,python_internal_MethodClosure) and isinstance(f2,python_internal_MethodClosure)):
            m1 = f1
            m2 = f2
            if HxOverrides.eq(m1.obj,m2.obj):
                return (m1.func == m2.func)
            else:
                return False
        if ((not Reflect.isFunction(f1)) or (not Reflect.isFunction(f2))):
            return False
        return False
Reflect._hx_class = Reflect


class Std:
    _hx_class_name = "Std"
    __slots__ = ()
    _hx_statics = ["isOfType", "string", "parseInt", "shortenPossibleNumber", "parseFloat"]

    @staticmethod
    def isOfType(v,t):
        if ((v is None) and ((t is None))):
            return False
        if (t is None):
            return False
        if ((type(t) == type) and (t == Dynamic)):
            return (v is not None)
        isBool = isinstance(v,bool)
        if (((type(t) == type) and (t == Bool)) and isBool):
            return True
        if ((((not isBool) and (not ((type(t) == type) and (t == Bool)))) and ((type(t) == type) and (t == Int))) and isinstance(v,int)):
            return True
        vIsFloat = isinstance(v,float)
        tmp = None
        tmp1 = None
        if (((not isBool) and vIsFloat) and ((type(t) == type) and (t == Int))):
            f = v
            tmp1 = (((f != Math.POSITIVE_INFINITY) and ((f != Math.NEGATIVE_INFINITY))) and (not python_lib_Math.isnan(f)))
        else:
            tmp1 = False
        if tmp1:
            tmp1 = None
            try:
                tmp1 = int(v)
            except BaseException as _g:
                None
                tmp1 = None
            tmp = (v == tmp1)
        else:
            tmp = False
        if ((tmp and ((v <= 2147483647))) and ((v >= -2147483648))):
            return True
        if (((not isBool) and ((type(t) == type) and (t == Float))) and isinstance(v,(float, int))):
            return True
        if ((type(t) == type) and (t == str)):
            return isinstance(v,str)
        isEnumType = ((type(t) == type) and (t == Enum))
        if ((isEnumType and python_lib_Inspect.isclass(v)) and hasattr(v,"_hx_constructs")):
            return True
        if isEnumType:
            return False
        isClassType = ((type(t) == type) and (t == Class))
        if ((((isClassType and (not isinstance(v,Enum))) and python_lib_Inspect.isclass(v)) and hasattr(v,"_hx_class_name")) and (not hasattr(v,"_hx_constructs"))):
            return True
        if isClassType:
            return False
        tmp = None
        try:
            tmp = isinstance(v,t)
        except BaseException as _g:
            None
            tmp = False
        if tmp:
            return True
        if python_lib_Inspect.isclass(t):
            cls = t
            loop = None
            def _hx_local_1(intf):
                f = (intf._hx_interfaces if (hasattr(intf,"_hx_interfaces")) else [])
                if (f is not None):
                    _g = 0
                    while (_g < len(f)):
                        i = (f[_g] if _g >= 0 and _g < len(f) else None)
                        _g = (_g + 1)
                        if (i == cls):
                            return True
                        else:
                            l = loop(i)
                            if l:
                                return True
                    return False
                else:
                    return False
            loop = _hx_local_1
            currentClass = v.__class__
            result = False
            while (currentClass is not None):
                if loop(currentClass):
                    result = True
                    break
                currentClass = python_Boot.getSuperClass(currentClass)
            return result
        else:
            return False

    @staticmethod
    def string(s):
        return python_Boot.toString1(s,"")

    @staticmethod
    def parseInt(x):
        if (x is None):
            return None
        try:
            return int(x)
        except BaseException as _g:
            None
            base = 10
            _hx_len = len(x)
            foundCount = 0
            sign = 0
            firstDigitIndex = 0
            lastDigitIndex = -1
            previous = 0
            _g = 0
            _g1 = _hx_len
            while (_g < _g1):
                i = _g
                _g = (_g + 1)
                c = (-1 if ((i >= len(x))) else ord(x[i]))
                if (((c > 8) and ((c < 14))) or ((c == 32))):
                    if (foundCount > 0):
                        return None
                    continue
                else:
                    c1 = c
                    if (c1 == 43):
                        if (foundCount == 0):
                            sign = 1
                        elif (not (((48 <= c) and ((c <= 57))))):
                            if (not (((base == 16) and ((((97 <= c) and ((c <= 122))) or (((65 <= c) and ((c <= 90))))))))):
                                break
                    elif (c1 == 45):
                        if (foundCount == 0):
                            sign = -1
                        elif (not (((48 <= c) and ((c <= 57))))):
                            if (not (((base == 16) and ((((97 <= c) and ((c <= 122))) or (((65 <= c) and ((c <= 90))))))))):
                                break
                    elif (c1 == 48):
                        if (not (((foundCount == 0) or (((foundCount == 1) and ((sign != 0))))))):
                            if (not (((48 <= c) and ((c <= 57))))):
                                if (not (((base == 16) and ((((97 <= c) and ((c <= 122))) or (((65 <= c) and ((c <= 90))))))))):
                                    break
                    elif ((c1 == 120) or ((c1 == 88))):
                        if ((previous == 48) and ((((foundCount == 1) and ((sign == 0))) or (((foundCount == 2) and ((sign != 0))))))):
                            base = 16
                        elif (not (((48 <= c) and ((c <= 57))))):
                            if (not (((base == 16) and ((((97 <= c) and ((c <= 122))) or (((65 <= c) and ((c <= 90))))))))):
                                break
                    elif (not (((48 <= c) and ((c <= 57))))):
                        if (not (((base == 16) and ((((97 <= c) and ((c <= 122))) or (((65 <= c) and ((c <= 90))))))))):
                            break
                if (((foundCount == 0) and ((sign == 0))) or (((foundCount == 1) and ((sign != 0))))):
                    firstDigitIndex = i
                foundCount = (foundCount + 1)
                lastDigitIndex = i
                previous = c
            if (firstDigitIndex <= lastDigitIndex):
                digits = HxString.substring(x,firstDigitIndex,(lastDigitIndex + 1))
                try:
                    return (((-1 if ((sign == -1)) else 1)) * int(digits,base))
                except BaseException as _g:
                    return None
            return None

    @staticmethod
    def shortenPossibleNumber(x):
        r = ""
        _g = 0
        _g1 = len(x)
        while (_g < _g1):
            i = _g
            _g = (_g + 1)
            c = ("" if (((i < 0) or ((i >= len(x))))) else x[i])
            _g2 = HxString.charCodeAt(c,0)
            if (_g2 is None):
                break
            else:
                _g3 = _g2
                if (((((((((((_g3 == 57) or ((_g3 == 56))) or ((_g3 == 55))) or ((_g3 == 54))) or ((_g3 == 53))) or ((_g3 == 52))) or ((_g3 == 51))) or ((_g3 == 50))) or ((_g3 == 49))) or ((_g3 == 48))) or ((_g3 == 46))):
                    r = (("null" if r is None else r) + ("null" if c is None else c))
                else:
                    break
        return r

    @staticmethod
    def parseFloat(x):
        try:
            return float(x)
        except BaseException as _g:
            None
            if (x is not None):
                r1 = Std.shortenPossibleNumber(x)
                if (r1 != x):
                    return Std.parseFloat(r1)
            return Math.NaN
Std._hx_class = Std


class Float: pass


class Int: pass


class Bool: pass


class Dynamic: pass


class StringBuf:
    _hx_class_name = "StringBuf"
    __slots__ = ("b",)
    _hx_fields = ["b"]
    _hx_methods = ["get_length"]

    def __init__(self):
        self.b = python_lib_io_StringIO()

    def get_length(self):
        pos = self.b.tell()
        self.b.seek(0,2)
        _hx_len = self.b.tell()
        self.b.seek(pos,0)
        return _hx_len

    @staticmethod
    def _hx_empty_init(_hx_o):
        _hx_o.b = None
StringBuf._hx_class = StringBuf


class StringTools:
    _hx_class_name = "StringTools"
    __slots__ = ()
    _hx_statics = ["isSpace", "ltrim", "rtrim", "trim", "lpad"]

    @staticmethod
    def isSpace(s,pos):
        if (((len(s) == 0) or ((pos < 0))) or ((pos >= len(s)))):
            return False
        c = HxString.charCodeAt(s,pos)
        if (not (((c > 8) and ((c < 14))))):
            return (c == 32)
        else:
            return True

    @staticmethod
    def ltrim(s):
        l = len(s)
        r = 0
        while ((r < l) and StringTools.isSpace(s,r)):
            r = (r + 1)
        if (r > 0):
            return HxString.substr(s,r,(l - r))
        else:
            return s

    @staticmethod
    def rtrim(s):
        l = len(s)
        r = 0
        while ((r < l) and StringTools.isSpace(s,((l - r) - 1))):
            r = (r + 1)
        if (r > 0):
            return HxString.substr(s,0,(l - r))
        else:
            return s

    @staticmethod
    def trim(s):
        return StringTools.ltrim(StringTools.rtrim(s))

    @staticmethod
    def lpad(s,c,l):
        if (len(c) <= 0):
            return s
        buf = StringBuf()
        l = (l - len(s))
        while (buf.get_length() < l):
            s1 = Std.string(c)
            buf.b.write(s1)
        s1 = Std.string(s)
        buf.b.write(s1)
        return buf.b.getvalue()
StringTools._hx_class = StringTools


class Sys:
    _hx_class_name = "Sys"
    __slots__ = ()
    _hx_statics = ["sleep"]

    @staticmethod
    def sleep(seconds):
        python_lib_Time.sleep(seconds)
Sys._hx_class = Sys

class ValueType(Enum):
    __slots__ = ()
    _hx_class_name = "ValueType"
    _hx_constructs = ["TNull", "TInt", "TFloat", "TBool", "TObject", "TFunction", "TClass", "TEnum", "TUnknown"]

    @staticmethod
    def TClass(c):
        return ValueType("TClass", 6, (c,))

    @staticmethod
    def TEnum(e):
        return ValueType("TEnum", 7, (e,))
ValueType.TNull = ValueType("TNull", 0, ())
ValueType.TInt = ValueType("TInt", 1, ())
ValueType.TFloat = ValueType("TFloat", 2, ())
ValueType.TBool = ValueType("TBool", 3, ())
ValueType.TObject = ValueType("TObject", 4, ())
ValueType.TFunction = ValueType("TFunction", 5, ())
ValueType.TUnknown = ValueType("TUnknown", 8, ())
ValueType._hx_class = ValueType


class Type:
    _hx_class_name = "Type"
    __slots__ = ()
    _hx_statics = ["getClass", "getSuperClass", "createEmptyInstance", "typeof"]

    @staticmethod
    def getClass(o):
        if (o is None):
            return None
        o1 = o
        if ((o1 is not None) and ((HxOverrides.eq(o1,str) or python_lib_Inspect.isclass(o1)))):
            return None
        if isinstance(o,_hx_AnonObject):
            return None
        if hasattr(o,"_hx_class"):
            return o._hx_class
        if hasattr(o,"__class__"):
            return o.__class__
        else:
            return None

    @staticmethod
    def getSuperClass(c):
        return python_Boot.getSuperClass(c)

    @staticmethod
    def createEmptyInstance(cl):
        i = cl.__new__(cl)
        callInit = None
        def _hx_local_0(cl):
            sc = Type.getSuperClass(cl)
            if (sc is not None):
                callInit(sc)
            if hasattr(cl,"_hx_empty_init"):
                cl._hx_empty_init(i)
        callInit = _hx_local_0
        callInit(cl)
        return i

    @staticmethod
    def typeof(v):
        if (v is None):
            return ValueType.TNull
        elif isinstance(v,bool):
            return ValueType.TBool
        elif isinstance(v,int):
            return ValueType.TInt
        elif isinstance(v,float):
            return ValueType.TFloat
        elif isinstance(v,str):
            return ValueType.TClass(str)
        elif isinstance(v,list):
            return ValueType.TClass(list)
        elif (isinstance(v,_hx_AnonObject) or python_lib_Inspect.isclass(v)):
            return ValueType.TObject
        elif isinstance(v,Enum):
            return ValueType.TEnum(v.__class__)
        elif (isinstance(v,type) or hasattr(v,"_hx_class")):
            return ValueType.TClass(v.__class__)
        elif callable(v):
            return ValueType.TFunction
        else:
            return ValueType.TUnknown
Type._hx_class = Type


class haxe_IMap:
    _hx_class_name = "haxe.IMap"
    __slots__ = ()
    _hx_methods = ["get", "keys"]
haxe_IMap._hx_class = haxe_IMap


class haxe_Exception(Exception):
    _hx_class_name = "haxe.Exception"
    __slots__ = ("_hx___nativeStack", "_hx___skipStack", "_hx___nativeException", "_hx___previousException")
    _hx_fields = ["__nativeStack", "__skipStack", "__nativeException", "__previousException"]
    _hx_methods = ["unwrap", "toString", "get_message", "get_native"]
    _hx_statics = ["caught", "thrown"]
    _hx_interfaces = []
    _hx_super = Exception


    def __init__(self,message,previous = None,native = None):
        self._hx___previousException = None
        self._hx___nativeException = None
        self._hx___nativeStack = None
        self._hx___skipStack = 0
        super().__init__(message)
        self._hx___previousException = previous
        if ((native is not None) and Std.isOfType(native,BaseException)):
            self._hx___nativeException = native
            self._hx___nativeStack = haxe_NativeStackTrace.exceptionStack()
        else:
            self._hx___nativeException = self
            infos = python_lib_Traceback.extract_stack()
            if (len(infos) != 0):
                infos.pop()
            infos.reverse()
            self._hx___nativeStack = infos

    def unwrap(self):
        return self._hx___nativeException

    def toString(self):
        return self.get_message()

    def get_message(self):
        return str(self)

    def get_native(self):
        return self._hx___nativeException

    @staticmethod
    def caught(value):
        if Std.isOfType(value,haxe_Exception):
            return value
        elif Std.isOfType(value,BaseException):
            return haxe_Exception(str(value),None,value)
        else:
            return haxe_ValueException(value,None,value)

    @staticmethod
    def thrown(value):
        if Std.isOfType(value,haxe_Exception):
            return value.get_native()
        elif Std.isOfType(value,BaseException):
            return value
        else:
            e = haxe_ValueException(value)
            e._hx___skipStack = (e._hx___skipStack + 1)
            return e

    @staticmethod
    def _hx_empty_init(_hx_o):
        _hx_o._hx___nativeStack = None
        _hx_o._hx___skipStack = None
        _hx_o._hx___nativeException = None
        _hx_o._hx___previousException = None
haxe_Exception._hx_class = haxe_Exception


class haxe_NativeStackTrace:
    _hx_class_name = "haxe.NativeStackTrace"
    __slots__ = ()
    _hx_statics = ["saveStack", "exceptionStack"]

    @staticmethod
    def saveStack(exception):
        pass

    @staticmethod
    def exceptionStack():
        exc = python_lib_Sys.exc_info()
        if (exc[2] is not None):
            infos = python_lib_Traceback.extract_tb(exc[2])
            infos.reverse()
            return infos
        else:
            return []
haxe_NativeStackTrace._hx_class = haxe_NativeStackTrace


class haxe_ValueException(haxe_Exception):
    _hx_class_name = "haxe.ValueException"
    __slots__ = ("value",)
    _hx_fields = ["value"]
    _hx_methods = ["unwrap"]
    _hx_statics = []
    _hx_interfaces = []
    _hx_super = haxe_Exception


    def __init__(self,value,previous = None,native = None):
        self.value = None
        super().__init__(Std.string(value),previous,native)
        self.value = value

    def unwrap(self):
        return self.value

    @staticmethod
    def _hx_empty_init(_hx_o):
        _hx_o.value = None
haxe_ValueException._hx_class = haxe_ValueException


class haxe_ds_List:
    _hx_class_name = "haxe.ds.List"
    __slots__ = ("h", "q", "length")
    _hx_fields = ["h", "q", "length"]
    _hx_methods = ["add", "filter", "map"]

    def __init__(self):
        self.q = None
        self.h = None
        self.length = 0

    def add(self,item):
        x = haxe_ds__List_ListNode(item,None)
        if (self.h is None):
            self.h = x
        else:
            self.q.next = x
        self.q = x
        _hx_local_0 = self
        _hx_local_1 = _hx_local_0.length
        _hx_local_0.length = (_hx_local_1 + 1)
        _hx_local_1

    def filter(self,f):
        l2 = haxe_ds_List()
        l = self.h
        while (l is not None):
            v = l.item
            l = l.next
            if f(v):
                l2.add(v)
        return l2

    def map(self,f):
        b = haxe_ds_List()
        l = self.h
        while (l is not None):
            v = l.item
            l = l.next
            b.add(f(v))
        return b

    @staticmethod
    def _hx_empty_init(_hx_o):
        _hx_o.h = None
        _hx_o.q = None
        _hx_o.length = None
haxe_ds_List._hx_class = haxe_ds_List


class haxe_ds__List_ListNode:
    _hx_class_name = "haxe.ds._List.ListNode"
    __slots__ = ("item", "next")
    _hx_fields = ["item", "next"]

    def __init__(self,item,next):
        self.item = item
        self.next = next

    @staticmethod
    def _hx_empty_init(_hx_o):
        _hx_o.item = None
        _hx_o.next = None
haxe_ds__List_ListNode._hx_class = haxe_ds__List_ListNode


class haxe_ds_StringMap:
    _hx_class_name = "haxe.ds.StringMap"
    __slots__ = ("h",)
    _hx_fields = ["h"]
    _hx_methods = ["get", "remove", "keys"]
    _hx_interfaces = [haxe_IMap]

    def __init__(self):
        self.h = dict()

    def get(self,key):
        return self.h.get(key,None)

    def remove(self,key):
        has = (key in self.h)
        if has:
            del self.h[key]
        return has

    def keys(self):
        return python_HaxeIterator(iter(self.h.keys()))

    @staticmethod
    def _hx_empty_init(_hx_o):
        _hx_o.h = None
haxe_ds_StringMap._hx_class = haxe_ds_StringMap


class haxe_exceptions_PosException(haxe_Exception):
    _hx_class_name = "haxe.exceptions.PosException"
    __slots__ = ("posInfos",)
    _hx_fields = ["posInfos"]
    _hx_methods = ["toString"]
    _hx_statics = []
    _hx_interfaces = []
    _hx_super = haxe_Exception


    def __init__(self,message,previous = None,pos = None):
        self.posInfos = None
        super().__init__(message,previous)
        if (pos is None):
            self.posInfos = _hx_AnonObject({'fileName': "(unknown)", 'lineNumber': 0, 'className': "(unknown)", 'methodName': "(unknown)"})
        else:
            self.posInfos = pos

    def toString(self):
        return ((((((((("" + HxOverrides.stringOrNull(super().toString())) + " in ") + HxOverrides.stringOrNull(self.posInfos.className)) + ".") + HxOverrides.stringOrNull(self.posInfos.methodName)) + " at ") + HxOverrides.stringOrNull(self.posInfos.fileName)) + ":") + Std.string(self.posInfos.lineNumber))

    @staticmethod
    def _hx_empty_init(_hx_o):
        _hx_o.posInfos = None
haxe_exceptions_PosException._hx_class = haxe_exceptions_PosException


class haxe_exceptions_NotImplementedException(haxe_exceptions_PosException):
    _hx_class_name = "haxe.exceptions.NotImplementedException"
    __slots__ = ()
    _hx_fields = []
    _hx_methods = []
    _hx_statics = []
    _hx_interfaces = []
    _hx_super = haxe_exceptions_PosException


    def __init__(self,message = None,previous = None,pos = None):
        if (message is None):
            message = "Not implemented"
        super().__init__(message,previous,pos)
haxe_exceptions_NotImplementedException._hx_class = haxe_exceptions_NotImplementedException


class haxe_format_JsonPrinter:
    _hx_class_name = "haxe.format.JsonPrinter"
    __slots__ = ("buf", "replacer", "indent", "pretty", "nind")
    _hx_fields = ["buf", "replacer", "indent", "pretty", "nind"]
    _hx_methods = ["write", "classString", "fieldsString", "quote"]
    _hx_statics = ["print"]

    def __init__(self,replacer,space):
        self.replacer = replacer
        self.indent = space
        self.pretty = (space is not None)
        self.nind = 0
        self.buf = StringBuf()

    def write(self,k,v):
        if (self.replacer is not None):
            v = self.replacer(k,v)
        _g = Type.typeof(v)
        tmp = _g.index
        if (tmp == 0):
            self.buf.b.write("null")
        elif (tmp == 1):
            _this = self.buf
            s = Std.string(v)
            _this.b.write(s)
        elif (tmp == 2):
            f = v
            v1 = (Std.string(v) if ((((f != Math.POSITIVE_INFINITY) and ((f != Math.NEGATIVE_INFINITY))) and (not python_lib_Math.isnan(f)))) else "null")
            _this = self.buf
            s = Std.string(v1)
            _this.b.write(s)
        elif (tmp == 3):
            _this = self.buf
            s = Std.string(v)
            _this.b.write(s)
        elif (tmp == 4):
            self.fieldsString(v,python_Boot.fields(v))
        elif (tmp == 5):
            self.buf.b.write("\"<fun>\"")
        elif (tmp == 6):
            c = _g.params[0]
            if (c == str):
                self.quote(v)
            elif (c == list):
                v1 = v
                _this = self.buf
                s = "".join(map(chr,[91]))
                _this.b.write(s)
                _hx_len = len(v1)
                last = (_hx_len - 1)
                _g1 = 0
                _g2 = _hx_len
                while (_g1 < _g2):
                    i = _g1
                    _g1 = (_g1 + 1)
                    if (i > 0):
                        _this = self.buf
                        s = "".join(map(chr,[44]))
                        _this.b.write(s)
                    else:
                        _hx_local_0 = self
                        _hx_local_1 = _hx_local_0.nind
                        _hx_local_0.nind = (_hx_local_1 + 1)
                        _hx_local_1
                    if self.pretty:
                        _this1 = self.buf
                        s1 = "".join(map(chr,[10]))
                        _this1.b.write(s1)
                    if self.pretty:
                        v2 = StringTools.lpad("",self.indent,(self.nind * len(self.indent)))
                        _this2 = self.buf
                        s2 = Std.string(v2)
                        _this2.b.write(s2)
                    self.write(i,(v1[i] if i >= 0 and i < len(v1) else None))
                    if (i == last):
                        _hx_local_2 = self
                        _hx_local_3 = _hx_local_2.nind
                        _hx_local_2.nind = (_hx_local_3 - 1)
                        _hx_local_3
                        if self.pretty:
                            _this3 = self.buf
                            s3 = "".join(map(chr,[10]))
                            _this3.b.write(s3)
                        if self.pretty:
                            v3 = StringTools.lpad("",self.indent,(self.nind * len(self.indent)))
                            _this4 = self.buf
                            s4 = Std.string(v3)
                            _this4.b.write(s4)
                _this = self.buf
                s = "".join(map(chr,[93]))
                _this.b.write(s)
            elif (c == haxe_ds_StringMap):
                v1 = v
                o = _hx_AnonObject({})
                k = v1.keys()
                while k.hasNext():
                    k1 = k.next()
                    value = v1.h.get(k1,None)
                    setattr(o,(("_hx_" + k1) if ((k1 in python_Boot.keywords)) else (("_hx_" + k1) if (((((len(k1) > 2) and ((ord(k1[0]) == 95))) and ((ord(k1[1]) == 95))) and ((ord(k1[(len(k1) - 1)]) != 95)))) else k1)),value)
                v1 = o
                self.fieldsString(v1,python_Boot.fields(v1))
            elif (c == Date):
                v1 = v
                self.quote(v1.toString())
            else:
                self.classString(v)
        elif (tmp == 7):
            _g1 = _g.params[0]
            i = v.index
            _this = self.buf
            s = Std.string(i)
            _this.b.write(s)
        elif (tmp == 8):
            self.buf.b.write("\"???\"")
        else:
            pass

    def classString(self,v):
        self.fieldsString(v,python_Boot.getInstanceFields(Type.getClass(v)))

    def fieldsString(self,v,fields):
        _this = self.buf
        s = "".join(map(chr,[123]))
        _this.b.write(s)
        _hx_len = len(fields)
        last = (_hx_len - 1)
        first = True
        _g = 0
        _g1 = _hx_len
        while (_g < _g1):
            i = _g
            _g = (_g + 1)
            f = (fields[i] if i >= 0 and i < len(fields) else None)
            value = Reflect.field(v,f)
            if Reflect.isFunction(value):
                continue
            if first:
                _hx_local_0 = self
                _hx_local_1 = _hx_local_0.nind
                _hx_local_0.nind = (_hx_local_1 + 1)
                _hx_local_1
                first = False
            else:
                _this = self.buf
                s = "".join(map(chr,[44]))
                _this.b.write(s)
            if self.pretty:
                _this1 = self.buf
                s1 = "".join(map(chr,[10]))
                _this1.b.write(s1)
            if self.pretty:
                v1 = StringTools.lpad("",self.indent,(self.nind * len(self.indent)))
                _this2 = self.buf
                s2 = Std.string(v1)
                _this2.b.write(s2)
            self.quote(f)
            _this3 = self.buf
            s3 = "".join(map(chr,[58]))
            _this3.b.write(s3)
            if self.pretty:
                _this4 = self.buf
                s4 = "".join(map(chr,[32]))
                _this4.b.write(s4)
            self.write(f,value)
            if (i == last):
                _hx_local_2 = self
                _hx_local_3 = _hx_local_2.nind
                _hx_local_2.nind = (_hx_local_3 - 1)
                _hx_local_3
                if self.pretty:
                    _this5 = self.buf
                    s5 = "".join(map(chr,[10]))
                    _this5.b.write(s5)
                if self.pretty:
                    v2 = StringTools.lpad("",self.indent,(self.nind * len(self.indent)))
                    _this6 = self.buf
                    s6 = Std.string(v2)
                    _this6.b.write(s6)
        _this = self.buf
        s = "".join(map(chr,[125]))
        _this.b.write(s)

    def quote(self,s):
        _this = self.buf
        s1 = "".join(map(chr,[34]))
        _this.b.write(s1)
        i = 0
        length = len(s)
        while (i < length):
            index = i
            i = (i + 1)
            c = ord(s[index])
            c1 = c
            if (c1 == 8):
                self.buf.b.write("\\b")
            elif (c1 == 9):
                self.buf.b.write("\\t")
            elif (c1 == 10):
                self.buf.b.write("\\n")
            elif (c1 == 12):
                self.buf.b.write("\\f")
            elif (c1 == 13):
                self.buf.b.write("\\r")
            elif (c1 == 34):
                self.buf.b.write("\\\"")
            elif (c1 == 92):
                self.buf.b.write("\\\\")
            else:
                _this = self.buf
                s1 = "".join(map(chr,[c]))
                _this.b.write(s1)
        _this = self.buf
        s = "".join(map(chr,[34]))
        _this.b.write(s)

    @staticmethod
    def print(o,replacer = None,space = None):
        printer = haxe_format_JsonPrinter(replacer,space)
        printer.write("",o)
        return printer.buf.b.getvalue()

    @staticmethod
    def _hx_empty_init(_hx_o):
        _hx_o.buf = None
        _hx_o.replacer = None
        _hx_o.indent = None
        _hx_o.pretty = None
        _hx_o.nind = None
haxe_format_JsonPrinter._hx_class = haxe_format_JsonPrinter


class haxe_http_HttpBase:
    _hx_class_name = "haxe.http.HttpBase"
    _hx_fields = ["url", "responseBytes", "responseAsString", "postData", "postBytes", "headers", "params", "emptyOnData"]
    _hx_methods = ["setHeader", "setParameter", "setPostData", "onData", "onBytes", "onError", "onStatus", "hasOnData", "success", "get_responseData"]

    def __init__(self,url):
        self.emptyOnData = None
        self.postBytes = None
        self.postData = None
        self.responseAsString = None
        self.responseBytes = None
        self.url = url
        self.headers = []
        self.params = []
        self.emptyOnData = self.onData

    def setHeader(self,name,value):
        _g = 0
        _g1 = len(self.headers)
        while (_g < _g1):
            i = _g
            _g = (_g + 1)
            if ((self.headers[i] if i >= 0 and i < len(self.headers) else None).name == name):
                python_internal_ArrayImpl._set(self.headers, i, _hx_AnonObject({'name': name, 'value': value}))
                return
        _this = self.headers
        _this.append(_hx_AnonObject({'name': name, 'value': value}))

    def setParameter(self,name,value):
        _g = 0
        _g1 = len(self.params)
        while (_g < _g1):
            i = _g
            _g = (_g + 1)
            if ((self.params[i] if i >= 0 and i < len(self.params) else None).name == name):
                python_internal_ArrayImpl._set(self.params, i, _hx_AnonObject({'name': name, 'value': value}))
                return
        _this = self.params
        _this.append(_hx_AnonObject({'name': name, 'value': value}))

    def setPostData(self,data):
        self.postData = data
        self.postBytes = None

    def onData(self,data):
        pass

    def onBytes(self,data):
        pass

    def onError(self,msg):
        pass

    def onStatus(self,status):
        pass

    def hasOnData(self):
        return (not Reflect.compareMethods(self.onData,self.emptyOnData))

    def success(self,data):
        self.responseBytes = data
        self.responseAsString = None
        if self.hasOnData():
            self.onData(self.get_responseData())
        self.onBytes(self.responseBytes)

    def get_responseData(self):
        if ((self.responseAsString is None) and ((self.responseBytes is not None))):
            self.responseAsString = self.responseBytes.getString(0,self.responseBytes.length,haxe_io_Encoding.UTF8)
        return self.responseAsString

    @staticmethod
    def _hx_empty_init(_hx_o):
        _hx_o.url = None
        _hx_o.responseBytes = None
        _hx_o.responseAsString = None
        _hx_o.postData = None
        _hx_o.postBytes = None
        _hx_o.headers = None
        _hx_o.params = None
        _hx_o.emptyOnData = None
haxe_http_HttpBase._hx_class = haxe_http_HttpBase


class haxe_io_Bytes:
    _hx_class_name = "haxe.io.Bytes"
    __slots__ = ("length", "b")
    _hx_fields = ["length", "b"]
    _hx_methods = ["sub", "getString", "toString"]
    _hx_statics = ["alloc", "ofString"]

    def __init__(self,length,b):
        self.length = length
        self.b = b

    def sub(self,pos,_hx_len):
        if (((pos < 0) or ((_hx_len < 0))) or (((pos + _hx_len) > self.length))):
            raise haxe_Exception.thrown(haxe_io_Error.OutsideBounds)
        return haxe_io_Bytes(_hx_len,self.b[pos:(pos + _hx_len)])

    def getString(self,pos,_hx_len,encoding = None):
        tmp = (encoding is None)
        if (((pos < 0) or ((_hx_len < 0))) or (((pos + _hx_len) > self.length))):
            raise haxe_Exception.thrown(haxe_io_Error.OutsideBounds)
        return self.b[pos:pos+_hx_len].decode('UTF-8','replace')

    def toString(self):
        return self.getString(0,self.length)

    @staticmethod
    def alloc(length):
        return haxe_io_Bytes(length,bytearray(length))

    @staticmethod
    def ofString(s,encoding = None):
        b = bytearray(s,"UTF-8")
        return haxe_io_Bytes(len(b),b)

    @staticmethod
    def _hx_empty_init(_hx_o):
        _hx_o.length = None
        _hx_o.b = None
haxe_io_Bytes._hx_class = haxe_io_Bytes


class haxe_io_BytesBuffer:
    _hx_class_name = "haxe.io.BytesBuffer"
    __slots__ = ("b",)
    _hx_fields = ["b"]
    _hx_methods = ["getBytes"]

    def __init__(self):
        self.b = bytearray()

    def getBytes(self):
        _hx_bytes = haxe_io_Bytes(len(self.b),self.b)
        self.b = None
        return _hx_bytes

    @staticmethod
    def _hx_empty_init(_hx_o):
        _hx_o.b = None
haxe_io_BytesBuffer._hx_class = haxe_io_BytesBuffer


class haxe_io_Output:
    _hx_class_name = "haxe.io.Output"
    __slots__ = ("bigEndian",)
    _hx_fields = ["bigEndian"]
    _hx_methods = ["writeByte", "writeBytes", "close", "set_bigEndian", "writeFullBytes", "prepare", "writeString"]

    def writeByte(self,c):
        raise haxe_exceptions_NotImplementedException(None,None,_hx_AnonObject({'fileName': "haxe/io/Output.hx", 'lineNumber': 47, 'className': "haxe.io.Output", 'methodName': "writeByte"}))

    def writeBytes(self,s,pos,_hx_len):
        if (((pos < 0) or ((_hx_len < 0))) or (((pos + _hx_len) > s.length))):
            raise haxe_Exception.thrown(haxe_io_Error.OutsideBounds)
        b = s.b
        k = _hx_len
        while (k > 0):
            self.writeByte(b[pos])
            pos = (pos + 1)
            k = (k - 1)
        return _hx_len

    def close(self):
        pass

    def set_bigEndian(self,b):
        self.bigEndian = b
        return b

    def writeFullBytes(self,s,pos,_hx_len):
        while (_hx_len > 0):
            k = self.writeBytes(s,pos,_hx_len)
            pos = (pos + k)
            _hx_len = (_hx_len - k)

    def prepare(self,nbytes):
        pass

    def writeString(self,s,encoding = None):
        b = haxe_io_Bytes.ofString(s,encoding)
        self.writeFullBytes(b,0,b.length)

    @staticmethod
    def _hx_empty_init(_hx_o):
        _hx_o.bigEndian = None
haxe_io_Output._hx_class = haxe_io_Output


class haxe_io_BytesOutput(haxe_io_Output):
    _hx_class_name = "haxe.io.BytesOutput"
    __slots__ = ("b",)
    _hx_fields = ["b"]
    _hx_methods = ["writeByte", "writeBytes", "getBytes"]
    _hx_statics = []
    _hx_interfaces = []
    _hx_super = haxe_io_Output


    def __init__(self):
        self.b = haxe_io_BytesBuffer()
        self.set_bigEndian(False)

    def writeByte(self,c):
        self.b.b.append(c)

    def writeBytes(self,buf,pos,_hx_len):
        _this = self.b
        if (((pos < 0) or ((_hx_len < 0))) or (((pos + _hx_len) > buf.length))):
            raise haxe_Exception.thrown(haxe_io_Error.OutsideBounds)
        _this.b.extend(buf.b[pos:(pos + _hx_len)])
        return _hx_len

    def getBytes(self):
        return self.b.getBytes()

    @staticmethod
    def _hx_empty_init(_hx_o):
        _hx_o.b = None
haxe_io_BytesOutput._hx_class = haxe_io_BytesOutput

class haxe_io_Encoding(Enum):
    __slots__ = ()
    _hx_class_name = "haxe.io.Encoding"
    _hx_constructs = ["UTF8", "RawNative"]
haxe_io_Encoding.UTF8 = haxe_io_Encoding("UTF8", 0, ())
haxe_io_Encoding.RawNative = haxe_io_Encoding("RawNative", 1, ())
haxe_io_Encoding._hx_class = haxe_io_Encoding


class haxe_io_Eof:
    _hx_class_name = "haxe.io.Eof"
    __slots__ = ()
    _hx_methods = ["toString"]

    def __init__(self):
        pass

    def toString(self):
        return "Eof"

    @staticmethod
    def _hx_empty_init(_hx_o):        pass
haxe_io_Eof._hx_class = haxe_io_Eof

class haxe_io_Error(Enum):
    __slots__ = ()
    _hx_class_name = "haxe.io.Error"
    _hx_constructs = ["Blocked", "Overflow", "OutsideBounds", "Custom"]

    @staticmethod
    def Custom(e):
        return haxe_io_Error("Custom", 3, (e,))
haxe_io_Error.Blocked = haxe_io_Error("Blocked", 0, ())
haxe_io_Error.Overflow = haxe_io_Error("Overflow", 1, ())
haxe_io_Error.OutsideBounds = haxe_io_Error("OutsideBounds", 2, ())
haxe_io_Error._hx_class = haxe_io_Error


class haxe_io_Input:
    _hx_class_name = "haxe.io.Input"
    __slots__ = ()
    _hx_methods = ["readByte", "readBytes"]

    def readByte(self):
        raise haxe_exceptions_NotImplementedException(None,None,_hx_AnonObject({'fileName': "haxe/io/Input.hx", 'lineNumber': 53, 'className': "haxe.io.Input", 'methodName': "readByte"}))

    def readBytes(self,s,pos,_hx_len):
        k = _hx_len
        b = s.b
        if (((pos < 0) or ((_hx_len < 0))) or (((pos + _hx_len) > s.length))):
            raise haxe_Exception.thrown(haxe_io_Error.OutsideBounds)
        try:
            while (k > 0):
                b[pos] = self.readByte()
                pos = (pos + 1)
                k = (k - 1)
        except BaseException as _g:
            None
            if (not Std.isOfType(haxe_Exception.caught(_g).unwrap(),haxe_io_Eof)):
                raise _g
        return (_hx_len - k)

    @staticmethod
    def _hx_empty_init(_hx_o):        pass
haxe_io_Input._hx_class = haxe_io_Input


class haxe_iterators_ArrayIterator:
    _hx_class_name = "haxe.iterators.ArrayIterator"
    __slots__ = ("array", "current")
    _hx_fields = ["array", "current"]
    _hx_methods = ["hasNext", "next"]

    def __init__(self,array):
        self.current = 0
        self.array = array

    def hasNext(self):
        return (self.current < len(self.array))

    def next(self):
        def _hx_local_3():
            def _hx_local_2():
                _hx_local_0 = self
                _hx_local_1 = _hx_local_0.current
                _hx_local_0.current = (_hx_local_1 + 1)
                return _hx_local_1
            return python_internal_ArrayImpl._get(self.array, _hx_local_2())
        return _hx_local_3()

    @staticmethod
    def _hx_empty_init(_hx_o):
        _hx_o.array = None
        _hx_o.current = None
haxe_iterators_ArrayIterator._hx_class = haxe_iterators_ArrayIterator


class haxe_iterators_ArrayKeyValueIterator:
    _hx_class_name = "haxe.iterators.ArrayKeyValueIterator"
    __slots__ = ("current", "array")
    _hx_fields = ["current", "array"]
    _hx_methods = ["hasNext", "next"]

    def __init__(self,array):
        self.current = 0
        self.array = array

    def hasNext(self):
        return (self.current < len(self.array))

    def next(self):
        def _hx_local_3():
            def _hx_local_2():
                _hx_local_0 = self
                _hx_local_1 = _hx_local_0.current
                _hx_local_0.current = (_hx_local_1 + 1)
                return _hx_local_1
            return _hx_AnonObject({'value': python_internal_ArrayImpl._get(self.array, self.current), 'key': _hx_local_2()})
        return _hx_local_3()

    @staticmethod
    def _hx_empty_init(_hx_o):
        _hx_o.current = None
        _hx_o.array = None
haxe_iterators_ArrayKeyValueIterator._hx_class = haxe_iterators_ArrayKeyValueIterator


class hxjsonast_Error:
    _hx_class_name = "hxjsonast.Error"
    __slots__ = ("message", "pos")
    _hx_fields = ["message", "pos"]

    def __init__(self,message,pos):
        self.message = message
        self.pos = pos

    @staticmethod
    def _hx_empty_init(_hx_o):
        _hx_o.message = None
        _hx_o.pos = None
hxjsonast_Error._hx_class = hxjsonast_Error


class hxjsonast_Json:
    _hx_class_name = "hxjsonast.Json"
    __slots__ = ("value", "pos")
    _hx_fields = ["value", "pos"]

    def __init__(self,value,pos):
        self.value = value
        self.pos = pos

    @staticmethod
    def _hx_empty_init(_hx_o):
        _hx_o.value = None
        _hx_o.pos = None
hxjsonast_Json._hx_class = hxjsonast_Json

class hxjsonast_JsonValue(Enum):
    __slots__ = ()
    _hx_class_name = "hxjsonast.JsonValue"
    _hx_constructs = ["JString", "JNumber", "JObject", "JArray", "JBool", "JNull"]

    @staticmethod
    def JString(s):
        return hxjsonast_JsonValue("JString", 0, (s,))

    @staticmethod
    def JNumber(s):
        return hxjsonast_JsonValue("JNumber", 1, (s,))

    @staticmethod
    def JObject(fields):
        return hxjsonast_JsonValue("JObject", 2, (fields,))

    @staticmethod
    def JArray(values):
        return hxjsonast_JsonValue("JArray", 3, (values,))

    @staticmethod
    def JBool(b):
        return hxjsonast_JsonValue("JBool", 4, (b,))
hxjsonast_JsonValue.JNull = hxjsonast_JsonValue("JNull", 5, ())
hxjsonast_JsonValue._hx_class = hxjsonast_JsonValue


class hxjsonast_JObjectField:
    _hx_class_name = "hxjsonast.JObjectField"
    __slots__ = ("name", "namePos", "value")
    _hx_fields = ["name", "namePos", "value"]

    def __init__(self,name,namePos,value):
        self.name = name
        self.namePos = namePos
        self.value = value

    @staticmethod
    def _hx_empty_init(_hx_o):
        _hx_o.name = None
        _hx_o.namePos = None
        _hx_o.value = None
hxjsonast_JObjectField._hx_class = hxjsonast_JObjectField


class hxjsonast_Parser:
    _hx_class_name = "hxjsonast.Parser"
    __slots__ = ("source", "filename", "pos")
    _hx_fields = ["source", "filename", "pos"]
    _hx_methods = ["doParse", "parseRec", "parseString", "parseNumber", "nextChar", "mk", "mkPos", "invalidChar", "invalidNumber"]
    _hx_statics = ["parse"]

    def __init__(self,source,filename):
        self.source = source
        self.filename = filename
        self.pos = 0

    def doParse(self):
        result = self.parseRec()
        c = None
        while True:
            s = self.source
            index = self.pos
            self.pos = (self.pos + 1)
            c = (-1 if ((index >= len(s))) else ord(s[index]))
            if (not ((c != -1))):
                break
            c1 = c
            if ((((c1 == 32) or ((c1 == 13))) or ((c1 == 10))) or ((c1 == 9))):
                pass
            else:
                self.invalidChar()
        return result

    def parseRec(self):
        while True:
            s = self.source
            index = self.pos
            self.pos = (self.pos + 1)
            c = (-1 if ((index >= len(s))) else ord(s[index]))
            c1 = c
            if ((((c1 == 32) or ((c1 == 13))) or ((c1 == 10))) or ((c1 == 9))):
                pass
            elif (c1 == 34):
                save = self.pos
                s1 = self.parseString()
                return hxjsonast_Json(hxjsonast_JsonValue.JString(s1),hxjsonast_Position(self.filename,(save - 1),self.pos))
            elif (((((((((((c1 == 57) or ((c1 == 56))) or ((c1 == 55))) or ((c1 == 54))) or ((c1 == 53))) or ((c1 == 52))) or ((c1 == 51))) or ((c1 == 50))) or ((c1 == 49))) or ((c1 == 48))) or ((c1 == 45))):
                start = (self.pos - 1)
                minus = (c == 45)
                digit = (not minus)
                zero = (c == 48)
                point = False
                e = False
                pm = False
                end = False
                while True:
                    s2 = self.source
                    index1 = self.pos
                    self.pos = (self.pos + 1)
                    _g = (-1 if ((index1 >= len(s2))) else ord(s2[index1]))
                    if ((_g == 45) or ((_g == 43))):
                        if ((not e) or pm):
                            self.invalidNumber(start)
                        digit = False
                        pm = True
                    elif (_g == 46):
                        if ((minus or point) or e):
                            self.invalidNumber(start)
                        digit = False
                        point = True
                    elif (_g == 48):
                        if (zero and (not point)):
                            self.invalidNumber(start)
                        if minus:
                            minus = False
                            zero = True
                        digit = True
                    elif (((((((((_g == 57) or ((_g == 56))) or ((_g == 55))) or ((_g == 54))) or ((_g == 53))) or ((_g == 52))) or ((_g == 51))) or ((_g == 50))) or ((_g == 49))):
                        if (zero and (not point)):
                            self.invalidNumber(start)
                        if minus:
                            minus = False
                        digit = True
                        zero = False
                    elif ((_g == 101) or ((_g == 69))):
                        if ((minus or zero) or e):
                            self.invalidNumber(start)
                        digit = False
                        e = True
                    else:
                        if (not digit):
                            self.invalidNumber(start)
                        _hx_local_0 = self
                        _hx_local_1 = _hx_local_0.pos
                        _hx_local_0.pos = (_hx_local_1 - 1)
                        _hx_local_1
                        end = True
                    if end:
                        break
                s3 = HxString.substr(self.source,start,(self.pos - start))
                return hxjsonast_Json(hxjsonast_JsonValue.JNumber(s3),hxjsonast_Position(self.filename,start,self.pos))
            elif (c1 == 91):
                values = []
                comma = None
                startPos = (self.pos - 1)
                while True:
                    s4 = self.source
                    index2 = self.pos
                    self.pos = (self.pos + 1)
                    _g1 = (-1 if ((index2 >= len(s4))) else ord(s4[index2]))
                    if ((((_g1 == 32) or ((_g1 == 13))) or ((_g1 == 10))) or ((_g1 == 9))):
                        pass
                    elif (_g1 == 44):
                        if comma:
                            comma = False
                        else:
                            self.invalidChar()
                    elif (_g1 == 93):
                        if (comma == False):
                            self.invalidChar()
                        return hxjsonast_Json(hxjsonast_JsonValue.JArray(values),hxjsonast_Position(self.filename,startPos,self.pos))
                    else:
                        if comma:
                            self.invalidChar()
                        _hx_local_2 = self
                        _hx_local_3 = _hx_local_2.pos
                        _hx_local_2.pos = (_hx_local_3 - 1)
                        _hx_local_3
                        x = self.parseRec()
                        values.append(x)
                        comma = True
            elif (c1 == 102):
                save1 = self.pos
                tmp = None
                tmp1 = None
                tmp2 = None
                s5 = self.source
                index3 = self.pos
                self.pos = (self.pos + 1)
                if (((-1 if ((index3 >= len(s5))) else ord(s5[index3]))) == 97):
                    s6 = self.source
                    index4 = self.pos
                    self.pos = (self.pos + 1)
                    tmp2 = (((-1 if ((index4 >= len(s6))) else ord(s6[index4]))) != 108)
                else:
                    tmp2 = True
                if (not tmp2):
                    s7 = self.source
                    index5 = self.pos
                    self.pos = (self.pos + 1)
                    tmp1 = (((-1 if ((index5 >= len(s7))) else ord(s7[index5]))) != 115)
                else:
                    tmp1 = True
                if (not tmp1):
                    s8 = self.source
                    index6 = self.pos
                    self.pos = (self.pos + 1)
                    tmp = (((-1 if ((index6 >= len(s8))) else ord(s8[index6]))) != 101)
                else:
                    tmp = True
                if tmp:
                    self.pos = save1
                    self.invalidChar()
                return hxjsonast_Json(hxjsonast_JsonValue.JBool(False),hxjsonast_Position(self.filename,(save1 - 1),self.pos))
            elif (c1 == 110):
                save2 = self.pos
                tmp3 = None
                tmp4 = None
                s9 = self.source
                index7 = self.pos
                self.pos = (self.pos + 1)
                if (((-1 if ((index7 >= len(s9))) else ord(s9[index7]))) == 117):
                    s10 = self.source
                    index8 = self.pos
                    self.pos = (self.pos + 1)
                    tmp4 = (((-1 if ((index8 >= len(s10))) else ord(s10[index8]))) != 108)
                else:
                    tmp4 = True
                if (not tmp4):
                    s11 = self.source
                    index9 = self.pos
                    self.pos = (self.pos + 1)
                    tmp3 = (((-1 if ((index9 >= len(s11))) else ord(s11[index9]))) != 108)
                else:
                    tmp3 = True
                if tmp3:
                    self.pos = save2
                    self.invalidChar()
                return hxjsonast_Json(hxjsonast_JsonValue.JNull,hxjsonast_Position(self.filename,(save2 - 1),self.pos))
            elif (c1 == 116):
                save3 = self.pos
                tmp5 = None
                tmp6 = None
                s12 = self.source
                index10 = self.pos
                self.pos = (self.pos + 1)
                if (((-1 if ((index10 >= len(s12))) else ord(s12[index10]))) == 114):
                    s13 = self.source
                    index11 = self.pos
                    self.pos = (self.pos + 1)
                    tmp6 = (((-1 if ((index11 >= len(s13))) else ord(s13[index11]))) != 117)
                else:
                    tmp6 = True
                if (not tmp6):
                    s14 = self.source
                    index12 = self.pos
                    self.pos = (self.pos + 1)
                    tmp5 = (((-1 if ((index12 >= len(s14))) else ord(s14[index12]))) != 101)
                else:
                    tmp5 = True
                if tmp5:
                    self.pos = save3
                    self.invalidChar()
                return hxjsonast_Json(hxjsonast_JsonValue.JBool(True),hxjsonast_Position(self.filename,(save3 - 1),self.pos))
            elif (c1 == 123):
                fields = list()
                names = haxe_ds_StringMap()
                field = None
                fieldPos = None
                comma1 = None
                startPos1 = (self.pos - 1)
                while True:
                    s15 = self.source
                    index13 = self.pos
                    self.pos = (self.pos + 1)
                    _g2 = (-1 if ((index13 >= len(s15))) else ord(s15[index13]))
                    if ((((_g2 == 32) or ((_g2 == 13))) or ((_g2 == 10))) or ((_g2 == 9))):
                        pass
                    elif (_g2 == 34):
                        if ((field is not None) or comma1):
                            self.invalidChar()
                        fieldStartPos = (self.pos - 1)
                        field = self.parseString()
                        fieldPos = hxjsonast_Position(self.filename,fieldStartPos,self.pos)
                        if (field in names.h):
                            raise haxe_Exception.thrown(hxjsonast_Error((("Duplicate field name \"" + ("null" if field is None else field)) + "\""),fieldPos))
                        else:
                            names.h[field] = True
                    elif (_g2 == 44):
                        if comma1:
                            comma1 = False
                        else:
                            self.invalidChar()
                    elif (_g2 == 58):
                        if (field is None):
                            self.invalidChar()
                        x1 = hxjsonast_JObjectField(field,fieldPos,self.parseRec())
                        fields.append(x1)
                        field = None
                        fieldPos = None
                        comma1 = True
                    elif (_g2 == 125):
                        if ((field is not None) or ((comma1 == False))):
                            self.invalidChar()
                        return hxjsonast_Json(hxjsonast_JsonValue.JObject(fields),hxjsonast_Position(self.filename,startPos1,self.pos))
                    else:
                        self.invalidChar()
            else:
                self.invalidChar()

    def parseString(self):
        start = self.pos
        buf = None
        while True:
            s = self.source
            index = self.pos
            self.pos = (self.pos + 1)
            c = (-1 if ((index >= len(s))) else ord(s[index]))
            if (c == 34):
                break
            if (c == 92):
                if (buf is None):
                    buf = StringBuf()
                s1 = self.source
                _hx_len = ((self.pos - start) - 1)
                s2 = (HxString.substr(s1,start,None) if ((_hx_len is None)) else HxString.substr(s1,start,_hx_len))
                buf.b.write(s2)
                s3 = self.source
                index1 = self.pos
                self.pos = (self.pos + 1)
                c = (-1 if ((index1 >= len(s3))) else ord(s3[index1]))
                c1 = c
                if (((c1 == 92) or ((c1 == 47))) or ((c1 == 34))):
                    s4 = "".join(map(chr,[c]))
                    buf.b.write(s4)
                elif (c1 == 98):
                    s5 = "".join(map(chr,[8]))
                    buf.b.write(s5)
                elif (c1 == 102):
                    s6 = "".join(map(chr,[12]))
                    buf.b.write(s6)
                elif (c1 == 110):
                    s7 = "".join(map(chr,[10]))
                    buf.b.write(s7)
                elif (c1 == 114):
                    s8 = "".join(map(chr,[13]))
                    buf.b.write(s8)
                elif (c1 == 116):
                    s9 = "".join(map(chr,[9]))
                    buf.b.write(s9)
                elif (c1 == 117):
                    uc = Std.parseInt(("0x" + HxOverrides.stringOrNull(HxString.substr(self.source,self.pos,4))))
                    _hx_local_0 = self
                    _hx_local_1 = _hx_local_0.pos
                    _hx_local_0.pos = (_hx_local_1 + 4)
                    _hx_local_0.pos
                    s10 = "".join(map(chr,[uc]))
                    buf.b.write(s10)
                else:
                    raise haxe_Exception.thrown(hxjsonast_Error(("Invalid escape sequence \\" + HxOverrides.stringOrNull("".join(map(chr,[c])))),hxjsonast_Position(self.filename,(self.pos - 2),self.pos)))
                start = self.pos
            elif (c == -1):
                _hx_local_2 = self
                _hx_local_3 = _hx_local_2.pos
                _hx_local_2.pos = (_hx_local_3 - 1)
                _hx_local_3
                raise haxe_Exception.thrown(hxjsonast_Error("Unclosed string",hxjsonast_Position(self.filename,(start - 1),self.pos)))
        if (buf is None):
            return HxString.substr(self.source,start,((self.pos - start) - 1))
        else:
            s = self.source
            _hx_len = ((self.pos - start) - 1)
            s1 = (HxString.substr(s,start,None) if ((_hx_len is None)) else HxString.substr(s,start,_hx_len))
            buf.b.write(s1)
            return buf.b.getvalue()

    def parseNumber(self,c):
        start = (self.pos - 1)
        minus = (c == 45)
        digit = (not minus)
        zero = (c == 48)
        point = False
        e = False
        pm = False
        end = False
        while True:
            s = self.source
            index = self.pos
            self.pos = (self.pos + 1)
            _g = (-1 if ((index >= len(s))) else ord(s[index]))
            if ((_g == 45) or ((_g == 43))):
                if ((not e) or pm):
                    self.invalidNumber(start)
                digit = False
                pm = True
            elif (_g == 46):
                if ((minus or point) or e):
                    self.invalidNumber(start)
                digit = False
                point = True
            elif (_g == 48):
                if (zero and (not point)):
                    self.invalidNumber(start)
                if minus:
                    minus = False
                    zero = True
                digit = True
            elif (((((((((_g == 57) or ((_g == 56))) or ((_g == 55))) or ((_g == 54))) or ((_g == 53))) or ((_g == 52))) or ((_g == 51))) or ((_g == 50))) or ((_g == 49))):
                if (zero and (not point)):
                    self.invalidNumber(start)
                if minus:
                    minus = False
                digit = True
                zero = False
            elif ((_g == 101) or ((_g == 69))):
                if ((minus or zero) or e):
                    self.invalidNumber(start)
                digit = False
                e = True
            else:
                if (not digit):
                    self.invalidNumber(start)
                _hx_local_0 = self
                _hx_local_1 = _hx_local_0.pos
                _hx_local_0.pos = (_hx_local_1 - 1)
                _hx_local_1
                end = True
            if end:
                break
        s = HxString.substr(self.source,start,(self.pos - start))
        return hxjsonast_Json(hxjsonast_JsonValue.JNumber(s),hxjsonast_Position(self.filename,start,self.pos))

    def nextChar(self):
        s = self.source
        index = self.pos
        self.pos = (self.pos + 1)
        if (index >= len(s)):
            return -1
        else:
            return ord(s[index])

    def mk(self,pos,value):
        return hxjsonast_Json(value,pos)

    def mkPos(self,_hx_min,_hx_max):
        return hxjsonast_Position(self.filename,_hx_min,_hx_max)

    def invalidChar(self):
        _hx_local_0 = self
        _hx_local_1 = _hx_local_0.pos
        _hx_local_0.pos = (_hx_local_1 - 1)
        _hx_local_1
        _this = self.source
        index = self.pos
        raise haxe_Exception.thrown(hxjsonast_Error(("Invalid character: " + HxOverrides.stringOrNull((("" if (((index < 0) or ((index >= len(_this))))) else _this[index])))),hxjsonast_Position(self.filename,self.pos,(self.pos + 1))))

    def invalidNumber(self,start):
        raise haxe_Exception.thrown(hxjsonast_Error(("Invalid number: " + HxOverrides.stringOrNull(HxString.substring(self.source,start,self.pos))),hxjsonast_Position(self.filename,start,self.pos)))

    @staticmethod
    def parse(source,filename):
        return hxjsonast_Parser(source,filename).doParse()

    @staticmethod
    def _hx_empty_init(_hx_o):
        _hx_o.source = None
        _hx_o.filename = None
        _hx_o.pos = None
hxjsonast_Parser._hx_class = hxjsonast_Parser


class hxjsonast_Position:
    _hx_class_name = "hxjsonast.Position"
    __slots__ = ("file", "min", "max")
    _hx_fields = ["file", "min", "max"]

    def __init__(self,file,_hx_min,_hx_max):
        self.file = file
        self.min = _hx_min
        self.max = _hx_max

    @staticmethod
    def _hx_empty_init(_hx_o):
        _hx_o.file = None
        _hx_o.min = None
        _hx_o.max = None
hxjsonast_Position._hx_class = hxjsonast_Position


class jackbergus_protocol_EvaluatorOrSubscriberServer:
    _hx_class_name = "jackbergus.protocol.EvaluatorOrSubscriberServer"
    __slots__ = ("eos",)
    _hx_fields = ["eos"]
    _hx_methods = ["processInstruction", "server"]

    def __init__(self,c,serviceId,registerFor,sleep = None,inFuture = None,inNext = None,busyWait = None,servicePrefix = None):
        if (sleep is None):
            sleep = 0.5
        if (inFuture is None):
            inFuture = False
        if (inNext is None):
            inNext = True
        if (busyWait is None):
            busyWait = True
        if (servicePrefix is None):
            servicePrefix = "service"
        self.eos = jackbergus_protocol_EvaluatorOrSubscriber(c,serviceId,registerFor,sleep,inFuture,inNext,busyWait,servicePrefix)

    def server(self):
        outcome = True
        while outcome:
            data = self.eos.foreverServerGetData()
            payload = ""
            print(str(("Payload: " + ("null" if payload is None else payload))))
            tmp = data.index
            if (tmp == 0):
                m = data.params[0]
                c = data.params[1]
                return jackbergus_utils_ErrorMonad.Error(m,c)
            elif (tmp == 1):
                d = data.params[0]
                payload = d
            else:
                pass
            out = self.processInstruction(payload)
            print(str(("Payload response: " + ("null" if out is None else out))))
            response = self.eos.foreverServerSendResponse(out)
            tmp1 = response.index
            if (tmp1 == 0):
                _g = response.params[0]
                _g1 = response.params[1]
                return response
            elif (tmp1 == 1):
                x = response.params[0]
                outcome = x
            else:
                pass
        return jackbergus_utils_ErrorMonad.Good(outcome)

    @staticmethod
    def _hx_empty_init(_hx_o):
        _hx_o.eos = None
jackbergus_protocol_EvaluatorOrSubscriberServer._hx_class = jackbergus_protocol_EvaluatorOrSubscriberServer


class jackbergus_Testing(jackbergus_protocol_EvaluatorOrSubscriberServer):
    _hx_class_name = "jackbergus.Testing"
    __slots__ = ()
    _hx_fields = []
    _hx_methods = ["processInstruction"]
    _hx_statics = []
    _hx_interfaces = []
    _hx_super = jackbergus_protocol_EvaluatorOrSubscriberServer


    def __init__(self,c,serviceId,registerFor,sleep = None,inFuture = None,inNext = None,busyWait = None,servicePrefix = None):
        super().__init__(c,serviceId,registerFor,sleep,inFuture,inNext,busyWait,servicePrefix)

    def processInstruction(self,input):
        print(str(input))
        return "Reply from bogus service!"

    @staticmethod
    def _hx_empty_init(_hx_o):        pass
jackbergus_Testing._hx_class = jackbergus_Testing


class DGDL_MICROSERVICE(jackbergus_protocol_EvaluatorOrSubscriberServer):
    _hx_class_name = "jackbergus.Testing"
    __slots__ = ('microservice')
    _hx_fields = ['microservice']
    _hx_methods = ["processInstruction"]
    _hx_statics = []
    _hx_interfaces = []
    _hx_super = jackbergus_protocol_EvaluatorOrSubscriberServer


    def __init__(self,c,serviceId,registerFor,sleep = None,inFuture = None,inNext = None,busyWait = None,servicePrefix = None):
        super().__init__(c,serviceId,registerFor,sleep,inFuture,inNext,busyWait,servicePrefix)

    def set_microservice(self, micro):
        self.microservice = micro

    def processInstruction(self,input):
        if self.microservice is not None:
            print("Input: " +input)
            result = str(self.microservice(input))
            print("Output: " +result)
            return result

    @staticmethod
    def _hx_empty_init(_hx_o):        pass
DGDL_MICROSERVICE._hx_class = DGDL_MICROSERVICE

# class jackbergus_Main:
#     _hx_class_name = "jackbergus.Main"
#     __slots__ = ()
#     _hx_statics = ["main", "game"]
#
#     @staticmethod
#     def main():
#         jackbergus_Main.game(1)
#
#     @staticmethod
#     def game(serviceID = None):
#         if (serviceID is None):
#             serviceID = 1
#         game = "\n\n\n        BOGUS {\n          turns{magnitude:single,ordering:strict}\n          roles{speaker,listener}\n          players{min:2, max:undefined}\n          player{id:Proposer,roles{speaker}}\n          player{id:Evaluator,roles{listener}}\n      \n           // This is mainly to store the request: it might be renamed\n          store { id: StackinteractionA, owner: shared, structure: stack, visibility : public   }\n      \n          // Players subscribing to the supplier to privde the information in broadcast\n          store { id: PlayersinteractionA, owner: shared, structure: stack, visibility : public  }\n      \n          // Whether the player has already read the information from the broadcaster\n          store { id: AlreadyReadinteractionA, owner: shared, structure: stack, visibility : public  }\n      \n          // The reply associated to the player\n          store { id: ReplyinteractionA, owner: shared, structure: stack, visibility : public  }\n      \n          // The reply associated to the player\n          store { id: ReplyAuthorinteractionA, owner: shared, structure: stack, visibility : public  }\n            // This is mainly to store the request: it might be renamed\n          store { id: StackinteractionB, owner: shared, structure: stack, visibility : public   }\n      \n          // Players subscribing to the supplier to privde the information in broadcast\n          store { id: PlayersinteractionB, owner: shared, structure: stack, visibility : public  }\n      \n          // Whether the player has already read the information from the broadcaster\n          store { id: AlreadyReadinteractionB, owner: shared, structure: stack, visibility : public  }\n      \n          // The reply associated to the player\n          store { id: ReplyinteractionB, owner: shared, structure: stack, visibility : public  }\n      \n          // The reply associated to the player\n          store { id: ReplyAuthorinteractionB, owner: shared, structure: stack, visibility : public  }\n          \n      \n          rule{id:StartingRule, scope:initial, {  move(add, next, SubscribeinteractionA, Evaluator)\n           &  move(add, next, SubscribeinteractionB, Evaluator)\n           }}\n      \n      \n          // First, someone can publish only if someone subscribed. This still allows other services to subscribe, and enables\n          // the client to start publishing. Still, I can subscribe only if I haven’t done so yet.\n          interaction { SubscribeinteractionA, { if { inspect(!in, {s}, PlayersinteractionA ) }  then {\n                                               store(add, {s}, PlayersinteractionA, listener) &\n                                               move(add, next, StartPublishinteractionA, $Proposer, Proposer) &\n                                               move(add, next, SubscribeinteractionA, Evaluator)\n                                           }\n                                      }\n                      }\n      \n          // The publisher stops all the subscribers to register and to do whatsoever operation, then, it starts adding the data\n          interaction { StartPublishinteractionA, { move(delete, next, SubscribeinteractionA, $Evaluator, Evaluator) &\n                                           move(add, next, PublishinteractionA, $Proposer, {p}, Proposer)\n                                         }\n                      }\n      \n          // Now, the publisher starts sending the data to the subscribers, that are going to reply to the data being passed with some\n          //  data replyThis might have been better expressed with a while-true loop, but anyway, expressing that the publisher shall\n          // repeat in the stack as many arguments as the number of players, while allowing the players only to publish\n          interaction { PublishinteractionA , {  if { magnitude(StackinteractionA, shared, smaller, PlayersinteractionA, shared) } then {\n                                                store(add, {d}, StackinteractionA, listener) &\n                                                move(add, next, PublishinteractionA, $Proposer, {d}, Proposer) &\n                                                store(copy, {l}, PlayersinteractionA, listener)\n                                           } else {\n                                                move(add, next, ConsumeinteractionA, $Evaluator, Evaluator)\n                                           }\n                                     }\n                      }\n      \n      \n      \n          // I can consume only if I was previously subscribed to this and if I haven’t read yet\n          interaction { ConsumeinteractionA , { if { inspect(!in, {s}, AlreadyReadinteractionA )  &\n                                            inspect(in, {s}, PlayersinteractionA ) }  then {\n      \n                                                store(pop, {p}, StackinteractionA, listener) & // reading the data for me on the stack\n                                                store(add, {s}, AlreadyReadinteractionA, listener) & // Setting myself as already read the data\n                                                move(add, next, PushOutcomeinteractionA, $Evaluator, Evaluator) &\n                                                move(add, next, ConsumeinteractionA, $Evaluator, Evaluator)\n                                           }\n                                     }\n                      }\n      \n          interaction { PushOutcomeinteractionA, {    if { inspect(in, {s}, PlayersinteractionA) &\n                                                  inspect(in, {s}, AlreadyReadinteractionA ) } then {\n      \n                                                    store(add, {o}, ReplyinteractionA, listener) &\n                                                    store(add, {s}, ReplyAuthorinteractionA, listener) &\n                                                    // Action that will be done effectively only by the last subscriber\n                                                    move(add, next, TestLastinteractionA, $Evaluator, Evaluator) &\n                                                    move(add, next, PushOutcomeinteractionA, $Evaluator, Evaluator) &\n                                                    move(add, next, ConsumeinteractionA, $Evaluator, Evaluator)\n                                                }\n                                        }\n                      }\n      \n              interaction { TestLastinteractionA, { if { magnitude(PlayersinteractionA, shared, equal, ReplyAuthorinteractionA, shared) &\n                                                magnitude(ReplyinteractionA, shared, equal, AlreadyReadinteractionA, shared) &\n                                                magnitude(PlayersinteractionA, shared, equal, AlreadyReadinteractionA, shared) } then {\n      \n                                                      move(add, next, PopOutcomeinteractionA, $Proposer, Proposer)\n                                              } else {\n                                                                                            move(add, next, TestLastinteractionA, $Evaluator, Evaluator) &\n                                                    move(add, next, TestLastinteractionA, $Evaluator, Evaluator) &\n                                                    move(add, next, PushOutcomeinteractionA, $Evaluator, Evaluator) &\n                                                    move(add, next, ConsumeinteractionA, $Evaluator, Evaluator)\n                                              }\n                                         }\n                          }\n      \n          interaction { PopOutcomeinteractionA, { if { size(ReplyinteractionA, Proposer, !empty) &\n                                              size(ReplyAuthorinteractionA, Proposer, !empty)  } then {\n      \n                                                 store(pop, {o}, ReplyinteractionA, speaker) &\n                                                 store(pop, {s}, ReplyAuthorinteractionA, speaker) &\n                                                 move(add, next, PopOutcomeinteractionA, $Evaluator, Proposer)\n                                            } else {\n                                                  // When I reach the maximum capacity, I enforce all the players to re-register if they\n                                                  // want to subscribe to the next round, and allowing all the players to consume.\n                                                  store(empty, PlayersinteractionA, listener) &\n                                                  store(empty, AlreadyReadinteractionA, listener) &\n                                                  store(empty, ReplyinteractionA, listener) &\n                                                  store(empty, ReplyAuthorinteractionA, listener) &\n                                                  store(empty, StackinteractionA, listener) &\n                                                  move(add, next, SubscribeinteractionA, Evaluator) // Going back to allowing the next process to subscribe itself\n                                           }\n                                       }\n                       }\n      }\n        "
#         service = ("service" + Std.string(serviceID))
#         participants = jackbergus_dgep_requests_Participant()
#         participants.add("client","Proposer")
#         participants.add("service1","Evaluator")
#         participants.add("service2","Evaluator")
#         participants.add("service3","Evaluator")
#         connection = jackbergus_dgep_connections_ConnectionLogic("127.0.0.1",5000)
#         pl = connection.newProtocol("test_game",game)
#         dl = pl.newDialogue("0",participants,service)
#         service1 = jackbergus_Testing(dl,serviceID,"interactionA")
#         service1.server()
#         print("EXIT")
# jackbergus_Main._hx_class = jackbergus_Main

import yaml

def setup_microservice(yaml_configuration_file_path, lambdaFunction):
    conf = dict()
    try:
        with open(yaml_configuration_file_path, 'r') as stream:
            conf = yaml.safe_load(stream)
    except:
        print("ERROR: unable to correctly parse the configuration file: " + yaml_configuration_file_path)
        sys.exit(1)

    if not 'service' in conf:
        print("ERROR: the service requires a service name: please specify it in 'service'")
        sys.exit(1)
    service = conf['service']

    if not 'interaction' in conf:
        print("ERROR: a service must register for an interaction. Please specify it in 'interaction'")
        sys.exit(1)
    interaction = conf['interaction']

    ## 1. loading the game
    game = ""
    if not "game_location" in conf:
        print("ERROR: please specify the location where the game dialogue is located: 'game_location'")
        sys.exit(1)
    if ("isGameFOL" in conf) and (conf["isGameFOL"]):
        g = Generaliser()
        game = g.readFile(conf['game_location'], False)
    else:
        with open(conf['game_location'], 'r') as file:
            game = file.read()

    ## 2. setting up the participants
    participants = jackbergus_dgep_requests_Participant()
    if not "participants" in conf:
        print("ERROR: please specify the location where the participants are declared: 'participants'")
        sys.exit(1)
    with open(conf['participants'], 'r') as file:
        for k, v in json.loads(file.read()).items():
            participants.add(k, v)

    url = "127.0.0.1"
    port = 5000
    if 'broker_ip' in conf:
        url = conf['broker_ip']
    if 'broker_port' in conf:
        port = int(conf['broker_port'])
    connection = jackbergus_dgep_connections_ConnectionLogic(url, port)

    if 'protocol' not in conf:
        print("ERROR: please specify the name of the game: 'protocol'")
        sys.exit(1)
    pl = connection.newProtocol(conf['protocol'], game)

    if 'new_dialogue' not in conf:
        print("ERROR: please specify the name of the current dialogue instance: 'new_dialogue'")
        sys.exit(1)
    dl = pl.newDialogue(conf['new_dialogue'], participants, service)
    service1 = DGDL_MICROSERVICE(dl, None, interaction, servicePrefix=service, sleep=5.0)
    service1.set_microservice(lambdaFunction)
    service1.server()
    print("EXIT")


class jackbergus_dgep_RestfulHTTPConnections:
    _hx_class_name = "jackbergus.dgep.RestfulHTTPConnections"
    __slots__ = ("url",)
    _hx_fields = ["url"]
    _hx_methods = ["fileRequest", "postFile", "get", "putFile"]

    def __init__(self,addr,port):
        self.url = ((("http://" + ("null" if addr is None else addr)) + ":") + Std.string(port))

    def fileRequest(self,path,content = None,isPut = None):
        if (content is None):
            content = ""
        if (isPut is None):
            isPut = True
        req = sys_Http((HxOverrides.stringOrNull(self.url) + ("null" if path is None else path)))
        responseBytes = haxe_io_BytesOutput()
        if (len(content) > 0):
            req.setPostData(content)
        def _hx_local_0(error):
            raise haxe_Exception.thrown(error)
        req.onError = _hx_local_0
        if isPut:
            req.customRequest(True,responseBytes,None,"PUT")
        else:
            req.customRequest(True,responseBytes)
        response = responseBytes.getBytes()
        return response.toString()

    def postFile(self,path,content = None):
        if (content is None):
            content = ""
        return self.fileRequest(path,content,False)

    def get(self,path):
        return restclient_RestClient.get((HxOverrides.stringOrNull(self.url) + ("null" if path is None else path)))

    def putFile(self,path,content = None):
        if (content is None):
            content = ""
        return self.fileRequest(path,content,True)

    @staticmethod
    def _hx_empty_init(_hx_o):
        _hx_o.url = None
jackbergus_dgep_RestfulHTTPConnections._hx_class = jackbergus_dgep_RestfulHTTPConnections


class jackbergus_dgep_connections_DialogueLogic:
    _hx_class_name = "jackbergus.dgep.connections.DialogueLogic"
    __slots__ = ("x", "protocolName", "dialogueName", "msg")
    _hx_fields = ["x", "protocolName", "dialogueName", "msg"]
    _hx_methods = ["getMovesFromMessage", "interaction", "moves"]

    def __init__(self,x,protocol,dialogue,msg):
        self.x = x
        self.protocolName = protocol
        self.dialogueName = dialogue
        self.msg = msg

    def getMovesFromMessage(self):
        r = None
        if (self.msg is not None):
            r = self.msg.moves.response
        return r

    def interaction(self,i):
        json = haxe_format_JsonPrinter.print(i,None,None)
        return self.x.interaction(self.dialogueName,i.moveId,json)

    def moves(self,initiator = None):
        if (initiator is None):
            initiator = ""
        z = self.x.dialogueMoves(self.dialogueName,initiator)
        if (z is None):
            print("Communication ERROR!")
        return z

    @staticmethod
    def _hx_empty_init(_hx_o):
        _hx_o.x = None
        _hx_o.protocolName = None
        _hx_o.dialogueName = None
        _hx_o.msg = None
jackbergus_dgep_connections_DialogueLogic._hx_class = jackbergus_dgep_connections_DialogueLogic


class jackbergus_dgep_connections_ProtocolLogic:
    _hx_class_name = "jackbergus.dgep.connections.ProtocolLogic"
    __slots__ = ("x", "msg", "protocol", "dialogues")
    _hx_fields = ["x", "msg", "protocol", "dialogues"]
    _hx_methods = ["newDialogue", "getMessage"]

    def __init__(self,x,protocolName,msg):
        self.x = x
        self.msg = msg
        self.protocol = protocolName
        self.dialogues = haxe_ds_StringMap()

    def newDialogue(self,name,p,initiator = None):
        if (initiator is None):
            initiator = ""
        msg = self.x.newDialogueFromProtocol(self.protocol,name,p.toJSONString(),initiator)
        dl = jackbergus_dgep_connections_DialogueLogic(self.x,self.protocol,name,msg)
        self.dialogues.h[name] = dl
        return dl

    def getMessage(self):
        return self.msg

    @staticmethod
    def _hx_empty_init(_hx_o):
        _hx_o.x = None
        _hx_o.msg = None
        _hx_o.protocol = None
        _hx_o.dialogues = None
jackbergus_dgep_connections_ProtocolLogic._hx_class = jackbergus_dgep_connections_ProtocolLogic


class jackbergus_dgep_connections_ConnectionLogic:
    _hx_class_name = "jackbergus.dgep.connections.ConnectionLogic"
    __slots__ = ("x", "protocols")
    _hx_fields = ["x", "protocols"]
    _hx_methods = ["dumpDB", "loadDB", "getProtocol", "list", "newProtocol"]

    def __init__(self,addr,port):
        self.x = jackbergus_dgep_connections_ConnectionRaw(addr,port)
        self.protocols = haxe_ds_StringMap()

    def dumpDB(self):
        return self.x.dump()

    def loadDB(self,db):
        json = haxe_format_JsonPrinter.print(db,None,None)
        return self.x.loadDB(json)

    def getProtocol(self,name):
        obj = self.x.getProtocol2(name)
        protocol = None
        if (obj != "Protocol not found"):
            if (name in self.protocols.h):
                protocol = self.protocols.h.get(name,None)
            else:
                pm = jackbergus_dgep_messages_ProtocolMessage("saved",name)
                this1 = self.protocols
                value = jackbergus_dgep_connections_ProtocolLogic(self.x,name,pm)
                this1.h[name] = value
                protocol = self.protocols.h.get(name,None)
        return protocol

    def list(self):
        return self.x.list()

    def newProtocol(self,name,data):
        obj = self.x.newProtocol(name,data)
        pl = jackbergus_dgep_connections_ProtocolLogic(self.x,name,obj)
        self.protocols.h[name] = pl
        return pl

    @staticmethod
    def _hx_empty_init(_hx_o):
        _hx_o.x = None
        _hx_o.protocols = None
jackbergus_dgep_connections_ConnectionLogic._hx_class = jackbergus_dgep_connections_ConnectionLogic


class jackbergus_dgep_connections_ConnectionRaw:
    _hx_class_name = "jackbergus.dgep.connections.ConnectionRaw"
    __slots__ = ("url", "protocolListParser")
    _hx_fields = ["url", "protocolListParser"]
    _hx_methods = ["loadDB", "dump", "newDialogueFromProtocol", "interaction", "dialogueMoves", "getProtocol2", "list", "newProtocol"]

    def __init__(self,addr,port):
        self.url = jackbergus_dgep_RestfulHTTPConnections(addr,port)
        self.protocolListParser = JsonParser_11()

    def loadDB(self,json):
        return self.url.postFile("/load/",json)

    def dump(self):
        x = self.url.get("/dump/")
        obj = python_lib_Json.loads(x,**python__KwArgs_KwArgs_Impl_.fromT(_hx_AnonObject({'object_hook': python_Lib.dictToAnon})))
        return obj

    def newDialogueFromProtocol(self,protocol,dialogue,data,initiator = None):
        if (initiator is None):
            initiator = ""
        _hx_str = ((("/new/" + ("null" if protocol is None else protocol)) + "/") + ("null" if dialogue is None else dialogue))
        if (len(initiator) > 0):
            _hx_str = ((("null" if _hx_str is None else _hx_str) + "/") + ("null" if initiator is None else initiator))
        x = self.url.postFile(_hx_str,data)
        msgParser = JsonParser_9()
        msg = msgParser.fromJson(x)
        return msg

    def interaction(self,dialogue,interactionId,json):
        _hx_str = ((("/" + ("null" if dialogue is None else dialogue)) + "/interaction/") + ("null" if interactionId is None else interactionId))
        x = self.url.postFile(_hx_str,json)
        parser = JsonParser_6()
        return parser.fromJson(x)

    def dialogueMoves(self,dialogue,initiator = None):
        if (initiator is None):
            initiator = ""
        _hx_str = (("/" + ("null" if dialogue is None else dialogue)) + "/moves/")
        if (len(initiator) > 0):
            _hx_str = (("null" if _hx_str is None else _hx_str) + ("null" if initiator is None else initiator))
        x = self.url.get(_hx_str)
        parser = JsonParser_6()
        return parser.fromJson(x)

    def getProtocol2(self,id):
        x = self.url.get(("/" + ("null" if id is None else id)))
        return x

    def list(self):
        x = self.url.putFile("/list/")
        obj = self.protocolListParser.fromJson(x)
        return obj

    def newProtocol(self,name,data):
        x = self.url.putFile(("/new/" + ("null" if name is None else name)),data)
        parser = JsonParser_16()
        obj = parser.fromJson(x)
        return obj

    @staticmethod
    def _hx_empty_init(_hx_o):
        _hx_o.url = None
        _hx_o.protocolListParser = None
jackbergus_dgep_connections_ConnectionRaw._hx_class = jackbergus_dgep_connections_ConnectionRaw


class jackbergus_dgep_internals_Dialogue:
    _hx_class_name = "jackbergus.dgep.internals.Dialogue"
    __slots__ = ("dgdl", "content_source", "players", "turntaking", "backtracking", "current_speaker", "status", "available_moves", "current_speakers", "runtimevars", "dialogue_history", "extURI")
    _hx_fields = ["dgdl", "content_source", "players", "turntaking", "backtracking", "current_speaker", "status", "available_moves", "current_speakers", "runtimevars", "dialogue_history", "extURI"]

    def __init__(self):
        self.extURI = None
        self.runtimevars = None
        self.current_speakers = None
        self.status = None
        self.current_speaker = None
        self.backtracking = None
        self.turntaking = None
        self.content_source = None
        self.dgdl = None
        self.players = haxe_ds_List()
        self.available_moves = haxe_ds_StringMap()
        self.dialogue_history = haxe_ds_StringMap()

    @staticmethod
    def _hx_empty_init(_hx_o):
        _hx_o.dgdl = None
        _hx_o.content_source = None
        _hx_o.players = None
        _hx_o.turntaking = None
        _hx_o.backtracking = None
        _hx_o.current_speaker = None
        _hx_o.status = None
        _hx_o.available_moves = None
        _hx_o.current_speakers = None
        _hx_o.runtimevars = None
        _hx_o.dialogue_history = None
        _hx_o.extURI = None
jackbergus_dgep_internals_Dialogue._hx_class = jackbergus_dgep_internals_Dialogue


class jackbergus_dgep_internals_MongoDB:
    _hx_class_name = "jackbergus.dgep.internals.MongoDB"
    __slots__ = ("protocols", "dialogues")
    _hx_fields = ["protocols", "dialogues"]

    def __init__(self):
        self.dialogues = haxe_ds_StringMap()
        self.protocols = haxe_ds_StringMap()

    @staticmethod
    def _hx_empty_init(_hx_o):
        _hx_o.protocols = None
        _hx_o.dialogues = None
jackbergus_dgep_internals_MongoDB._hx_class = jackbergus_dgep_internals_MongoDB


class jackbergus_dgep_internals_Move:
    _hx_class_name = "jackbergus.dgep.internals.Move"
    __slots__ = ("reply", "opener", "moveID", "target")
    _hx_fields = ["reply", "opener", "moveID", "target"]
    _hx_methods = ["nameMatch"]

    def __init__(self):
        self.reply = haxe_ds_StringMap()
        self.opener = ""
        self.moveID = ""
        self.target = ""

    def nameMatch(self,pred):
        return pred(self.moveID)

    @staticmethod
    def _hx_empty_init(_hx_o):
        _hx_o.reply = None
        _hx_o.opener = None
        _hx_o.moveID = None
        _hx_o.target = None
jackbergus_dgep_internals_Move._hx_class = jackbergus_dgep_internals_Move


class jackbergus_dgep_internals_ResponseAndData:
    _hx_class_name = "jackbergus.dgep.internals.ResponseAndData"
    __slots__ = ("response", "data")
    _hx_fields = ["response", "data"]
    _hx_methods = ["available"]

    def __init__(self):
        self.response = haxe_ds_StringMap()
        self.data = haxe_ds_StringMap()

    def available(self,user,pred):
        l = haxe_ds_List()
        if (not (user in self.response.h)):
            return l
        else:
            def _hx_local_2():
                def _hx_local_1(x):
                    return x.nameMatch(pred)
                def _hx_local_0(x):
                    return x.moveID
                return self.response.h.get(user,None).filter(_hx_local_1).map(_hx_local_0)
            return _hx_local_2()

    @staticmethod
    def _hx_empty_init(_hx_o):
        _hx_o.response = None
        _hx_o.data = None
jackbergus_dgep_internals_ResponseAndData._hx_class = jackbergus_dgep_internals_ResponseAndData


class jackbergus_dgep_internals__Move_Move_Fields_:
    _hx_class_name = "jackbergus.dgep.internals._Move.Move_Fields_"
    __slots__ = ()
    _hx_statics = ["parseJSONMoves"]

    @staticmethod
    def parseJSONMoves(parse):
        _hx_map = haxe_ds_StringMap()
        _g = 0
        _g1 = python_Boot.fields(parse)
        while (_g < len(_g1)):
            username = (_g1[_g] if _g >= 0 and _g < len(_g1) else None)
            _g = (_g + 1)
            obj = Reflect.field(parse,username)
            um = haxe_ds_List()
            parser = JsonParser_1()
            um = parser.fromJson(obj)
            _hx_map.h[username] = um
        return _hx_map
jackbergus_dgep_internals__Move_Move_Fields_._hx_class = jackbergus_dgep_internals__Move_Move_Fields_


class jackbergus_dgep_internals_Player:
    _hx_class_name = "jackbergus.dgep.internals.Player"
    __slots__ = ("playerID", "roles")
    _hx_fields = ["playerID", "roles"]

    def __init__(self):
        self.playerID = ""
        self.roles = haxe_ds_List()

    @staticmethod
    def _hx_empty_init(_hx_o):
        _hx_o.playerID = None
        _hx_o.roles = None
jackbergus_dgep_internals_Player._hx_class = jackbergus_dgep_internals_Player


class jackbergus_dgep_messages_DialogueMessage:
    _hx_class_name = "jackbergus.dgep.messages.DialogueMessage"
    __slots__ = ("moves", "dialogueID")
    _hx_fields = ["moves", "dialogueID"]

    def __init__(self):
        self.moves = jackbergus_dgep_internals_ResponseAndData()
        self.dialogueID = ""

    @staticmethod
    def _hx_empty_init(_hx_o):
        _hx_o.moves = None
        _hx_o.dialogueID = None
jackbergus_dgep_messages_DialogueMessage._hx_class = jackbergus_dgep_messages_DialogueMessage


class jackbergus_dgep_messages_ProtocolMessage:
    _hx_class_name = "jackbergus.dgep.messages.ProtocolMessage"
    __slots__ = ("message", "protocol")
    _hx_fields = ["message", "protocol"]

    def __init__(self,m = None,p = None):
        if (m is None):
            m = ""
        if (p is None):
            p = ""
        self.message = m
        self.protocol = p

    @staticmethod
    def _hx_empty_init(_hx_o):
        _hx_o.message = None
        _hx_o.protocol = None
jackbergus_dgep_messages_ProtocolMessage._hx_class = jackbergus_dgep_messages_ProtocolMessage


class jackbergus_dgep_requests_Interaction:
    _hx_class_name = "jackbergus.dgep.requests.Interaction"
    __slots__ = ("moveId", "speaker", "target", "reply")
    _hx_fields = ["moveId", "speaker", "target", "reply"]
    _hx_methods = ["add"]

    def __init__(self,move,s,t):
        self.moveId = move
        self.speaker = s
        self.target = t
        self.reply = haxe_ds_StringMap()

    def add(self,key,val):
        self.reply.h[key] = val

    @staticmethod
    def _hx_empty_init(_hx_o):
        _hx_o.moveId = None
        _hx_o.speaker = None
        _hx_o.target = None
        _hx_o.reply = None
jackbergus_dgep_requests_Interaction._hx_class = jackbergus_dgep_requests_Interaction


class jackbergus_dgep_requests_RawParticipantToJSON:
    _hx_class_name = "jackbergus.dgep.requests.RawParticipantToJSON"
    __slots__ = ("name", "player")
    _hx_fields = ["name", "player"]

    def __init__(self,n = None,p = None):
        if (n is None):
            n = ""
        if (p is None):
            p = ""
        self.name = n
        self.player = p

    @staticmethod
    def _hx_empty_init(_hx_o):
        _hx_o.name = None
        _hx_o.player = None
jackbergus_dgep_requests_RawParticipantToJSON._hx_class = jackbergus_dgep_requests_RawParticipantToJSON


class jackbergus_dgep_requests_RawParticipantObjectToJSON:
    _hx_class_name = "jackbergus.dgep.requests.RawParticipantObjectToJSON"
    __slots__ = ("participants",)
    _hx_fields = ["participants"]

    def __init__(self):
        self.participants = haxe_ds_List()

    @staticmethod
    def _hx_empty_init(_hx_o):
        _hx_o.participants = None
jackbergus_dgep_requests_RawParticipantObjectToJSON._hx_class = jackbergus_dgep_requests_RawParticipantObjectToJSON


class jackbergus_dgep_requests_Participant:
    _hx_class_name = "jackbergus.dgep.requests.Participant"
    __slots__ = ("participants", "parser")
    _hx_fields = ["participants", "parser"]
    _hx_methods = ["add", "get", "toJSONString"]

    def __init__(self):
        self.participants = haxe_ds_StringMap()
        self.parser = JsonWriter_0()

    def add(self,name,role):
        self.participants.h[name] = role

    def get(self,x):
        n = None
        if (x in self.participants.h):
            n = self.participants.h.get(x,None)
        return n

    def toJSONString(self):
        obj = jackbergus_dgep_requests_RawParticipantObjectToJSON()
        _hx_map = self.participants
        _g_map = _hx_map
        _g_keys = _hx_map.keys()
        while _g_keys.hasNext():
            key = _g_keys.next()
            _g1_value = _g_map.get(key)
            _g1_key = key
            user = _g1_key
            age = _g1_value
            obj.participants.add(jackbergus_dgep_requests_RawParticipantToJSON(user,age))
        return self.parser.write(obj)

    @staticmethod
    def _hx_empty_init(_hx_o):
        _hx_o.participants = None
        _hx_o.parser = None
jackbergus_dgep_requests_Participant._hx_class = jackbergus_dgep_requests_Participant

class jackbergus_protocol_EvaluatrOrSubscriberCases(Enum):
    __slots__ = ()
    _hx_class_name = "jackbergus.protocol.EvaluatrOrSubscriberCases"
    _hx_constructs = ["CannotSubscribeToAction", "CannotRetrievePublisherData", "PublisherMapIsEmpty", "NotAdequateProtocolAdoption", "CannotReplyToSubscription", "CannotTestForResponse", "CannotCallGetDataTwice"]
jackbergus_protocol_EvaluatrOrSubscriberCases.CannotSubscribeToAction = jackbergus_protocol_EvaluatrOrSubscriberCases("CannotSubscribeToAction", 0, ())
jackbergus_protocol_EvaluatrOrSubscriberCases.CannotRetrievePublisherData = jackbergus_protocol_EvaluatrOrSubscriberCases("CannotRetrievePublisherData", 1, ())
jackbergus_protocol_EvaluatrOrSubscriberCases.PublisherMapIsEmpty = jackbergus_protocol_EvaluatrOrSubscriberCases("PublisherMapIsEmpty", 2, ())
jackbergus_protocol_EvaluatrOrSubscriberCases.NotAdequateProtocolAdoption = jackbergus_protocol_EvaluatrOrSubscriberCases("NotAdequateProtocolAdoption", 3, ())
jackbergus_protocol_EvaluatrOrSubscriberCases.CannotReplyToSubscription = jackbergus_protocol_EvaluatrOrSubscriberCases("CannotReplyToSubscription", 4, ())
jackbergus_protocol_EvaluatrOrSubscriberCases.CannotTestForResponse = jackbergus_protocol_EvaluatrOrSubscriberCases("CannotTestForResponse", 5, ())
jackbergus_protocol_EvaluatrOrSubscriberCases.CannotCallGetDataTwice = jackbergus_protocol_EvaluatrOrSubscriberCases("CannotCallGetDataTwice", 6, ())
jackbergus_protocol_EvaluatrOrSubscriberCases._hx_class = jackbergus_protocol_EvaluatrOrSubscriberCases


class jackbergus_protocol_EvaluatorOrSubscriber:
    _hx_class_name = "jackbergus.protocol.EvaluatorOrSubscriber"
    __slots__ = ("protocol", "fut", "next", "cs", "p", "po", "s", "tl", "pd", "noargs", "busy", "fixedAction", "wasforeverServerGetDataCalled", "selfMap")
    _hx_fields = ["protocol", "fut", "next", "cs", "p", "po", "s", "tl", "pd", "noargs", "busy", "fixedAction", "wasforeverServerGetDataCalled", "selfMap"]
    _hx_methods = ["foreverServerGetData", "foreverServerSendResponse"]

    def __init__(self,c,serviceId,registerFor,sleep = None,inFuture = None,inNext = None,busyWait = None,servicePrefix = None):
        if (sleep is None):
            sleep = 0.5
        if (inFuture is None):
            inFuture = False
        if (inNext is None):
            inNext = True
        if (busyWait is None):
            busyWait = True
        if (servicePrefix is None):
            servicePrefix = "service"
        self.pd = None
        self.protocol = jackbergus_protocol_ProtocolService(c,(("null" if servicePrefix is None else servicePrefix)),sleep)
        self.fut = inFuture
        self.next = inNext
        self.cs = "Consume"
        self.s = "Subscribe"
        self.p = "Publish"
        self.po = "PushOutcome"
        self.tl = "TestLast"
        self.noargs = haxe_ds_StringMap()
        self.busy = busyWait
        self.fixedAction = registerFor
        self.wasforeverServerGetDataCalled = False
        self.selfMap = haxe_ds_StringMap()
        this1 = self.selfMap
        value = self.protocol.getSelfServiceName()
        this1.h["s"] = value

    def foreverServerGetData(self):
        if self.wasforeverServerGetDataCalled:
            return jackbergus_utils_ErrorMonad.Error("Cannot call foreverServerGetData twice!",jackbergus_protocol_EvaluatrOrSubscriberCases.CannotCallGetDataTwice)
        result = None
        result = self.protocol.testAction((HxOverrides.stringOrNull(self.s) + HxOverrides.stringOrNull(self.fixedAction)),self.selfMap,"bogus",self.busy)
        if (result is None):
            return jackbergus_utils_ErrorMonad.Error((("Action " + HxOverrides.stringOrNull(self.fixedAction)) + " not available for subscription"),jackbergus_protocol_EvaluatrOrSubscriberCases.CannotSubscribeToAction)
        result = self.protocol.testAction((HxOverrides.stringOrNull(self.cs) + HxOverrides.stringOrNull(self.fixedAction)),self.selfMap,"bogus",True)
        if (result is None):
            return jackbergus_utils_ErrorMonad.Error((("Action " + HxOverrides.stringOrNull(self.fixedAction)) + " cannot retrieve data from the publisher"),jackbergus_protocol_EvaluatrOrSubscriberCases.CannotRetrievePublisherData)
        if (not ("p" in result.h)):
            return jackbergus_utils_ErrorMonad.Error((("Cannot read for " + HxOverrides.stringOrNull(self.fixedAction)) + " the data provided by the publisher in parameter 'p'"),jackbergus_protocol_EvaluatrOrSubscriberCases.PublisherMapIsEmpty)
        else:
            self.wasforeverServerGetDataCalled = True
            return jackbergus_utils_ErrorMonad.Good(result.h.get("p",None))

    def foreverServerSendResponse(self,response):
        if (not self.wasforeverServerGetDataCalled):
            return jackbergus_utils_ErrorMonad.Error("Error: invoking foreverServerSendResponse before satisfactory calling foreverServerGetData",jackbergus_protocol_EvaluatrOrSubscriberCases.NotAdequateProtocolAdoption)
        self.wasforeverServerGetDataCalled = False
        self.selfMap.h["o"] = response
        result = self.protocol.testAction((HxOverrides.stringOrNull(self.po) + HxOverrides.stringOrNull(self.fixedAction)),self.selfMap,"bogus",False)
        if (result is None):
            return jackbergus_utils_ErrorMonad.Error((("Action " + HxOverrides.stringOrNull(self.fixedAction)) + " not available for response with subscription"),jackbergus_protocol_EvaluatrOrSubscriberCases.CannotReplyToSubscription)
        self.selfMap.remove("o")
        result = self.protocol.testAction((HxOverrides.stringOrNull(self.tl) + HxOverrides.stringOrNull(self.fixedAction)),self.noargs,"bogus",False)
        if (result is None):
            return jackbergus_utils_ErrorMonad.Error((("Action " + HxOverrides.stringOrNull(self.fixedAction)) + " not available for testing the response!"),jackbergus_protocol_EvaluatrOrSubscriberCases.CannotTestForResponse)
        return jackbergus_utils_ErrorMonad.Good(True)

    @staticmethod
    def _hx_empty_init(_hx_o):
        _hx_o.protocol = None
        _hx_o.fut = None
        _hx_o.next = None
        _hx_o.cs = None
        _hx_o.p = None
        _hx_o.po = None
        _hx_o.s = None
        _hx_o.tl = None
        _hx_o.pd = None
        _hx_o.noargs = None
        _hx_o.busy = None
        _hx_o.fixedAction = None
        _hx_o.wasforeverServerGetDataCalled = None
        _hx_o.selfMap = None
jackbergus_protocol_EvaluatorOrSubscriber._hx_class = jackbergus_protocol_EvaluatorOrSubscriber

class jackbergus_protocol_ProposerOrPublisherCases(Enum):
    __slots__ = ()
    _hx_class_name = "jackbergus.protocol.ProposerOrPublisherCases"
    _hx_constructs = ["ActionNotReady", "UnknownError", "CannotPopValues", "UnexpectedNullArgumentFromPop", "DuplicateServiceName", "MissingAuthorArgument", "MissingResponseArgument"]
jackbergus_protocol_ProposerOrPublisherCases.ActionNotReady = jackbergus_protocol_ProposerOrPublisherCases("ActionNotReady", 0, ())
jackbergus_protocol_ProposerOrPublisherCases.UnknownError = jackbergus_protocol_ProposerOrPublisherCases("UnknownError", 1, ())
jackbergus_protocol_ProposerOrPublisherCases.CannotPopValues = jackbergus_protocol_ProposerOrPublisherCases("CannotPopValues", 2, ())
jackbergus_protocol_ProposerOrPublisherCases.UnexpectedNullArgumentFromPop = jackbergus_protocol_ProposerOrPublisherCases("UnexpectedNullArgumentFromPop", 3, ())
jackbergus_protocol_ProposerOrPublisherCases.DuplicateServiceName = jackbergus_protocol_ProposerOrPublisherCases("DuplicateServiceName", 4, ())
jackbergus_protocol_ProposerOrPublisherCases.MissingAuthorArgument = jackbergus_protocol_ProposerOrPublisherCases("MissingAuthorArgument", 5, ())
jackbergus_protocol_ProposerOrPublisherCases.MissingResponseArgument = jackbergus_protocol_ProposerOrPublisherCases("MissingResponseArgument", 6, ())
jackbergus_protocol_ProposerOrPublisherCases._hx_class = jackbergus_protocol_ProposerOrPublisherCases


class jackbergus_protocol_ProposerOrPublisher:
    _hx_class_name = "jackbergus.protocol.ProposerOrPublisher"
    __slots__ = ("protocol", "fut", "next", "sp", "p", "po", "noargs", "busy")
    _hx_fields = ["protocol", "fut", "next", "sp", "p", "po", "noargs", "busy"]
    _hx_methods = ["publishableActions", "returnResultsFromSubscribers"]

    def __init__(self,c,agentName = None,sleep = None,busyWait = None):
        if (agentName is None):
            agentName = "ARGA"
        if (sleep is None):
            sleep = 0.5
        if (busyWait is None):
            busyWait = True
        self.next = None
        self.fut = None
        self.protocol = jackbergus_protocol_ProtocolService(c,agentName,sleep)
        self.p = "Publish"
        self.sp = "StartPublish"
        self.po = "PopOutcome"
        self.noargs = haxe_ds_StringMap()
        self.busy = busyWait

    def publishableActions(self,action = None):
        if (action is None):
            action = ""
        return self.protocol.doableActions(self.sp,action)

    def returnResultsFromSubscribers(self,action,data):
        results = jackbergus_utils_ErrorMonad.Error("Unknown error",jackbergus_protocol_ProposerOrPublisherCases.UnknownError)
        if (self.publishableActions(action).length == 0):
            return jackbergus_utils_ErrorMonad.Error((("Action " + ("null" if action is None else action)) + " not available"),jackbergus_protocol_ProposerOrPublisherCases.ActionNotReady)
        result = None
        result = self.protocol.testAction((HxOverrides.stringOrNull(self.sp) + ("null" if action is None else action)),self.noargs,"bogus",self.busy)
        if (result is None):
            return jackbergus_utils_ErrorMonad.Error((("Action " + ("null" if action is None else action)) + " not available at testAction"),jackbergus_protocol_ProposerOrPublisherCases.ActionNotReady)
        countServices = 0
        publishableData = haxe_ds_StringMap()
        publishableData.h["d"] = data
        servicesToCount = "[]"
        while True:
            result = self.protocol.testAction((HxOverrides.stringOrNull(self.p) + ("null" if action is None else action)),publishableData,"bogus",False)
            if (result is not None):
                if ("l" in result.h):
                    servicesToCount = result.h.get("l",None)
            if (not ((result is not None))):
                break
        _this = HxString.substring(servicesToCount,1,(len(servicesToCount) - 1))
        servicesToCountList = _this.split(",")
        countServices = len(servicesToCountList)
        if (not self.protocol.isActionAvailable((HxOverrides.stringOrNull(self.po) + ("null" if action is None else action)),self.busy)):
            return jackbergus_utils_ErrorMonad.Error(((("Cannot pop the outcome of " + ("null" if action is None else action)) + " given the busyness: ") + HxOverrides.stringOrNull((("true" if (self.busy) else "false")))),jackbergus_protocol_ProposerOrPublisherCases.CannotPopValues)
        m = haxe_ds_StringMap()
        while True:
            result = self.protocol.testAction((HxOverrides.stringOrNull(self.po) + ("null" if action is None else action)),self.noargs,"bogus",False)
            countServices = (countServices - 1)
            if ((result is None) and ((countServices > 0))):
                return jackbergus_utils_ErrorMonad.Error("Expecting that the PopOutcome would return a value, but null was returned instead",jackbergus_protocol_ProposerOrPublisherCases.UnexpectedNullArgumentFromPop)
            if (result is None):
                break
            if (not ("o" in result.h)):
                return jackbergus_utils_ErrorMonad.Error("Expecting a missing response argument!",jackbergus_protocol_ProposerOrPublisherCases.MissingResponseArgument)
            o = result.h.get("o",None)
            if (not ("s" in result.h)):
                return jackbergus_utils_ErrorMonad.Error("Expecting a missing service name argument!",jackbergus_protocol_ProposerOrPublisherCases.MissingAuthorArgument)
            s = result.h.get("s",None)
            if (s in m.h):
                return jackbergus_utils_ErrorMonad.Error(("Obtained a duplicate service name for: " + ("null" if s is None else s)),jackbergus_protocol_ProposerOrPublisherCases.DuplicateServiceName)
            m.h[s] = o
            if (not (((result is not None) and ((countServices > 0))))):
                break
        if (countServices == 0):
            result = self.protocol.testAction((HxOverrides.stringOrNull(self.po) + ("null" if action is None else action)),self.noargs,"bogus",False)
            if (result is None):
                print("Null last result")
            else:
                print("last result not null")
            return jackbergus_utils_ErrorMonad.Good(m)
        else:
            return jackbergus_utils_ErrorMonad.Error("Something went wrong: not the expected number of agents was provided",jackbergus_protocol_ProposerOrPublisherCases.UnexpectedNullArgumentFromPop)

    @staticmethod
    def _hx_empty_init(_hx_o):
        _hx_o.protocol = None
        _hx_o.fut = None
        _hx_o.next = None
        _hx_o.sp = None
        _hx_o.p = None
        _hx_o.po = None
        _hx_o.noargs = None
        _hx_o.busy = None
jackbergus_protocol_ProposerOrPublisher._hx_class = jackbergus_protocol_ProposerOrPublisher


class jackbergus_protocol_ProtocolService:
    _hx_class_name = "jackbergus.protocol.ProtocolService"
    __slots__ = ("connection", "self", "s")
    _hx_fields = ["connection", "self", "s"]
    _hx_methods = ["getSelfServiceName", "canIDoActionQM", "availableActions", "isActionAvailable", "testAction", "doableActions"]

    def __init__(self,c,agentName,sleep = None):
        if (sleep is None):
            sleep = 0.5
        self.connection = c
        self.self = agentName
        self.s = sleep

    def getSelfServiceName(self):
        return self.self

    def canIDoActionQM(self,action):
        m = self.connection.moves(self.self)
        if (not (self.self in m.response.h)):
            return False
        myActions = m.response.h.get(self.self,None)
        _g_head = myActions.h
        while (_g_head is not None):
            val = _g_head.item
            _g_head = _g_head.next
            x = val
            if (x.moveID == action):
                return True
        return False

    def availableActions(self,pred):
        l = haxe_ds_List()
        m = self.connection.moves(self.self)
        if (not (self.self in m.response.h)):
            return l
        _g_head = m.available(self.self,pred).h
        while (_g_head is not None):
            val = _g_head.item
            _g_head = _g_head.next
            x = val
            l.add(x)
        return l

    def isActionAvailable(self,action,busyWait):
        if busyWait:
            while (not self.canIDoActionQM(action)):
                Sys.sleep(self.s)
            print(str(("Can perform action after busy waiting: " + ("null" if action is None else action))))
            return True
        else:
            outcome = self.canIDoActionQM(action)
            if outcome:
                print(str(("Can immediately perform action: " + ("null" if action is None else action))))
            else:
                print(str(("Cannot immediately perform action: " + ("null" if action is None else action))))
            return outcome

    def testAction(self,action,args,target,busyWait):
        r = None
        if (not self.isActionAvailable(action,busyWait)):
            return r
        i = jackbergus_dgep_requests_Interaction(action,self.self,target)
        _hx_map = args
        _g_map = _hx_map
        _g_keys = _hx_map.keys()
        while _g_keys.hasNext():
            key = _g_keys.next()
            _g1_value = _g_map.get(key)
            _g1_key = key
            k = _g1_key
            v = _g1_value
            i.add(k,v)
        try:
            r = self.connection.interaction(i).data
            return r
        except BaseException as _g:
            e = haxe_Exception.caught(_g)
            print(str(e.get_message()))
            return r

    def doableActions(self,actionKind,action = None):
        if (action is None):
            action = ""
        if (len(action) == 0):
            def _hx_local_2():
                def _hx_local_1(x):
                    return x.startswith(actionKind)
                def _hx_local_0(x):
                    return HxString.substr(x,len(actionKind),None)
                return self.availableActions(_hx_local_1).map(_hx_local_0)
            return _hx_local_2()
        else:
            def _hx_local_5():
                def _hx_local_4(x):
                    return (x == ((("null" if actionKind is None else actionKind) + ("null" if action is None else action))))
                def _hx_local_3(x):
                    return HxString.substr(x,len(actionKind),None)
                return self.availableActions(_hx_local_4).map(_hx_local_3)
            return _hx_local_5()

    @staticmethod
    def _hx_empty_init(_hx_o):
        _hx_o.connection = None
        _hx_o.self = None
        _hx_o.s = None
jackbergus_protocol_ProtocolService._hx_class = jackbergus_protocol_ProtocolService

class jackbergus_utils_ErrorMonad(Enum):
    __slots__ = ()
    _hx_class_name = "jackbergus.utils.ErrorMonad"
    _hx_constructs = ["Error", "Good"]

    @staticmethod
    def Error(x,error):
        return jackbergus_utils_ErrorMonad("Error", 0, (x,error))

    @staticmethod
    def Good(value):
        return jackbergus_utils_ErrorMonad("Good", 1, (value,))
jackbergus_utils_ErrorMonad._hx_class = jackbergus_utils_ErrorMonad

class json2object_Error(Enum):
    __slots__ = ()
    _hx_class_name = "json2object.Error"
    _hx_constructs = ["IncorrectType", "IncorrectEnumValue", "InvalidEnumConstructor", "UninitializedVariable", "UnknownVariable", "ParserError", "CustomFunctionException"]

    @staticmethod
    def IncorrectType(variable,expected,pos):
        return json2object_Error("IncorrectType", 0, (variable,expected,pos))

    @staticmethod
    def IncorrectEnumValue(value,expected,pos):
        return json2object_Error("IncorrectEnumValue", 1, (value,expected,pos))

    @staticmethod
    def InvalidEnumConstructor(value,expected,pos):
        return json2object_Error("InvalidEnumConstructor", 2, (value,expected,pos))

    @staticmethod
    def UninitializedVariable(variable,pos):
        return json2object_Error("UninitializedVariable", 3, (variable,pos))

    @staticmethod
    def UnknownVariable(variable,pos):
        return json2object_Error("UnknownVariable", 4, (variable,pos))

    @staticmethod
    def ParserError(message,pos):
        return json2object_Error("ParserError", 5, (message,pos))

    @staticmethod
    def CustomFunctionException(e,pos):
        return json2object_Error("CustomFunctionException", 6, (e,pos))
json2object_Error._hx_class = json2object_Error

class json2object_InternalError(Enum):
    __slots__ = ()
    _hx_class_name = "json2object.InternalError"
    _hx_constructs = ["AbstractNoJsonRepresentation", "CannotGenerateSchema", "HandleExpr", "ParsingThrow", "UnsupportedAbstractEnumType", "UnsupportedEnumAbstractValue", "UnsupportedMapKeyType", "UnsupportedSchemaObjectType", "UnsupportedSchemaType"]

    @staticmethod
    def AbstractNoJsonRepresentation(name):
        return json2object_InternalError("AbstractNoJsonRepresentation", 0, (name,))

    @staticmethod
    def CannotGenerateSchema(name):
        return json2object_InternalError("CannotGenerateSchema", 1, (name,))

    @staticmethod
    def UnsupportedAbstractEnumType(name):
        return json2object_InternalError("UnsupportedAbstractEnumType", 4, (name,))

    @staticmethod
    def UnsupportedEnumAbstractValue(name):
        return json2object_InternalError("UnsupportedEnumAbstractValue", 5, (name,))

    @staticmethod
    def UnsupportedMapKeyType(name):
        return json2object_InternalError("UnsupportedMapKeyType", 6, (name,))

    @staticmethod
    def UnsupportedSchemaObjectType(name):
        return json2object_InternalError("UnsupportedSchemaObjectType", 7, (name,))

    @staticmethod
    def UnsupportedSchemaType(type):
        return json2object_InternalError("UnsupportedSchemaType", 8, (type,))
json2object_InternalError.HandleExpr = json2object_InternalError("HandleExpr", 2, ())
json2object_InternalError.ParsingThrow = json2object_InternalError("ParsingThrow", 3, ())
json2object_InternalError._hx_class = json2object_InternalError


class json2object_CustomFunctionError:
    _hx_class_name = "json2object.CustomFunctionError"
    __slots__ = ("message",)
    _hx_fields = ["message"]

    def __init__(self,message):
        self.message = message

    @staticmethod
    def _hx_empty_init(_hx_o):
        _hx_o.message = None
json2object_CustomFunctionError._hx_class = json2object_CustomFunctionError


class json2object_JsonParser:
    _hx_class_name = "json2object.JsonParser"
    __slots__ = ()
json2object_JsonParser._hx_class = json2object_JsonParser


class json2object_JsonWriter:
    _hx_class_name = "json2object.JsonWriter"
    __slots__ = ()
json2object_JsonWriter._hx_class = json2object_JsonWriter


class json2object_PositionUtils:
    _hx_class_name = "json2object.PositionUtils"
    __slots__ = ("linesInfo",)
    _hx_fields = ["linesInfo"]
    _hx_methods = ["convertPosition", "revert"]

    def __init__(self,content):
        self.linesInfo = list()
        s = 0
        e = 0
        i = 0
        lineCount = 0
        while (i < len(content)):
            _g = ("" if (((i < 0) or ((i >= len(content))))) else content[i])
            if (_g == "\n"):
                e = i
                _this = self.linesInfo
                _this.append(_hx_AnonObject({'number': lineCount, 'start': s, 'end': e}))
                lineCount = (lineCount + 1)
                i = (i + 1)
                s = i
            elif (_g == "\r"):
                e = i
                index = (i + 1)
                if ((("" if (((index < 0) or ((index >= len(content))))) else content[index])) == "\n"):
                    e = (e + 1)
                _this1 = self.linesInfo
                _this1.append(_hx_AnonObject({'number': lineCount, 'start': s, 'end': e}))
                lineCount = (lineCount + 1)
                i = (e + 1)
                s = i
            else:
                i = (i + 1)
        _this = self.linesInfo
        _this.append(_hx_AnonObject({'number': lineCount, 'start': s, 'end': i}))

    def convertPosition(self,position):
        file = position.file
        _hx_min = position.min
        _hx_max = position.max
        pos = _hx_AnonObject({'file': file, 'min': (_hx_min + 1), 'max': (_hx_max + 1), 'lines': []})
        lastLine = (len(self.linesInfo) - 1)
        bounds_min = 0
        bounds_max = lastLine
        if (_hx_min > (self.linesInfo[0] if 0 < len(self.linesInfo) else None).end):
            while (bounds_max > bounds_min):
                x = (((bounds_min + bounds_max)) / 2)
                i = None
                try:
                    i = int(x)
                except BaseException as _g:
                    None
                    i = None
                line = (self.linesInfo[i] if i >= 0 and i < len(self.linesInfo) else None)
                if (line.start == _hx_min):
                    bounds_min = i
                    bounds_max = i
                if (line.end < _hx_min):
                    bounds_min = (i + 1)
                if ((line.start > _hx_min) or (((line.end >= _hx_min) and ((line.start < _hx_min))))):
                    bounds_max = i
        _g = bounds_min
        _g1 = len(self.linesInfo)
        while (_g < _g1):
            i = _g
            _g = (_g + 1)
            line = (self.linesInfo[i] if i >= 0 and i < len(self.linesInfo) else None)
            if ((line.start <= _hx_min) and ((line.end >= _hx_max))):
                _this = pos.lines
                x = _hx_AnonObject({'number': (line.number + 1), 'start': ((_hx_min - line.start) + 1), 'end': ((_hx_max - line.start) + 1)})
                _this.append(x)
                break
            if ((line.start <= _hx_min) and ((_hx_min <= line.end))):
                _this1 = pos.lines
                x1 = _hx_AnonObject({'number': (line.number + 1), 'start': ((_hx_min - line.start) + 1), 'end': (line.end + 1)})
                _this1.append(x1)
            if ((line.start <= _hx_max) and ((_hx_max <= line.end))):
                _this2 = pos.lines
                x2 = _hx_AnonObject({'number': (line.number + 1), 'start': (line.start + 1), 'end': ((_hx_max - line.start) + 1)})
                _this2.append(x2)
            if ((line.start >= _hx_max) or ((line.end >= _hx_max))):
                break
        return pos

    def revert(self,position):
        return hxjsonast_Position(position.file,(position.min - 1),(position.max - 1))

    @staticmethod
    def _hx_empty_init(_hx_o):
        _hx_o.linesInfo = None
json2object_PositionUtils._hx_class = json2object_PositionUtils


class json2object_writer_StringUtils:
    _hx_class_name = "json2object.writer.StringUtils"
    __slots__ = ()
    _hx_statics = ["quote"]

    @staticmethod
    def quote(s):
        buf_b = python_lib_io_StringIO()
        buf_b.write("".join(map(chr,[34])))
        i = 0
        while True:
            index = i
            i = (i + 1)
            c = (-1 if ((index >= len(s))) else ord(s[index]))
            if (c == -1):
                break
            c1 = c
            if (c1 == 8):
                buf_b.write("\\b")
            elif (c1 == 9):
                buf_b.write("\\t")
            elif (c1 == 10):
                buf_b.write("\\n")
            elif (c1 == 12):
                buf_b.write("\\f")
            elif (c1 == 13):
                buf_b.write("\\r")
            elif (c1 == 34):
                buf_b.write("\\\"")
            elif (c1 == 92):
                buf_b.write("\\\\")
            else:
                buf_b.write("".join(map(chr,[c])))
        buf_b.write("".join(map(chr,[34])))
        return buf_b.getvalue()
json2object_writer_StringUtils._hx_class = json2object_writer_StringUtils


class python_Boot:
    _hx_class_name = "python.Boot"
    __slots__ = ()
    _hx_statics = ["keywords", "toString1", "fields", "simpleField", "hasField", "field", "getInstanceFields", "getSuperClass", "getClassFields", "prefixLength", "unhandleKeywords"]

    @staticmethod
    def toString1(o,s):
        if (o is None):
            return "null"
        if isinstance(o,str):
            return o
        if (s is None):
            s = ""
        if (len(s) >= 5):
            return "<...>"
        if isinstance(o,bool):
            if o:
                return "true"
            else:
                return "false"
        if (isinstance(o,int) and (not isinstance(o,bool))):
            return str(o)
        if isinstance(o,float):
            try:
                if (o == int(o)):
                    return str(Math.floor((o + 0.5)))
                else:
                    return str(o)
            except BaseException as _g:
                None
                return str(o)
        if isinstance(o,list):
            o1 = o
            l = len(o1)
            st = "["
            s = (("null" if s is None else s) + "\t")
            _g = 0
            _g1 = l
            while (_g < _g1):
                i = _g
                _g = (_g + 1)
                prefix = ""
                if (i > 0):
                    prefix = ","
                st = (("null" if st is None else st) + HxOverrides.stringOrNull(((("null" if prefix is None else prefix) + HxOverrides.stringOrNull(python_Boot.toString1((o1[i] if i >= 0 and i < len(o1) else None),s))))))
            st = (("null" if st is None else st) + "]")
            return st
        try:
            if hasattr(o,"toString"):
                return o.toString()
        except BaseException as _g:
            None
        if hasattr(o,"__class__"):
            if isinstance(o,_hx_AnonObject):
                toStr = None
                try:
                    fields = python_Boot.fields(o)
                    _g = []
                    _g1 = 0
                    while (_g1 < len(fields)):
                        f = (fields[_g1] if _g1 >= 0 and _g1 < len(fields) else None)
                        _g1 = (_g1 + 1)
                        x = ((("" + ("null" if f is None else f)) + " : ") + HxOverrides.stringOrNull(python_Boot.toString1(python_Boot.simpleField(o,f),(("null" if s is None else s) + "\t"))))
                        _g.append(x)
                    fieldsStr = _g
                    toStr = (("{ " + HxOverrides.stringOrNull(", ".join([x1 for x1 in fieldsStr]))) + " }")
                except BaseException as _g:
                    None
                    return "{ ... }"
                if (toStr is None):
                    return "{ ... }"
                else:
                    return toStr
            if isinstance(o,Enum):
                o1 = o
                l = len(o1.params)
                hasParams = (l > 0)
                if hasParams:
                    paramsStr = ""
                    _g = 0
                    _g1 = l
                    while (_g < _g1):
                        i = _g
                        _g = (_g + 1)
                        prefix = ""
                        if (i > 0):
                            prefix = ","
                        paramsStr = (("null" if paramsStr is None else paramsStr) + HxOverrides.stringOrNull(((("null" if prefix is None else prefix) + HxOverrides.stringOrNull(python_Boot.toString1(o1.params[i],s))))))
                    return (((HxOverrides.stringOrNull(o1.tag) + "(") + ("null" if paramsStr is None else paramsStr)) + ")")
                else:
                    return o1.tag
            if hasattr(o,"_hx_class_name"):
                if (o.__class__.__name__ != "type"):
                    fields = python_Boot.getInstanceFields(o)
                    _g = []
                    _g1 = 0
                    while (_g1 < len(fields)):
                        f = (fields[_g1] if _g1 >= 0 and _g1 < len(fields) else None)
                        _g1 = (_g1 + 1)
                        x = ((("" + ("null" if f is None else f)) + " : ") + HxOverrides.stringOrNull(python_Boot.toString1(python_Boot.simpleField(o,f),(("null" if s is None else s) + "\t"))))
                        _g.append(x)
                    fieldsStr = _g
                    toStr = (((HxOverrides.stringOrNull(o._hx_class_name) + "( ") + HxOverrides.stringOrNull(", ".join([x1 for x1 in fieldsStr]))) + " )")
                    return toStr
                else:
                    fields = python_Boot.getClassFields(o)
                    _g = []
                    _g1 = 0
                    while (_g1 < len(fields)):
                        f = (fields[_g1] if _g1 >= 0 and _g1 < len(fields) else None)
                        _g1 = (_g1 + 1)
                        x = ((("" + ("null" if f is None else f)) + " : ") + HxOverrides.stringOrNull(python_Boot.toString1(python_Boot.simpleField(o,f),(("null" if s is None else s) + "\t"))))
                        _g.append(x)
                    fieldsStr = _g
                    toStr = (((("#" + HxOverrides.stringOrNull(o._hx_class_name)) + "( ") + HxOverrides.stringOrNull(", ".join([x1 for x1 in fieldsStr]))) + " )")
                    return toStr
            if ((type(o) == type) and (o == str)):
                return "#String"
            if ((type(o) == type) and (o == list)):
                return "#Array"
            if callable(o):
                return "function"
            try:
                if hasattr(o,"__repr__"):
                    return o.__repr__()
            except BaseException as _g:
                None
            if hasattr(o,"__str__"):
                return o.__str__([])
            if hasattr(o,"__name__"):
                return o.__name__
            return "???"
        else:
            return str(o)

    @staticmethod
    def fields(o):
        a = []
        if (o is not None):
            if hasattr(o,"_hx_fields"):
                fields = o._hx_fields
                if (fields is not None):
                    return list(fields)
            if isinstance(o,_hx_AnonObject):
                d = o.__dict__
                keys = d.keys()
                handler = python_Boot.unhandleKeywords
                for k in keys:
                    if (k != '_hx_disable_getattr'):
                        a.append(handler(k))
            elif hasattr(o,"__dict__"):
                d = o.__dict__
                keys1 = d.keys()
                for k in keys1:
                    a.append(k)
        return a

    @staticmethod
    def simpleField(o,field):
        if (field is None):
            return None
        field1 = (("_hx_" + field) if ((field in python_Boot.keywords)) else (("_hx_" + field) if (((((len(field) > 2) and ((ord(field[0]) == 95))) and ((ord(field[1]) == 95))) and ((ord(field[(len(field) - 1)]) != 95)))) else field))
        if hasattr(o,field1):
            return getattr(o,field1)
        else:
            return None

    @staticmethod
    def hasField(o,field):
        if isinstance(o,_hx_AnonObject):
            return o._hx_hasattr(field)
        return hasattr(o,(("_hx_" + field) if ((field in python_Boot.keywords)) else (("_hx_" + field) if (((((len(field) > 2) and ((ord(field[0]) == 95))) and ((ord(field[1]) == 95))) and ((ord(field[(len(field) - 1)]) != 95)))) else field)))

    @staticmethod
    def field(o,field):
        if (field is None):
            return None
        if isinstance(o,str):
            field1 = field
            _hx_local_0 = len(field1)
            if (_hx_local_0 == 10):
                if (field1 == "charCodeAt"):
                    return python_internal_MethodClosure(o,HxString.charCodeAt)
                else:
                    field1 = (("_hx_" + field) if ((field in python_Boot.keywords)) else (("_hx_" + field) if (((((len(field) > 2) and ((ord(field[0]) == 95))) and ((ord(field[1]) == 95))) and ((ord(field[(len(field) - 1)]) != 95)))) else field))
                    if hasattr(o,field1):
                        return getattr(o,field1)
                    else:
                        return None
            elif (_hx_local_0 == 11):
                if (field1 == "lastIndexOf"):
                    return python_internal_MethodClosure(o,HxString.lastIndexOf)
                elif (field1 == "toLowerCase"):
                    return python_internal_MethodClosure(o,HxString.toLowerCase)
                elif (field1 == "toUpperCase"):
                    return python_internal_MethodClosure(o,HxString.toUpperCase)
                else:
                    field1 = (("_hx_" + field) if ((field in python_Boot.keywords)) else (("_hx_" + field) if (((((len(field) > 2) and ((ord(field[0]) == 95))) and ((ord(field[1]) == 95))) and ((ord(field[(len(field) - 1)]) != 95)))) else field))
                    if hasattr(o,field1):
                        return getattr(o,field1)
                    else:
                        return None
            elif (_hx_local_0 == 9):
                if (field1 == "substring"):
                    return python_internal_MethodClosure(o,HxString.substring)
                else:
                    field1 = (("_hx_" + field) if ((field in python_Boot.keywords)) else (("_hx_" + field) if (((((len(field) > 2) and ((ord(field[0]) == 95))) and ((ord(field[1]) == 95))) and ((ord(field[(len(field) - 1)]) != 95)))) else field))
                    if hasattr(o,field1):
                        return getattr(o,field1)
                    else:
                        return None
            elif (_hx_local_0 == 5):
                if (field1 == "split"):
                    return python_internal_MethodClosure(o,HxString.split)
                else:
                    field1 = (("_hx_" + field) if ((field in python_Boot.keywords)) else (("_hx_" + field) if (((((len(field) > 2) and ((ord(field[0]) == 95))) and ((ord(field[1]) == 95))) and ((ord(field[(len(field) - 1)]) != 95)))) else field))
                    if hasattr(o,field1):
                        return getattr(o,field1)
                    else:
                        return None
            elif (_hx_local_0 == 7):
                if (field1 == "indexOf"):
                    return python_internal_MethodClosure(o,HxString.indexOf)
                else:
                    field1 = (("_hx_" + field) if ((field in python_Boot.keywords)) else (("_hx_" + field) if (((((len(field) > 2) and ((ord(field[0]) == 95))) and ((ord(field[1]) == 95))) and ((ord(field[(len(field) - 1)]) != 95)))) else field))
                    if hasattr(o,field1):
                        return getattr(o,field1)
                    else:
                        return None
            elif (_hx_local_0 == 8):
                if (field1 == "toString"):
                    return python_internal_MethodClosure(o,HxString.toString)
                else:
                    field1 = (("_hx_" + field) if ((field in python_Boot.keywords)) else (("_hx_" + field) if (((((len(field) > 2) and ((ord(field[0]) == 95))) and ((ord(field[1]) == 95))) and ((ord(field[(len(field) - 1)]) != 95)))) else field))
                    if hasattr(o,field1):
                        return getattr(o,field1)
                    else:
                        return None
            elif (_hx_local_0 == 6):
                if (field1 == "charAt"):
                    return python_internal_MethodClosure(o,HxString.charAt)
                elif (field1 == "length"):
                    return len(o)
                elif (field1 == "substr"):
                    return python_internal_MethodClosure(o,HxString.substr)
                else:
                    field1 = (("_hx_" + field) if ((field in python_Boot.keywords)) else (("_hx_" + field) if (((((len(field) > 2) and ((ord(field[0]) == 95))) and ((ord(field[1]) == 95))) and ((ord(field[(len(field) - 1)]) != 95)))) else field))
                    if hasattr(o,field1):
                        return getattr(o,field1)
                    else:
                        return None
            else:
                field1 = (("_hx_" + field) if ((field in python_Boot.keywords)) else (("_hx_" + field) if (((((len(field) > 2) and ((ord(field[0]) == 95))) and ((ord(field[1]) == 95))) and ((ord(field[(len(field) - 1)]) != 95)))) else field))
                if hasattr(o,field1):
                    return getattr(o,field1)
                else:
                    return None
        elif isinstance(o,list):
            field1 = field
            _hx_local_1 = len(field1)
            if (_hx_local_1 == 11):
                if (field1 == "lastIndexOf"):
                    return python_internal_MethodClosure(o,python_internal_ArrayImpl.lastIndexOf)
                else:
                    field1 = (("_hx_" + field) if ((field in python_Boot.keywords)) else (("_hx_" + field) if (((((len(field) > 2) and ((ord(field[0]) == 95))) and ((ord(field[1]) == 95))) and ((ord(field[(len(field) - 1)]) != 95)))) else field))
                    if hasattr(o,field1):
                        return getattr(o,field1)
                    else:
                        return None
            elif (_hx_local_1 == 4):
                if (field1 == "copy"):
                    return python_internal_MethodClosure(o,python_internal_ArrayImpl.copy)
                elif (field1 == "join"):
                    return python_internal_MethodClosure(o,python_internal_ArrayImpl.join)
                elif (field1 == "push"):
                    return python_internal_MethodClosure(o,python_internal_ArrayImpl.push)
                elif (field1 == "sort"):
                    return python_internal_MethodClosure(o,python_internal_ArrayImpl.sort)
                else:
                    field1 = (("_hx_" + field) if ((field in python_Boot.keywords)) else (("_hx_" + field) if (((((len(field) > 2) and ((ord(field[0]) == 95))) and ((ord(field[1]) == 95))) and ((ord(field[(len(field) - 1)]) != 95)))) else field))
                    if hasattr(o,field1):
                        return getattr(o,field1)
                    else:
                        return None
            elif (_hx_local_1 == 5):
                if (field1 == "shift"):
                    return python_internal_MethodClosure(o,python_internal_ArrayImpl.shift)
                elif (field1 == "slice"):
                    return python_internal_MethodClosure(o,python_internal_ArrayImpl.slice)
                else:
                    field1 = (("_hx_" + field) if ((field in python_Boot.keywords)) else (("_hx_" + field) if (((((len(field) > 2) and ((ord(field[0]) == 95))) and ((ord(field[1]) == 95))) and ((ord(field[(len(field) - 1)]) != 95)))) else field))
                    if hasattr(o,field1):
                        return getattr(o,field1)
                    else:
                        return None
            elif (_hx_local_1 == 7):
                if (field1 == "indexOf"):
                    return python_internal_MethodClosure(o,python_internal_ArrayImpl.indexOf)
                elif (field1 == "reverse"):
                    return python_internal_MethodClosure(o,python_internal_ArrayImpl.reverse)
                elif (field1 == "unshift"):
                    return python_internal_MethodClosure(o,python_internal_ArrayImpl.unshift)
                else:
                    field1 = (("_hx_" + field) if ((field in python_Boot.keywords)) else (("_hx_" + field) if (((((len(field) > 2) and ((ord(field[0]) == 95))) and ((ord(field[1]) == 95))) and ((ord(field[(len(field) - 1)]) != 95)))) else field))
                    if hasattr(o,field1):
                        return getattr(o,field1)
                    else:
                        return None
            elif (_hx_local_1 == 3):
                if (field1 == "map"):
                    return python_internal_MethodClosure(o,python_internal_ArrayImpl.map)
                elif (field1 == "pop"):
                    return python_internal_MethodClosure(o,python_internal_ArrayImpl.pop)
                else:
                    field1 = (("_hx_" + field) if ((field in python_Boot.keywords)) else (("_hx_" + field) if (((((len(field) > 2) and ((ord(field[0]) == 95))) and ((ord(field[1]) == 95))) and ((ord(field[(len(field) - 1)]) != 95)))) else field))
                    if hasattr(o,field1):
                        return getattr(o,field1)
                    else:
                        return None
            elif (_hx_local_1 == 8):
                if (field1 == "contains"):
                    return python_internal_MethodClosure(o,python_internal_ArrayImpl.contains)
                elif (field1 == "iterator"):
                    return python_internal_MethodClosure(o,python_internal_ArrayImpl.iterator)
                elif (field1 == "toString"):
                    return python_internal_MethodClosure(o,python_internal_ArrayImpl.toString)
                else:
                    field1 = (("_hx_" + field) if ((field in python_Boot.keywords)) else (("_hx_" + field) if (((((len(field) > 2) and ((ord(field[0]) == 95))) and ((ord(field[1]) == 95))) and ((ord(field[(len(field) - 1)]) != 95)))) else field))
                    if hasattr(o,field1):
                        return getattr(o,field1)
                    else:
                        return None
            elif (_hx_local_1 == 16):
                if (field1 == "keyValueIterator"):
                    return python_internal_MethodClosure(o,python_internal_ArrayImpl.keyValueIterator)
                else:
                    field1 = (("_hx_" + field) if ((field in python_Boot.keywords)) else (("_hx_" + field) if (((((len(field) > 2) and ((ord(field[0]) == 95))) and ((ord(field[1]) == 95))) and ((ord(field[(len(field) - 1)]) != 95)))) else field))
                    if hasattr(o,field1):
                        return getattr(o,field1)
                    else:
                        return None
            elif (_hx_local_1 == 6):
                if (field1 == "concat"):
                    return python_internal_MethodClosure(o,python_internal_ArrayImpl.concat)
                elif (field1 == "filter"):
                    return python_internal_MethodClosure(o,python_internal_ArrayImpl.filter)
                elif (field1 == "insert"):
                    return python_internal_MethodClosure(o,python_internal_ArrayImpl.insert)
                elif (field1 == "length"):
                    return len(o)
                elif (field1 == "remove"):
                    return python_internal_MethodClosure(o,python_internal_ArrayImpl.remove)
                elif (field1 == "splice"):
                    return python_internal_MethodClosure(o,python_internal_ArrayImpl.splice)
                else:
                    field1 = (("_hx_" + field) if ((field in python_Boot.keywords)) else (("_hx_" + field) if (((((len(field) > 2) and ((ord(field[0]) == 95))) and ((ord(field[1]) == 95))) and ((ord(field[(len(field) - 1)]) != 95)))) else field))
                    if hasattr(o,field1):
                        return getattr(o,field1)
                    else:
                        return None
            else:
                field1 = (("_hx_" + field) if ((field in python_Boot.keywords)) else (("_hx_" + field) if (((((len(field) > 2) and ((ord(field[0]) == 95))) and ((ord(field[1]) == 95))) and ((ord(field[(len(field) - 1)]) != 95)))) else field))
                if hasattr(o,field1):
                    return getattr(o,field1)
                else:
                    return None
        else:
            field1 = (("_hx_" + field) if ((field in python_Boot.keywords)) else (("_hx_" + field) if (((((len(field) > 2) and ((ord(field[0]) == 95))) and ((ord(field[1]) == 95))) and ((ord(field[(len(field) - 1)]) != 95)))) else field))
            if hasattr(o,field1):
                return getattr(o,field1)
            else:
                return None

    @staticmethod
    def getInstanceFields(c):
        f = (list(c._hx_fields) if (hasattr(c,"_hx_fields")) else [])
        if hasattr(c,"_hx_methods"):
            f = (f + c._hx_methods)
        sc = python_Boot.getSuperClass(c)
        if (sc is None):
            return f
        else:
            scArr = python_Boot.getInstanceFields(sc)
            scMap = set(scArr)
            _g = 0
            while (_g < len(f)):
                f1 = (f[_g] if _g >= 0 and _g < len(f) else None)
                _g = (_g + 1)
                if (not (f1 in scMap)):
                    scArr.append(f1)
            return scArr

    @staticmethod
    def getSuperClass(c):
        if (c is None):
            return None
        try:
            if hasattr(c,"_hx_super"):
                return c._hx_super
            return None
        except BaseException as _g:
            None
        return None

    @staticmethod
    def getClassFields(c):
        if hasattr(c,"_hx_statics"):
            x = c._hx_statics
            return list(x)
        else:
            return []

    @staticmethod
    def unhandleKeywords(name):
        if (HxString.substr(name,0,python_Boot.prefixLength) == "_hx_"):
            real = HxString.substr(name,python_Boot.prefixLength,None)
            if (real in python_Boot.keywords):
                return real
        return name
python_Boot._hx_class = python_Boot


class python_HaxeIterator:
    _hx_class_name = "python.HaxeIterator"
    __slots__ = ("it", "x", "has", "checked")
    _hx_fields = ["it", "x", "has", "checked"]
    _hx_methods = ["next", "hasNext"]

    def __init__(self,it):
        self.checked = False
        self.has = False
        self.x = None
        self.it = it

    def next(self):
        if (not self.checked):
            self.hasNext()
        self.checked = False
        return self.x

    def hasNext(self):
        if (not self.checked):
            try:
                self.x = self.it.__next__()
                self.has = True
            except BaseException as _g:
                None
                if Std.isOfType(haxe_Exception.caught(_g).unwrap(),StopIteration):
                    self.has = False
                    self.x = None
                else:
                    raise _g
            self.checked = True
        return self.has

    @staticmethod
    def _hx_empty_init(_hx_o):
        _hx_o.it = None
        _hx_o.x = None
        _hx_o.has = None
        _hx_o.checked = None
python_HaxeIterator._hx_class = python_HaxeIterator


class python__KwArgs_KwArgs_Impl_:
    _hx_class_name = "python._KwArgs.KwArgs_Impl_"
    __slots__ = ()
    _hx_statics = ["fromT"]

    @staticmethod
    def fromT(d):
        this1 = python_Lib.anonAsDict(d)
        return this1
python__KwArgs_KwArgs_Impl_._hx_class = python__KwArgs_KwArgs_Impl_


class python_Lib:
    _hx_class_name = "python.Lib"
    __slots__ = ()
    _hx_statics = ["dictToAnon", "anonToDict", "anonAsDict"]

    @staticmethod
    def dictToAnon(v):
        return _hx_AnonObject(v.copy())

    @staticmethod
    def anonToDict(o):
        if isinstance(o,_hx_AnonObject):
            return o.__dict__.copy()
        else:
            return None

    @staticmethod
    def anonAsDict(o):
        if isinstance(o,_hx_AnonObject):
            return o.__dict__
        else:
            return None
python_Lib._hx_class = python_Lib


class python_internal_ArrayImpl:
    _hx_class_name = "python.internal.ArrayImpl"
    __slots__ = ()
    _hx_statics = ["concat", "copy", "iterator", "keyValueIterator", "indexOf", "lastIndexOf", "join", "toString", "pop", "push", "unshift", "remove", "contains", "shift", "slice", "sort", "splice", "map", "filter", "insert", "reverse", "_get", "_set"]

    @staticmethod
    def concat(a1,a2):
        return (a1 + a2)

    @staticmethod
    def copy(x):
        return list(x)

    @staticmethod
    def iterator(x):
        return python_HaxeIterator(x.__iter__())

    @staticmethod
    def keyValueIterator(x):
        return haxe_iterators_ArrayKeyValueIterator(x)

    @staticmethod
    def indexOf(a,x,fromIndex = None):
        _hx_len = len(a)
        l = (0 if ((fromIndex is None)) else ((_hx_len + fromIndex) if ((fromIndex < 0)) else fromIndex))
        if (l < 0):
            l = 0
        _g = l
        _g1 = _hx_len
        while (_g < _g1):
            i = _g
            _g = (_g + 1)
            if HxOverrides.eq(a[i],x):
                return i
        return -1

    @staticmethod
    def lastIndexOf(a,x,fromIndex = None):
        _hx_len = len(a)
        l = (_hx_len if ((fromIndex is None)) else (((_hx_len + fromIndex) + 1) if ((fromIndex < 0)) else (fromIndex + 1)))
        if (l > _hx_len):
            l = _hx_len
        while True:
            l = (l - 1)
            tmp = l
            if (not ((tmp > -1))):
                break
            if HxOverrides.eq(a[l],x):
                return l
        return -1

    @staticmethod
    def join(x,sep):
        return sep.join([python_Boot.toString1(x1,'') for x1 in x])

    @staticmethod
    def toString(x):
        return (("[" + HxOverrides.stringOrNull(",".join([python_Boot.toString1(x1,'') for x1 in x]))) + "]")

    @staticmethod
    def pop(x):
        if (len(x) == 0):
            return None
        else:
            return x.pop()

    @staticmethod
    def push(x,e):
        x.append(e)
        return len(x)

    @staticmethod
    def unshift(x,e):
        x.insert(0, e)

    @staticmethod
    def remove(x,e):
        try:
            x.remove(e)
            return True
        except BaseException as _g:
            None
            return False

    @staticmethod
    def contains(x,e):
        return (e in x)

    @staticmethod
    def shift(x):
        if (len(x) == 0):
            return None
        return x.pop(0)

    @staticmethod
    def slice(x,pos,end = None):
        return x[pos:end]

    @staticmethod
    def sort(x,f):
        x.sort(key= python_lib_Functools.cmp_to_key(f))

    @staticmethod
    def splice(x,pos,_hx_len):
        if (pos < 0):
            pos = (len(x) + pos)
        if (pos < 0):
            pos = 0
        res = x[pos:(pos + _hx_len)]
        del x[pos:(pos + _hx_len)]
        return res

    @staticmethod
    def map(x,f):
        return list(map(f,x))

    @staticmethod
    def filter(x,f):
        return list(filter(f,x))

    @staticmethod
    def insert(a,pos,x):
        a.insert(pos, x)

    @staticmethod
    def reverse(a):
        a.reverse()

    @staticmethod
    def _get(x,idx):
        if ((idx > -1) and ((idx < len(x)))):
            return x[idx]
        else:
            return None

    @staticmethod
    def _set(x,idx,v):
        l = len(x)
        while (l < idx):
            x.append(None)
            l = (l + 1)
        if (l == idx):
            x.append(v)
        else:
            x[idx] = v
        return v
python_internal_ArrayImpl._hx_class = python_internal_ArrayImpl


class HxOverrides:
    _hx_class_name = "HxOverrides"
    __slots__ = ()
    _hx_statics = ["iterator", "eq", "stringOrNull", "mapKwArgs"]

    @staticmethod
    def iterator(x):
        if isinstance(x,list):
            return haxe_iterators_ArrayIterator(x)
        return x.iterator()

    @staticmethod
    def eq(a,b):
        if (isinstance(a,list) or isinstance(b,list)):
            return a is b
        return (a == b)

    @staticmethod
    def stringOrNull(s):
        if (s is None):
            return "null"
        else:
            return s

    @staticmethod
    def mapKwArgs(a,v):
        a1 = _hx_AnonObject(python_Lib.anonToDict(a))
        k = python_HaxeIterator(iter(v.keys()))
        while k.hasNext():
            k1 = k.next()
            val = v.get(k1)
            if a1._hx_hasattr(k1):
                x = getattr(a1,k1)
                setattr(a1,val,x)
                delattr(a1,k1)
        return a1
HxOverrides._hx_class = HxOverrides


class python_internal_MethodClosure:
    _hx_class_name = "python.internal.MethodClosure"
    __slots__ = ("obj", "func")
    _hx_fields = ["obj", "func"]
    _hx_methods = ["__call__"]

    def __init__(self,obj,func):
        self.obj = obj
        self.func = func

    def __call__(self,*args):
        return self.func(self.obj,*args)

    @staticmethod
    def _hx_empty_init(_hx_o):
        _hx_o.obj = None
        _hx_o.func = None
python_internal_MethodClosure._hx_class = python_internal_MethodClosure


class HxString:
    _hx_class_name = "HxString"
    __slots__ = ()
    _hx_statics = ["split", "charCodeAt", "charAt", "lastIndexOf", "toUpperCase", "toLowerCase", "indexOf", "indexOfImpl", "toString", "substring", "substr"]

    @staticmethod
    def split(s,d):
        if (d == ""):
            return list(s)
        else:
            return s.split(d)

    @staticmethod
    def charCodeAt(s,index):
        if ((((s is None) or ((len(s) == 0))) or ((index < 0))) or ((index >= len(s)))):
            return None
        else:
            return ord(s[index])

    @staticmethod
    def charAt(s,index):
        if ((index < 0) or ((index >= len(s)))):
            return ""
        else:
            return s[index]

    @staticmethod
    def lastIndexOf(s,_hx_str,startIndex = None):
        if (startIndex is None):
            return s.rfind(_hx_str, 0, len(s))
        elif (_hx_str == ""):
            length = len(s)
            if (startIndex < 0):
                startIndex = (length + startIndex)
                if (startIndex < 0):
                    startIndex = 0
            if (startIndex > length):
                return length
            else:
                return startIndex
        else:
            i = s.rfind(_hx_str, 0, (startIndex + 1))
            startLeft = (max(0,((startIndex + 1) - len(_hx_str))) if ((i == -1)) else (i + 1))
            check = s.find(_hx_str, startLeft, len(s))
            if ((check > i) and ((check <= startIndex))):
                return check
            else:
                return i

    @staticmethod
    def toUpperCase(s):
        return s.upper()

    @staticmethod
    def toLowerCase(s):
        return s.lower()

    @staticmethod
    def indexOf(s,_hx_str,startIndex = None):
        if (startIndex is None):
            return s.find(_hx_str)
        else:
            return HxString.indexOfImpl(s,_hx_str,startIndex)

    @staticmethod
    def indexOfImpl(s,_hx_str,startIndex):
        if (_hx_str == ""):
            length = len(s)
            if (startIndex < 0):
                startIndex = (length + startIndex)
                if (startIndex < 0):
                    startIndex = 0
            if (startIndex > length):
                return length
            else:
                return startIndex
        return s.find(_hx_str, startIndex)

    @staticmethod
    def toString(s):
        return s

    @staticmethod
    def substring(s,startIndex,endIndex = None):
        if (startIndex < 0):
            startIndex = 0
        if (endIndex is None):
            return s[startIndex:]
        else:
            if (endIndex < 0):
                endIndex = 0
            if (endIndex < startIndex):
                return s[endIndex:startIndex]
            else:
                return s[startIndex:endIndex]

    @staticmethod
    def substr(s,startIndex,_hx_len = None):
        if (_hx_len is None):
            return s[startIndex:]
        else:
            if (_hx_len == 0):
                return ""
            if (startIndex < 0):
                startIndex = (len(s) + startIndex)
                if (startIndex < 0):
                    startIndex = 0
            return s[startIndex:(startIndex + _hx_len)]
HxString._hx_class = HxString


class sys_net_Socket:
    _hx_class_name = "sys.net.Socket"
    __slots__ = ("_hx___s", "input", "output")
    _hx_fields = ["__s", "input", "output"]
    _hx_methods = ["__initSocket", "close", "connect", "shutdown", "setTimeout", "fileno"]

    def __init__(self):
        self.output = None
        self.input = None
        self._hx___s = None
        self._hx___initSocket()
        self.input = sys_net__Socket_SocketInput(self._hx___s)
        self.output = sys_net__Socket_SocketOutput(self._hx___s)

    def _hx___initSocket(self):
        self._hx___s = python_lib_socket_Socket()

    def close(self):
        self._hx___s.close()

    def connect(self,host,port):
        host_str = host.toString()
        self._hx___s.connect((host_str, port))

    def shutdown(self,read,write):
        self._hx___s.shutdown((python_lib_Socket.SHUT_RDWR if ((read and write)) else (python_lib_Socket.SHUT_RD if read else python_lib_Socket.SHUT_WR)))

    def setTimeout(self,timeout):
        self._hx___s.settimeout(timeout)

    def fileno(self):
        return self._hx___s.fileno()

    @staticmethod
    def _hx_empty_init(_hx_o):
        _hx_o._hx___s = None
        _hx_o.input = None
        _hx_o.output = None
sys_net_Socket._hx_class = sys_net_Socket


class python_net_SslSocket(sys_net_Socket):
    _hx_class_name = "python.net.SslSocket"
    __slots__ = ("hostName",)
    _hx_fields = ["hostName"]
    _hx_methods = ["__initSocket", "connect"]
    _hx_statics = []
    _hx_interfaces = []
    _hx_super = sys_net_Socket


    def __init__(self):
        self.hostName = None
        super().__init__()

    def _hx___initSocket(self):
        context = python_lib_ssl_SSLContext(python_lib_Ssl.PROTOCOL_SSLv23)
        context.verify_mode = python_lib_Ssl.CERT_REQUIRED
        context.set_default_verify_paths()
        context.options = (context.options | python_lib_Ssl.OP_NO_SSLv2)
        context.options = (context.options | python_lib_Ssl.OP_NO_SSLv3)
        context.options = (context.options | python_lib_Ssl.OP_NO_COMPRESSION)
        context.options = (context.options | python_lib_Ssl.OP_NO_TLSv1)
        self._hx___s = python_lib_socket_Socket()
        self._hx___s = context.wrap_socket(self._hx___s,False,True,True,self.hostName)

    def connect(self,host,port):
        self.hostName = host.host
        super().connect(host,port)

    @staticmethod
    def _hx_empty_init(_hx_o):
        _hx_o.hostName = None
python_net_SslSocket._hx_class = python_net_SslSocket


class restclient_RestClient:
    _hx_class_name = "restclient.RestClient"
    __slots__ = ()
    _hx_statics = ["preferHttpMethodOverride", "postAsync", "getAsync", "putAsync", "deleteAsync", "post", "get", "put", "delete", "requestAsync", "request", "buildHttpRequest"]

    @staticmethod
    def postAsync(url,onData = None,parameters = None,onError = None):
        restclient_RestClient.requestAsync("POST",url,onData,parameters,onError)

    @staticmethod
    def getAsync(url,onData = None,parameters = None,onError = None):
        restclient_RestClient.requestAsync("GET",url,onData,parameters,onError)

    @staticmethod
    def putAsync(url,onData = None,parameters = None,onError = None):
        restclient_RestClient.requestAsync("PUT",url,onData,parameters,onError)

    @staticmethod
    def deleteAsync(url,onData = None,parameters = None,onError = None):
        restclient_RestClient.requestAsync("DELETE",url,onData,parameters,onError)

    @staticmethod
    def post(url,parameters = None,onError = None):
        return restclient_RestClient.request("POST",url,parameters,None,onError)

    @staticmethod
    def get(url,parameters = None,onError = None):
        return restclient_RestClient.request("GET",url,parameters,None,onError)

    @staticmethod
    def put(url,parameters = None,onError = None):
        return restclient_RestClient.request("PUT",url,parameters,None,onError)

    @staticmethod
    def delete(url,parameters = None,onError = None):
        return restclient_RestClient.request("DELETE",url,parameters,None,onError)

    @staticmethod
    def requestAsync(verb,url,onData = None,parameters = None,onError = None):
        post = (verb != "GET")
        httpRequest = restclient_RestClient.buildHttpRequest(verb,True,url,parameters,True,onData,onError)
        httpRequest.request(post)

    @staticmethod
    def request(verb,url,parameters = None,_hx_async = None,onData = None,onError = None):
        if (_hx_async is None):
            _hx_async = False
        result = None
        useOverride = restclient_RestClient.preferHttpMethodOverride
        post = (verb != "GET")
        def _hx_local_0(data):
            nonlocal result
            result = data
        httpRequest = restclient_RestClient.buildHttpRequest(verb,useOverride,url,parameters,False,_hx_local_0,onError)
        output = haxe_io_BytesOutput()
        if useOverride:
            verb = ("POST" if post else "GET")
        httpRequest.customRequest(False,output,None,verb)
        return output.getBytes().toString()

    @staticmethod
    def buildHttpRequest(verb,useOverride,url,parameters = None,_hx_async = None,onData = None,onError = None):
        if (_hx_async is None):
            _hx_async = False
        httpRequest = sys_Http(url)
        if (onError is not None):
            httpRequest.onError = onError
        if (onData is not None):
            httpRequest.onData = onData
        if (parameters is not None):
            x = parameters.keys()
            while x.hasNext():
                x1 = x.next()
                httpRequest.setParameter(x1,parameters.h.get(x1,None))
        if ((useOverride and ((verb != "GET"))) and ((verb != "POST"))):
            httpRequest.setHeader("X-HTTP-Method-Override",verb)
        return httpRequest
restclient_RestClient._hx_class = restclient_RestClient


class sys_Http(haxe_http_HttpBase):
    _hx_class_name = "sys.Http"
    __slots__ = ("noShutdown", "cnxTimeout", "responseHeaders", "chunk_size", "chunk_buf", "file")
    _hx_fields = ["noShutdown", "cnxTimeout", "responseHeaders", "chunk_size", "chunk_buf", "file"]
    _hx_methods = ["request", "customRequest", "writeBody", "readHttpResponse", "readChunk"]
    _hx_statics = ["PROXY"]
    _hx_interfaces = []
    _hx_super = haxe_http_HttpBase


    def __init__(self,url):
        self.file = None
        self.chunk_buf = None
        self.chunk_size = None
        self.responseHeaders = None
        self.noShutdown = None
        self.cnxTimeout = 10
        super().__init__(url)

    def request(self,post = None):
        _gthis = self
        output = haxe_io_BytesOutput()
        old = self.onError
        err = False
        def _hx_local_0(e):
            nonlocal err
            _gthis.responseBytes = output.getBytes()
            err = True
            _gthis.onError = old
            _gthis.onError(e)
        self.onError = _hx_local_0
        post = ((post or ((self.postBytes is not None))) or ((self.postData is not None)))
        self.customRequest(post,output)
        if (not err):
            self.success(output.getBytes())

    def customRequest(self,post,api,sock = None,method = None):
        self.responseAsString = None
        self.responseBytes = None
        url_regexp = EReg("^(https?://)?([a-zA-Z\\.0-9_-]+)(:[0-9]+)?(.*)$","")
        url_regexp.matchObj = python_lib_Re.search(url_regexp.pattern,self.url)
        if (url_regexp.matchObj is None):
            self.onError("Invalid URL")
            return
        secure = (url_regexp.matchObj.group(1) == "https://")
        if (sock is None):
            if secure:
                sock = python_net_SslSocket()
            else:
                sock = sys_net_Socket()
            sock.setTimeout(self.cnxTimeout)
        host = url_regexp.matchObj.group(2)
        portString = url_regexp.matchObj.group(3)
        request = url_regexp.matchObj.group(4)
        if ((("" if ((0 >= len(request))) else request[0])) != "/"):
            request = ("/" + ("null" if request is None else request))
        port = ((443 if secure else 80) if (((portString is None) or ((portString == "")))) else Std.parseInt(HxString.substr(portString,1,(len(portString) - 1))))
        multipart = (self.file is not None)
        boundary = None
        uri = None
        if multipart:
            post = True
            boundary = (((Std.string(int((python_lib_Random.random() * 1000))) + Std.string(int((python_lib_Random.random() * 1000)))) + Std.string(int((python_lib_Random.random() * 1000)))) + Std.string(int((python_lib_Random.random() * 1000))))
            while (len(boundary) < 38):
                boundary = ("-" + ("null" if boundary is None else boundary))
            b_b = python_lib_io_StringIO()
            _g = 0
            _g1 = self.params
            while (_g < len(_g1)):
                p = (_g1[_g] if _g >= 0 and _g < len(_g1) else None)
                _g = (_g + 1)
                b_b.write("--")
                b_b.write(Std.string(boundary))
                b_b.write("\r\n")
                b_b.write("Content-Disposition: form-data; name=\"")
                b_b.write(Std.string(p.name))
                b_b.write("\"")
                b_b.write("\r\n")
                b_b.write("\r\n")
                b_b.write(Std.string(p.value))
                b_b.write("\r\n")
            b_b.write("--")
            b_b.write(Std.string(boundary))
            b_b.write("\r\n")
            b_b.write("Content-Disposition: form-data; name=\"")
            b_b.write(Std.string(self.file.param))
            b_b.write("\"; filename=\"")
            b_b.write(Std.string(self.file.filename))
            b_b.write("\"")
            b_b.write("\r\n")
            b_b.write(Std.string(((("Content-Type: " + HxOverrides.stringOrNull(self.file.mimeType)) + "\r\n") + "\r\n")))
            uri = b_b.getvalue()
        else:
            _g = 0
            _g1 = self.params
            while (_g < len(_g1)):
                p = (_g1[_g] if _g >= 0 and _g < len(_g1) else None)
                _g = (_g + 1)
                if (uri is None):
                    uri = ""
                else:
                    uri = (("null" if uri is None else uri) + "&")
                uri = (("null" if uri is None else uri) + HxOverrides.stringOrNull((((HxOverrides.stringOrNull(python_lib_urllib_Parse.quote(p.name,"")) + "=") + HxOverrides.stringOrNull(python_lib_urllib_Parse.quote(("" + HxOverrides.stringOrNull(p.value)),""))))))
        b = haxe_io_BytesOutput()
        if (method is not None):
            b.writeString(method)
            b.writeString(" ")
        elif post:
            b.writeString("POST ")
        else:
            b.writeString("GET ")
        if (sys_Http.PROXY is not None):
            b.writeString("http://")
            b.writeString(host)
            if (port != 80):
                b.writeString(":")
                b.writeString(("" + Std.string(port)))
        b.writeString(request)
        if ((not post) and ((uri is not None))):
            if (HxString.indexOfImpl(request,"?",0) >= 0):
                b.writeString("&")
            else:
                b.writeString("?")
            b.writeString(uri)
        b.writeString(((" HTTP/1.1\r\nHost: " + ("null" if host is None else host)) + "\r\n"))
        if (self.postData is not None):
            self.postBytes = haxe_io_Bytes.ofString(self.postData)
            self.postData = None
        if (self.postBytes is not None):
            b.writeString((("Content-Length: " + Std.string(self.postBytes.length)) + "\r\n"))
        elif (post and ((uri is not None))):
            def _hx_local_4(h):
                return (h.name == "Content-Type")
            if (multipart or (not Lambda.exists(self.headers,_hx_local_4))):
                b.writeString("Content-Type: ")
                if multipart:
                    b.writeString("multipart/form-data")
                    b.writeString("; boundary=")
                    b.writeString(boundary)
                else:
                    b.writeString("application/x-www-form-urlencoded")
                b.writeString("\r\n")
            if multipart:
                b.writeString((("Content-Length: " + Std.string(((((len(uri) + self.file.size) + len(boundary)) + 6)))) + "\r\n"))
            else:
                b.writeString((("Content-Length: " + Std.string(len(uri))) + "\r\n"))
        b.writeString("Connection: close\r\n")
        _g = 0
        _g1 = self.headers
        while (_g < len(_g1)):
            h = (_g1[_g] if _g >= 0 and _g < len(_g1) else None)
            _g = (_g + 1)
            b.writeString(h.name)
            b.writeString(": ")
            b.writeString(h.value)
            b.writeString("\r\n")
        b.writeString("\r\n")
        if (self.postBytes is not None):
            b.writeFullBytes(self.postBytes,0,self.postBytes.length)
        elif (post and ((uri is not None))):
            b.writeString(uri)
        try:
            if (sys_Http.PROXY is not None):
                sock.connect(sys_net_Host(sys_Http.PROXY.host),sys_Http.PROXY.port)
            else:
                sock.connect(sys_net_Host(host),port)
            if multipart:
                self.writeBody(b,self.file.io,self.file.size,boundary,sock)
            else:
                self.writeBody(b,None,0,None,sock)
            self.readHttpResponse(api,sock)
            sock.close()
        except BaseException as _g:
            None
            e = haxe_Exception.caught(_g).unwrap()
            try:
                sock.close()
            except BaseException as _g:
                pass
            self.onError(Std.string(e))

    def writeBody(self,body,fileInput,fileSize,boundary,sock):
        if (body is not None):
            _hx_bytes = body.getBytes()
            sock.output.writeFullBytes(_hx_bytes,0,_hx_bytes.length)
        if (boundary is not None):
            bufsize = 4096
            buf = haxe_io_Bytes.alloc(bufsize)
            while (fileSize > 0):
                size = (bufsize if ((fileSize > bufsize)) else fileSize)
                _hx_len = 0
                try:
                    _hx_len = fileInput.readBytes(buf,0,size)
                except BaseException as _g:
                    None
                    if Std.isOfType(haxe_Exception.caught(_g).unwrap(),haxe_io_Eof):
                        break
                    else:
                        raise _g
                sock.output.writeFullBytes(buf,0,_hx_len)
                fileSize = (fileSize - _hx_len)
            sock.output.writeString("\r\n")
            sock.output.writeString("--")
            sock.output.writeString(boundary)
            sock.output.writeString("--")

    def readHttpResponse(self,api,sock):
        b = haxe_io_BytesBuffer()
        k = 4
        s = haxe_io_Bytes.alloc(4)
        sock.setTimeout(self.cnxTimeout)
        while True:
            p = sock.input.readBytes(s,0,k)
            while (p != k):
                p = (p + sock.input.readBytes(s,p,(k - p)))
            if ((k < 0) or ((k > s.length))):
                raise haxe_Exception.thrown(haxe_io_Error.OutsideBounds)
            b.b.extend(s.b[0:k])
            k1 = k
            if (k1 == 1):
                c = s.b[0]
                if (c == 10):
                    break
                if (c == 13):
                    k = 3
                else:
                    k = 4
            elif (k1 == 2):
                c1 = s.b[1]
                if (c1 == 10):
                    if (s.b[0] == 13):
                        break
                    k = 4
                elif (c1 == 13):
                    k = 3
                else:
                    k = 4
            elif (k1 == 3):
                c2 = s.b[2]
                if (c2 == 10):
                    if (s.b[1] != 13):
                        k = 4
                    elif (s.b[0] != 10):
                        k = 2
                    else:
                        break
                elif (c2 == 13):
                    if ((s.b[1] != 10) or ((s.b[0] != 13))):
                        k = 1
                    else:
                        k = 3
                else:
                    k = 4
            elif (k1 == 4):
                c3 = s.b[3]
                if (c3 == 10):
                    if (s.b[2] != 13):
                        continue
                    elif ((s.b[1] != 10) or ((s.b[0] != 13))):
                        k = 2
                    else:
                        break
                elif (c3 == 13):
                    if ((s.b[2] != 10) or ((s.b[1] != 13))):
                        k = 3
                    else:
                        k = 1
            else:
                pass
        _this = b.getBytes().toString()
        headers = _this.split("\r\n")
        response = (None if ((len(headers) == 0)) else headers.pop(0))
        rp = response.split(" ")
        status = Std.parseInt((rp[1] if 1 < len(rp) else None))
        if ((status == 0) or ((status is None))):
            raise haxe_Exception.thrown("Response status error")
        if (len(headers) != 0):
            headers.pop()
        if (len(headers) != 0):
            headers.pop()
        self.responseHeaders = haxe_ds_StringMap()
        size = None
        chunked = False
        _g = 0
        while (_g < len(headers)):
            hline = (headers[_g] if _g >= 0 and _g < len(headers) else None)
            _g = (_g + 1)
            a = hline.split(": ")
            hname = (None if ((len(a) == 0)) else a.pop(0))
            hval = ((a[0] if 0 < len(a) else None) if ((len(a) == 1)) else ": ".join([python_Boot.toString1(x1,'') for x1 in a]))
            hval = StringTools.ltrim(StringTools.rtrim(hval))
            self.responseHeaders.h[hname] = hval
            _g1 = hname.lower()
            _hx_local_2 = len(_g1)
            if (_hx_local_2 == 17):
                if (_g1 == "transfer-encoding"):
                    chunked = (hval.lower() == "chunked")
            elif (_hx_local_2 == 14):
                if (_g1 == "content-length"):
                    size = Std.parseInt(hval)
            else:
                pass
        self.onStatus(status)
        chunk_re = EReg("^([0-9A-Fa-f]+)[ ]*\r\n","m")
        self.chunk_size = None
        self.chunk_buf = None
        bufsize = 1024
        buf = haxe_io_Bytes.alloc(bufsize)
        if chunked:
            try:
                while True:
                    _hx_len = sock.input.readBytes(buf,0,bufsize)
                    if (not self.readChunk(chunk_re,api,buf,_hx_len)):
                        break
            except BaseException as _g:
                None
                if Std.isOfType(haxe_Exception.caught(_g).unwrap(),haxe_io_Eof):
                    raise haxe_Exception.thrown("Transfer aborted")
                else:
                    raise _g
        elif (size is None):
            if (not self.noShutdown):
                sock.shutdown(False,True)
            try:
                while True:
                    _hx_len = sock.input.readBytes(buf,0,bufsize)
                    if (_hx_len == 0):
                        break
                    api.writeBytes(buf,0,_hx_len)
            except BaseException as _g:
                None
                if (not Std.isOfType(haxe_Exception.caught(_g).unwrap(),haxe_io_Eof)):
                    raise _g
        else:
            api.prepare(size)
            try:
                while (size > 0):
                    _hx_len = sock.input.readBytes(buf,0,(bufsize if ((size > bufsize)) else size))
                    api.writeBytes(buf,0,_hx_len)
                    size = (size - _hx_len)
            except BaseException as _g:
                None
                if Std.isOfType(haxe_Exception.caught(_g).unwrap(),haxe_io_Eof):
                    raise haxe_Exception.thrown("Transfer aborted")
                else:
                    raise _g
        if (chunked and (((self.chunk_size is not None) or ((self.chunk_buf is not None))))):
            raise haxe_Exception.thrown("Invalid chunk")
        if ((status < 200) or ((status >= 400))):
            raise haxe_Exception.thrown(("Http Error #" + Std.string(status)))
        api.close()

    def readChunk(self,chunk_re,api,buf,_hx_len):
        if (self.chunk_size is None):
            if (self.chunk_buf is not None):
                b = haxe_io_BytesBuffer()
                b.b.extend(self.chunk_buf.b)
                if ((_hx_len < 0) or ((_hx_len > buf.length))):
                    raise haxe_Exception.thrown(haxe_io_Error.OutsideBounds)
                b.b.extend(buf.b[0:_hx_len])
                buf = b.getBytes()
                _hx_len = (_hx_len + self.chunk_buf.length)
                self.chunk_buf = None
            s = buf.toString()
            chunk_re.matchObj = python_lib_Re.search(chunk_re.pattern,s)
            if (chunk_re.matchObj is not None):
                p_pos = chunk_re.matchObj.start()
                p_len = (chunk_re.matchObj.end() - chunk_re.matchObj.start())
                if (p_len <= _hx_len):
                    cstr = chunk_re.matchObj.group(1)
                    self.chunk_size = Std.parseInt(("0x" + ("null" if cstr is None else cstr)))
                    if (self.chunk_size == 0):
                        self.chunk_size = None
                        self.chunk_buf = None
                        return False
                    _hx_len = (_hx_len - p_len)
                    return self.readChunk(chunk_re,api,buf.sub(p_len,_hx_len),_hx_len)
            if (_hx_len > 10):
                self.onError("Invalid chunk")
                return False
            self.chunk_buf = buf.sub(0,_hx_len)
            return True
        if (self.chunk_size > _hx_len):
            _hx_local_2 = self
            _hx_local_3 = _hx_local_2.chunk_size
            _hx_local_2.chunk_size = (_hx_local_3 - _hx_len)
            _hx_local_2.chunk_size
            api.writeBytes(buf,0,_hx_len)
            return True
        end = (self.chunk_size + 2)
        if (_hx_len >= end):
            if (self.chunk_size > 0):
                api.writeBytes(buf,0,self.chunk_size)
            _hx_len = (_hx_len - end)
            self.chunk_size = None
            if (_hx_len == 0):
                return True
            return self.readChunk(chunk_re,api,buf.sub(end,_hx_len),_hx_len)
        if (self.chunk_size > 0):
            api.writeBytes(buf,0,self.chunk_size)
        _hx_local_5 = self
        _hx_local_6 = _hx_local_5.chunk_size
        _hx_local_5.chunk_size = (_hx_local_6 - _hx_len)
        _hx_local_5.chunk_size
        return True

    @staticmethod
    def _hx_empty_init(_hx_o):
        _hx_o.noShutdown = None
        _hx_o.cnxTimeout = None
        _hx_o.responseHeaders = None
        _hx_o.chunk_size = None
        _hx_o.chunk_buf = None
        _hx_o.file = None
sys_Http._hx_class = sys_Http


class sys_net_Host:
    _hx_class_name = "sys.net.Host"
    __slots__ = ("host", "name")
    _hx_fields = ["host", "name"]
    _hx_methods = ["toString"]

    def __init__(self,name):
        self.host = name
        self.name = name

    def toString(self):
        return self.name

    @staticmethod
    def _hx_empty_init(_hx_o):
        _hx_o.host = None
        _hx_o.name = None
sys_net_Host._hx_class = sys_net_Host


class sys_net__Socket_SocketInput(haxe_io_Input):
    _hx_class_name = "sys.net._Socket.SocketInput"
    __slots__ = ("_hx___s",)
    _hx_fields = ["__s"]
    _hx_methods = ["readByte", "readBytes"]
    _hx_statics = []
    _hx_interfaces = []
    _hx_super = haxe_io_Input


    def __init__(self,s):
        self._hx___s = s

    def readByte(self):
        r = None
        try:
            r = self._hx___s.recv(1,0)
        except BaseException as _g:
            None
            if Std.isOfType(haxe_Exception.caught(_g).unwrap(),BlockingIOError):
                raise haxe_Exception.thrown(haxe_io_Error.Blocked)
            else:
                raise _g
        if (len(r) == 0):
            raise haxe_Exception.thrown(haxe_io_Eof())
        return r[0]

    def readBytes(self,buf,pos,_hx_len):
        r = None
        data = buf.b
        try:
            r = self._hx___s.recv(_hx_len,0)
            _g = pos
            _g1 = (pos + len(r))
            while (_g < _g1):
                i = _g
                _g = (_g + 1)
                data.__setitem__(i,r[(i - pos)])
        except BaseException as _g:
            None
            if Std.isOfType(haxe_Exception.caught(_g).unwrap(),BlockingIOError):
                raise haxe_Exception.thrown(haxe_io_Error.Blocked)
            else:
                raise _g
        if (len(r) == 0):
            raise haxe_Exception.thrown(haxe_io_Eof())
        return len(r)

    @staticmethod
    def _hx_empty_init(_hx_o):
        _hx_o._hx___s = None
sys_net__Socket_SocketInput._hx_class = sys_net__Socket_SocketInput


class sys_net__Socket_SocketOutput(haxe_io_Output):
    _hx_class_name = "sys.net._Socket.SocketOutput"
    __slots__ = ("_hx___s",)
    _hx_fields = ["__s"]
    _hx_methods = ["writeByte", "writeBytes", "close"]
    _hx_statics = []
    _hx_interfaces = []
    _hx_super = haxe_io_Output


    def __init__(self,s):
        self._hx___s = s

    def writeByte(self,c):
        try:
            self._hx___s.send(bytes([c]),0)
        except BaseException as _g:
            None
            if Std.isOfType(haxe_Exception.caught(_g).unwrap(),BlockingIOError):
                raise haxe_Exception.thrown(haxe_io_Error.Blocked)
            else:
                raise _g

    def writeBytes(self,buf,pos,_hx_len):
        try:
            data = buf.b
            payload = data[pos:pos+_hx_len]
            r = self._hx___s.send(payload,0)
            return r
        except BaseException as _g:
            None
            if Std.isOfType(haxe_Exception.caught(_g).unwrap(),BlockingIOError):
                raise haxe_Exception.thrown(haxe_io_Error.Blocked)
            else:
                raise _g

    def close(self):
        super().close()
        if (self._hx___s is not None):
            self._hx___s.close()

    @staticmethod
    def _hx_empty_init(_hx_o):
        _hx_o._hx___s = None
sys_net__Socket_SocketOutput._hx_class = sys_net__Socket_SocketOutput

Math.NEGATIVE_INFINITY = float("-inf")
Math.POSITIVE_INFINITY = float("inf")
Math.NaN = float("nan")
Math.PI = python_lib_Math.pi

python_Boot.keywords = set(["and", "del", "from", "not", "with", "as", "elif", "global", "or", "yield", "assert", "else", "if", "pass", "None", "break", "except", "import", "raise", "True", "class", "exec", "in", "return", "False", "continue", "finally", "is", "try", "def", "for", "lambda", "while"])
python_Boot.prefixLength = len("_hx_")
restclient_RestClient.preferHttpMethodOverride = False
sys_Http.PROXY = None