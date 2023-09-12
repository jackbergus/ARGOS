#!/bin/bash
rm -rf docs/
rm -rf pages/
haxelib install dox
haxe -xml docs/doc.xml -D doc-gen -L json2object  -p src/ jackbergus
haxelib run dox -i docs
