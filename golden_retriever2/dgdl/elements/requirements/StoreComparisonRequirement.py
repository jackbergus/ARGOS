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

from .Requirement import Requirement

class StoreComparisonRequirement(Requirement):
    def __init__(requirement, store1, user1, comparison, store2, user2):
        requirement.type = "magnitude"
        requirement.store1 = store1
        requirement.user1 = user1
        requirement.comparison = comparison
        requirement.store2 = store2
        requirement.user2 = user2