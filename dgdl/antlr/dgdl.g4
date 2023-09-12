grammar dgdl;

system	  	: ( systemID '{' (game)+ '}') ;
systemID	: identifier;

game		: gameID '{' composition (rule)* (interaction)+ '}' ;
gameID		: identifier;



/* === composition === */

composition	: turns (roleList)? participants (player)+ (extURImap)* (store)* (backtrack)?;

turns   	: 'turns' '{' turnSize ',' ordering (',' maxTurns)? '}' ;
turnSize	: 'magnitude' ':' (number | 'single' | 'multiple') ;
ordering	: 'ordering' ':' (STRICT | LIBERAL) ;
maxTurns	: 'maxturns' ':' (number | runTimeVar | 'undefined') ;
runTimeVar	: '$' identifier '$';

roleList    : 'roles' '{' role (',' role)* '}' ;
role        : (LISTENER | SPEAKER | identifier);

participants: 'players' '{' 'min' ':' minplayers ',' 'max' ':' maxplayers '}' ;
minplayers  : number;
maxplayers  : (number | 'undefined');

player      : 'player' '{' 'id' ':' playerID (',' roleList)? '}' ;
playerID    : (identifier | runTimeVar);

extURImap   : 'extURI' '{' 'id' ':' extURIID ',' 'uri' ':' extURI '}' ;
extURIID    : identifier;
extURI      : STRINGLITERAL;

store       : 'store' '{' 'id' ':'  storeName ',' 'owner' ':' storeOwner ',' storeStructure ',' visibility (',' content)* '}' ;//Extension to the language
storeName   : identifier;
storeOwner  : playerID | '{' playerID (',' playerID)+ '}' | SHARED;
storeStructure: 'structure' ':' (SET | QUEUE | STACK);
visibility  : 'visibility' ':' (PUBLIC | PRIVATE);

backtrack   : 'backtrack' '{' ('on' | 'off') '}' ;


/* === rules === */

rule        : 'rule' '{' 'id' ':' ruleID ',' 'scope' ':' scopeType ',' ruleBody '}' ;
ruleID      : identifier;
scopeType   : (INITIAL | TURNWISE | MOVEWISE);

ruleBody    : effects 
            | conditional ;

effects     : '{' effect ('&' effect)* '}';
effect      : (move | storeOp | statusUpdate | roleAssignment | externalEffect);

parameter	: identifier | contentSet | contentVar | 'hello';
content     : '{' contentItem (',' contentItem)* '}' ;
contentItem : (contentSet | contentVar | contentStr);
contentSet  : upperChar;
contentVar  : NOT?  lowerChar;
contentStr  : STRINGLITERAL;

conditional : '{' 'if' requirements 'then' effects condelseif* condelse? '}';
condelseif  : 'elseif' requirements 'then' effects;
condelse    : 'else' effects;

requirements: ('{' condition (AND condition)* '}'); 
/*            | ('{' requirements (OR requirements)* '}');*/

condition   : (event | storeInspection | roleInspection | magnitude | storeComparison | dialogueSize | correspondence | relation | currentPlayer | externalCondition);


/* === interactions === */

interaction : 'interaction' '{' moveID (',' addressee)? (',' target)? (',' forcetarget)* (',' opener)? ',' ruleBody '}' ;
addressee   : '$' identifier ;
target      : content  
            | '{' schemeApp ',' schemeID '}' ;
schemeApp   : '<' content ',' content '>';
forcetarget : forceID ',' target ;
forceID     : identifier;
opener      : STRINGLITERAL;









/* === conditions === */
event             : 'event' '(' eventpos ',' moveID (',' content )? (',' user)? (',' requirements)? ')' ;
eventpos          : ('last' | '!last' | 'past' | '!past');

storeInspection   : 'inspect' '(' storepos ',' commitment ',' storeName (',' user)? (',' ('initial' | 'past' | 'current'))? ')' ;
storepos          : ('in' | '!in' | 'on' | '!on' | 'top' | '!top');

roleInspection    : 'inrole' '(' playerID ',' role ')' ;

magnitude         : 'size' '(' container ',' playerID ',' containersize ')' ;
container         : (storeName | 'legalmoves');
containersize     : ('empty' | '!empty' | Number);

storeComparison   : 'magnitude' '(' store1 ',' user1 ',' comparison ',' store2 ',' user2 ')' ;
comparison        : ('greater' | 'smaller' | 'equal' | '!equal');
store1            : storeName;
user1             : user | SHARED;
store2            : storeName;
user2             : user | SHARED;

dialogueSize      : 'numturns' '(' systemID ',' (number | runTimeVar) ')' ;

correspondence    : 'corresponds' '(' argument ',' schemeID ')' ;

relation          : 'relation' '(' (content | argument) ',' ('backing' | 'warrant') ',' (content | argument) ')' ;

currentPlayer     : 'player' '(' user ')' ;

externalCondition : 'extCondition' '(' identifier '{' parameter (',' parameter)* '}' ')' ;


