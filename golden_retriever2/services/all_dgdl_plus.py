import os

import regex
import itertools
from pathlib import Path

def product_dict(**kwargs):
    """
    Providing the cartesian product across all the lists of the provided dictionary

    :param kwargs:  The dictionary
    :return:        {x->y}_{x\in kwargs.keys(), y\in kwargs[x]}
    """
    keys = kwargs.keys()
    for instance in itertools.product(*kwargs.values()):
        yield dict(zip(keys, instance))

def expand_with_generic(d, var_rgx, str, callable):
    """
    Replacing all the occurrences of the regex match in str with the output provided by callble

    :param d:           Additional value coming from the outside
    :param var_rgx:     Regex to be matched
    :param str:         String where to find multiple matches of the regex
    :param callable:    Callable object/function to be called over the matched data, the regex, and the additional value
    :return:            The expanded string
    """
    init = ""
    end = 0
    for m in var_rgx.finditer(str):
        c = m.capturesdict()
        init = init + str[end:m.start()]
        init = init + callable(d, c, str, var_rgx)
        end = m.end()
    return init + str[end:]

def expand_with_lambda(d, var_rgx, str):
    return expand_with_generic(d, var_rgx, str, lambda d, c, str, rgx: d.get(c["varmatch"][0], ""))

class Generaliser:
    def __init__(self):
        # Associating the variables to the finite set
        self.variables = regex.compile(r'∀(?P<var>[a-z]+)∈\{(?P<head>\w+)(?P<tail>,\s*\w+)*\}.')
        # Defining the regions to be expanded, which are going to be serialised in a specific file
        self.tocapture = regex.compile(r'(?P<file>[a-z]+)\s*≝\s*⟪(?P<region>[^[≝⟪⟫]+)⟫')
        # Determining the regions where the variables should be expanded with the values associated to the variables
        # in the finite set, and joining together all the retrieved instances with the provided string
        self.toexpand = regex.compile(r'⟦(?P<toexpand>[^[⟦⟧]+)⟧\(\"(?P<with>.+?)\"\)')
        # Delimiting the variables in the text
        self.tomatch = regex.compile(r'‖(?P<varmatch>[^‖]+)‖')

    def to_expand_part(self, str, with_):
        return expand_with_generic(None, self.toexpand, str, lambda d, c, str, rgc: c["with"][0].join(
            map(lambda x: expand_with_lambda(x, self.tomatch, c["toexpand"][0]), with_)))

    def readContent(self, s, filename_base, ext_base, returned=False):
        """
        Expands a textual content and demultiplexes it according to a finite quantification.
        The expansion of the variables is also joined together using an appending mechanism

        :param s:                   String to be expanded
        :param filename_base:       Filename base
        :param ext_base:            Extension for each expanded file
        :param returned:            Whether the expansion should be also be returned as a dictionary mapping each expansion name to the result
        :return:                    The extensions that were also been expanded into a file, if returned=True
        """
        d = dict()
        ## Getting the universal quantifiers
        for m in self.variables.finditer(s):
            c = m.capturesdict()
            var = c["var"][0]
            vals = [c["head"][0].strip()]
            for x in c["tail"]:
                vals.append(x[1:].strip())
            d[var] = vals
        d = list(product_dict(**d))

        e = None
        if returned:
            e = dict()
        for m in self.tocapture.finditer(s):
            c = m.capturesdict()
            name = c["file"][0]
            region = c["region"][0]
            tmp = self.to_expand_part(region, d)
            with open(filename_base+"_"+name+ext_base, "w") as f:
                f.write(tmp)
            if returned:
                e[name] = tmp
        return e

    def readFile(self, f, returned=True):
        """
        Reading the file to be expanded
        :param f:           The file path to be read
        :param returned:    Whether the expansion should be also be returned as a dictionary mapping each expansion name to the result
        :return:            The aforementioned map, if returned=True
        """
        name = Path(f).stem
        extension = "".join(Path(f).suffixes)
        data = None
        with open(f, 'r') as file:
            data = file.read()
        return self.readContent(data, name, extension, returned)
