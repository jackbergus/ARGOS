"""
Copyright (C) 2023  Giacomo Bergami <giacomobergami@gmail.com>

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Lesser General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
"""

from dgdl.antlr import dgdlParser


def parse_content(context:dgdlParser.ContentContext):
    """
    Dealing with multiple possible representations of  a contentContext within Dundee's pipeline
    :param context:
    :return:
    """
    result = []
    if context is not None:
        if isinstance(context, list):
            if len(context)==0:
                return result
            else:
                for y in context:
                    for x in y.contentItem():
                        if x.contentSet() is not None:
                            raise Exception("unhandled case")
                        elif x.contentVar() is not None:
                            result.append(x.contentVar().getText())
                        elif x.contentStr() is not None:
                            result.append(x.contentStr().getText())
        else:
            ci = None
            try:
                ci = context.contentItem()
            except:
                print("wat")
            if ci is not None:
                for x in ci:
                    if x.contentSet() is not None:
                        raise Exception("unhandled case")
                    elif x.contentVar() is not None:
                        result.append(x.contentVar().getText())
                    elif x.contentStr() is not None:
                        result.append(x.contentStr().getText())
    return result