user              : role; // corresponds to (playerID | role)

schemeID          : identifier;
commitment        : (content | locution | argument);

locution          : '<' moveID ',' content '>';

argument          : '<' conclusion ',' premises '>';
premises          : '{' contentVar (',' contentVar)* '}';
conclusion        : contentVar;


/* === effects === */
move          : 'move' '(' moveaction ',' movetime ',' moveID (',' addressee)? (',' content)? (',' user)? (',' requirements)? ')' ;
moveaction    : ('add' | 'delete');
movetime      : ('next' | 'future');

storeOp       : 'store' '(' storeaction (',' content)* ',' DOLLAR? storeName ',' user ')' ;
storeaction   : ('add' | 'remove' | 'empty' | 'gettop' | 'getbot' | 'pop'); // Extension to the language!

statusUpdate  : 'status' '(' status ',' sysgame ')' ;
status        : ('active' | 'inactive' | 'complete' | 'incomplete' | 'initiate' | 'terminate');

roleAssignment: 'assign' '(' user ',' role ')' ;

externalEffect: 'extEffect' '(' identifier (',' identifier)* ')' ;

moveID        : identifier;
sysgame       : identifier; // corresponds to (systemID | gameID)



upperChar	  : UpperChar;
lowerChar	  : LowerChar;
identifier	  : Identifier;
number		  : Number;


Identifier	  : UpperChar (UpperChar | LowerChar | Number)+;
LowerChar	  : 'a'..'z';
Number		  : '0'..'9' '0'..'9'*;	
UpperChar	  : 'A'..'Z';


/***************************************************
 *
 * Lexer
 *
 ***************************************************/

LESSTHAN        : '<';
GREATERTHAN     : '>';
COMMA           : ',';
COLON           : ':';
LPAREN          : '(';
RPAREN          : ')';
LBRACE          : '{';
RBRACE          : '}';
DOLLAR          : '$';
AND             : '&';
OR              : '||';
ACTIVE          : 'active';
ADD             : 'add';
ASSIGN          : 'assign';
BACKING         : 'backing';
BACKTRACK       : 'backtrack';
COMPLETE        : 'complete';
CORRESPONDS     : 'corresponds';
CURRENT         : 'current';
DELETE          : 'delete';
ELSE            : 'else';
ELSEIF          : 'elseif';
NOTEMPTY        : '!empty';
EMPTY           : 'empty';
NOTEQUAL        : '!equal';
EQUAL           : 'equal';
EVENT           : 'event';
EXTCONDITION    : 'extCondition';
EXTEFFECT       : 'extEffect';
EXTURI          : 'extURI';
FUTURE          : 'future';
GREATER         : 'greater';
HELLO           : 'hello';
ID              : 'id';
IF              : 'if';
NOTIN           : '!in';
IN              : 'in';
INACTIVE        : 'inactive';
INCOMPLETE      : 'incomplete';
INITIAL         : 'initial';
INITIATE        : 'initiate';
INROLE          : 'inrole';
INSPECT         : 'inspect';
INTERACTION     : 'interaction';
NOTLAST         : '!last';
LAST            : 'last';
LEGALMOVES      : 'legalmoves';
LIBERAL         : 'liberal';
LISTENER        : 'listener';
MAGNITUDE       : 'magnitude';
MAX             : 'max';
MAXTURNS        : 'maxturns';
MIN             : 'min';
MOVE            : 'move';
MOVEWISE        : 'movewise';
MULTIPLE        : 'multiple';
NEXT            : 'next';
NOT             : '!';
NUMTURNS        : 'numturns';
OFF             : 'off';
NOTON           : '!on';
ON              : 'on';
ORDERING        : 'ordering';
OWNER           : 'owner';
NOTPAST         : '!past';
PAST            : 'past';
PLAYER          : 'player';
PLAYERS         : 'players';
PRIVATE         : 'private';
PUBLIC          : 'public';
QUEUE           : 'queue';
RELATION        : 'relation';
REMOVE          : 'remove';
ROLES           : 'roles';
RULE            : 'rule';
SCOPE           : 'scope';
SET             : 'set';
SHARED          : 'shared';
SINGLE          : 'single';
SIZE            : 'size';
SMALLER         : 'smaller';
SPEAKER         : 'speaker';
STACK           : 'stack';
STATUS          : 'status';
STORE           : 'store';
STRICT          : 'strict';
STRUCTURE       : 'structure';
TERMINATE       : 'terminate';
THEN            : 'then';
NOTTOP          : '!top';
TOP             : 'top';
TURNS           : 'turns';
TURNWISE        : 'turnwise';
UNDEFINED       : 'undefined';
VISIBILITY      : 'visibility';
WARRANT         : 'warrant';

STRINGLITERAL   : '"' (~( '\\' | '"' | '\r' | '\n' ))* '"';
SPACE : [ \t\r\n]+ -> skip;
COMMENT         
    : '/*' .*? '*/' -> skip;

LINE_COMMENT
    : '//' ~[\r\n]* -> skip
;
